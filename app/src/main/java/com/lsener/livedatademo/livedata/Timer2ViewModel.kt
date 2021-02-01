package com.lsener.livedatademo.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 *  如果需要 Context 就使用 AndroidViewModel ，不需要使用Context则使用常规的Context
 *
 */
class Timer2ViewModel : ViewModel() {

    private var timer: Timer? = null
    private var currentSecond: MutableLiveData<Int>? = null

    fun getCurrentSecond(): MutableLiveData<Int>? {
        if (currentSecond == null) {
            currentSecond = MutableLiveData()
        }
        return currentSecond
    }


    fun startTiming() {
        if (timer == null) {
            currentSecond?.let {
                it.value = 0
                timer = Timer()
                val timerTask: TimerTask = object : TimerTask() {
                    override fun run() {
                        var tip = it.value
                        if (tip != null) {
                            println("发送的数据:" + (tip + 1))
                            it.postValue(tip + 1)
                        }
                    }
                }
                timer?.schedule(timerTask, 1000, 1000)

            }

        }
    }


    override fun onCleared() {
        super.onCleared()
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }
}