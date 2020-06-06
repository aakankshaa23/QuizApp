package com.example.quizapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var quizList=ArrayList<Quiz>();
    var goodAns: Int=0;
    var currentQuiz: Int=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizList.add(Quiz("Who Invented C++?","Charles Babbage","Dennis Ritchie","Bjarne Stroustrup",2))
        quizList.add((Quiz("Speed of Internet Connetion is measured in?","GHz","dpi","ppm",0)));
        quizList.add(Quiz("Video Conferencing is done through? ","Telephone Network","IP Network","TV",1));
        quizList.add(Quiz("Which was the World's First successful electronic computer","PARAM","CRAY-1","ENIAC",2));
        quizList.add(Quiz("In fiber optics, the signal source is called?","Light Waves","Sound Waves","a-rays",0));
        showQues(quizList.get(currentQuiz));



    }
    fun showQues(quiz: Quiz){
        txtques.setText(quiz.question);
        op1.setText("a. "+quiz.ans1);
        op2.setText("b. " +quiz.ans2);
        op3.setText("c. "+quiz.ans3);
    }

   fun handleAns(answerId:Int){
       val quiz=quizList.get(currentQuiz);
       if(quiz.isCorrect(answerId)){
           goodAns++;
           Toast.makeText(this,"Correct !",Toast.LENGTH_SHORT).show();
       }
       else{
           Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();

       }
       currentQuiz++;
       if(currentQuiz>=quizList.size){
           var alert=AlertDialog.Builder(this);
           alert.setTitle("Quiz Finished!");
           alert.setMessage("Total Score is "+goodAns);
           alert.setPositiveButton("OK", {dialog: DialogInterface?, which: Int -> finish();  });
           alert.show()

       }
       else
       {
           showQues(quizList.get(currentQuiz));
       }
   }
    fun onClickans1(view: View){
        handleAns(0);
    }
    fun onClickans2(view: View){
        handleAns(1);
    }
    fun onClickans3(view: View){
        handleAns(2);
    }

}
