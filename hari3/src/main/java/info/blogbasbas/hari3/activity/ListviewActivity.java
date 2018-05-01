package info.blogbasbas.hari3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.hari3.R;
import info.blogbasbas.hari3.adapter.AdapterListview;

public class ListviewActivity extends AppCompatActivity {

    @BindView(R.id.lsBuah)
    ListView lsBuah;

    String isiJudul []= {"Alpukat","apel","Ceri","DUrian","Jambuar Air","Manggis","Strawberry"};
    int isiGambar []= {R.drawable.alpukat,R.drawable.apel,R.drawable.ceri,R.drawable.durian,
            R.drawable.jambuair,R.drawable.manggis,R.drawable.strawberry};
    int isiSuaraBuah []= {R.raw.alpukat,R.raw.apel,R.raw.ceri,
            R.raw.durian,R.raw.jambuair,R.raw.manggis,R.raw.strawberry};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        //buat objek adapter
        AdapterListview adapterListview = new AdapterListview(this,isiJudul,isiGambar);
        lsBuah.setAdapter(adapterListview);
        lsBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long l) {

                Intent kirimdata = new Intent(ListviewActivity.this,DetailActivity.class);
                //buat putextra utk krim data
                kirimdata.putExtra("NM",isiJudul[posisi]);
                kirimdata.putExtra("GMB",isiGambar[posisi]);
                kirimdata.putExtra("SR",isiSuaraBuah[posisi]);
                startActivity(kirimdata);




            }
        });


    }
}
