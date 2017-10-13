package com.devf5.arthursalgado.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.devf5.arthursalgado.swoosh.Model.Player
import com.devf5.arthursalgado.swoosh.R
import com.devf5.arthursalgado.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finished.*

class FinishedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)

       var player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeaguesText.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
