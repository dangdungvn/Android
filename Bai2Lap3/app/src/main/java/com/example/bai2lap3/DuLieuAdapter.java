package com.example.bai2lap3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class DuLieuAdapter extends ArrayAdapter<DuLieu> {
    Activity context;
    int IdLayout;
    List<DuLieu> list;
    public DuLieuAdapter(Activity context, int IdLayout, List<DuLieu> list) {
        super(context, IdLayout, list);
        this.context = context;
        this.IdLayout = IdLayout;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView= inflater.inflate(IdLayout, null);
        DuLieu duLieu = list.get(position);
        ShapeableImageView image = convertView.findViewById(R.id.listImage);
        TextView name = convertView.findViewById(R.id.listName);
        TextView price = convertView.findViewById(R.id.listPirce);
        image.setImageResource(duLieu.getImage());
        name.setText(duLieu.getName());
        price.setText(duLieu.getPrice());

        return convertView;
    }
}
