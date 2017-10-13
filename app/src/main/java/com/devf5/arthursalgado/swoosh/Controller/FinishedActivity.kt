package com.devf5.arthursalgado.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.devf5.arthursalgado.swoosh.R
import com.devf5.arthursalgado.swoosh.Utilities.EXTRA_LEAGUE
import com.devf5.arthursalgado.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finished.*

class FinishedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)

        var league = intent.getStringExtra(EXTRA_LEAGUE)
        var skill = intent.getStringExtra(EXTRA_SKILL)

        searchLeaguesText.text = "Looking for $league $skill league near you..."
    }
}
