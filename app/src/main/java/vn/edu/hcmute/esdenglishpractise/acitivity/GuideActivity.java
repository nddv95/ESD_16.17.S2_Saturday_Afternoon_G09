package vn.edu.hcmute.esdenglishpractise.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.adapter.ViewPagerAdapter;

public class GuideActivity extends AppCompatActivity {

    TabLayout mTabGuide;
    Toolbar toolbar;
    ViewPager mViewPagerGuide;
    long id;

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
        Intent intent = getIntent();
        id = intent.getLongExtra("id", -1);
        Lesson lesson = Lesson.findById(Lesson.class, id);

        String titles[] = new String[]{lesson.sound1.sound, lesson.sound2.sound};
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, titles, lesson.getId());
        mViewPagerGuide = (ViewPager) findViewById(R.id.viewPaperGuide);
        mViewPagerGuide.setAdapter(adapter);

        mTabGuide = (TabLayout) findViewById(R.id.tabGuide);
        mTabGuide.setupWithViewPager(mViewPagerGuide);

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
