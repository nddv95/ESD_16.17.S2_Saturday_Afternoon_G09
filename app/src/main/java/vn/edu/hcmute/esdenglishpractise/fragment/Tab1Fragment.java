package vn.edu.hcmute.esdenglishpractise.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import vn.edu.hcmute.esdenglishpractise.R;


public class Tab1Fragment extends Fragment {
    private static final String ARG_PARAM1 = "pronounId";
    private static final String API_KEY = "AIzaSyBlV71FnSEyyRZnmtHLpm9jnrRRPR4sjME";

    private int pronounId;


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
            pronounId = getArguments().getInt(ARG_PARAM1);
        }
        Toast.makeText(getActivity(), "" + pronounId, Toast.LENGTH_SHORT).show();
        /*YouTubePlayerSupportFragment youtubePlayerFragment =YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout1, youtubePlayerFragment).commit();
        youtubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    youTubePlayer.loadVideo("Wm6CUkswsNw");
                    youTubePlayer.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();;
            }
        });*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        return view;
    }

}
