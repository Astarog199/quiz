package com.example.quiz.client

data class User  (
    private val name: String = "",
    private val email: String = "",
    private val password: String = ""
){
    var balls = 0


    fun setBalss(arg: Int) {
        balls += arg
    }

}