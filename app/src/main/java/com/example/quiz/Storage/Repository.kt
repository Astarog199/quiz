package com.example.quiz.Storage


import android.content.Context
import com.example.quiz.client.User
import java.io.FileInputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class Repository {
    private var autorizationResult = false
    private lateinit var user: User
    private val FILE = "userDB.json"
    lateinit var name: String
    lateinit var password: String
    var balls: Int = 0

    fun readUserDB(context: Context): String? {
        var fin: FileInputStream? = null
        return try {
            fin = context.openFileInput(FILE)
            val bytes = ByteArray(fin.available())
            fin.read(bytes)
            String(bytes)
        } catch (ex: IOException) {
            null
        } finally {
            fin?.close()
        }
    }

    fun autorization(context: Context, inputName: String, inputPassword: String): Boolean {
        var text = readUserDB(context)

        text = text?.replace("[", "")
        text = text?.replace("]", "")
        text = text?.replace("\n", "")
        text = text?.replace("{", "")
        text = text?.replace("\"", "")
        val arr = text?.split("},")

        var arg1 = false
        var arg2 = false
        for (i in arr!!) {
            val arr2 = i.split(",")
            for (indexArr2 in arr2) {
                if (indexArr2.contains("name")) {
                    arg1 = (indexArr2.replace("name: ", "").equals(inputName))
                }
                if (indexArr2.contains("password")) {
                    arg2 = (indexArr2.replace("password: ", "").equals(inputPassword))
                }
                autorizationResult = arg1 && arg2
                if (autorizationResult) {
                    userInitiative(i)
                    return true
                }
            }
        }
        return autorizationResult
    }

    private fun userInitiative(indexArr2: String) {
        var dob = Date()

        val array = indexArr2.split(",")

        for (i in array) {

            if (i.contains("name")) {
                name = (i.replace("name: ", ""))
            }

            if (i.contains("password")) {
                password = (i.replace("password: ", ""))
            }

            if (i.contains("DOB")) {
                val dateString = (i.replace("DOB: ", ""))
                val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
                dob = dateFormat.parse(dateString)!!
            }
            if (i.contains("balls")) {
                balls = (i.replace("balls: ", "")).toInt()
            }
        }
        user = User(name, password, dob)
        user.setBalss(balls)
    }

    fun getUser(): User {
        return user
    }
}