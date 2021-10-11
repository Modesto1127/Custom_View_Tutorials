package me.modesto.learnview.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Description.
 * @author Created by Modesto in 2021/10/11
 */
abstract class BaseActivity(layoutRes: Int) : AppCompatActivity(layoutRes) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    open fun init() {}

    protected fun goActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }

}