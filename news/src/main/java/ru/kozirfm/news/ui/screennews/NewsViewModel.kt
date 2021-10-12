package ru.kozirfm.news.ui.screennews

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.network_api.utils.ResponseSuccess
import ru.kozirfm.news.usecase.NewsUseCase
import ru.kozirfm.news_api.entities.InNews
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val application: Application,
    private val newsUseCase: NewsUseCase
) : BaseViewModel() {

    @Suppress("UNCHECKED_CAST")
    val data = flow {
        when (val response = newsUseCase.getNews()) {
            is ResponseSuccess<*> ->  emit(response.data as List<InNews>)
        }
    }

}