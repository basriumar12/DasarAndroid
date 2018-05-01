package info.blogbasbas.androiddasar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //Definisikan Variabel Widget yang ada di layout di Global
    TextView tvText, tvUserName, tvPass;
    EditText edtName;
    Button btnKlik;
    @BindView(R.id.btnHitung)
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panggil_widget);
        ButterKnife.bind(this);

        inisialisasiWidget();
        //cara Manggil kiriman Intent
        Intent getData = getIntent();
        Log.d("Tag", "getdata" + getData.getStringExtra("US"));

        tvUserName.setText(getData.getStringExtra("US"));
        tvPass.setText(getData.getStringExtra("PS"));


        //panggil method inisialisasi widget

        //buat event untuk button
        btnKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Ini Button", Toast.LENGTH_SHORT).show();
                Log.d("Tag", "ini Button");
                //ambil nilai dari editext
                String ambilNilaiEditext = edtName.getText().toString();

                //validasi editext agar tidak kosong
                if (edtName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Isi Inputan Editext", Toast.LENGTH_SHORT).show();
                }

                Log.d("tag", "Hasil editext :" + ambilNilaiEditext);
                tvText.setText(ambilNilaiEditext);


            }
        });


        Toast.makeText(this, "Ini Method OnCreate", Toast.LENGTH_SHORT).show();

        //semua function yang ingin di jalankan di layout
        //di panggil di method oncreate
        menghitungJarak();


        //oop
        KelasCoba objekKelasCoba = new KelasCoba();
        objekKelasCoba.iniMethod();
        String buku1 = KelasCoba.buku;
        Log.d("Tag", "Cetak :" + buku1);


    }

    void inisialisasiWidget() {
        //ini inisialisasi widget
        tvText = (TextView) findViewById(R.id.tvSetText);
        edtName = (EditText) findViewById(R.id.edtName);
        btnKlik = (Button) findViewById(R.id.btnKlik);
        tvPass = (TextView) findViewById(R.id.tvPassMainActivity);
        tvUserName = (TextView) findViewById(R.id.tvUserMainactivity);
    }

    void menghitungJarak() {
        //;;
        //penggunaan logcat
        Log.e("Tag", "Log Error");
        Log.d("Tag", "Log Debug");
        Log.i("Tag", "Log Info");
        Log.v("Tag", "Log Verbose");
        Log.w("Tag", "Warm");
    }


    //     s.id/Wny


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Ini Method OnStart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Ini Method OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Ini Method OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Ini Method OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Ini Method OnDestroy", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnHitung)
    public void onViewClicked() {

        startActivity(new Intent(MainActivity.this,
            MenhitungBangunDatarActivity.class));
    }

    //tombol keluar
    @Override
    public void onBackPressed() {

        //Widget dialog
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Konfirmasi Exit");
        alert.setMessage("Yakin Anda ingin keluar dari app ?");
        alert.setCancelable(true);

        alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);

            }
        });
        alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.create();
        alert.show();

    }
}
