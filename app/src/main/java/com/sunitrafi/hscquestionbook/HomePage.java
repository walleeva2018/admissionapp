package com.sunitrafi.hscquestionbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class HomePage extends AppCompatActivity {
    private CardView first_card;
    private CardView second_card;
    private CardView third_card;
    private CardView fourth_card;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Toolbar toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3646774575054065/2361756105");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        first_card=findViewById(R.id.cardView);
        first_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openengineering();

            }
        });
        second_card=findViewById(R.id.cardView2);
        second_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmedical();
            }
        });
        third_card=findViewById(R.id.cardView3);
        third_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openuniversities();
            }
        });
        fourth_card=findViewById(R.id.cardview4);
        fourth_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openothers();
            }
        });
    }
    public void openengineering(){

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Intent intent = new Intent(HomePage.this, Engineering.class);
            startActivity(intent);
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                Intent intent = new Intent(HomePage.this, Engineering.class);
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }
    public void openmedical(){

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Intent intent = new Intent(HomePage.this, Medical.class);
            startActivity(intent);
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                Intent intent = new Intent(HomePage.this, Medical.class);
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }
    public void openuniversities(){

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Intent intent = new Intent(HomePage.this, University.class);
            startActivity(intent);
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                Intent intent = new Intent(HomePage.this, University.class);
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }
    public void openothers(){

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Intent intent = new Intent(HomePage.this, Others.class);
            startActivity(intent);
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                Intent intent = new Intent(HomePage.this, Others.class);
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.share)
        {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage= "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Share with"));
            } catch(Exception e) {
                Toast.makeText(HomePage.this,"Can not Share an error occured",Toast.LENGTH_LONG).show();
            }

        }
        else if(id==R.id.rate)
        {
            Uri uri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());

            if(!isconnected(this))
            {
                Intent intent=new Intent(this,no_Internet.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        }
        else if(id==R.id.credits)
        {
            Intent intent=new Intent(this,privacy_policy.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isconnected(HomePage homePage) {

        ConnectivityManager connectivityManager=(ConnectivityManager)homePage.getSystemService(Context.CONNECTIVITY_SERVICE);

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
}