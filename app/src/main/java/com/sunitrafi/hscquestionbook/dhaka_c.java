package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dhaka_c extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_c);

        Button btnduc2016=findViewById(R.id.duc2016);
        btnduc2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openduc2016();
            }
        });

        Button btnduc2017=findViewById(R.id.duc2017);
        btnduc2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openduc2017();
            }
        });

        Button btnduc2018=findViewById(R.id.duc2018);
        btnduc2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openduc2018();
            }
        });

        Button btnduc2019=findViewById(R.id.duc2019);
        btnduc2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openduc2019();
            }
        });

        Button btnduchomepage=findViewById(R.id.duchomepage);
        btnduchomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openduchomepage();
            }
        });
    }

    public void openduc2016(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_c_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(dhaka_c dhaka_c) {
        ConnectivityManager connectivityManager=(ConnectivityManager)dhaka_c.getSystemService(Context.CONNECTIVITY_SERVICE);

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


    public void openduc2017(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_c_2017.class);
            startActivity(intent);
        }
    }
    public void openduc2018(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_c_2018.class);
            startActivity(intent);
        }
    }
    public void openduc2019(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_c_2019.class);
            startActivity(intent);
        }
    }
    public void openduchomepage(){

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