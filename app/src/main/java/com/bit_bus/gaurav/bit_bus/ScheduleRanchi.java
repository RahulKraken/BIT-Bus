package com.bit_bus.gaurav.bit_bus;

import java.util.Calendar;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ScheduleRanchi extends Fragment implements View.OnClickListener{
    TextView stutime,staftime,sc_day,sc_day1,t,tt;
    Button br1,bn1,br2,bn2,pb1,pb2;
    Calendar cal = Calendar.getInstance();
    double currentstu,currentstaf;
    int i,j,x,y;
    int day1=cal.get(Calendar.DAY_OF_WEEK);
    int day2=cal.get(Calendar.DAY_OF_WEEK);
    int dayres1=cal.get(Calendar.DAY_OF_WEEK);
    int dayres2=cal.get(Calendar.DAY_OF_WEEK);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_schedule, container, false);
        stutime = (TextView) v.findViewById(R.id.sc_sbt);
        staftime = (TextView) v.findViewById(R.id.sc_sbt1);

        t=(TextView)v.findViewById(R.id.textView10);
        br1 = (Button) v.findViewById(R.id.sc_b1);
        bn1 = (Button) v.findViewById(R.id.sc_b2);
        br2 = (Button) v.findViewById(R.id.sc_b3);
        bn2 = (Button) v.findViewById(R.id.sc_b4);
        pb1 = (Button) v.findViewById(R.id.sc_pb1);
        pb2 = (Button) v.findViewById(R.id.sc_pb2);
        sc_day=(TextView)v.findViewById(R.id.sc_day);
        sc_day1=(TextView)v.findViewById(R.id.sc_weekday1);
        br1.setOnClickListener(this);
        br2.setOnClickListener(this);
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
        pb1.setOnClickListener(this);
        pb2.setOnClickListener(this);
        dispViewSturnc();
        dispViewStafrnc();
        t.setText("From Ranchi");

        return v;
    }



    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.sc_b2:
                x++;


                if (day1 >= 2 && day1 <= 6) {
                    if (day1 == 6 && x == Busdatabase.weekday_stu_rnc.length) {
                        day1 = 7;
                        sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        x = 0;
                        stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString() + "0");
                    } else {
                        if (x == Busdatabase.weekday_stu_rnc.length)
                            day1 = (day1 + 1) % 7;
                        if (day1 == 0)
                            day1 = 7;
                        sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        x = x % Busdatabase.weekday_stu_rnc.length;
                        if (Busdatabase.weekday_stu_rnc[x] == 15.15)
                            stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString());
                        else
                            stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString() + "0");
                    }
                } else if (day1 == 7 || day1 == 1) {
                    if (day1 == 1 && x == Busdatabase.weekend_stu_rnc.length) {
                        day1 = (day1 + 1) % 7;
                        if (day1 == 0)
                            day1 = 7;
                        sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        x = x % Busdatabase.weekend_stu_rnc.length;
                        if(Busdatabase.weekday_stu_rnc[x]==15.15)
                            stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString());
                        else
                        stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString()+"0");

                    } else {
                        if (x == Busdatabase.weekend_stu_rnc.length) {
                            day1 = (day1 + 1) % 7;
                            if (day1 == 0)
                                day1 = 7;
                            sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        }
                        x = x % Busdatabase.weekend_stu_rnc.length;
                        if(Busdatabase.weekend_stu_rnc[x]==15.15)
                            stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString());
                        else
                        stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString() + "0");
                    }
                }
                break;

            case R.id.sc_b1:
                resetViewSturnc();

                break;
            case R.id.sc_b4:
                y++;

                if (day2 > 1 && day2 < 7) {
                    if (day2 == 6 && y == Busdatabase.weekday_staf_rnc.length) {
                        day2 = 7;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = 0;
                        staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[y]).toString() + "0");
                    } else {
                        if (y == Busdatabase.weekday_staf_rnc.length)
                            day2 = (day2 + 1) % 7;
                        if (day2 == 0)
                            day2 = 7;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = y % Busdatabase.weekday_staf_rnc.length;
                        if(Busdatabase.weekday_staf_rnc[y]==16.15||Busdatabase.weekday_staf_rnc[y]==8.15)
                            staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString());
                        else
                        staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString() + "0");
                    }
                } else if (day2 == 7) {
                    if (day2 == 7 && y == Busdatabase.satur_staf_rnc.length) {
                        day2 = 1;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = 0;
                        staftime.setText(Double.valueOf(Busdatabase.sund_staf_rnc[y]).toString() + "0");
                    } else {
                        if (y == Busdatabase.satur_staf_rnc.length)
                            day2 = (day2 + 1) % 7;
                        if (day2 == 0)
                            day2 = 7;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = y % Busdatabase.satur_staf_rnc.length;
                        if(Busdatabase.satur_staf_rnc[y]==16.15)
                            staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[y]).toString());
                        else
                        staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[y]).toString() + "0");
                    }
                } else if (day2 == 1) {
                    if (day2 == 1 && y == Busdatabase.sund_staf_rnc.length) {
                        day2 = 2;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = 0;
                        staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString() + "0");
                    } else {
                        if (y == Busdatabase.sund_staf_rnc.length)
                            day2 = (day2 + 1) % 7;
                        if (day2 == 0)
                            day2 = 7;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = y % Busdatabase.sund_staf_rnc.length;
                        staftime.setText(Double.valueOf(Busdatabase.sund_staf_rnc[y]).toString() + "0");
                    }
                }
                break;
            case R.id.sc_b3:
                resetViewStafrnc();
                break;
            case R.id.sc_pb1:
                x--;


                if (day1 >=2 && day1 <= 6) {
                    if (day1 == 2 && x == -1) {
                        day1 = 1;
                        sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        x = Busdatabase.weekend_stu_rnc.length-1;
                        stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString() + "0");
                    } else {
                        if (x == -1) {
                            day1 = (day1 - 1);
                            x=Busdatabase.weekday_stu_rnc.length-1;
                        }
                        sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        if (Busdatabase.weekday_stu_rnc[x] == 15.15)
                            stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString());
                        else
                            stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString() + "0");
                    }
                } else if (day1 == 7 || day1 == 1) {
                    if (day1 == 7 && x == -1) {
                        day1--;
                        sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        x =Busdatabase.weekday_stu_rnc.length-1;
                        stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString()+"0");

                    } else {
                        if (x == -1) {
                            day1=7;
                            x=Busdatabase.weekend_stu_rnc.length-1;
                        }
                        sc_day.setText(Busdatabase.weekday[day1 - 1]);
                        if(Busdatabase.weekend_stu_rnc[x]==15.15)
                            stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString());
                        else
                            stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString() + "0");
                    }
                }
                break;
            case R.id.sc_pb2:
                y--;

                if (day2 > 1 && day2 < 7) {
                    if (day2 == 2 && y == -1) {
                        day2 = 1;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = Busdatabase.sund_staf_rnc.length-1;
                        staftime.setText(Double.valueOf(Busdatabase.sund_staf_rnc[y]).toString() + "0");
                    } else {
                        if (y == -1) {
                            day2--;
                            y=Busdatabase.weekday_staf_rnc.length-1;
                        }
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        if(Busdatabase.weekday_staf_rnc[y]==16.15||Busdatabase.weekday_staf_rnc[y]==8.15)
                            staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString());
                        else
                            staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString() + "0");
                    }
                } else if (day2 == 7) {
                    if (day2 == 7 && y == -1) {
                        day2 = 6;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = Busdatabase.weekday_staf_rnc.length-1;
                        staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString() + "0");
                    } else {
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        if(Busdatabase.satur_staf_rnc[y]==16.15||Busdatabase.satur_staf_rnc[y]==8.15)
                            staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[y]).toString());
                        else
                            staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[y]).toString() + "0");
                    }
                } else if (day2 == 1) {
                    if (day2 == 1 && y == -1) {
                        day2 = 7;
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        y = Busdatabase.satur_staf_rnc.length-1;
                        staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[y]).toString() + "0");
                    } else {
                        sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                        staftime.setText(Double.valueOf(Busdatabase.sund_staf_rnc[y]).toString() + "0");
                    }
                }
                break;
        }
    }
    public void resetViewSturnc(){
        if (dayres1 >= 2 && dayres1 <= 6) {
            if(Busdatabase.weekday_stu_rnc[i]==15.15)
                stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[i]).toString());
            else
                stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[i]).toString()+"0");
        }
        else if(dayres1==1||dayres1==7){
            if(Busdatabase.weekend_stu_rnc[i]==15.15)
                stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[i]).toString());
            else
            stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[i]).toString()+"0");
        }x = i;
        day1=dayres1;
        sc_day.setText(Busdatabase.weekday[day1-1]);
    }
    public void resetViewStafrnc(){
        if(dayres2 >=2 && dayres2<=6) {
            if(Busdatabase.weekday_staf_rnc[j]==16.15||Busdatabase.weekday_staf_rnc[j]==8.15)
                staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[j]).toString());
            else
            staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[j]).toString() + "0");
        }
        else if(dayres2==7)
            if(Busdatabase.satur_staf_rnc[j]==16.15)
                staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[j]).toString());
        else
            staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[j]).toString() + "0");
        else if(dayres2==1)
            staftime.setText(Double.valueOf(Busdatabase.sund_staf_rnc[j]).toString() + "0");
        y=j;
        day2=dayres2;
        sc_day1.setText(Busdatabase.weekday[day2-1]);
    }

    public void dispViewSturnc() {
        int day = cal.get(Calendar.DAY_OF_WEEK);
        double hour = cal.get(Calendar.HOUR_OF_DAY);
        double min = cal.get(Calendar.MINUTE);
        if (day > 1 && day < 7) {
            for (i = 0; i < Busdatabase.weekday_stu_rnc.length; i++) {
                if (hour + min / 100 <= Busdatabase.weekday_stu_rnc[i]) {
                    currentstu = Busdatabase.weekday_stu_rnc[i];
                    if (Busdatabase.weekday_stu_rnc[i] == 15.15) {
                        stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[i]).toString());
                        sc_day.setText(Busdatabase.weekday[day - 1]);
                    } else {
                        stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[i]).toString() + "0");
                        sc_day.setText(Busdatabase.weekday[day - 1]);
                    }
                    x = i;
                    break;

                }
            }
            if (day > 1 && day < 6 && i == Busdatabase.weekday_stu_rnc.length) {
                x = 0;
                day1++;
                dayres1 = day1;
                i = 0;
                stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString()+"0");
                sc_day.setText(Busdatabase.weekday[day1 - 1]);
            }
            if (day == 6 && i == Busdatabase.weekday_stu_rnc.length) {
                x = 0;
                day1++;
                dayres1 = day1;
                i = 0;
                stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString() + "0");
                sc_day.setText(Busdatabase.weekday[day1 - 1]);
            }
        } else if (day == 1 || day == 7) {
            for (i = 0; i < Busdatabase.weekend_stu_rnc.length; i++) {
                if (hour + min / 100 <= Busdatabase.weekend_stu_rnc[i]) {
                    if(Busdatabase.weekend_stu_rnc[i]==15.15)
                        stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[i]).toString());
                    else
                    stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[i]).toString() + "0");
                    sc_day.setText(Busdatabase.weekday[day1 - 1]);
                    x = i;
                    break;
                }
            }
            if (day == 1 && i == Busdatabase.weekend_stu_rnc.length) {
                x = 0;
                i = 0;
                day1 = 2;
                dayres1 = day1;
                stutime.setText(Double.valueOf(Busdatabase.weekday_stu_rnc[x]).toString()+"0");
                sc_day.setText(Busdatabase.weekday[day1 - 1]);
            }
            if (day == 7 && i == Busdatabase.weekend_stu_rnc.length) {
                x = 0;
                i = 0;
                day1 = 1;
                dayres1 = day1;
                stutime.setText(Double.valueOf(Busdatabase.weekend_stu_rnc[x]).toString() + "0");
                sc_day.setText(Busdatabase.weekday[day1 - 1]);
            }
        }
    }
    public void dispViewStafrnc() {
        int day = cal.get(Calendar.DAY_OF_WEEK);
        int daychange = day;
        double hour = cal.get(Calendar.HOUR_OF_DAY);
        double min = cal.get(Calendar.MINUTE);
        if (day > 1 && day < 7) {
            for (j = 0; j < Busdatabase.weekday_staf_rnc.length; j++) {
                if (hour + min / 100 <= Busdatabase.weekday_staf_rnc[j]) {
                    currentstaf = Busdatabase.weekday_staf_rnc[j];
                    if(Busdatabase.weekday_staf_rnc[j]==16.15||Busdatabase.weekday_staf_rnc[j]==8.15)
                        staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[j]).toString());
                    else
                    staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[j]).toString() + "0");
                    sc_day1.setText(Busdatabase.weekday[day - 1]);

                    y = j;
                    break;
                }

            }
            if (day > 1 && day < 6 && j == Busdatabase.weekday_staf_rnc.length) {
                y = 0;
                day2++;
                dayres2 = day2;
                j = 0;
                staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString()+"0");
                sc_day1.setText(Busdatabase.weekday[day2 - 1]);
            }
            if (day == 6 && j == Busdatabase.weekday_staf_rnc.length) {
                y = 0;
                day2++;
                dayres2 = day2;
                j = 0;
                staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[y]).toString() + "0");
                sc_day1.setText(Busdatabase.weekday[day2 - 1]);
            }
        } else if (day == 1) {
            for (j = 0; j < Busdatabase.sund_staf_rnc.length; j++) {
                if (hour + min / 100 <= Busdatabase.sund_staf_rnc[j]) {
                    currentstu = Busdatabase.sund_staf_rnc[j];
                    staftime.setText(Double.valueOf(Busdatabase.sund_staf_rnc[j]).toString() + "0");
                    sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                    y = j;
                    break;
                }
            }
            if (day == 1 && j == Busdatabase.sund_staf_rnc.length) {
                y = 0;
                j = 0;
                day2 = 2;
                dayres2 = day2;
                staftime.setText(Double.valueOf(Busdatabase.weekday_staf_rnc[y]).toString() + "0");
                sc_day1.setText(Busdatabase.weekday[day2 - 1]);
            }
        } else if (day == 7) {

            for (j = 0; j < Busdatabase.satur_staf_rnc.length; j++) {
                if (hour + min / 100 <= Busdatabase.satur_staf_rnc[j]) {
                    currentstu = Busdatabase.satur_staf_rnc[j];
                    if(Busdatabase.satur_staf_rnc[j]==16.15)
                        staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[j]).toString());
                    else
                    staftime.setText(Double.valueOf(Busdatabase.satur_staf_rnc[j]).toString() + "0");
                    sc_day1.setText(Busdatabase.weekday[day2 - 1]);
                    y = j;
                    break;
                }
            }

            if (day == 7 && j == Busdatabase.satur_staf_rnc.length) {
                y = 0;
                j = 0;
                day2 = 1;
                dayres2 = day2;
                staftime.setText(Double.valueOf(Busdatabase.sund_staf_rnc[y]).toString() + "0");
                sc_day1.setText(Busdatabase.weekday[day2 - 1]);
            }
        }

    }

}

