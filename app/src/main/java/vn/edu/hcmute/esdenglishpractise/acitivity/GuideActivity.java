package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.adapter.ViewPagerAdapter;

public class GuideActivity extends AppCompatActivity {

    TabLayout mTabGuide;
    Toolbar toolbar;
    ViewPager mViewPagerGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, titles);
        mViewPagerGuide = (ViewPager) findViewById(R.id.viewPaperGuide);
        mViewPagerGuide.setAdapter(adapter);

        mTabGuide = (TabLayout) findViewById(R.id.tabGuide);
        mTabGuide.setupWithViewPager(mViewPagerGuide);

    }

}
