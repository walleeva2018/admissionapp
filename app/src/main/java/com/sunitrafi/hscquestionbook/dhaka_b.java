package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dhaka_b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_b);


        Button btndub2016=findViewById(R.id.dub2016);
        btndub2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendub2016();
            }
        });

        Button btndub2017=findViewById(R.id.dub2017);
        btndub2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendub2017();
            }
        });

        Button btndub2018=findViewById(R.id.dub2018);
        btndub2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendub2018();
            }
        });

        Button btndub2019=findViewById(R.id.dub2019);
        btndub2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendub2019();
            }
        });

        Button btndubhomepage=findViewById(R.id.dubhomepage);
        btndubhomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendubhomepage();
            }
        });
    }


    public void opendub2016(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_b_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(dhaka_b dhaka_b) {
        ConnectivityManager connectivityManager=(ConnectivityManager)dhaka_b.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void opendub2017(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_b_2017.class);
            startActivity(intent);
        }
    }

    public void opendub2018(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_b_2018.class);
            startActivity(intent);
        }
    }

    public void opendub2019(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_a_2019.class);
            startActivity(intent);
        }
    }

    public void opendubhomepage(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        this.finish();
    }
}