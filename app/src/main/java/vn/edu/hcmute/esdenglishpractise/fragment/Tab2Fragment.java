package vn.edu.hcmute.esdenglishpractise.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import vn.edu.hcmute.esdenglishpractise.util.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {

    private static final String ARG_PARAM1 = "pronounId";
    ImageView mImageGuide;
    TextView mTvGuide;
    FancyButton mBtnPlaySound, mBtnOpenVideo;
    private long soundId;

    public Tab2Fragment() {
        // Required empty public constructor
    }

    public static Tab2Fragment newInstance(Long mSoundId) {
        Tab2Fragment fragment = new Tab2Fragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, mSoundId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            soundId = getArguments().getLong(ARG_PARAM1);
        }


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

        final Sound sound = Sound.findById(Sound.class, soundId);

        mImageGuide = (ImageView) getActivity().findViewById(R.id.imgGuide2);
        mImageGuide.setImageBitmap(Utils.LoadImageFromAssert(getContext(), sound.img));

        mBtnPlaySound = (FancyButton) getActivity().findViewById(R.id.btnPlaySound2);
        mBtnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.PlaySoundFromAssert(getContext(), sound.audio);
            }
        });

        mBtnOpenVideo = (FancyButton) getActivity().findViewById(R.id.btnOpenVideo2);
        mBtnOpenVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent youtubeIntent = new Intent(getActivity(), YoutubeActivity.class);
                youtubeIntent.putExtra("soundId", sound.getId());
                startActivity(youtubeIntent);
            }
        });

        mTvGuide = (TextView) getActivity().findViewById(R.id.tvGuideText2);
        mTvGuide.setText(sound.text);
    }
}
