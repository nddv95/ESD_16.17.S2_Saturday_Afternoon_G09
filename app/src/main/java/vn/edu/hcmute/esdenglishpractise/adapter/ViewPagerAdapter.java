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

import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.fragment.Tab1Fragment;

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

    public ViewPagerAdapter(FragmentManager fm, Context context, String[] tabTitles) {
        super(fm);
        this.mContext = context;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return Tab1Fragment.newInstance(position);
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
