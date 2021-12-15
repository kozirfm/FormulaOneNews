package ru.kozirfm.championship.ui

import android.os.Bundle
import android.view.View
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.kozirfm.base.BaseFragment
import ru.kozirfm.championship.R
import ru.kozirfm.championship.entity.InDriver

class ChampionshipFragment : BaseFragment(useComposeView = true){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ComposeView).setContent {
            Text(text = stringResource(id = R.string.championship))
            Championship(drivers = emptyList())
        }
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