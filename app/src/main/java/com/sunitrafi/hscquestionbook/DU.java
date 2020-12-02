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

public class DU extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_u);
        Button btnmm=findViewById(R.id.main_menu_du);
        btnmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();
            }
        });

        Button btndua=findViewById(R.id.du_a);
        btndua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godua();
            }
        });

        Button btndub=findViewById(R.id.du_b);
        btndub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godub();
            }
        });

        Button btnduc=findViewById(R.id.du_c);
        btnduc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goduc();
            }
        });

        Button btndud=findViewById(R.id.du_d);
        btndud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godud();
            }
        });

        Button btnduf=findViewById(R.id.du_f);
        btnduf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goduf();
            }
        });

        TextView btnduwebsite=findViewById(R.id.dhakawebsite);
        btnduwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openduwebsite();
            }
        });
    }
    public void goback(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void godua(){


        Intent intent=new Intent(this,dhaka_a.class);
        startActivity(intent);

    }

    public void godub(){
        Intent intent= new Intent(this,dhaka_b.class);
        startActivity(intent);
    }

    public void goduc(){
        Intent intent=new Intent(this,dhaka_c.class);
        startActivity(intent);
    }

    public void godud(){
        Intent intent=new Intent(this,dhaka_d.class);
        startActivity(intent);
    }

    public void goduf(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_f.class);
            startActivity(intent);
        }
    }

    private boolean isconnected(DU du) {
        ConnectivityManager connectivityManager=(ConnectivityManager)du.getSystemService(Context.CONNECTIVITY_SERVICE);

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

    public void openduwebsite(){

        if(!isconnected(this))
        {
            Intent intent=new Intent(this,no_Internet.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, du_website.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}