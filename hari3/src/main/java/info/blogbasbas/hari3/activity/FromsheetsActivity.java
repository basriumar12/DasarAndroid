package info.blogbasbas.hari3.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.hari3.MainActivity;
import info.blogbasbas.hari3.R;
import info.blogbasbas.hari3.RecordsItem;
import info.blogbasbas.hari3.ResponseModel;
import info.blogbasbas.hari3.adapter.AdapterListSheet;

public class FromsheetsActivity extends AppCompatActivity {

    @BindView(R.id.lsSheet)
    ListView lsSheet;
    //variabel
    List <RecordsItem> itemList;
    AdapterListSheet adapterListSheet;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fromsheets);
        ButterKnife.bind(this);

        itemList = new ArrayList<>();
        //dialog
       final ProgressDialog pd = new ProgressDialog(context);
        pd.setTitle("Loading . . . ");
        pd.setMessage("Sabar Menunggu .");
        pd.setCancelable(false);
        pd.show();


        Atom.with(FromsheetsActivity.this)
                .load("https://script.google.com/macros/s/AKfycbx14BPaWu2FkK9G6axwF_AnLO1Tt2XEBdEL-lrYSbcNFkBesw8/exec?action=read")
                .as(ResponseModel.class)
                .setCallback(new FutureCallback<ResponseModel>() {
                    @Override
                    public void onCompleted(Exception e, ResponseModel result) {

                        if (e != null) {
                            e.printStackTrace();
                            Log.d("TAG", "Error sheets" + e.getMessage());


                        }

                        itemList = result.getRecords();
                        Log.d("TAG", "RESULT 2"  +itemList);


                        List<RecordsItem> data = result.getRecords();
                        Log.d("TAG", "RESULT 1"  +data);
                        adapterListSheet = new AdapterListSheet(context,R.layout.list_sheet,data);
                        Log.d("TAG", "RESULT 3"  +adapterListSheet);
                        pd.dismiss();
                        lsSheet.setAdapter(adapterListSheet);



                        //lsSheet.setAdapter(adapterListSheet);
                        Log.d("TAG", "RESULT" + new Gson().toJson(result));

                        Comparable<String> nama = result.getRecords().get(0).getNama();


                    }
                });

    }
}
