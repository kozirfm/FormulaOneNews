object Features {

    val login = module("login")
    val news = module("news")
    val calendar = module("calendar")
    val calendarApi = module("calendar-api")
    val championship = module("championship")
    val newsDetail = module("news-detail")
    val newsApi = module("news-api")

    private fun module(module: String): Map<String, String> {
        return mapOf("path" to ":$module")
    }

}