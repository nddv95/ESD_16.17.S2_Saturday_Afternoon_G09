package vn.edu.hcmute.esdenglishpractise.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.adapter.LessonAdapter;
import vn.edu.hcmute.esdenglishpractise.database.LessonRepository;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ArrayList<Lesson> myLessons = new ArrayList<>();
        LessonRepository lessonRepository = new LessonRepository(getActivity());
        List<Lesson> lstLessons = null;
        try {
            lstLessons = lessonRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Lesson> myLessons = new ArrayList<>(lstLessons);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView lstLesson = (RecyclerView) view.findViewById(R.id.lstLesson);
        lstLesson.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        lstLesson.setLayoutManager(layoutManager);
        LessonAdapter lessonAdapter = new LessonAdapter(getActivity(), myLessons);
        lstLesson.setAdapter(lessonAdapter);
        return view;
    }


}
