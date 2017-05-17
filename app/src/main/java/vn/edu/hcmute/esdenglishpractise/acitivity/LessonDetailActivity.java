package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.util.Utils;

public class LessonDetailActivity extends AppCompatActivity implements View.OnClickListener {

    FancyButton mGuideButton;
    FancyButton mListeningButton;
    FancyButton mSpeakingButton;
    ImageView mImageLesson;
    TextView mTvLessonTitle;
    long id;
    private Lesson lesson;

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
        id = intent.getLongExtra("position", -1);
        mTvLessonTitle = (TextView) findViewById(R.id.tvLessonDetailTitle);
        if (id > 0) {
            lesson = Lesson.findById(Lesson.class, id);
            mTvLessonTitle.setText(lesson.name.toUpperCase() + ": "
                    + lesson.sound1.sound + " vs " + lesson.sound2.sound);
        }
        mGuideButton = (FancyButton) findViewById(R.id.btnGuide);
        mGuideButton.setOnClickListener(this);
        mListeningButton = (FancyButton) findViewById(R.id.btnListening);
        mListeningButton.setOnClickListener(this);
        mSpeakingButton = (FancyButton) findViewById(R.id.btnSpeaking);
        mSpeakingButton.setOnClickListener(this);
        mImageLesson = (ImageView) findViewById(R.id.imgLessonDetail);
        mImageLesson.setImageBitmap(Utils.LoadImageFromAssert(this, lesson.img));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGuide:
                Intent guideIntent = new Intent(LessonDetailActivity.this, GuideActivity.class);
                guideIntent.putExtra("id", id);
                startActivity(guideIntent);
                break;
            case R.id.btnListening:
                Intent listeningIntent = new Intent(LessonDetailActivity.this, ListeningActivity.class);
                listeningIntent.putExtra("id", id);
                startActivity(listeningIntent);
                break;
            case R.id.btnSpeaking:
                Intent speakingIntent = new Intent(LessonDetailActivity.this, SpeakingActivity.class);
                speakingIntent.putExtra("id", id);
                startActivity(speakingIntent);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
