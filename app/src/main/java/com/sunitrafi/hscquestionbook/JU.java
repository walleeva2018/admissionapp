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

public class JU extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_u);

        Button btnjua=findViewById(R.id.ju_a);
        btnjua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gojua();
            }
        });

        Button btnjub=findViewById(R.id.jub);
        btnjub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjub();
            }
        });

        Button btnjuc=findViewById(R.id.juc);
        btnjuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjuc();
            }
        });

        Button btnjud=findViewById(R.id.jud);
        btnjud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjud();
            }
        });

        Button btnjue=findViewById(R.id.jue);
        btnjue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjue();
            }
        });

        Button btnjuf=findViewById(R.id.juf);
        btnjuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjuf();
            }
        });

        Button btnjuh=findViewById(R.id.juh);
        btnjuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjuh();
            }
        });

        TextView btnjuwebsite=findViewById(R.id.juwebsite);
        btnjuwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjuwebsite();
            }
        });
    }

    public void gojua(){
        Intent intent=new Intent(this,ju_a.class);
        startActivity(intent);
    }

    public void openjub(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ju_b.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(JU ju) {
        ConnectivityManager connectivityManager=(ConnectivityManager)ju.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openjuc(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ju_c.class);
            startActivity(intent);
        }
    }

    public void openjud(){
        Intent intent=new Intent(this,ju_d.class);
        startActivity(intent);
    }

    public void openjue(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ju_e.class);
            startActivity(intent);
        }
    }

    public void openjuf(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ju_f.class);
            startActivity(intent);
        }
    }

    public void openjuh(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, ju_h.class);
            startActivity(intent);
        }
    }

    public void openjuwebsite(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ju_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}