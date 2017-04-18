package vn.edu.hcmute.esdenglishpractise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.R;

/**
 * Created by nddv9 on 18/04/2017.
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {

    //list lessons
    private ArrayList<Lesson> myLessons;
    //
    private Context mContext;

    public LessonAdapter(Context context, ArrayList<Lesson> myLessons) {
        this.myLessons = myLessons;
        this.mContext = context;
    }

    @Override
    public LessonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LessonAdapter.ViewHolder holder, int position) {
        Lesson lesson = myLessons.get(position);
        holder.mLessonTitle.setText(lesson.getLessonName());
        holder.mLessonDescription.setText(lesson.getDescription());
    }

    @Override
    public int getItemCount() {
        return myLessons.size();
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageLesson;
        public TextView mLessonTitle;
        public TextView mLessonDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageLesson = (ImageView) itemView.findViewById(R.id.imgLesson);
            mLessonTitle = (TextView) itemView.findViewById(R.id.tvLessonTitle);
            mLessonDescription = (TextView) itemView.findViewById(R.id.tvSubTitle);
        }
    }
}
