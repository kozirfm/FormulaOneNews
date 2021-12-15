package ru.kozirfm.formulaonenews.activity

import android.os.Bundle
import androidx.navigation.findNavController
import ru.kozirfm.base.BaseActivity
import ru.kozirfm.formulaonenews.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        findNavController(R.id.main_activity_container).setGraph(R.navigation.root_nav_graph)
    }

}