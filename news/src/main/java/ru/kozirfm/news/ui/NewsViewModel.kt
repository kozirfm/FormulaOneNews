package ru.kozirfm.news.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.network_api.utils.ResponseSuccess
import ru.kozirfm.news.usecase.NewsUseCase
import ru.kozirfm.news_api.entities.InNews
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : BaseViewModel() {

    private val _news = MutableSharedFlow<List<InNews>>()

    @Suppress("UNCHECKED_CAST")
    fun getData(): Flow<List<InNews>>{
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            Log.w(javaClass.simpleName, throwable)
        }) {
            when (val response = newsUseCase.getNews()) {
                is ResponseSuccess<*> ->  _news.emit(response.data as List<InNews>)
            }
        }
        return _news
    }

}