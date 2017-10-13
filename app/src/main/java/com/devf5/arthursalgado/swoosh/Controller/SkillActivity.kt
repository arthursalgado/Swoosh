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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
        // Quando rotaciona o app é destruído e criado uma nova 'instance', assim precisamos salvar o que foi selecionado
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        // Aqui recuperamos o que selecionamos após a rotação. Se foi feito alguma.
        if(savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
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
