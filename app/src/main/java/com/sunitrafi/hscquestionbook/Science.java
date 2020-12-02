package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Science extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        Button btnsciencembstu=findViewById(R.id.sciencembstu);
        btnsciencembstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensciencembstu();
            }
        });

        Button btnsciencenstu=findViewById(R.id.sciencenstu);
        btnsciencenstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensciencenstu();
            }
        });

        Button btnsciencehomepage=findViewById(R.id.sciencehomepage);
        btnsciencehomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensciencehomepage();
            }
        });
    }

    public void opensciencembstu()
    {
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, mbstu.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Science science) {
        ConnectivityManager connectivityManager=(ConnectivityManager)science.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void opensciencenstu(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, nstu.class);
            startActivity(intent);
        }
    }

    public void opensciencehomepage(){
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