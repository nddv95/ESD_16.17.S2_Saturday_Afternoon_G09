package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.Model.Word;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.util.Utils;

public class SpeakingPracticeActivity extends AppCompatActivity implements View.OnClickListener {
    private final int REQUEST_CODE_SPEECH = 120;
    Toolbar toolbar;
    TextView mTvWordSpeak, mTvHint, mTvPhienAm, mTvPage, mTvStar1, mTvStar2, mTvStar3;
    FancyButton mBtnSpeaking, mBtnNext, mBtnPre, mBtnSound;
    private List<Word> lstWordsPractice;
    private int indexWord = -1;

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

        long wordId = getIntent().getLongExtra("wordid", 0);

        Word word = Word.findById(Word.class, wordId);

        getSupportActionBar().setTitle("Sound " + word.sound.sound + " practice");
        lstWordsPractice = Word.find(Word.class, "sound = ?", String.valueOf(word.sound.getId()));
        for (int i = 0; i < lstWordsPractice.size(); i++) {
            if (lstWordsPractice.get(i).getId() == word.getId()) {
                indexWord = i;
                break;
            }
        }

        mTvWordSpeak = (TextView) findViewById(R.id.tvWordSpeak);
        mTvHint = (TextView) findViewById(R.id.tvHint);
        mTvPhienAm = (TextView) findViewById(R.id.tvPhienAm);
        mTvPage = (TextView) findViewById(R.id.tvPage);
        mTvStar1 = (TextView) findViewById(R.id.tvStar1);
        mTvStar2 = (TextView) findViewById(R.id.tvStar2);
        mTvStar3 = (TextView) findViewById(R.id.tvStar3);

        LoadData(indexWord);

        mBtnNext = (FancyButton) findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(this);
        mBtnPre = (FancyButton) findViewById(R.id.btnPre);
        mBtnPre.setOnClickListener(this);
        mBtnSound = (FancyButton) findViewById(R.id.btnSoundSpeak);
        mBtnSound.setOnClickListener(this);
        mBtnSpeaking = (FancyButton) findViewById(R.id.btnSpeaking);
        mBtnSpeaking.setOnClickListener(this);

    }

    private void LoadData(int index) {
        Word w = lstWordsPractice.get(index);
        mTvWordSpeak.setText(w.word);
        mTvPhienAm.setText(w.pro);
        mTvHint.setText(R.string.string_hint_speaking);
        mTvPage.setText(String.valueOf(index + 1) + "/" + lstWordsPractice.size());
        setColorStar(w.star);
    }

    private void setColorStar(int star) {
        switch (star) {
            case 0:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mTvStar1.setTextColor(getColor(R.color.colorButtonDefault));
                    mTvStar2.setTextColor(getColor(R.color.colorButtonDefault));
                    mTvStar3.setTextColor(getColor(R.color.colorButtonDefault));
                } else {
                    mTvStar1.setTextColor(getResources().getColor(R.color.colorButtonDefault));
                    mTvStar2.setTextColor(getResources().getColor(R.color.colorButtonDefault));
                    mTvStar3.setTextColor(getResources().getColor(R.color.colorButtonDefault));
                }
                break;
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mTvStar1.setTextColor(getColor(R.color.colorStar));
                    mTvStar2.setTextColor(getColor(R.color.colorButtonDefault));
                    mTvStar3.setTextColor(getColor(R.color.colorButtonDefault));
                } else {
                    mTvStar1.setTextColor(getResources().getColor(R.color.colorStar));
                    mTvStar2.setTextColor(getResources().getColor(R.color.colorButtonDefault));
                    mTvStar3.setTextColor(getResources().getColor(R.color.colorButtonDefault));
                }
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mTvStar1.setTextColor(getColor(R.color.colorStar));
                    mTvStar2.setTextColor(getColor(R.color.colorStar));
                    mTvStar3.setTextColor(getColor(R.color.colorButtonDefault));
                } else {
                    mTvStar1.setTextColor(getResources().getColor(R.color.colorStar));
                    mTvStar2.setTextColor(getResources().getColor(R.color.colorStar));
                    mTvStar3.setTextColor(getResources().getColor(R.color.colorButtonDefault));
                }
                break;
            case 3:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mTvStar1.setTextColor(getColor(R.color.colorStar));
                    mTvStar2.setTextColor(getColor(R.color.colorStar));
                    mTvStar3.setTextColor(getColor(R.color.colorStar));
                } else {
                    mTvStar1.setTextColor(getResources().getColor(R.color.colorStar));
                    mTvStar2.setTextColor(getResources().getColor(R.color.colorStar));
                    mTvStar3.setTextColor(getResources().getColor(R.color.colorStar));
                }
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                if (indexWord != lstWordsPractice.size() - 1) {
                    indexWord++;
                    LoadData(indexWord);
                }
                break;
            case R.id.btnPre:
                if (indexWord != 0) {
                    indexWord--;
                    LoadData(indexWord);
                }
                break;
            case R.id.btnSpeaking:
                openSpeaking();
                break;
            case R.id.btnSoundSpeak:
                Utils.PlaySoundFromAssert(this, lstWordsPractice.get(indexWord).audio);
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
                    ArrayList<String> temp = new ArrayList<>();
                    for (String s : voiceInText) {
                        temp.add(s.toLowerCase());
                    }
                    EvaluateSound(temp);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void EvaluateSound(ArrayList<String> voicesRecognized) {
        Word w = lstWordsPractice.get(indexWord);
        switch (voicesRecognized.size()) {
            case 1:
                if (voicesRecognized.get(0).toString() == w.word) {
                    mTvHint.setText("Excellent!");
                    updateWord(w.getId(), 3);
                    setColorStar(3);
                } else {
                    mTvHint.setText("Wrong! You spoke: " + voicesRecognized.get(0).toString());
                    updateWord(w.getId(), 0);
                    setColorStar(0);
                }
                break;
            case 2:
                int indexInResult = voicesRecognized.indexOf(w.word);
                switch (indexInResult) {
                    case 0:
                        mTvHint.setText("Excellent!");
                        updateWord(w.getId(), 3);
                        setColorStar(3);
                        break;
                    case 1:
                        mTvHint.setText("Need some improve. Your sound still like " + voicesRecognized.get(0) + ".");
                        updateWord(w.getId(), 2);
                        setColorStar(2);
                        break;
                    case -1:
                        mTvHint.setText("Wrong! You spoke: " + voicesRecognized.get(0) + ", " + voicesRecognized.get(1) + ".");
                        updateWord(w.getId(), 0);
                        setColorStar(0);
                        break;
                }
                break;
            case 3:
                int indexInArr = voicesRecognized.indexOf(w.word);
                switch (indexInArr) {
                    case 0:
                        mTvHint.setText("Excellent!");
                        updateWord(w.getId(), 3);
                        setColorStar(3);
                        break;
                    case 1:
                        mTvHint.setText("Need some improve. Your sound still like " + voicesRecognized.get(0) + ".");
                        updateWord(w.getId(), 2);
                        setColorStar(2);
                        break;
                    case 2:
                        mTvHint.setText("Need some improve. Your sound still like " + voicesRecognized.get(0) + ", " + voicesRecognized.get(0) + ".");
                        updateWord(w.getId(), 1);
                        setColorStar(1);
                        break;
                    case -1:
                        mTvHint.setText("Wrong! You spoke: " + voicesRecognized.get(0) + ", " + voicesRecognized.get(1) + ".");
                        updateWord(w.getId(), 0);
                        setColorStar(0);
                        break;
                }
                break;
        }
    }

    private void updateWord(long id, int star) {
        lstWordsPractice.get(indexWord).star = star;
        Word w = Word.findById(Word.class, id);
        w.star = star;
        w.save();
    }
}
