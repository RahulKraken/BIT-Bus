package com.bit_bus.gaurav.bit_bus;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Chart extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner sp1,sp2,sp3;
    TextView tv;
    int day=0,loc=0,bus=0;
    String text="";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_chart,container,false);
        sp1=(Spinner)v.findViewById(R.id.ch_sp1);
        sp2=(Spinner)v.findViewById(R.id.ch_sp2);
        sp3=(Spinner)v.findViewById(R.id.ch_sp3);
        tv=(TextView)v.findViewById(R.id.ch_tv);
        sp1.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);
        sp3.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(v.getContext(),R.array.days, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(v.getContext(),R.array.Location, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(v.getContext(),R.array.Bus, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);
        return v;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (parent.getId()){
            case R.id.ch_sp1:
                day=Integer.valueOf(pos);

                break;
            case R.id.ch_sp2:
                loc=Integer.valueOf(pos);

                break;
            case R.id.ch_sp3:
                bus=Integer.valueOf(pos);

                break;

        }
        if(day+1>1&&day+1<7){
            if(loc==0){
                if(bus==0){
                    text="";
                    for(int i=0;i<Busdatabase.weekday_stu_bit.length;i++){
                        if(Busdatabase.weekday_stu_bit[i]==6.15)
                            text=text+(i+1)+".    "+Busdatabase.weekday_stu_bit[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekday_stu_bit[i]+"0\n";
                    }
                }
                if(bus==1){
                    text="";
                    for(int i=0;i<Busdatabase.weekday_staf_bit.length;i++){
                        if(Busdatabase.weekday_staf_bit[i]==6.15)
                            text=text+(i+1)+".    "+Busdatabase.weekday_staf_bit[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekday_staf_bit[i]+"0\n";
                    }
                }
            }
            if(loc==1){
                if(bus==0){
                    text="";
                    for(int i=0;i<Busdatabase.weekday_stu_rnc.length;i++){
                        if(Busdatabase.weekday_stu_rnc[i]==15.15)
                            text=text+(i+1)+".    "+Busdatabase.weekday_stu_rnc[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekday_stu_rnc[i]+"0\n";
                    }
                }
                if(bus==1){
                    text="";
                    for(int i=0;i<Busdatabase.weekday_staf_rnc.length;i++){
                        if(Busdatabase.weekday_staf_rnc[i]==8.15||Busdatabase.weekday_staf_rnc[i]==16.15)
                            text=text+(i+1)+".    "+Busdatabase.weekday_staf_rnc[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekday_staf_rnc[i]+"0\n";
                    }
                }
            }
        }
        if(day+1==1){
            if(loc==0){
                if(bus==0){
                    text="";
                    for(int i=0;i<Busdatabase.weekend_stu_bit.length;i++){
                        if(Busdatabase.weekend_stu_bit[i]==6.15)
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_bit[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_bit[i]+"0\n";
                    }
                }
                if(bus==1){
                    text="";
                    for(int i=0;i<Busdatabase.sund_staf_bit.length;i++){
                        if(Busdatabase.sund_staf_bit[i]==6.15)
                            text=text+(i+1)+".    "+Busdatabase.sund_staf_bit[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.sund_staf_bit[i]+"0\n";
                    }
                }
            }
            if(loc==1){
                if(bus==0){
                    text="";
                    for(int i=0;i<Busdatabase.weekend_stu_rnc.length;i++){
                        if(Busdatabase.weekend_stu_rnc[i]==15.15)
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_rnc[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_rnc[i]+"0\n";
                    }
                }
                if(bus==1){
                    text="";
                    for(int i=0;i<Busdatabase.sund_staf_rnc.length;i++){
                        if(Busdatabase.sund_staf_rnc[i]==6.15)
                            text=text+(i+1)+".    "+Busdatabase.sund_staf_rnc[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.sund_staf_rnc[i]+"0\n";
                    }
                }
            }
        }
        if(day+1==7){
            if(loc==0){
                if(bus==0){
                    text="";
                    for(int i=0;i<Busdatabase.weekend_stu_bit.length;i++){
                        if(Busdatabase.weekend_stu_bit[i]==6.15)
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_bit[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_bit[i]+"0\n";
                    }
                }
                if(bus==1){
                    text="";
                    for(int i=0;i<Busdatabase.satur_staf_bit.length;i++){
                        if(Busdatabase.satur_staf_bit[i]==6.15)
                            text=text+(i+1)+".    "+Busdatabase.satur_staf_bit[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.satur_staf_bit[i]+"0\n";
                    }
                }
            }
            if(loc==1){
                if(bus==0){
                    text="";
                    for(int i=0;i<Busdatabase.weekend_stu_rnc.length;i++){
                        if(Busdatabase.weekend_stu_rnc[i]==15.15)
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_rnc[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.weekend_stu_rnc[i]+"0\n";
                    }
                }
                if(bus==1){
                    text="";
                    for(int i=0;i<Busdatabase.satur_staf_rnc.length;i++){
                        if(Busdatabase.satur_staf_rnc[i]==16.15)
                            text=text+(i+1)+".    "+Busdatabase.satur_staf_rnc[i]+"\n";
                        else
                            text=text+(i+1)+".    "+Busdatabase.satur_staf_rnc[i]+"0\n";
                    }
                }
            }
        }
        tv.setText(text);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
