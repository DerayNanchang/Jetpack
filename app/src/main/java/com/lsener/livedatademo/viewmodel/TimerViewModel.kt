package com.lsener.livedatademo.viewmodel
import androidx.lifecycle.ViewModel
import java.util.*

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 */
class TimerViewModel : ViewModel() {


    private var timer: Timer? = null
    private var currentSecond = 0


    fun startTiming() {
        if (timer == null) {
            currentSecond = 0
            timer = Timer()
            val timerTask: TimerTask = object : TimerTask() {
                override fun run() {
                    currentSecond++
                    if (onTimeChangeListener != null) {
                        onTimeChangeListener!!.onTimeChanged(currentSecond)
                    }
                }
            }
            timer?.schedule(timerTask, 1000, 1000)
        }
    }


    /**
     * 通过接口的方式，完成对调用者的通知，这种方式不是太好，更好的方式是通过LiveData组件来实现
     */
    interface OnTimeChangeListener {
        fun onTimeChanged(second: Int)
    }

    private var onTimeChangeListener: OnTimeChangeListener? = null

    fun setOnTimeChangeListener(onTimeChangeListener: OnTimeChangeListener?) {
        this.onTimeChangeListener = onTimeChangeListener
    }


    override fun onCleared() {
        super.onCleared()
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }
}