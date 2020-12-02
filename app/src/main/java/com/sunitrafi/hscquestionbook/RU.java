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

public class RU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_u);

        Button btnru2017=findViewById(R.id.ru2017);
        btnru2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openru2017();
            }
        });

        Button btnru2019=findViewById(R.id.ru2019);
        btnru2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openru2019();
            }
        });

        Button btnruhomepage=findViewById(R.id.ruhomepage);
        btnruhomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openruhomepage();
            }
        });

        TextView btnruwebsite=findViewById(R.id.ruwebsite);
        btnruwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openruwebsite();
            }
        });
    }

    public void openru2017(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ru_2018.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(RU ru) {
        ConnectivityManager connectivityManager=(ConnectivityManager)ru.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openru2019(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ru_2019.class);
            startActivity(intent);
        }
    }

    public void openruhomepage(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openruwebsite() {
        if (!isconnected(this)) {
            Intent intent = new Intent(this, no_Internet.class);
            startActivity(intent);
        } else{
            Intent intent=new Intent(this,ru_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}