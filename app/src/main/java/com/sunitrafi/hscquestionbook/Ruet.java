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

public class Ruet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruet);

        Button btnruethp=findViewById(R.id.ruet_home_page);
        btnruethp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruetgoback();
            }
        });

        Button btnruet2016=findViewById(R.id.ruet2016);
        btnruet2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openruet2016();
            }
        });

        Button btnruet2017=findViewById(R.id.ruet2017);
        btnruet2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openruet2017();
            }
        });

        Button btnruet2018=findViewById(R.id.ruet2018);
        btnruet2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openruet2018();
            }
        });

        TextView ruetwebsite=findViewById(R.id.ruetwebsite);
        ruetwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openruetwebsite();
            }
        });
    }

    public void ruetgoback(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openruet2016(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ruet_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Ruet ruet) {
        ConnectivityManager connectivityManager=(ConnectivityManager)ruet.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openruet2017(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ruet_2017.class);
            startActivity(intent);
        }
    }

    public void openruet2018(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ruet_2018.class);
            startActivity(intent);
        }
    }

    public void openruetwebsite(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ruet_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        this.finish();
    }
}