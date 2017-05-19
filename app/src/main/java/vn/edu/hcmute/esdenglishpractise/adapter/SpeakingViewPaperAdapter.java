package vn.edu.hcmute.esdenglishpractise.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.database.LessonRepository;
import vn.edu.hcmute.esdenglishpractise.fragment.Speaking1Fragment;
import vn.edu.hcmute.esdenglishpractise.fragment.Speaking2Fragment;

/**
 * Created by nddv9 on 20/04/2017.
 */

public class SpeakingViewPaperAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private String tabTitles[];
    private int[] imageResId = {
            R.drawable.ic_tab_1,
            R.drawable.ic_tab_2
    };

    private int lessonId;
    private Lesson lesson;
    private LessonRepository lessonRepository;

    public SpeakingViewPaperAdapter(FragmentManager fm, Context context, String[] tabTitles, int id) throws Exception {
        super(fm);
        this.mContext = context;
        this.tabTitles = tabTitles;
        this.lessonId = id;
        this.lessonRepository = new LessonRepository(context);
        lesson = lessonRepository.findById(lessonId);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Speaking1Fragment fragment = new Speaking1Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("soundId", lesson.sound1.getId());
            fragment.setArguments(bundle);
            return fragment;
        }
        Speaking2Fragment fragment = new Speaking2Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("soundId", lesson.sound2.getId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable image = ContextCompat.getDrawable(mContext, imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" " + tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
