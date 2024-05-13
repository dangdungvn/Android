package com.example.btvn81;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DuLieuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<DuLieu> list = new ArrayList<>();

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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txtHoTen = convertView.findViewById(R.id.txtHoTen);
        TextView txtGioiTinh = convertView.findViewById(R.id.txtGioiTinh);
        TextView txtQueQuan = convertView.findViewById(R.id.txtQueQuan);
        DuLieu duLieu = list.get(position);
        txtHoTen.setText(duLieu.getHoTen());
        txtGioiTinh.setText(duLieu.getGioiTinh());
        txtQueQuan.setText(duLieu.getQueQuan());
        return convertView;
    }
}
