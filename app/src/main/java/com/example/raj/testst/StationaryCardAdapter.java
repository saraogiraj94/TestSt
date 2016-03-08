package com.example.raj.testst;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by raj on 2/1/16.
 */
public class StationaryCardAdapter extends RecyclerView.Adapter<StationaryCardAdapter.ViewHolder> {
    List<Stationary> list;
    private ImageLoader imageLoader;
    private Context context;

    public StationaryCardAdapter(List<Stationary> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Stationary stationary = list.get(position);
        //Loading image from url
        int x;
        final String name=stationary.getName();
        final Long price=stationary.getPrice();
        final Long[] quantity = new Long[list.size()];
        final String desc=stationary.getDesc();
        Log.d("OnBind","calling on bind");
        imageLoader = Singleton.getInstance().getImageLoader();
        imageLoader.get(stationary.getImgUrl(), ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, R.drawable.abc_btn_check_material));
        holder.textViewName.setText(stationary.getName());
        holder.textViewPrice.setText(stationary.getPrice().toString());
        holder.textViewPublisher.setText(stationary.getDesc());
        holder.imageView.setImageUrl(stationary.getImgUrl(), imageLoader);


        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkText(position);
                quantity[position] = Long.valueOf(holder.editText.getText().toString());
           //     Toast.makeText(context, "Item is added to the cart" + quantity[position]+" "+name+" "+price, Toast.LENGTH_LONG).show();
                pass(name, quantity[position], price,desc);
            }
        });


    }
    public void checkText(int position){
        notifyItemChanged(position);
    }

    public void pass(String name,Long q,Long price,String desc){
        Stationary st ;
        for(int i=0;i<Config.cartlist.size();i++){
            st=Config.cartlist.get(i);
            if(name==st.getName().toString()){
                q = st.getQty() +q;
                Config.cartlist.remove(i);
                break;
                //          st.setQty();
            }
        }
        String uid="20";
        Config.cartlist.add(new Stationary(name, q, price, desc));
        Toast.makeText(this.context,"Item Successfully Added to Cart",Toast.LENGTH_LONG).show();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.context);
        alertDialogBuilder.setMessage("Want to Go to Cart");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1){
                      //  Intent intent = new Intent(context,Cart.class);
                      // intent.putParcelableArrayListExtra("list",l);
                        Intent intent =new Intent(context,MyCart.class);
                        context.startActivity(intent);
                    }

                        //Puting the value false for loggedin

                        //Starting login activity

                    }
                );

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
      //  Toast.makeText(context,l.toString(), Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public NetworkImageView imageView;
        public TextView textViewName;
        public TextView textViewPublisher;
        public TextView textViewPrice;
        public Button btn;
        public EditText editText;
        public String quantity;

        //Initializing Views
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewHero);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewPublisher = (TextView) itemView.findViewById(R.id.textViewPublisher);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            editText = (EditText) itemView.findViewById(R.id.quantity);
            btn = (Button) itemView.findViewById(R.id.add);
        }

    }
}


