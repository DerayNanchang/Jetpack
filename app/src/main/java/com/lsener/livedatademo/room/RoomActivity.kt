package com.lsener.livedatademo.room

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lsener.livedatademo.R
import com.lsener.livedatademo.room.db.entity.Student
import kotlinx.android.synthetic.main.activity_room.*

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 */
class RoomActivity : AppCompatActivity(), View.OnClickListener {


    private var mAdapter: MAdapter? = null
    private lateinit var roomViewModel: RoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        mAdapter = MAdapter()
        rvContent.apply {
            layoutManager = LinearLayoutManager(this@RoomActivity)
            adapter = mAdapter
        }
        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel::class.java)
        // 初始化数据
        //roomViewModel.setInitData()
        // 获取数据库数据
        roomViewModel.getRoomData().observe(this,
            Observer<List<Student>> { students ->
                students?.run {
                    mAdapter?.setData(this)
                }
            })

        btnAdd.setOnClickListener(this)
        btnDelete.setOnClickListener(this)
        btnUpdate.setOnClickListener(this)
        btnQuery.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (v.id) {
                R.id.btnAdd -> {
                    val substring = System.currentTimeMillis().toString()
                        .substring(System.currentTimeMillis().toString().length - 4)
                    roomViewModel.insertStudent(Student("新增测试数据 :$substring", substring))

                }
                R.id.btnDelete -> {
                    //roomViewModel.dele
                }
                R.id.btnUpdate -> {

                }
                R.id.btnQuery -> {
                    // 查询所有数据
                    mAdapter?.notifyDataSetChanged()
                }
                else -> {

                }
            }
        }
    }
}