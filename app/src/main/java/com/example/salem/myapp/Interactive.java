package com.example.salem.myapp;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class Interactive extends AppCompatActivity implements AIListener {

    private AIService aiService;
    TextView t, outputText;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    ImageButton button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive);

        //Query Text field
        t = (TextView) findViewById(R.id.textView7);

        //Response Text field
        outputText = (TextView) findViewById(R.id.textView8);

        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        if (permission != PackageManager.PERMISSION_GRANTED) {

            makeRequest();
        }

        final AIConfiguration config = new AIConfiguration("2d6cf6095b1b45c08949984de8236024",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiService = AIService.getService(this, config);
        aiService.setListener(this);


        // Get the Intent that started this activity
        // Intent intent = getIntent();
    }


    protected void makeRequest(){
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 101: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {


                } else {

                }
                return;
            }
        }
    }

    public void buttonClicked(final View view){

        //when button is clicked the SDK starts to listen for a microphone input from the device
        aiService.startListening();

    }

    @Override

    //after speech has been processed the results are returned in the result parameter
    public void onResult(final AIResponse result) {

        Log.d("anu", result.toString());
        Result result1 = result.getResult();
        t.setText("Query: "+result1.getResolvedQuery()+ " \nAction: "+result1.getAction()+ " \nParameter: "+result1.getParameters());

    }


    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }

}