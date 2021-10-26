package ru.kozirfm.calendar.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import ru.kozirfm.calendar.R
import ru.kozirfm.core.base.BaseFragment

class CalendarFragment : BaseFragment(R.layout.fragment_calendar) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ViewGroup).addView(ComposeView(view.context).apply {
            setContent {
                Text(text = stringResource(id = R.string.calendar))
            }
        })
    }
}