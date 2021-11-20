package ru.kozirfm.core.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.kozirfm.core.R
import ru.kozirfm.core.base.BaseFragment

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private lateinit var toolbar: Toolbar
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        bottomNavigationView = view.findViewById(R.id.bottom_navigation)
        if (savedInstanceState == null) {
            initNavigationBar()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        initNavigationBar()
    }

    private fun initNavigationBar() {
        navigationController.setupBottomNavigationBar(
            activity = requireActivity(),
            fragment = this,
            toolbar = toolbar,
            bottomNavigationView = bottomNavigationView,
            childFragmentManager = childFragmentManager
        )
    }

}