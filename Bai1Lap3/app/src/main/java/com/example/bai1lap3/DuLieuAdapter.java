package com.example.bai1lap3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        ShapeableImageView listImage = convertView.findViewById(R.id.listImage);
        TextView listName = convertView.findViewById(R.id.listName);
        TextView listPirce = convertView.findViewById(R.id.listPirce);
        DuLieu dulieu = list.get(position);
        listImage.setImageResource(dulieu.getImage());
        listName.setText(dulieu.getName());
        listPirce.setText(dulieu.getPrice());
        return convertView;
    }
}
