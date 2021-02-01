package com.lsener.livedatademo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lsener.livedatademo.livedata.LiveDataActivity
import com.lsener.livedatademo.room.RoomActivity
import com.lsener.livedatademo.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnViewModel.setOnClickListener(this)
        btnLiveData.setOnClickListener(this)
        btnRoom.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        v?.apply {
            when (id) {
                R.id.btnViewModel -> {
                    startActivity(Intent(this@MainActivity, ViewModelActivity::class.java))
                }
                R.id.btnLiveData -> {
                    startActivity(Intent(this@MainActivity, LiveDataActivity::class.java))
                }
                R.id.btnRoom -> {
                    startActivity(
                        Intent(this@MainActivity, RoomActivity::class.java)
                    )
                }
            }
        }
    }


}