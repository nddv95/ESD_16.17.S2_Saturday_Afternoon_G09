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

import vn.edu.hcmute.esdenglishpractise.Model.Word;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.adapter.WordAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Speaking2Fragment extends Fragment {

    private ArrayList<Word> wordArrayList = new ArrayList<>();


    public Speaking2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        wordArrayList.add(new Word(1, "ship", "null", "Tau", "/ship/", 3));
        wordArrayList.add(new Word(1, "share", "null", "Tau", "/ship/", 1));
        wordArrayList.add(new Word(1, "ship", "null", "Tau", "/ship/", 5));
        wordArrayList.add(new Word(1, "sheep", "null", "Tau", "/ship/", 2));
        wordArrayList.add(new Word(1, "ship", "null", "Tau", "/ship/", 3));
        wordArrayList.add(new Word(1, "ship", "null", "Tau", "/ship/", 3));
        wordArrayList.add(new Word(1, "ship", "null", "Tau", "/ship/", 3));
        wordArrayList.add(new Word(1, "ship", "null", "Tau", "/ship/", 3));
        wordArrayList.add(new Word(1, "ship", "null", "Tau", "/ship/", 3));

        View rootView = inflater.inflate(R.layout.fragment_speaking2, container, false);
        RecyclerView rcvWord = (RecyclerView) rootView.findViewById(R.id.rcvListWord2);
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

}
