package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ju_a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_a);

        Button btnjua2016=findViewById(R.id.jua2016);
        btnjua2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjua2016();
            }
        });

        Button btnjua2018=findViewById(R.id.jua2018);
        btnjua2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjua2018();
            }
        });

        Button btnjuahomepage=findViewById(R.id.juahomepage);
        btnjuahomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjuahomepage();
            }
        });
    }

    public void openjua2016(){
        if(!isconnected(this))
        {
          Intent intent=new Intent(this,no_Internet.class);
          startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ju_a_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(ju_a ju_a) {
        ConnectivityManager connectivityManager=(ConnectivityManager)ju_a.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openjua2018(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ju_a_2018.class);
            startActivity(intent);
        }
    }

    public void openjuahomepage(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}