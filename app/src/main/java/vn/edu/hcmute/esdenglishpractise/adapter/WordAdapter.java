package vn.edu.hcmute.esdenglishpractise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.Model.Word;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.util.Utils;

/**
 * Created by nddv9 on 21/04/2017.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private ArrayList<Word> wordArrayList;
    private Context mContext;

    public WordAdapter(Context context, ArrayList<Word> words) {
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
        holder.mTvWord.setText(word.getWord());
        holder.mTvPronoun.setText(word.getPronoun());
        holder.mTvMean.setText(word.getMean());
        holder.mBtnOpenPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getmContext(), word.getWord(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.mBtnSoundWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.PlaySoundFromAssert(getmContext(), "ced11");
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
        public TextView mTvWord, mTvPronoun, mTvMean;
        public FancyButton mBtnOpenPractice, mBtnSoundWord;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvWord = (TextView) itemView.findViewById(R.id.tvWord);
            mTvPronoun = (TextView) itemView.findViewById(R.id.tvPronoun);
            mTvMean = (TextView) itemView.findViewById(R.id.tvMean);
            mBtnOpenPractice = (FancyButton) itemView.findViewById(R.id.btnOpenPractice);
            mBtnSoundWord = (FancyButton) itemView.findViewById(R.id.btnSoundWord);

        }
    }
}
