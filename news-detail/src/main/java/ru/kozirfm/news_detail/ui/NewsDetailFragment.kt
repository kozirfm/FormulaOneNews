package ru.kozirfm.news_detail.ui

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
import ru.kozirfm.news_detail.di.NewsDetailFeature
import javax.inject.Inject

class NewsDetailFragment : BaseFragment(useComposeView = true) {

    private val viewModel by viewModels<NewsDetailViewModel> { viewModelFactory }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @set:Inject
    var imageLoader: ImageLoader? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        NewsDetailFeature.newsDetailComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.events, this::handleEvent)
        val id = arguments?.getString(ARGUMENTS_KEY)
        (view as ComposeView).setContent {
            AppTheme {
                NewsDetailScreen(viewModel = viewModel, imageLoader = imageLoader, id = id)
            }
        }
    }

    private companion object {
        const val ARGUMENTS_KEY = "id"
    }
}