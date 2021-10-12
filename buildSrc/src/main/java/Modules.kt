object Modules {

    val core = module("core")
    val designSystem = module("design-system")
    val navigationApi = module("navigation-api")
    val navigation = module("navigation")
    val navigationGraph = module("navigation-graph")
    val networkApi = module("network-api")
    val network = module("network")
    val newsApi = module("news-api")
    val news = module("news")
    val utils = module("utils")
    val championship = module("championship")
    val championshipApi = module("championship-api")
    val calendar = module("calendar")
    val calendarApi = module("calendar-api")


    private fun module(module: String): Map<String, String> {
        return mapOf("path" to ":$module")
    }

}
