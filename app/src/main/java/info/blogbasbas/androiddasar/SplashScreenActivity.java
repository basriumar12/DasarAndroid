package info.blogbasbas.androiddasar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //logic jedah
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //pindah activity
                startActivity(new Intent(SplashScreenActivity.this,
                                        KelasCoba.class));
                //membuat actiivty destroy / di selesain
                finish();


            }
        }, 10000);

    }
}
