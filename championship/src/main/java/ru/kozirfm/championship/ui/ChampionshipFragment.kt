package ru.kozirfm.championship.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import ru.kozirfm.championship.R
import ru.kozirfm.championship_api.entity.InDriver
import ru.kozirfm.core.base.BaseFragment

class ChampionshipFragment : BaseFragment(R.layout.fragment_championship) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ViewGroup).addView(ComposeView(view.context).apply {
            setContent {
                Text(text = "Чемпионат")
                Championship(drivers = emptyList())
            }
        })
    }
}

@Composable
fun Championship(drivers: List<InDriver>) {

}

@Preview
@Composable
fun ChampionshipPreview() {
    Championship(drivers = emptyList())
}