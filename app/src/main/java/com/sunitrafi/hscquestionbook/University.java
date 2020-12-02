package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class University extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        Button jubtn=findViewById(R.id.ju);
        jubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openju();
            }
        });

        Button btndu=findViewById(R.id.dhaka);
        btndu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godu();
            }
        });

        Button btnjnu=findViewById(R.id.jnu);
        btnjnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gojnu();
            }
        });

        Button btncu=findViewById(R.id.cu);
        btncu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gocu();
            }
        });

        Button btnru=findViewById(R.id.ru);
        btnru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goru();
            }
        });

        Button btnku=findViewById(R.id.ku);
        btnku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goku();
            }
        });

        Button btnother=findViewById(R.id.uni_other);
        btnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goother();
            }
        });
    }
    public void openju(){
        Intent intent=new Intent(this,JU.class);
        startActivity(intent);
    }

    public void godu(){
        Intent intent=new Intent(this,DU.class);
        startActivity(intent);
    }

    public void goru(){
        Intent intent=new Intent(this,RU.class);
        startActivity(intent);
    }

    public void gocu()
    {
        Intent intent=new Intent(this,cu.class);
        startActivity(intent);
    }

    public void gojnu(){
        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, jnupdf.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(University university) {
        ConnectivityManager connectivityManager=(ConnectivityManager)university.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void goku(){
        Intent intent=new Intent(this,kupdf.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goother(){
        Intent intent=new Intent(this,university_others.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}