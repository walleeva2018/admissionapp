package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CardView first_card;
    private CardView second_card;
    private CardView third_card;
    private CardView fourth_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first_card=findViewById(R.id.engi);
        first_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openengineering();

            }
        });
        second_card=findViewById(R.id.medi);
        second_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmedical();
            }
        });
        third_card=findViewById(R.id.uni);
        third_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openuniversities();
            }
        });
        fourth_card=findViewById(R.id.othe);
        fourth_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openothers();
            }
        });
    }
    public void openengineering(){
        Intent intent=new Intent(this,Engineering.class);
        startActivity(intent);
    }
    public void openmedical(){
        Intent intent=new Intent(this,Medical.class);
        startActivity(intent);
    }
    public void openuniversities(){
        Intent intent=new Intent(this,University.class);
        startActivity(intent);
    }
    public void openothers(){
        Intent intent=new Intent(this,Others.class);
        startActivity(intent);
    }
}