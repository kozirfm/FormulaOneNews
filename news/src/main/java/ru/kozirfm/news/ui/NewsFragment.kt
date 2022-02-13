package ru.kozirfm.news.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.redmadrobot.extensions.lifecycle.observe
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.image_loader_api.ImageLoader
import ru.kozirfm.news.R
import ru.kozirfm.news.di.NewsFeature
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@ExperimentalMaterialApi
class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private val viewModel by viewModels<NewsViewModel> { viewModelFactory }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @set:Inject
    var imageLoader: ImageLoader? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        NewsFeature.newsComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val composeView = view.findViewById<ComposeView>(R.id.newsComposeView)
        observe(viewModel.events, this::handleEvent)
        composeView.setContent {
            NewsScreen(
                viewModel = viewModel,
                imageLoader = imageLoader
            )
        }
    }

}

