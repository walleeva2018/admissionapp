package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Agriculture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture);

        Button btnagrienglish=findViewById(R.id.agricultureenglish);
        btnagrienglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openagrienglish();
            }
        });

        Button btnagrigk=findViewById(R.id.agriculturegk);
        btnagrigk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openagrigk();
            }
        });

        Button btnagrihome=findViewById(R.id.agriculturehomepage);
        btnagrihome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openagrihome();
            }
        });
    }

    public void openagrienglish(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, agri_english.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Agriculture agriculture) {

        ConnectivityManager connectivityManager=(ConnectivityManager)agriculture.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openagrigk(){

        if(!isconnected(this))
        {
             Intent intent=new Intent(this,no_Internet.class);
             startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, agri_general_knowledge.class);
            startActivity(intent);
        }
    }

    public void openagrihome(){
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