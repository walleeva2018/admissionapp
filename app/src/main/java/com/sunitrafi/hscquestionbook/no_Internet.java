package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class no_Internet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no__internet);

        Button btnnointernethomepage=findViewById(R.id.nointernethomepage);
        btnnointernethomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennointernetpage();
            }
        });
    }

    public void opennointernetpage(){
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