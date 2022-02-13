object Modules {

    val core = module("core")
    val network = module("network")
    val networkApi = module("network-api")
    val navigation = module("navigation")
    val navigationApi = module("navigation-api")
    val designSystem = module("design-system")
    val utils = module("utils")
    val imageLoader = module("image-loader")
    val imageLoaderApi = module("image-loader-api")
    val firebase = module("firebase")
    val firebaseApi = module("firebase-api")
    val persistentStorage = module("persistent-storage")
    val persistentStorageApi = module("persistent-storage-api")

    private fun module(module: String): Map<String, String> {
        return mapOf("path" to ":$module")
    }

}
