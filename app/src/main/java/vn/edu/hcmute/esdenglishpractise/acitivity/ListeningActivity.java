package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.R;

public class ListeningActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTvQuestion, mTvPoint, mTvKey, mTvGuide;
    FancyButton mBtnAnswer1, mBtnAnswer2, mBtnAnswer3, mBtnQuestion, mBtnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        mTvQuestion = (TextView) findViewById(R.id.tvQuestion);
        mTvPoint = (TextView) findViewById(R.id.tvPoint);
        mTvKey = (TextView) findViewById(R.id.tvWordSpeak);
        mTvGuide = (TextView) findViewById(R.id.tvDescription);

        mBtnQuestion = (FancyButton) findViewById(R.id.btnSoundSpeak);
        mBtnQuestion.setOnClickListener(this);
        mBtnAnswer1 = (FancyButton) findViewById(R.id.btnAnswer1);
        mBtnAnswer1.setOnClickListener(this);
        mBtnAnswer2 = (FancyButton) findViewById(R.id.btnAnswer2);
        mBtnAnswer2.setOnClickListener(this);
        mBtnAnswer3 = (FancyButton) findViewById(R.id.btnAnswer3);
        mBtnAnswer3.setOnClickListener(this);
        mBtnCheck = (FancyButton) findViewById(R.id.btnPre);
        mBtnCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSoundSpeak:
                //play sound
                break;
            case R.id.btnAnswer1:
                break;
            case R.id.btnAnswer2:
                break;
            case R.id.btnAnswer3:
                break;
            case R.id.btnPre:
                break;
        }
    }
}
