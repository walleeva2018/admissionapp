package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ju_d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_d);

        Button btnjud2016=findViewById(R.id.jud2016);
        btnjud2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjud2016();
            }
        });

        Button btnjud2018=findViewById(R.id.jud2018);
        btnjud2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjud2018();
            }
        });

        Button btnjudhomepage=findViewById(R.id.judhomapage);
        btnjudhomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjudhomepage();
            }
        });
    }

    public void openjud2016(){
        Intent intent=new Intent(this,ju_d_2016.class);
        startActivity(intent);
    }

    public void openjud2018(){
        Intent intent=new Intent(this,ju_d_2018.class);
        startActivity(intent);
    }

    public void openjudhomepage(){
        Intent intent=new Intent(this,HomePage.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}