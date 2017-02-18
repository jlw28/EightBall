package com.example.jwimsatt.eightball;

import android.content.Intent;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit = (EditText) findViewById(R.id.etxt_question);
        edit.setText("");
    }

    public void buttonClick_answer(View view){
        //check if question is blank - maybe?

        //Starts shake animation on button
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));

        //Delays view change to allow animation to finish
        new CountDownTimer(1800, 200){

            public void onTick(long millisUntilFinished){

            }

            public void onFinish(){
                change_view();
            }
        }.start();


    }

    //Switches to Answer view
    public void change_view(){

        Intent intent = new Intent(this, Answer.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
