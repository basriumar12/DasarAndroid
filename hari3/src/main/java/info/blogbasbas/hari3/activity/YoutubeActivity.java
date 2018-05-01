package info.blogbasbas.hari3.activity;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.hari3.R;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    @BindView(R.id.ytView)
    YouTubePlayerView ytView;
    YouTubePlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        ButterKnife.bind(this);
        ytView.initialize("AIzaSyCU-Xju-hsaU8QK5JB2Mpe",this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        mPlayer = youTubePlayer;
        String idYoutubeVideo = "-m9jYKVz4Hs";
        if (idYoutubeVideo != null){
            if (b){
                mPlayer.play();
            } else {
                mPlayer.loadVideo(idYoutubeVideo);
            }

        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
