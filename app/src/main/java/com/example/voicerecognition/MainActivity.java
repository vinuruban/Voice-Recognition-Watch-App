package com.example.voicerecognition;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(i,0);

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //what to do with the voice-translated text
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {

            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            for (String result : results) {
                Log.i("Result", result);
            }
        }
    }
}
