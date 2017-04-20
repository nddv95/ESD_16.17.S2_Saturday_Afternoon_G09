package vn.edu.hcmute.esdenglishpractise.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.util.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {

    private static final String ARG_PARAM1 = "pronounId";
    ImageView mImageGuide;
    TextView mTvGuide;
    FancyButton mBtnPlaySound, mBtnOpenVideo, mBtnOpenListening, mBtnOpenSpeaking;
    private int pronounId;

    public Tab2Fragment() {
        // Required empty public constructor
    }

    public static Tab2Fragment newInstance(int mSoundId) {
        Tab2Fragment fragment = new Tab2Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, mSoundId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pronounId = getArguments().getInt(ARG_PARAM1);
        }
        Toast.makeText(getActivity(), "get id in tab 2", Toast.LENGTH_SHORT).show();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImageGuide = (ImageView) getActivity().findViewById(R.id.imgGuide2);
        //set image

        mBtnPlaySound = (FancyButton) getActivity().findViewById(R.id.btnPlaySound2);
        mBtnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.PlaySoundFromAssert(getContext(), "ced22");
                Toast.makeText(getActivity(), "sound 2", Toast.LENGTH_SHORT).show();
            }
        });

        mBtnOpenVideo = (FancyButton) getActivity().findViewById(R.id.btnOpenVideo2);
        mBtnOpenVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "video 2", Toast.LENGTH_SHORT).show();
            }
        });

        mTvGuide = (TextView) getActivity().findViewById(R.id.tvGuideText2);
        mTvGuide.setText("Text 2 \n dadjjajd \n abdadb \n anannan");

        mBtnOpenListening = (FancyButton) getActivity().findViewById(R.id.btnOpenListening2);
        mBtnOpenListening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "listening 2", Toast.LENGTH_SHORT).show();
            }
        });

        mBtnOpenSpeaking = (FancyButton) getActivity().findViewById(R.id.btnOpenSpeaking2);
        mBtnOpenSpeaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "speaking 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
