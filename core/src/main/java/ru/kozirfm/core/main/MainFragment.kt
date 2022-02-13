package ru.kozirfm.core.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.kozirfm.base.R
import ru.kozirfm.core.base.BaseFragment

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private var toolbar: Toolbar? = null
    private var bottomNavigationView: BottomNavigationView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        bottomNavigationView = view.findViewById(R.id.bottom_navigation)
        if (savedInstanceState == null) initNavigation()
    }

    private fun initNavigation() {
        navigationController.setupBottomNavigationBar(
            fragment = this,
            bottomNavigationView = bottomNavigationView
        )
        navigationController.setupToolbar(
            fragment = this,
            toolbar = toolbar
        )
    }

}