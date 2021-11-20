package ru.kozirfm.news.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.redmadrobot.extensions.lifecycle.observe
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.kozirfm.core.adapterdelegate.AdapterDelegatesManager
import ru.kozirfm.core.adapterdelegate.CompositeAdapter
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.news.R
import ru.kozirfm.news.di.NewsFeature
import javax.inject.Inject

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private val viewModel by viewModels<NewsViewModel> { viewModelFactory }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        NewsFeature.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val composeView = ComposeView(context = context ?: return)
        view.findViewById<ConstraintLayout>(R.id.newsContainer).addView(composeView)
        observe(viewModel.events, this::handleEvent)
        lifecycleScope.launch {
            viewModel.getData()
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    view.findViewById<RecyclerView>(R.id.recyclerView).apply {
                        adapter = CompositeAdapter(
                            AdapterDelegatesManager(
                                NewsRecyclerViewAdapter {
                                    composeView.setContent { Content(text = it.text) }
                                }
                            ), it
                        )
                    }
                }
        }
    }
}

