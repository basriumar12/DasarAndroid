package info.blogbasbas.androiddasar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenhitungBangunDatarActivity extends AppCompatActivity {

    @BindView(R.id.edtTinggi)
    EditText edtTinggi;
    @BindView(R.id.edtAlas)
    EditText edtAlas;
    @BindView(R.id.btnHitung)
    Button btnHitung;
    @BindView(R.id.btnClear)
    Button btnClear;
    @BindView(R.id.txtKeliling)
    TextView txtKeliling;
    @BindView(R.id.txtLuas)
    TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menhitung_bangun_datar);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnHitung, R.id.btnClear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHitung:
                hitungBangunDatar();
                break;
            case R.id.btnClear:
                break;
        }
    }


    void hitungBangunDatar (){
        //validasi isian editext
        edtAlas.onEditorAction(EditorInfo.IME_ACTION_DONE);
        if (edtAlas.getText().toString().isEmpty() &&
                edtTinggi.getText().toString().isEmpty()){
            Toast.makeText(this, "Data Tidak Bisa Kosong", Toast.LENGTH_SHORT).show();
        }else {
            //ambil nilai dari setiap editext
            int nilaiAlas = Integer.parseInt(edtAlas.getText().toString());
             int nilaiTinggi = Integer.parseInt(edtTinggi.getText().toString());

             double luas = (nilaiAlas * nilaiTinggi) / 2;
             double sisiMiring = ((nilaiAlas /2) * (nilaiTinggi/2)) + (nilaiTinggi *nilaiTinggi);
             double hasilSisiMiring = Math.sqrt(sisiMiring);
             double keliling = hasilSisiMiring + hasilSisiMiring + nilaiAlas;


             txtLuas.setText(String.valueOf(luas));
             txtKeliling.setText(String.valueOf(keliling));


        }
    }

}
