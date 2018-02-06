package com.bit_bus.gaurav.bit_bus;

import android.Manifest;
import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;


public class Auto extends Fragment implements View.OnClickListener {
    TextView name, mno, ano;
    Button next, callm;
    int i = 0,MY_PERMISSIONS_REQUEST_CALL_PHONE;

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_auto, container, false);
        name = (TextView) v.findViewById(R.id.auto_name);
        mno = (TextView) v.findViewById(R.id.auto_no);
        ano = (TextView) v.findViewById(R.id.auto_ano);
        next = (Button) v.findViewById(R.id.auto_aautob);
        callm = (Button) v.findViewById(R.id.auto_callb);
        next.setOnClickListener(this);
        callm.setOnClickListener(this);

        name.setText(Busdatabase.auto_name[0]);
        mno.setText(Busdatabase.auto_nnumber[0]);
        ano.setText(Busdatabase.auto_lnumber[0]);
        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.auto_aautob) {
            i++;
            i=i%Busdatabase.auto_lnumber.length;
            name.setText(Busdatabase.auto_name[i]);
            mno.setText(Busdatabase.auto_nnumber[i]);
            ano.setText(Busdatabase.auto_lnumber[i]);
        } else if (id == R.id.auto_callb) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+Busdatabase.auto_nnumber[i]));
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                Toast.makeText(getContext(),"Permission denied, please change permissions from app settings.",Toast.LENGTH_LONG).show();
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
