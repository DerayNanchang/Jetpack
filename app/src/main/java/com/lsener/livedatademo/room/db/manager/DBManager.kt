package com.lsener.livedatademo.room.db.manager

import android.content.Context
import androidx.room.*
import com.lsener.livedatademo.room.db.dao.StudentDAO
import com.lsener.livedatademo.room.db.entity.Student

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 */
@Database(entities = [Student::class], version = 1)
abstract class DBManager : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: DBManager? = null
        private var DB_NAME = "DB_NAME"

        fun getInstance(context: Context): DBManager =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DBManager::class.java, DB_NAME
            )
                .build()
    }

    abstract fun studentDao(): StudentDAO
}