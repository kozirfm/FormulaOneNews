package ru.kozirfm.news.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.redmadrobot.extensions.lifecycle.observe
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.design_system.ui.compose.theme.AppTheme
import ru.kozirfm.image_loader_api.ImageLoader
import ru.kozirfm.news.di.NewsFeature
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class NewsFragment : BaseFragment(useComposeView = true) {

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
        observe(viewModel.events, this::handleEvent)
        (view as ComposeView).setContent {
            AppTheme {
                NewsScreen(
                    viewModel = viewModel,
                    imageLoader = imageLoader
                )
            }
        }
    }
}

