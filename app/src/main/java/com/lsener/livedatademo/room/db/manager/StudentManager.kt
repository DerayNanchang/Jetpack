package com.lsener.livedatademo.room.db.manager

import android.content.Context
import androidx.lifecycle.LiveData
import com.lsener.livedatademo.room.db.entity.Student
import com.lsener.livedatademo.room.db.manager.DBManager
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/7
 *  Description
 *
 */
object StudentManager {

    fun addStudent(context: Context, student: Student): Completable {
        return DBManager.getInstance(context).studentDao().insertStudent(student)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun updateStudent(context: Context, student: Student): Completable {
        return DBManager.getInstance(context).studentDao().updateStudent(student)
    }

    fun getStudents(context: Context): LiveData<List<Student>> {
        return DBManager.getInstance(context).studentDao().getStudents()
    }

    fun deleteStudent(context: Context, student: Student) {
        DBManager.getInstance(context).studentDao().deleteStudent(student)
    }
}