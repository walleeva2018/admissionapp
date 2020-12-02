package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class university_others extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_others);

        Button btnotherbu=findViewById(R.id.otherbu);
        btnotherbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openotherbu();
            }
        });

        Button btnothercou=findViewById(R.id.othercou);
        btnothercou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openothercou();
            }
        });

        Button btnotherjkkniu=findViewById(R.id.otherjkkniu);
        btnotherjkkniu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openotherjkkniu();
            }
        });

        Button btnotherhomepage=findViewById(R.id.otherhomepage);
        btnotherhomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openotherhomepage();
            }
        });
    }

    public void openotherbu(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, bu.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(university_others university_others) {
        ConnectivityManager connectivityManager=(ConnectivityManager)university_others.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openothercou(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cou.class);
            startActivity(intent);
        }
    }

    public void openotherjkkniu(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, Jkkkniu.class);
            startActivity(intent);
        }
    }

    public void openotherhomepage(){
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