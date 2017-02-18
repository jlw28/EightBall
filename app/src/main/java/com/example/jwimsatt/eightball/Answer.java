package com.example.jwimsatt.eightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Generates and displays answer to question that was asked
 */

public class Answer extends AppCompatActivity{
    private Random rand = new Random();
    private String ans;
    private String[] opts = {"It is certain", "Without a doubt", "Yes, definitely",
        "You may rely on it", "Yes", "Reply hazy try later", "Ask again later",
        "Don't count on it", "My sources say no", "Very doubtful"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        ans = GenerateAnswer();
        TextView answer = (TextView) findViewById(R.id.reply);
        answer.setText(ans);
    }

    //Picks a random number between 1-10 and picks answer from array
    private String GenerateAnswer(){
        int position = rand.nextInt(10);
        String str = opts[position];

        return str;
    }

    //Starts MainActivity view
    public void buttonClick_back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
