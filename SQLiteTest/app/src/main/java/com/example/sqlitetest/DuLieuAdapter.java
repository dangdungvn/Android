package com.example.sqlitetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class DuLieuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<DuLieu> list;

    public DuLieuAdapter(Context context, int layout, List<DuLieu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        TextView txtHoTen = convertView.findViewById(R.id.txtHoTen);
        TextView txtMota = convertView.findViewById(R.id.txtMoTa);
        ImageView imgNam = convertView.findViewById(R.id.imgNam);
        ImageView imgNu = convertView.findViewById(R.id.imgNu);
        Switch swVB2 = convertView.findViewById(R.id.swVB2);
        ImageView imgAnh = convertView.findViewById(R.id.imgAnh);
        DuLieu duLieu = list.get(position);
        txtHoTen.setText(duLieu.getTen());
        txtMota.setText(duLieu.getMota());

        if (duLieu.getGioiTinh().equals("Nam")){
            imgNam.setAlpha(0.8f);
            imgNu.setAlpha(0.2f);
        }else {
            imgNam.setAlpha(0.2f);
            imgNu.setAlpha(0.8f);
        }
        if (duLieu.isVb2()){
            swVB2.setChecked(true);
        }else {
            swVB2.setChecked(false);
        }
        if(duLieu.getGioiTinh().equals("Nam")){
            imgAnh.setImageResource(R.drawable.avatar_nam);
        }else {
            imgAnh.setImageResource(R.drawable.avatar_nu);
        }
        return convertView;
    }
}
