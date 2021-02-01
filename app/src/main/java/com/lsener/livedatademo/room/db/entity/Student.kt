package com.lsener.livedatademo.room.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 *
 *  Author: lsn
 *  Blog: https://www.jianshu.com/u/a3534a2292e8
 *  Date: 2021/1/6
 *  Description
 *
 */
@Entity(tableName = "STUDENT")
class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID", typeAffinity = ColumnInfo.INTEGER)
    var id = 0

    @ColumnInfo(name = "NAME", typeAffinity = ColumnInfo.TEXT)
    var name = ""

    @ColumnInfo(name = "AGE", typeAffinity = ColumnInfo.TEXT)
    var age = ""


    constructor(id: Int, name: String, age: String) {
        this.id = id
        this.name = name
        this.age = age
    }

    @Ignore
    constructor(name: String, age: String) {
        this.name = name
        this.age = age
    }
}