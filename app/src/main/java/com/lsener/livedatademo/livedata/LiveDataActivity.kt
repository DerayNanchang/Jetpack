package com.lsener.livedatademo.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lsener.livedatademo.R
import kotlinx.android.synthetic.main.activity_live_data.*

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 */
class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        initComponent()
    }

    private fun initComponent() {
        val liveViewModel = ViewModelProviders.of(this).get(Timer2ViewModel::class.java)
        val liveData = liveViewModel.getCurrentSecond()
        liveData?.observe(this, Observer<Int> {
            // 数据更新，订阅方法
            it?.apply {
                runOnUiThread {
                    val numStr = this.toString()
                    tvCurrent.text = numStr
                }
            }
        })
        liveViewModel.startTiming()


        btnReset.setOnClickListener {
            //  重置数据
            liveData?.let {
                it.value = 0
            }
        }
    }
}