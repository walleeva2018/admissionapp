package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Engineering extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering);

        btn=(Button)findViewById(R.id.buet);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuet();
            }
        });

        Button btnkuet= findViewById(R.id.kuetarButton);

        btnkuet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkuet();
            }
        });


        Button btnruet= findViewById(R.id.ruet);
        btnruet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openruet();
            }
        });

        Button btncuet=findViewById(R.id.cuet);
        btncuet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuet();
            }
        });

        Button btnsust=findViewById(R.id.sust);
        btnsust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensust();
            }
        });

        Button btnbutex=findViewById(R.id.butex);
        btnbutex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbutex();
            }
        });

    }
    public void openbuet(){
        Intent intent=new Intent(this,Buet.class);
        startActivity(intent);

    }

    public void openkuet(){
        Intent intent=new Intent(this,KUET.class);
        startActivity(intent);

    }

    public void openruet(){
        Intent intent=new Intent(this,Ruet.class);
        startActivity(intent);
    }

    public void opencuet(){
        Intent intent=new Intent(this,Cuet.class);
        startActivity(intent);
    }

    public void opensust(){
        Intent intent=new Intent(this,SUST.class);
        startActivity(intent);
    }

    public void openbutex(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, butex_2016.class);
            startActivity(intent);
        }

    }

    private boolean isconnected(Engineering engineering) {

        ConnectivityManager connectivityManager=(ConnectivityManager)engineering.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}