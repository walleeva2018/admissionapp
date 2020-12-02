package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Medical extends AppCompatActivity {

    private Button btnmm;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        btnmm=(Button)findViewById(R.id.main_menu_med);
        btnmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();
            }
        });

        Button btn20=findViewById(R.id.med_2009_20);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gomed20();
            }
        });

        Button btnchap=findViewById(R.id.med_chapter_wise);
        btnchap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gomedchap();
            }
        });

        TextView medweb=findViewById(R.id.medical_website);
        medweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gomedweb();
            }
        });

        TextView medpros=findViewById(R.id.medical_prospectus);
        medpros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gomedpros();
            }
        });

        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-3646774575054065/3674837773");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void goback(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void gomed20(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, med_2010_19.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(Medical medical) {
        ConnectivityManager connectivityManager=(ConnectivityManager)medical.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void gomedchap(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, med_chapter.class);
            startActivity(intent);
        }
    }

    public void gomedweb(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, medicalwebsite.class);
            startActivity(intent);
        }
    }

    public void gomedpros(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, medicalprospectus.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}