package com.example.raj.testst;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raj on 26/12/15.
 */
public class MainCardAdapter extends RecyclerView.Adapter<MainCardAdapter.MainCardViewHolder> {
    //   Context context;
    ArrayList<MainCard> mainCards = new ArrayList<MainCard>();
    HomeFragment homeFragment;


    public MainCardAdapter(ArrayList<MainCard> mainCards, HomeFragment homeFragment) {

        this.mainCards = mainCards;
        this.homeFragment = homeFragment;
    }


    @Override
    public MainCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        MainCardViewHolder mainCardViewHolder = new MainCardViewHolder(view, homeFragment);
        return mainCardViewHolder;
    }

    @Override
    public void onBindViewHolder(MainCardViewHolder holder, int position) {
        MainCard mainCard = mainCards.get(position);
        holder.image.setImageResource(mainCard.getImage_id());
        holder.name.setText(mainCard.getName());

    }

    @Override
    public int getItemCount() {
        return mainCards.size();
    }

    public static class MainCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView name;
        HomeFragment homeFragment;


        //   Context context;
        public MainCardViewHolder(View itemView, HomeFragment homeFragment) {
            super(itemView);
            this.homeFragment = homeFragment;
            //   this.context=context;
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.mainImage);
            name = (TextView) itemView.findViewById(R.id.mainText);
        }


        @Override
        public void onClick(View view) {

            int pos = getPosition();
             //  Toast.makeText(homeFragment.getActivity(), "Clicked " + pos, Toast.LENGTH_SHORT).show();
                homeFragment.onClick(pos);

        }
    }
}

