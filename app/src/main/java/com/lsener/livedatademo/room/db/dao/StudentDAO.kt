package com.lsener.livedatademo.room.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lsener.livedatademo.room.db.entity.Student
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 */
@Dao
interface StudentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student): Completable

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student): Completable

    @Query("SELECT * FROM STUDENT")
    fun getStudents(): LiveData<List<Student>>


    @Query("SELECT * FROM STUDENT WHERE NAME = :name")
    fun findStudentByName(name: String): List<Student>
}