package com.tl_recycleview_crud.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tl_recycleview_crud.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private Context context;
    private List<Cat> mList;

    private CatItemListener mCatItem;
    public CatAdapter(Context context) {
        this.context = context;
        mList=new ArrayList<>();
    }

    public void setClickListener(CatItemListener mCatItem){
        this.mCatItem=mCatItem;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new CatViewHolder(view);
    }

    public Cat getItem(int position){
        return mList.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        //lay cat o vi tri position
        Cat cat = mList.get(position);
        if(cat==null)
            return;
        holder.img.setImageResource(cat.getImg());
        holder.tvName.setText(cat.getName());
        holder.tvDesc.setText(cat.getDesc());
        holder.tvPrice.setText(cat.getPrice()+"");

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(position);
                notifyDataSetChanged(); // lm tươi data
            }
        });

    }

    public void add(Cat c){
        mList.add(c);
        notifyDataSetChanged();
    }

    public void update(int position, Cat cat){
        mList.set(position,cat);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        //tra ve so luong item
        if(mList!=null)
            return mList.size();
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView tvName, tvDesc, tvPrice;
        private Button btRemove;


        public CatViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img);
            tvName=view.findViewById(R.id.txtName);
            tvDesc=view.findViewById(R.id.txtDesc);
            tvPrice=view.findViewById(R.id.txtPrice);
            btRemove=view.findViewById(R.id.btRemove);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mCatItem!=null){
                mCatItem.onItemClick(v,getAdapterPosition());
            }
        }
    }

    //tao interface lang nghe su kien bat tick chuot
    public interface CatItemListener {
        void onItemClick(View view, int position);
    }

}
