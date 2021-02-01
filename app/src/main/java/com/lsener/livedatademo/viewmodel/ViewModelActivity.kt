package com.lsener.livedatademo.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.lsener.livedatademo.R
import kotlinx.android.synthetic.main.activity_view_model.*

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 */
class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        simpleViewModel()
    }


    private fun simpleViewModel() {
        // 简单的ViewModel
        // ViewModel 就是处理数据隔离并暴露对应的方法用于View 界面与数据交互

        val timerViewModel = ViewModelProviders.of(this).get(TimerViewModel::class.java)
        timerViewModel.setOnTimeChangeListener(object : TimerViewModel.OnTimeChangeListener {
            override fun onTimeChanged(second: Int) {
                runOnUiThread {
                    tvCurrent.text = second.toString()
                }
            }
        })
        timerViewModel.startTiming()
    }
}