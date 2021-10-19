package me.modesto.learnview

import android.widget.Button
import me.modesto.learnview.base.BaseActivity
import me.modesto.learnview.ch1.PaintActivity
import me.modesto.learnview.ch2.PathActivity
import me.modesto.learnview.ch3.TextActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun init() {
        findViewById<Button>(R.id.btn_go_paint).setOnClickListener { goActivity(PaintActivity::class.java) }
        findViewById<Button>(R.id.btn_go_path).setOnClickListener { goActivity(PathActivity::class.java) }
        findViewById<Button>(R.id.btn_go_text).setOnClickListener { goActivity(TextActivity::class.java) }
    }

}