package com.example.raj.testst;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raj on 21/1/16.
 */
public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder>{
    Context context;
    ArrayList<Stationary> list;
    public CartListAdapter(Context context) {
        this.list=Config.cartlist;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Stationary st= list.get(position);
        holder.name.setText(st.getName().toString());
        holder.qty.setText(st.getQty().toString());
        holder.price.setText(st.getPrice().toString().trim());
        holder.desc.setText(st.getDesc().toString());

        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAt(position);

            }
        });


    }
    public void removeAt(int p) {
        list.remove(p);
        //  Config.cartlist.remove(p);
        notifyItemRemoved(p);
        notifyItemRangeChanged(p, list.size());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,qty,price,desc;
        ImageButton ib;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.n);
            price=(TextView)itemView.findViewById(R.id.p);
            qty=(TextView)itemView.findViewById(R.id.q);
            desc=(TextView)itemView.findViewById(R.id.d);
            ib=(ImageButton)itemView.findViewById(R.id.imageButton);

        }
    }
}
