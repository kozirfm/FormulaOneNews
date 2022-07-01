package ru.kozirfm.navigation

import android.net.Uri
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.kozirfm.calendar.di.CalendarFeature.Companion.CALENDAR_SCREEN
import ru.kozirfm.championship.ChampionshipFeature.Companion.CHAMPIONSHIP_SCREEN
import ru.kozirfm.core.base.ScreenFeature
import ru.kozirfm.login.di.LoginFeature.Companion.LOGIN_SCREEN
import ru.kozirfm.navigation_api.NavigationController
import ru.kozirfm.navigation_api.NavigationEvent
import ru.kozirfm.news.di.NewsFeature.Companion.NEWS_SCREEN
import ru.kozirfm.utils.extensions.toLowerCase
import javax.inject.Inject
import ru.kozirfm.core.R as RCore

class NavigationControllerImpl @Inject constructor(
    private val screens: Set<@JvmSuppressWildcards ScreenFeature<*>>
) : NavigationController {

    init {
        initBaseScreens()
    }

    private var rootNavController: NavController? = null

    override fun setupBottomNavigationBar(
        fragment: Fragment,
        bottomNavigationView: BottomNavigationView?
    ) {
        val navController = fragment.findNavigationController()
        bottomNavigationView?.setupWithNavController(navController)
    }

    override fun setupToolbar(fragment: Fragment, toolbar: Toolbar?) {
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.newsFragment,
                R.id.calendarFragment,
                R.id.championshipFragment,
                R.id.loginFragment
            )
        )
        val navController = fragment.findNavigationController()
        toolbar?.setupWithNavController(navController, appBarConfiguration)
    }

    override fun setRootNavController(activityNavController: NavController) {
        this.rootNavController = activityNavController
    }

    override fun handleNavigationEvent(
        fragment: Fragment,
        event: NavigationEvent
    ) {
        when (event) {
            is NavigationEvent.ToUri -> {
                screens.singleOrNull { it.getScreenName() == event.screen }?.getApi()
                val deeplinkArguments = event.arguments?.joinToString(prefix = "/", separator = "/")
                val uri = Uri.parse("$DEEPLINK_PREFIX${event.screen.toLowerCase()}$deeplinkArguments")
                getNavController(fragment, event.isRoot)?.navigate(uri)
            }
        }
    }

    private fun initBaseScreens() {
        val baseScreen = listOf(
            NEWS_SCREEN,
            LOGIN_SCREEN,
            CALENDAR_SCREEN,
            CHAMPIONSHIP_SCREEN
        )
        screens.filter { baseScreen.contains(it.getScreenName()) }.forEach { it.getApi() }
    }

    private fun getNavController(fragment: Fragment, isRoot: Boolean): NavController? {
        return if (isRoot) rootNavController else fragment.findNavController()
    }

    private fun Fragment.findNavigationController(): NavController {
        val navHostFragment = this
            .childFragmentManager
            .findFragmentById(RCore.id.main_fragment_container) as NavHostFragment
        return navHostFragment.navController.apply {
            graph = navInflater.inflate(R.navigation.root_nav_graph).apply {
                setStartDestination(R.id.menu_news_nav_graph)
            }
        }
    }

    private companion object {
        const val DEEPLINK_PREFIX = "app://"
    }

}