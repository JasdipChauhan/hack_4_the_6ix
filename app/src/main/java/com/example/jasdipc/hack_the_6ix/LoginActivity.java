package com.example.jasdipc.hack_the_6ix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button guestButton = (Button) findViewById(R.id.guestButton);
        assert guestButton!=null;
        guestButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View arg0){
               Intent playerActivity = new Intent(LoginActivity.this,PlayerActivity.class);
               startActivity(playerActivity);
            }
        });


    }
}
