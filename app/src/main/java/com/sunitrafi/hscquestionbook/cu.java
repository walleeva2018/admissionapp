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

public class cu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cu);

        Button btncuallunit=findViewById(R.id.cuallunit);
        btncuallunit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuallunit();
            }
        });

        Button btncub=findViewById(R.id.cub);
        btncub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencub();
            }
        });

        Button btncud=findViewById(R.id.cud);
        btncud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencud();
            }
        });

        Button btncuother=findViewById(R.id.cuotheruit);
        btncuother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuotherunit();
            }
        });

        Button btncuhomeppage=findViewById(R.id.cuhomepage);
        btncuhomeppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuhomepage();
            }
        });

        TextView btncuwebsite=findViewById(R.id.cuwebsite);
        btncuwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencuwebsite();
            }
        });
    }

    public void opencuallunit(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cu_all_unit.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(cu cu) {
        ConnectivityManager connectivityManager=(ConnectivityManager)cu.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void opencub(){

        if(!isconnected(this))
        {
           Intent intent=new Intent(this,no_Internet.class);
           startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cu_b.class);
            startActivity(intent);
        }
    }

    public void opencud(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cu_d.class);
            startActivity(intent);
        }
    }

    public void opencuotherunit(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cu_other_unit.class);
            startActivity(intent);
        }
    }

    public void opencuhomepage(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void opencuwebsite(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, cu_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}