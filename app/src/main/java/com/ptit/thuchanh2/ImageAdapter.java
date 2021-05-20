package com.ptit.thuchanh2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    int[] icons={ R.drawable.iphone7plus
            ,R.drawable.laptoptoshiba
            ,R.drawable.macbook
            ,R.drawable.samsunng
            ,R.drawable.xsmax
            ,R.drawable.op1
            ,R.drawable.oplung
            ,R.drawable.maydelll
    };

    private Context context;

    public ImageAdapter(Context c)
    {
        context = c;
    }
    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
        return icons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null)
        {
            imageView=new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100,30));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        }
        else{

            imageView=(ImageView)convertView;
        }
        imageView.setImageResource(icons[position]);
        return imageView;
    }
}
