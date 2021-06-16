package com.example.quizz

class Quizz (var question: String, var reponse1: String, var reponse2: String, var reponse3: String, var numrepcorrect: Int ) {

    fun isCorrect(numrep: Int) : Boolean {

        if (numrep == numrepcorrect)
            return true

        return false

    }

}