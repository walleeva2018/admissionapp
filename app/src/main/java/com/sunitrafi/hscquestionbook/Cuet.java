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

public class Cuet extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuet);

        Button cuetbtnc=findViewById(R.id.cuet_home_page);
        cuetbtnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuetgoback();
            }
        });

        Button btncuet2016=findViewById(R.id.cuet2016);
        btncuet2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuet2016();
            }
        });

        Button btncuet2017=findViewById(R.id.cuet2017);
        btncuet2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuet2017();
            }
        });

        Button btncuet2018=findViewById(R.id.cuet2018);
        btncuet2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuet2018();
            }
        });

        TextView cuetwebsite=findViewById(R.id.cuetwebsite);
        cuetwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuetwebsite();
            }
        });


    }

    public void cuetgoback(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void opencuet2016(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cuet_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Cuet cuet) {
        ConnectivityManager connectivityManager=(ConnectivityManager)cuet.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void opencuet2017(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cuet_2017.class);
            startActivity(intent);
        }
    }

    public void opencuet2018(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cuet_2018.class);
            startActivity(intent);
        }
    }

    public void opencuetwebsite(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cuet_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}