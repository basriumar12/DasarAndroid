package info.blogbasbas.hari3.activitymultimedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import com.wang.avi.AVLoadingIndicatorView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.blogbasbas.hari3.R;

public class AudioActivity extends AppCompatActivity {

    @BindView(R.id.loader)
    AVLoadingIndicatorView loader;
    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnStop)
    Button btnStop;

    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        ButterKnife.bind(this);

        btnStop.setEnabled(false);

    }

    @OnClick({R.id.btnPlay, R.id.btnStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                audio = new MediaPlayer();
                try {

                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.music);
                    //offline
                    audio.setDataSource(this, uri);

                    //online
                    //audio.setDataSource("http://103.16.198.36:9160/stream");
                    audio.prepareAsync();
                    audio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            audio.start();
                            btnPlay.setEnabled(false);
                            btnStop.setEnabled(true);
                            loader.setVisibility(View.VISIBLE);

                    }
                });

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("TAG","ERROR audio"+e.getMessage());

                }

                break;
            case R.id.btnStop:
                audio.stop();
                btnPlay.setEnabled(true);
                btnStop.setEnabled(false);
                loader.setVisibility(View.INVISIBLE);

                break;
        }
    }
}
