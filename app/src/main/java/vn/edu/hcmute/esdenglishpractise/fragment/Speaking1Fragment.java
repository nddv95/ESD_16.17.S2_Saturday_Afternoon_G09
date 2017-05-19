package vn.edu.hcmute.esdenglishpractise.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.hcmute.esdenglishpractise.Model.Word;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.adapter.WordAdapter;
import vn.edu.hcmute.esdenglishpractise.database.WordRepository;

/**
 * A placeholder fragment containing a simple view.
 */
public class Speaking1Fragment extends Fragment {

    int soundId;
    private List<Word> wordArrayList = new ArrayList<>();
    private RecyclerView rcvWord;
    private WordRepository wordRepository;

    public Speaking1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null)
            soundId = getArguments().getInt("soundId");
        wordRepository = new WordRepository(getActivity());
        try {
            wordArrayList = wordRepository.findWordBySoundId(soundId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        View rootView = inflater.inflate(R.layout.fragment_speaking1, container, false);

        rcvWord = (RecyclerView) rootView.findViewById(R.id.rcvListWord1);
        rcvWord.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcvWord.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration mDividerItemDecoration = new DividerItemDecoration(rcvWord.getContext(),
                layoutManager.getOrientation());
        rcvWord.addItemDecoration(mDividerItemDecoration);
        WordAdapter wordAdapter = new WordAdapter(getActivity(), wordArrayList);
        rcvWord.setAdapter(wordAdapter);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            wordArrayList = wordRepository.findWordBySoundId(soundId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WordAdapter wordAdapter = new WordAdapter(getActivity(), wordArrayList);
        rcvWord.setAdapter(wordAdapter);
    }
}
