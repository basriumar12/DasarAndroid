package info.blogbasbas.hari3.activitymultimedia;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.hari3.R;

public class VideoOnlineActivity extends AppCompatActivity {

    @BindView(R.id.vdVideoOfline)
    VideoView vdVideoOfline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_online);
        ButterKnife.bind(this);

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("loading . . .");
        dialog.setMessage("waiting video");
        dialog.setCancelable(false);
        dialog.show();


        String urlVideo = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
        Uri uri = Uri.parse(urlVideo);
        vdVideoOfline.setVideoURI(uri);
        vdVideoOfline.setMediaController(new MediaController(this));
        vdVideoOfline.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                dialog.dismiss();
                vdVideoOfline.start();
            }
        });

    }
}
