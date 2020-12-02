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

public class KUET extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_u_e_t);


        Button btnkuet2014=findViewById(R.id.kuet2014);
        btnkuet2014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkuet2014();
            }
        });

        Button btnkuet2018=findViewById(R.id.kuet2018);
        btnkuet2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkuet2018();
            }
        });

        Button btnkuet2019=findViewById(R.id.kuet2019);
        btnkuet2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkuet2019();
            }
        });

        Button btnkuethome=findViewById(R.id.kuet_home_page);
        btnkuethome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkuethome();
            }
        });

        TextView btnkuetwebsite=findViewById(R.id.kuetwebsite);
        btnkuetwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openkuetwebsite();
            }
        });

    }

    public void openkuet2014(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, kuet_2014.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(KUET kuet) {
        ConnectivityManager connectivityManager=(ConnectivityManager)kuet.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openkuet2018(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, kuet_2018.class);
            startActivity(intent);
        }
    }

    public void openkuet2019(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, kuet_2019.class);
            startActivity(intent);
        }
    }

    public  void openkuethome(){

        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openkuetwebsite(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, kuet_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        this.finish();
    }
}