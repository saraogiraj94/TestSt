package com.example.raj.testst;


import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment implements View.OnClickListener {
    Button button;

    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_contact_us, container, false);
        button=(Button)view.findViewById(R.id.btn);
        button.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View view) {
        final Dialog dialog = new Dialog(view.getContext());
        dialog.setContentView(R.layout.custom);
        dialog.setTitle("Proprietor");
        dialog.setCanceledOnTouchOutside(false);



        // set the custom dialog components - text, image and button


        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        Button calla=(Button)dialog.findViewById(R.id.cbutton);
        Button callb=(Button)dialog.findViewById(R.id.obutton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        calla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9979505840"));
                startActivity(callIntent);
                dialog.dismiss();

            }
        });
        callb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:07922868859"));
                startActivity(callIntent);
                dialog.dismiss();
            }
        });


        dialog.show();

    }
}
