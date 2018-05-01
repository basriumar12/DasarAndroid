package info.blogbasbas.hari3.activity;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.hari3.R;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.itemGambar)
    ImageView itemGambar;
    @BindView(R.id.itemNama)
    TextView itemNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //tangkap data intent
        String nama_buah = getIntent().getStringExtra("NM");
        int gambar_bauh = getIntent().getIntExtra("GMB",1);
        int suara_buah = getIntent().getIntExtra("SR",10);
        Log.d("TAG","DATA INTENT "+suara_buah);
        itemNama.setText(nama_buah);
        itemGambar.setImageResource(gambar_bauh);

        putarAudio(suara_buah);



    }

    private void putarAudio(int suara_buah) {

        MediaPlayer player = new MediaPlayer();
        Uri lokasiAudio =
         Uri.parse("android.resource://"+getPackageName()+"/"+getIntent().getIntExtra("SR",0));
        Log.d("TAG","SUARA"+lokasiAudio);
       // player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {

            player.setDataSource(DetailActivity.this, lokasiAudio);
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG","ERROR AUDIO"+e.getMessage());
        }

    }
}
