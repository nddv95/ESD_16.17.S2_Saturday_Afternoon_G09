package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.R;

public class LessonDetailActivity extends AppCompatActivity implements View.OnClickListener {

    FancyButton mGuideButton;
    FancyButton mListeningButton;
    FancyButton mSpeakingButton;
    ImageView mImageLesson;
    TextView mTvLessonTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);
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

        Intent intent = getIntent();
        Toast.makeText(this, intent.getIntExtra("position", 0) + "adada", Toast.LENGTH_SHORT).show();

        mGuideButton = (FancyButton) findViewById(R.id.btnGuide);
        mGuideButton.setOnClickListener(this);
        mListeningButton = (FancyButton) findViewById(R.id.btnListening);
        mListeningButton.setOnClickListener(this);
        mSpeakingButton = (FancyButton) findViewById(R.id.btnSpeaking);
        mSpeakingButton.setOnClickListener(this);
        mImageLesson = (ImageView) findViewById(R.id.imgLessonDetail);
        mTvLessonTitle = (TextView) findViewById(R.id.tvLessonDetailTitle);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGuide:
                Intent guideIntent = new Intent(LessonDetailActivity.this, GuideActivity.class);
                startActivity(guideIntent);
                break;
            case R.id.btnListening:
                Toast.makeText(this, "open activity listening", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSpeaking:
                Toast.makeText(this, "open activity speaking", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
