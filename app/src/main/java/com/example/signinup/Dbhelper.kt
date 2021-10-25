package com.example.signinup

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Dbhelper(cont: Context): SQLiteOpenHelper(cont, "login db",null, 1) {

    private val sqldb:SQLiteDatabase =writableDatabase
    private val sqldbr:SQLiteDatabase =readableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            db.execSQL("create table members(Name text,Mobile text,Location text,Password text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun addmem(n:String, mob:String, loc:String, pass:String): Long {
        val cv= ContentValues()
        cv.put("Name",n)
        cv.put("Mobile",mob)
        cv.put("Location",loc)
        cv.put("Password",pass.hashCode())
        var st= sqldb.insert("members",null,cv)
        return st
    }
    @SuppressLint("Range")
    fun getmem(contact: String): Member {
        var cursor:Cursor? = null
        try {
            cursor=sqldbr.rawQuery("SELECT * FROM members WHERE Mobile LIKE ? ",arrayOf(contact))
        } catch (e: SQLException){
            sqldbr.execSQL("SELECT * FROM members WHERE Mobile LIKE $contact ")
        }
        cursor?.moveToFirst()

        if (cursor != null&&cursor.count >0) {
            return Member(cursor.getString(cursor.getColumnIndex("Name")),cursor.getString(cursor.getColumnIndex("Mobile")),cursor.getString(cursor.getColumnIndex("Location")),cursor.getString(cursor.getColumnIndex("Password")))
        }else return Member("","","","")
    }

//    @SuppressLint("Range")
//    fun getall():ArrayList<celeb>{
//        var list=arrayListOf<celeb>()
//        val query="SELECT * from celeb"
//        var cursor : Cursor? = null
//        try {
//            cursor=sqldbr.rawQuery(query,null)
//        }catch (e:Exception){
//            sqldbr.execSQL(query)
//            return ArrayList()
//        }
//        var name=""
//        var tb1=""
//        var tb2=""
//        var tb3=""
//        if(cursor.moveToFirst()){
//            do {
//                name=cursor.getString(cursor.getColumnIndex("Name"))
//                tb1=cursor.getString(cursor.getColumnIndex("taboo1"))
//                tb2=cursor.getString(cursor.getColumnIndex("taboo2"))
//                tb3=cursor.getString(cursor.getColumnIndex("taboo3"))
//                list.add(celeb(name,tb1,tb2,tb3))
//            }while(cursor.moveToNext())
//        }
//        return list
//    }
}