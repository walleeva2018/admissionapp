package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Others extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        Button btnmm=findViewById(R.id.main_menu_oth);
        btnmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();
            }
        });


        Button btnag=findViewById(R.id.agriculture);
        btnag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAgriculture();
            }
        });

        Button btnsc=findViewById(R.id.science);
        btnsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goScience();
            }
        });
    }
    public void goback(){
        Intent intent=new Intent(this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goAgriculture(){
        Intent intent=new Intent(this,Agriculture.class);
        startActivity(intent);

    }

    public void goScience(){
        Intent intent=new Intent(this,Science.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}