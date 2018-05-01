package info.blogbasbas.hari3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.blogbasbas.hari3.R;
import info.blogbasbas.hari3.RecordsItem;

/**
 * Created by User on 14/04/2018.
 */

public class AdapterListSheet extends ArrayAdapter<RecordsItem> {
    List <RecordsItem> itemlist ;
    Context ctx;
    String nama;

    public AdapterListSheet(@NonNull Context context, int resource,List<RecordsItem> nama) {

        super(context, resource,nama);
        this.ctx = context;
        this.itemlist = nama;
    }




    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_sheet, null,true);
        TextView tvnamaBuah = (TextView)v.findViewById(R.id.itemNamaSheet);

        RecordsItem item = itemlist.get(i);
        Log.d("TAG","ADAPTER"+item);
        tvnamaBuah.setText(item.getNama());

        return v;
    }
}
