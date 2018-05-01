package info.blogbasbas.androiddasar;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 07/04/2018.
 */

public class KelasCoba extends AppCompatActivity  {
    //Variabel
    static String buku = "buku saya";
    public static int angka = 123;
    long duit = 2313134;

    //buat variabel
    Button btnLogin;
    EditText edtName, edtPass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_coba);
        initSialisasiWidget();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =edtName.getText().toString();
                String pass = edtPass.getText().toString();

                //validasi login
                if (edtName.getText().toString().equals("basri") &&
                        edtPass.getText().toString().equals("umar")){
                    //pindah activity menggunakan intent
                    Intent intent = new Intent(KelasCoba.this, MainActivity.class);
                    //ngirim data
                    intent.putExtra("US",username);
                    intent.putExtra("PS",pass);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(KelasCoba.this, "Pass & Username Salah", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    //function / method
    public static void iniMethod(){
         String rasa = "Manis Gula";
        Log.d("Tag", "Rasa "+rasa);
    }

        void initSialisasiWidget(){
        btnLogin = (Button)findViewById(R.id.btnLogin);
        edtName = (EditText) findViewById(R.id.edtUsername);
        edtPass = (EditText) findViewById(R.id.edtPass);
        }

}
