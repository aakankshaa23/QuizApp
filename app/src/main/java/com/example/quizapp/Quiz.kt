package com.example.quizapp

class Quiz(var question: String,var ans1: String,var ans2: String,var ans3:String,var correctAns: Int){
    fun isCorrect(answerNumber: Int):Boolean{
        if(answerNumber==correctAns)
            return true;
        return  false;
    }
}