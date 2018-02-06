package com.bit_bus.gaurav.bit_bus;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.bit_bus.gaurav.bit_bus.R.*;
import static com.bit_bus.gaurav.bit_bus.R.id.*;

public class DepoContacts extends Fragment implements View.OnClickListener {
    Button b1,b2;
    int MY_PERMISSIONS_REQUEST_CALL_PHONE;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(layout.activity_depo_contacts,container,false);
        b1=(Button)v.findViewById(depo_b1);
        b2=(Button)v.findViewById(depo_b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==id.depo_b1){
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:+916512275777"));
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                Toast.makeText(getContext(),"Permission denied, please change permissions from app settings.",Toast.LENGTH_LONG);
                if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
                        Manifest.permission.CALL_PHONE)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(this.getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
                return;
            }
            startActivity(callIntent);
        }
        if(view.getId()==id.depo_b2){
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:+916512274467"));
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                Toast.makeText(getContext(),"Permission denied, please change permissions from app settings.",Toast.LENGTH_LONG);
                if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
                        Manifest.permission.CALL_PHONE)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(this.getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
                return;
            }
            startActivity(callIntent);
        }
    }
}
