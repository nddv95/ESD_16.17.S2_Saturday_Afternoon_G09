package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.adapter.SpeakingViewPaperAdapter;

public class SpeakingActivity extends AppCompatActivity {

    TabLayout mTabSpeaking;
    Toolbar toolbar;
    ViewPager mViewPagerSpeaking;
    FancyButton mBtnGuide, mBtnPractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaking);
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

        String titles[] = new String[]{"/u/", "/u:/"};
        SpeakingViewPaperAdapter adapter = new SpeakingViewPaperAdapter(getSupportFragmentManager(), this, titles);
        mViewPagerSpeaking = (ViewPager) findViewById(R.id.viewPaperSpeaking);
        mViewPagerSpeaking.setAdapter(adapter);

        mTabSpeaking = (TabLayout) findViewById(R.id.tabSpeaking);
        mTabSpeaking.setupWithViewPager(mViewPagerSpeaking);

        mBtnGuide = (FancyButton) findViewById(R.id.btnOpenGuide);
        mBtnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guideIntent = new Intent(SpeakingActivity.this, GuideActivity.class);
                //put lesson id
                startActivity(guideIntent);
            }
        });
        mBtnPractice = (FancyButton) findViewById(R.id.btnOpenSpeakingPractice);
        mBtnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent praticeIntent = new Intent(SpeakingActivity.this, SpeakingPracticeActivity.class);
                //put lesson id
                //put word id
                startActivity(praticeIntent);
            }
        });
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_speaking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_practice) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}
