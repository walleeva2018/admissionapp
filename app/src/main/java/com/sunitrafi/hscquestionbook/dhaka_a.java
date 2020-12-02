package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dhaka_a extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_a);

        Button btndua2016=findViewById(R.id.dua2016);
        btndua2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendua2016();
            }
        });

        Button btndua2017=findViewById(R.id.dua2017);
        btndua2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendua2017();
            }
        });

        Button btndua2018=findViewById(R.id.dua2018);
        btndua2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendua2018();
            }
        });

        Button btndua2019=findViewById(R.id.dua2019);
        btndua2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendua2019();
            }
        });

        Button btnduahomepage=findViewById(R.id.duahomepage);
        btnduahomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openduahomepage();
            }
        });
    }


    public void opendua2016(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_a_2016.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(dhaka_a dhaka_a) {
        ConnectivityManager connectivityManager=(ConnectivityManager)dhaka_a.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void opendua2017(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_a_2017.class);
            startActivity(intent);
        }
    }

    public void opendua2018(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_a_2018.class);
            startActivity(intent);
        }
    }

    public void opendua2019(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_a_2019.class);
            startActivity(intent);
        }
    }

    public void openduahomepage(){
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