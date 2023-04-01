package com.tl_recycleview_crud.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.tl_recycleview_crud.R;

public class SpinnerAdapter extends BaseAdapter {
    private int[] imgs = {R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,R.drawable.cat5,R.drawable.cat6};
    private Context context; //để gắn

    public SpinnerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        //co bao nhieu item
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        //tra ve vi tri cua img
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //tra ve 1 View
        View item = LayoutInflater.from(context).inflate(R.layout.item_image,parent,false);
        //gan layout co doi tuong
        ImageView img = item.findViewById(R.id.img);
        img.setImageResource(imgs[position]);
        return item;
    }
}
