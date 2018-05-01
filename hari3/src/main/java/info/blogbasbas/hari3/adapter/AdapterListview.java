package info.blogbasbas.hari3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import info.blogbasbas.hari3.R;

/**
 * Created by User on 14/04/2018.
 */

public class AdapterListview extends BaseAdapter{
    //variabel
    Context ctx;
    String namaBuah [];
    int gambarBuah [];

    //constructor adapter


    public AdapterListview(Context ctx, String[] namaBuah, int[] gambarBuah) {
        this.ctx = ctx;
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
    }

    @Override
    public int getCount() {
        return namaBuah.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posisi, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_buah, null);

        //inisialisasi widget dalam list_buah
        ImageView imgBuah = (ImageView)view.findViewById(R.id.itemGambar);
        TextView tvnamaBuah = (TextView)view.findViewById(R.id.itemNama);

        //set value setiap widget
        imgBuah.setImageResource(gambarBuah[posisi]);
        tvnamaBuah.setText(namaBuah[posisi]);

        return view;
    }
}
