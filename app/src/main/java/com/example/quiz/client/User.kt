package com.example.quiz.client

import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File


data class User  (
    private val name: String = "",
    private val email: String = "",
    private val password: String = ""
){
    var balls = 0
    val  fileDir = "app/sampledata/"

    fun setBalss(arg: Int) {
        balls += arg
    }

    fun write(){
        val text="[\n{\"name\": \"bob\",\n\"phones\": \"password\"\n},\n]"
        File(fileDir,"usersDB.json").writeText("")
        File(fileDir,"usersDB.json").appendText(text)
    }
}