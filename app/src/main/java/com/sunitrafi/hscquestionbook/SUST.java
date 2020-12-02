package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SUST extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_u_s_t);

        Button sustbtnhp=findViewById(R.id.sust_home_page);
        sustbtnhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sustgoback();
            }
        });

        Button btnsust2016=findViewById(R.id.sust2016);
        btnsust2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensust2016();
            }
        });


        Button btnsust2017=findViewById(R.id.sust2017);
        btnsust2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensust2017();
            }
        });

        TextView btnsustwebsite=findViewById(R.id.sustwebsite);
        btnsustwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensustwebsite();
            }
        });

    }

    public void sustgoback(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void opensust2016(){
        if(!isconnected(this))
        {
            Intent intent =new  Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, sust_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(SUST sust) {

        ConnectivityManager connectivityManager=(ConnectivityManager)sust.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wificon=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobilecon=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if(( wificon!=null && wificon.isConnected() ) || (mobilecon!=null && mobilecon.isConnected()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void opensust2017(){
        if(!isconnected(this))
        {
            Intent intent =new  Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, sust_2017.class);
            startActivity(intent);
        }
    }

    public void opensustwebsite(){
        if(!isconnected(this))
        {
            Intent intent =new  Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, sust_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}