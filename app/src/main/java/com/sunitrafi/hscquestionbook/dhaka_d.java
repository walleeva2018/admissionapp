package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dhaka_d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_d);

        Button btndud2016=findViewById(R.id.dud2016);
        btndud2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendud2016();
            }
        });

        Button btndud2017=findViewById(R.id.dud2017);
        btndud2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendud2017();
            }
        });

        Button btndud2018=findViewById(R.id.dud2018);
        btndud2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendud2018();
            }
        });

        Button btndud2019=findViewById(R.id.dud2019);
        btndud2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendud2019();
            }
        });

        Button btndudhomepage=findViewById(R.id.dudhomepage);
        btndudhomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendudhomepage();
            }
        });
    }

    public void opendud2016(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_d_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(dhaka_d dhaka_d) {
        ConnectivityManager connectivityManager=(ConnectivityManager)dhaka_d.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void opendud2017(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_d_2017.class);
            startActivity(intent);
        }
    }

    public void opendud2018(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_d_2018.class);
            startActivity(intent);
        }
    }

    public void opendud2019(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_d_2019.class);
            startActivity(intent);
        }
    }

    public void opendudhomepage(){

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