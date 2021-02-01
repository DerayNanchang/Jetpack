package com.lsener.livedatademo.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lsener.livedatademo.R
import com.lsener.livedatademo.room.db.entity.Student
import kotlinx.android.synthetic.main.item_room_view.view.*

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/7
 *  Description
 *
 */
class MAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var students: List<Student>? = null

    fun setData(students: List<Student>) {
        this.students = students
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
        return MViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        students?.apply {
            holder.itemView.tvIndex.text = this[position].id.toString()
            holder.itemView.tvName.text = this[position].name
            holder.itemView.tvAge.text = this[position].age
        }

    }


    class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tvIndex: TextView = itemView.findViewById(R.id.tvIndex)
        private var tvName: TextView = itemView.findViewById(R.id.tvName)
        private var tvAge: TextView = itemView.findViewById(R.id.tvAge)

    }


    override fun getItemCount(): Int {
        if (students != null) {
            return students!!.size
        } else {
            return 0
        }
    }


}