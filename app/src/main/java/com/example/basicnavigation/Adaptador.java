package com.example.basicnavigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Adaptador extends BaseAdapter {
    private Context context;
    private int[] lista;

    public Adaptador(Context context, int[] lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imagem = new ImageView(context);
        imagem.setImageResource(lista[position]);
        imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imagem.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        return imagem;
    }
}
