package info.blogbasbas.hari3.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import info.blogbasbas.hari3.R;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    public void tampilToast(View view) {
        LayoutInflater inflateLayout = getLayoutInflater();
        Toast toastCustom = new Toast(CustomActivity.this);
       view = inflateLayout.inflate(R.layout.layout_toast, null);
       toastCustom.setView(view);
       toastCustom.setGravity(Gravity.CENTER_HORIZONTAL,0,10);
       toastCustom.setDuration(Toast.LENGTH_LONG);

       toastCustom.show();




    }

    public void tampilAlert(View view) {
        LayoutInflater inflateLayout = getLayoutInflater();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        view = inflateLayout.inflate(R.layout.layout_alert,null);
        alert.setView(view);
        alert.setTitle("INI ALERT");
        Button button = (Button)view.findViewById(R.id.btnYes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });


        WebView web = (WebView) view.findViewById(R.id.webAlert);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://www.facebook.com");

        alert.show();
    }
}
