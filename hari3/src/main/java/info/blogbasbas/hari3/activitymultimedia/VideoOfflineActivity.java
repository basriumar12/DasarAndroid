package info.blogbasbas.hari3.activitymultimedia;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.hari3.R;

public class VideoOfflineActivity extends AppCompatActivity {

    @BindView(R.id.vdVideoOfline)
    VideoView vdVideoOfline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_offline);
        ButterKnife.bind(this);

        //Url
        Uri videoLokasi = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.androidcommercial);
        vdVideoOfline.setVideoURI(videoLokasi);
        vdVideoOfline.setMediaController(new MediaController(this));
        vdVideoOfline.start();
    }
}
