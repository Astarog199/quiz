package com.example.quiz.client

import android.content.Context
import android.widget.Toast
import java.io.FileOutputStream
import java.io.IOException
import java.util.Date

val FILE = "userDB.json"

data class User  (
    private val name: String = "",
    private val password: String = "",
    private val DOB: Date
){
    init {
        var age: Int
        var dataReg: Date
    }
    var balls = 0

    fun setBalss(arg: Int) {
        balls += arg
    }
    fun userWrite(context: Context) {
        val text="[\n{\n\"name\": \"$name\",\n\"password\": \"$password\",\n\"DOB\": \"$DOB\",\n\"balls\": \"$balls\"\n},\n]"
        var fos: FileOutputStream? = null
        try {
            fos =context.openFileOutput(FILE, Context.MODE_PRIVATE)
            fos.write(text.toByteArray())
        } catch (ex: IOException) {
            Toast.makeText(context, "ошибка: $ex", Toast.LENGTH_SHORT).show()
        }finally {
            fos?.close()
        }
    }
}