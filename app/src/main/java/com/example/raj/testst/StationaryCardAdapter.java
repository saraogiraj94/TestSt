package com.example.raj.testst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by raj on 2/1/16.
 */
public class StationaryCardAdapter extends RecyclerView.Adapter<StationaryCardAdapter.ViewHolder>{
    List<Stationary> list;
    private ImageLoader imageLoader;
    private Context context;

    public StationaryCardAdapter(List<Stationary> list, Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Stationary stationary = list.get(position);
        //Loading image from url
        imageLoader = Singleton.getInstance().getImageLoader();
        imageLoader.get(stationary.getImgUrl(), ImageLoader.getImageListener(holder.imageView,R.mipmap.ic_launcher,R.drawable.abc_btn_check_material));
        holder.textViewName.setText(stationary.getName());
        holder.textViewPrice.setText(stationary.getPrice().toString());
        holder.textViewPublisher.setText(stationary.getDesc());
        holder.imageView.setImageUrl(stationary.getImgUrl(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

     class ViewHolder extends RecyclerView.ViewHolder{
            public NetworkImageView imageView;
            public TextView textViewName;
            public TextView textViewPublisher;
            public TextView textViewPrice;
            //Initializing Views
            public ViewHolder(View itemView) {
                super(itemView);
                imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewHero);
                textViewName = (TextView) itemView.findViewById(R.id.textViewName);
                textViewPublisher = (TextView) itemView.findViewById(R.id.textViewPublisher);
                textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            }

        }
    }

