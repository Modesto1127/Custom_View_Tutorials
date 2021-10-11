package me.modesto.learnview

import android.widget.Button
import me.modesto.learnview.base.BaseActivity
import me.modesto.learnview.ch1.PaintActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun init() {
        findViewById<Button>(R.id.btn_go_paint).setOnClickListener { goActivity(PaintActivity::class.java) }
    }

}