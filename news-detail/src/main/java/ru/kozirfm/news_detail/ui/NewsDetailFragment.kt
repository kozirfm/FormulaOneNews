package ru.kozirfm.news_detail.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.redmadrobot.extensions.lifecycle.observe
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.image_loader_api.ImageLoader
import ru.kozirfm.news_api.entity.InNews
import ru.kozirfm.news_detail.R
import ru.kozirfm.news_detail.di.NewsDetailFeature
import ru.kozirfm.utils.extensions.emptyString
import javax.inject.Inject

class NewsDetailFragment : BaseFragment(R.layout.fragment_news_detail) {

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
        val composeView = view.findViewById<ComposeView>(R.id.newsDetailComposeView)
        observe(viewModel.events, this::handleEvent)
        val id = arguments?.getString(ARGUMENTS_KEY)
        composeView.setContent {
            val uiState by remember { viewModel.getData(id?.toLong()) }.collectAsState()
            when (uiState) {
                is UiSuccess<*> -> {
                    val news = (uiState as UiSuccess<*>).data as InNews
                    imageLoader?.let { imageLoader ->
                        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                            item {
                                Text(
                                    news.text,
                                    fontSize = 18.sp,
                                )
                            }
                            news.images?.let { images ->
                                items(images.count()) { index ->
                                    Image(
                                        painter = imageLoader.load(any = images[index]),
                                        contentDescription = emptyString(),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 16.dp)
                                            .clip(
                                                RoundedCornerShape(8.dp)
                                            ),
                                        contentScale = ContentScale.FillWidth
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private companion object {
        const val ARGUMENTS_KEY = "id"
    }
}