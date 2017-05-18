package vn.edu.hcmute.esdenglishpractise.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.Model.Word;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.acitivity.SpeakingPracticeActivity;
import vn.edu.hcmute.esdenglishpractise.util.Utils;

/**
 * Created by nddv9 on 21/04/2017.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private List<Word> wordArrayList;
    private Context mContext;

    public WordAdapter(Context context, List<Word> words) {
        this.mContext = context;
        this.wordArrayList = words;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Word word = wordArrayList.get(position);
        switch (word.star) {
            case 0:
                break;
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.mTvStar1.setTextColor(mContext.getColor(R.color.colorStar));
                } else {
                    holder.mTvStar1.setTextColor(mContext.getResources().getColor(R.color.colorStar));
                }
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.mTvStar1.setTextColor(mContext.getColor(R.color.colorStar));
                    holder.mTvStar2.setTextColor(mContext.getColor(R.color.colorStar));
                } else {
                    holder.mTvStar1.setTextColor(mContext.getResources().getColor(R.color.colorStar));
                    holder.mTvStar2.setTextColor(mContext.getResources().getColor(R.color.colorStar));
                }
                break;
            case 3:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder.mTvStar1.setTextColor(mContext.getColor(R.color.colorStar));
                    holder.mTvStar2.setTextColor(mContext.getColor(R.color.colorStar));
                    holder.mTvStar3.setTextColor(mContext.getColor(R.color.colorStar));
                } else {
                    holder.mTvStar1.setTextColor(mContext.getResources().getColor(R.color.colorStar));
                    holder.mTvStar2.setTextColor(mContext.getResources().getColor(R.color.colorStar));
                    holder.mTvStar3.setTextColor(mContext.getResources().getColor(R.color.colorStar));
                }
                break;

        }
        holder.mTvWord.setText(word.word);
        holder.mTvPronoun.setText(word.pro);
        holder.mTvMean.setText(word.mean);
        holder.mBtnOpenPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SpeakingPracticeActivity.class);
                intent.putExtra("wordid", word.getId());
                mContext.startActivity(intent);
            }
        });

        holder.mBtnSoundWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.PlaySoundFromAssert(getmContext(), word.audio);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wordArrayList.size();
    }

    public Context getmContext() {
        return this.mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvWord, mTvPronoun, mTvMean, mTvStar1, mTvStar2, mTvStar3;
        public FancyButton mBtnOpenPractice, mBtnSoundWord;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvWord = (TextView) itemView.findViewById(R.id.tvWord);
            mTvPronoun = (TextView) itemView.findViewById(R.id.tvPronoun);
            mTvMean = (TextView) itemView.findViewById(R.id.tvMean);
            mTvStar3 = (TextView) itemView.findViewById(R.id.tvStar);
            mTvStar2 = (TextView) itemView.findViewById(R.id.tvStar12);
            mTvStar1 = (TextView) itemView.findViewById(R.id.tvStar123);
            mBtnOpenPractice = (FancyButton) itemView.findViewById(R.id.btnOpenPractice);
            mBtnSoundWord = (FancyButton) itemView.findViewById(R.id.btnSoundWord);

        }
    }
}
