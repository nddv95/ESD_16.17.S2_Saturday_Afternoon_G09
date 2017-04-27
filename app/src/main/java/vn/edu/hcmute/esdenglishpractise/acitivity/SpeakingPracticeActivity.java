package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.R;

public class SpeakingPracticeActivity extends AppCompatActivity implements View.OnClickListener {
    private final int REQUEST_CODE_SPEECH = 120;
    Toolbar toolbar;
    TextView mTvWordSpeak, mTvHint, mTvPhienAm;
    FancyButton mBtnSpeaking, mBtnNext, mBtnPre, mBtnSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaking_practice);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something you want
                onBackPressed();
            }
        });

        mTvWordSpeak = (TextView) findViewById(R.id.tvWordSpeak);
        mTvHint = (TextView) findViewById(R.id.tvHint);
        mTvPhienAm = (TextView) findViewById(R.id.tvPhienAm);

        mBtnNext = (FancyButton) findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(this);
        mBtnPre = (FancyButton) findViewById(R.id.btnPre);
        mBtnPre.setOnClickListener(this);
        mBtnSound = (FancyButton) findViewById(R.id.btnSoundSpeak);
        mBtnSound.setOnClickListener(this);
        mBtnSpeaking = (FancyButton) findViewById(R.id.btnSpeaking);
        mBtnSpeaking.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                break;
            case R.id.btnPre:
                break;
            case R.id.btnSpeaking:
                openSpeaking();
                break;
            case R.id.btnSoundSpeak:
                break;
        }

    }

    public void openSpeaking() {
        Intent speakingIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speakingIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speakingIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
        speakingIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speaking now");
        try {
            startActivityForResult(speakingIntent, REQUEST_CODE_SPEECH);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Google voice typing must be enabled!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_SPEECH:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mTvHint.setText(voiceInText.toString());
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
