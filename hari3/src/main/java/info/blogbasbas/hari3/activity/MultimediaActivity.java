package info.blogbasbas.hari3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.blogbasbas.hari3.R;
import info.blogbasbas.hari3.activitymultimedia.AudioActivity;
import info.blogbasbas.hari3.activitymultimedia.VideoOfflineActivity;
import info.blogbasbas.hari3.activitymultimedia.VideoOnlineActivity;

public class MultimediaActivity extends AppCompatActivity {

    @BindView(R.id.btnAudio)
    Button btnAudio;
    @BindView(R.id.btnVIdeoOffline)
    Button btnVIdeoOffline;
    @BindView(R.id.btnVIdeoonline)
    Button btnVIdeoonline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAudio)
    public void onBtnAudioClicked() {

        startActivity(new Intent(MultimediaActivity.this, AudioActivity.class));

    }

    @OnClick(R.id.btnVIdeoOffline)
    public void onBtnVIdeoOfflineClicked() {
        startActivity(new Intent(MultimediaActivity.this, VideoOfflineActivity.class));
    }

    @OnClick(R.id.btnVIdeoonline)
    public void onBtnVIdeoonlineClicked() {

        startActivity(new Intent(MultimediaActivity.this, VideoOnlineActivity.class));
    }
}
