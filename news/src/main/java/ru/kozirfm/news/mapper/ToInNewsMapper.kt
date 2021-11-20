package ru.kozirfm.news.mapper

import ru.kozirfm.news.entity.InNews
import ru.kozirfm.news.entity.OutNews
import ru.kozirfm.utils.mapper.BaseMapper

object ToInNewsMapper : BaseMapper<OutNews, InNews> {
    override fun map(response: OutNews): InNews {
        return response.run {
            InNews(
                id = id,
                date = date,
                link = link,
                title = title,
                text = text,
                images = images
            )
        }
    }
}