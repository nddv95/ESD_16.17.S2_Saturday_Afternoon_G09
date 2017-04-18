package vn.edu.hcmute.esdenglishpractise.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.adapter.LessonAdapter;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Lesson> myLessons = new ArrayList<>();
        myLessons.add(new Lesson(1, "Lesson1", "afafff", null));
        myLessons.add(new Lesson(1, "Lesson1", "afafff", null));
        myLessons.add(new Lesson(1, "Lesson1", "afafff", null));
        myLessons.add(new Lesson(1, "Lesson1", "afafff", null));
        myLessons.add(new Lesson(1, "Lesson1", "afafff", null));
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