package com.devf5.arthursalgado.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devf5.arthursalgado.swoosh.Model.Player
import com.devf5.arthursalgado.swoosh.R
import com.devf5.arthursalgado.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player // lateinit significa que vamos inicializar em algum momento a variável não necessariamente agora

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onSkillFinishedClicked(view: View) {
        if(player.skill != "") {
            val finishedActivity = Intent(this, FinishedActivity::class.java)
            finishedActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishedActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillButton.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClicked(view: View) {
        beginnerSkillButton.isChecked = false
        player.skill = "baller"
    }
}
