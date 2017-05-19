package vn.edu.hcmute.esdenglishpractise.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import vn.edu.hcmute.esdenglishpractise.fragment.Tab1Fragment;
import vn.edu.hcmute.esdenglishpractise.fragment.Tab2Fragment;

/**
 * Created by nddv9 on 19/04/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private String tabTitles[];
    private int[] imageResId = {
            R.drawable.ic_tab_1,
            R.drawable.ic_tab_2
    };
    private LessonRepository lessonRepository;
    private int lessonId;
    private int soundid2;
    private int soundid1;

    public ViewPagerAdapter(FragmentManager fm, Context context, String[] tabTitles, int lessonId) {
        super(fm);
        this.mContext = context;
        this.tabTitles = tabTitles;
        this.lessonId = lessonId;
        this.lessonRepository = new LessonRepository(context);
    }

    @Override
    public Fragment getItem(int position) {

        try {
            soundid2 = this.lessonRepository.findById(lessonId).sound2.getId();
            soundid1 = this.lessonRepository.findById(lessonId).sound1.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (position == 0)
            return Tab1Fragment.newInstance(soundid1);
        return Tab2Fragment.newInstance(soundid2);
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
