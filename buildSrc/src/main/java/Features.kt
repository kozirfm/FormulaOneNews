object Features {

    val login = module("login")
    val news = module("news")
    val calendar = module("calendar")
    val championship = module("championship")

    private fun module(module: String): Map<String, String> {
        return mapOf("path" to ":$module")
    }

}