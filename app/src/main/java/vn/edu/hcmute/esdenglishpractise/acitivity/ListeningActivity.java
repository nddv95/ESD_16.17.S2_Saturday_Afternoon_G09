package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.Model.Listening;
import vn.edu.hcmute.esdenglishpractise.R;

public class ListeningActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTvQuestion, mTvPoint, mTvKey, mTvGuide;
    FancyButton mBtnAnswer1, mBtnAnswer2, mBtnAnswer3, mBtnQuestion, mBtnCheck;
    boolean isContinue = false;
    boolean choiceAnswer1 = false;
    boolean choiceAnswer2 = false;
    boolean choiceAnswer3 = false;
    int keyIndex;
    int point = 0;
    int indexQuestion = 0;
    long lessonId;
    private List<Listening> lstListeningTest = new ArrayList<>();

    private static int randomInt(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

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

        Intent intent = getIntent();
        lessonId = intent.getLongExtra("id", -1);

        lstListeningTest = Listening.find(Listening.class, "lesson = ?", String.valueOf(lessonId));

        mTvQuestion = (TextView) findViewById(R.id.tvQuestion);

        mTvPoint = (TextView) findViewById(R.id.tvPoint);
        mTvPoint.setText("Point\n" + String.valueOf(point));
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

        LoadQuestion(indexQuestion);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSoundSpeak:
                //play sound
                break;
            case R.id.btnAnswer1:
                choiceAnswer1 = true;
                choiceAnswer2 = false;
                choiceAnswer3 = false;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mBtnAnswer1.setBackgroundColor(getColor(R.color.colorAccent));
                    mBtnAnswer2.setBackgroundColor(getColor(R.color.colorButtonDefault));
                    mBtnAnswer3.setBackgroundColor(getColor(R.color.colorButtonDefault));
                } else {
                    mBtnAnswer1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    mBtnAnswer2.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
                    mBtnAnswer3.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
                }
                break;
            case R.id.btnAnswer2:
                choiceAnswer1 = false;
                choiceAnswer2 = true;
                choiceAnswer3 = false;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mBtnAnswer1.setBackgroundColor(getColor(R.color.colorButtonDefault));
                    mBtnAnswer2.setBackgroundColor(getColor(R.color.colorAccent));
                    mBtnAnswer3.setBackgroundColor(getColor(R.color.colorButtonDefault));
                } else {
                    mBtnAnswer1.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
                    mBtnAnswer2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    mBtnAnswer3.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
                }
                break;
            case R.id.btnAnswer3:
                choiceAnswer1 = false;
                choiceAnswer2 = false;
                choiceAnswer3 = true;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mBtnAnswer1.setBackgroundColor(getColor(R.color.colorButtonDefault));
                    mBtnAnswer2.setBackgroundColor(getColor(R.color.colorButtonDefault));
                    mBtnAnswer3.setBackgroundColor(getColor(R.color.colorAccent));
                } else {
                    mBtnAnswer1.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
                    mBtnAnswer2.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
                    mBtnAnswer3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
                break;
            case R.id.btnPre:
                if (!isContinue) {
                    if (checkAnswer()) {
                        // play audio correct
                        point++;
                        mTvPoint.setText("Point\n" + String.valueOf(point));
                    } else {
                        //play audio wrong
                    }
                    if (indexQuestion + 1 != lstListeningTest.size()) {
                        mBtnCheck.setText("CONTINUE");
                    } else {
                        mBtnCheck.setText("END");
                    }

                } else {
                    if (indexQuestion + 1 != lstListeningTest.size()) {
                        indexQuestion++;
                        LoadQuestion(indexQuestion);
                        mBtnCheck.setText("CHECK");
                    } else {
                        onBackPressed();
                    }
                }
                isContinue = !isContinue;
                break;
        }
    }

    private void LoadQuestion(int index) {
        mTvQuestion.setText("Question\n" + String.valueOf(indexQuestion + 1) + "/" + lstListeningTest.size());

        mTvKey.setText("");
        mTvGuide.setText("Which word did you hear?");
        keyIndex = randomInt(3);
        Toast.makeText(this, "" + keyIndex, Toast.LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mBtnAnswer1.setBackgroundColor(getColor(R.color.colorButtonDefault));
            mBtnAnswer2.setBackgroundColor(getColor(R.color.colorButtonDefault));
            mBtnAnswer3.setBackgroundColor(getColor(R.color.colorButtonDefault));
        } else {
            mBtnAnswer1.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
            mBtnAnswer2.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
            mBtnAnswer3.setBackgroundColor(getResources().getColor(R.color.colorButtonDefault));
        }
        switch (keyIndex) {
            case 0:
                mBtnAnswer1.setText(lstListeningTest.get(index).key.word);
                mBtnAnswer2.setText(lstListeningTest.get(index).word1.word);
                mBtnAnswer3.setText(lstListeningTest.get(index).word2.word);
                break;
            case 1:
                mBtnAnswer1.setText(lstListeningTest.get(index).word1.word);
                mBtnAnswer2.setText(lstListeningTest.get(index).key.word);
                mBtnAnswer3.setText(lstListeningTest.get(index).word2.word);
                break;
            case 2:
                mBtnAnswer1.setText(lstListeningTest.get(index).word2.word);
                mBtnAnswer2.setText(lstListeningTest.get(index).word1.word);
                mBtnAnswer3.setText(lstListeningTest.get(index).key.word);
                break;
        }

    }

    private boolean checkAnswer() {
        switch (keyIndex) {
            case 0:
                if (choiceAnswer1)
                    return true;
                else return false;
            case 1:
                if (choiceAnswer2)
                    return true;
                else return false;
            case 2:
                if (choiceAnswer3)
                    return true;
                else
                    return false;
        }
        return false;
    }
}
