package com.example.letsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class Questions extends AppCompatActivity implements View.OnClickListener
{
    String [] questions={"How many states are there in the United States of America?","What currency is used in Italy?","The most preferred language of Android is?","Who owns Google?"," How many days a February month has in the leap year?","Which of the following does Java lack?"};
    String[][] choices={{"50","51","49","53"},
            {"Pounds","Pesos","Euro","Dirhams"},
            {"Python","Kotlin","Java","C"},
            {"Microsoft","Amazon","Meta","Alphabet Inc."},
            {"28","30","31","29"},
            {"OOPS","Multi-threading","Platform independent","Pointers"}
    };
    String [] answers={
            "50",
            "Euro",
            "Kotlin",
            "Alphabet Inc.",
            "29",
            "Pointers"
    };

    private int index=0;
    private int score=0;
    String selectedAnswer = "";
    TextView question;
    TextView qnums;
    Button b1,b2,b3,b4;
    int totalQuestion = questions.length;
    int num=1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        Toast.makeText(this, "Welcome "+name+"!", Toast.LENGTH_SHORT).show();

        question=findViewById(R.id.question);
        qnums=findViewById(R.id.qnums);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        loadNewQuestion();
    }
    @Override
    public void onClick(View view){

        b1.setBackgroundColor(Color.parseColor("#32AADA"));
        b2.setBackgroundColor(Color.parseColor("#32AADA"));
        b3.setBackgroundColor(Color.parseColor("#32AADA"));
        b4.setBackgroundColor(Color.parseColor("#32AADA"));
        //qnums.setText("Question number: "+index);

        Button clickedButton = (Button) view;
        selectedAnswer  = clickedButton.getText().toString();
        //clickedButton.setBackgroundColor(Color.GREEN);

            if(selectedAnswer.equals(answers[index])){
                score++;
                index++;
                num++;
                loadNewQuestion();
            }

        else{
            //choices button clicked
//            selectedAnswer  = clickedButton.getText().toString();
//            clickedButton.setBackgroundColor(Color.GREEN);
                index++;
                num++;
                loadNewQuestion();
                //clickedButton.setBackgroundColor(Color.RED);

        }qnums.setText("Question number: "+num);
//        index++;
//        loadNewQuestion();
    }

    void loadNewQuestion(){

        if(index == totalQuestion ){
            finishQuiz();
            return;
        }

        question.setText(questions[index]);
        b1.setText(choices[index][0]);
        b2.setText(choices[index][1]);
        b3.setText(choices[index][2]);
        b4.setText(choices[index][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

//        new AlertDialog.Builder(this)
//                .setTitle(passStatus)
//                .setMessage("Score is "+ score+" out of "+ totalQuestion)
//                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
//                .setCancelable(false)
//                .show();

        Intent intent = new Intent(Questions.this, finalactivity.class);
        intent.putExtra("scores", score);
        startActivity(intent);


    }

    void restartQuiz(){
        score = 0;
        index =0;
        loadNewQuestion();
    }

}