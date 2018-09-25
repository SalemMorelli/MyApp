package com.example.salem.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    /** Called when the user taps the Send button */
    public void sendMessage2(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Interactive.class);
        //  EditText editText = (EditText) findViewById(R.id.editText);

        startActivity(intent);
    }
}
