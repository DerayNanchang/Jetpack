package com.lsener.livedatademo.room

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lsener.livedatademo.room.db.entity.Student
import com.lsener.livedatademo.room.db.manager.StudentManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/7
 *  Description
 *
 *  Android为我们提供了ViewModel类，专门用于存放应用程序页面所需的数据。
 *
 */
class RoomViewModel(application: Application) : AndroidViewModel(application) {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    private fun initRoomData(students: List<Student>) {

        students.forEach {
            var subscribe = StudentManager.addStudent(getApplication(), it)
                .subscribe({
                    // 传递给View,通知创建成功
                    Toast.makeText(getApplication(), "创建成功", Toast.LENGTH_SHORT).show()
                }, {})
            compositeDisposable.add(subscribe)

        }
    }

    fun insertStudent(student: Student) {
        var subscribe = StudentManager.addStudent(getApplication(), student)
            .subscribe({
                // 传递给View,通知创建成功
                Toast.makeText(getApplication(), "创建成功", Toast.LENGTH_SHORT).show()
            }, {})
        compositeDisposable.add(subscribe)
    }


/*    fun updateStudent(student: Student) {
        var subscribe = StudentManager.updateStudent(getApplication(), student)
            .subscribe({
                // 传递给View,通知创建成功
                roomData.value = it
            }, {})
        compositeDisposable.add(subscribe)
    }*/

    /**
     *  模拟初始化数据
     */
    fun setInitData() {
        var students = ArrayList<Student>()
        for (index in 1..10) {
            val student = Student("默认数据" + index + "号", (index + 20).toString())
            students.add(student)
        }
        initRoomData(students)
    }


    /**
     *  结果返回 liveData 接受数据是不需要自己切换线程去处理数据
     */
    fun getRoomData(): LiveData<List<Student>> {
        return StudentManager.getStudents(getApplication())
    }


    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }
}