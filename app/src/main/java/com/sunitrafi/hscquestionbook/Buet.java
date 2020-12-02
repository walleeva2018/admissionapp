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

public class Buet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buet);


        Button btnhp=findViewById(R.id.buet_home_button);
        btnhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();
            }
        });

        Button btnbuet2016=findViewById(R.id.buet2016);
        btnbuet2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuet2016();
            }
        });

        Button btnbuet2017=findViewById(R.id.buet2017);
        btnbuet2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuet2017();
            }
        });


        Button btnbuet2018=findViewById(R.id.buet2018);
        btnbuet2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuet2018();
            }
        });

        TextView btnbuetwebsite=findViewById(R.id.buetwebsite);
        btnbuetwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuetwebsite();
            }
        });

    }
    public void goback(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openbuet2016(){
        if(!isconnected(this))
        {
              Intent intent =new Intent(this,no_Internet.class);
              startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, buet_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Buet buet) {

        ConnectivityManager connectivityManager=(ConnectivityManager)buet.getSystemService(Context.CONNECTIVITY_SERVICE);

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


    public void openbuet2017(){
        if(!isconnected(this))
        {
               Intent intent=new Intent(this,no_Internet.class);
               startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, buet_2017.class);
            startActivity(intent);
        }
    }

    public void openbuet2018(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, buet_2018.class);
            startActivity(intent);
        }
    }

    public void openbuetwebsite(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else{
            Intent intent=new Intent(this,buet_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}