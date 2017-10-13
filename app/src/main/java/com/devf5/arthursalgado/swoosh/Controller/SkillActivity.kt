package com.devf5.arthursalgado.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devf5.arthursalgado.swoosh.Utilities.EXTRA_LEAGUE
import com.devf5.arthursalgado.swoosh.R
import com.devf5.arthursalgado.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onSkillFinishedClicked(view: View) {
        if(selectedSkill != "") {
            val finishedActivity = Intent(this, FinishedActivity::class.java)
            finishedActivity.putExtra(EXTRA_LEAGUE, league)
            finishedActivity.putExtra(EXTRA_SKILL, selectedSkill)
            startActivity(finishedActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillButton.isChecked = false
        selectedSkill = "beginner"
    }

    fun onBallerClicked(view: View) {
        beginnerSkillButton.isChecked = false
        selectedSkill = "baller"
    }
}
