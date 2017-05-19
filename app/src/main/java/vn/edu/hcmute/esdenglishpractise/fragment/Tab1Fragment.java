package vn.edu.hcmute.esdenglishpractise.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;
import vn.edu.hcmute.esdenglishpractise.Model.Sound;
import vn.edu.hcmute.esdenglishpractise.R;
import vn.edu.hcmute.esdenglishpractise.acitivity.YoutubeActivity;
import vn.edu.hcmute.esdenglishpractise.database.SoundRepository;
import vn.edu.hcmute.esdenglishpractise.util.Utils;


public class Tab1Fragment extends Fragment {
    private static final String ARG_PARAM1 = "pronounId";
    ImageView mImageGuide;
    TextView mTvGuide;
    FancyButton mBtnPlaySound, mBtnOpenVideo;
    private int soundId;
    private Sound sound;


    public Tab1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mSoundId Parameter 1.
     * @return A new instance of fragment Tab1Fragment.
     */
    public static Tab1Fragment newInstance(int mSoundId) {
        Tab1Fragment fragment = new Tab1Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, mSoundId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            soundId = getArguments().getInt(ARG_PARAM1);
            // get content to show in view
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SoundRepository soundRepository = new SoundRepository(getActivity());

        try {
            sound = soundRepository.findById(soundId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mImageGuide = (ImageView) getActivity().findViewById(R.id.imgGuide1);
        //set image
        // load image
        Bitmap imageBitmap = Utils.LoadImageFromAssert(getActivity(), sound.img);
        mImageGuide.setImageBitmap(imageBitmap);

        mBtnPlaySound = (FancyButton) getActivity().findViewById(R.id.btnPlaySound1);
        mBtnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.PlaySoundFromAssert(getActivity(), sound.audio);
            }
        });

        mBtnOpenVideo = (FancyButton) getActivity().findViewById(R.id.btnOpenVideo1);
        mBtnOpenVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent youtubeIntent = new Intent(getActivity(), YoutubeActivity.class);
                youtubeIntent.putExtra("soundId", sound.getId());
                startActivity(youtubeIntent);
            }
        });

        mTvGuide = (TextView) getActivity().findViewById(R.id.tvGuideText1);
        mTvGuide.setText(sound.text);
    }
}
