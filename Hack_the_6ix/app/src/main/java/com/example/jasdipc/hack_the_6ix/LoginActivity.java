package com.example.jasdipc.hack_the_6ix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private NearbyHost nearbyHost;
    private NearbyPlayer nearbyPlayer;
    private APIClient apiClient;
    private Button hostButton;
    private Button playerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        hostButton = (Button) findViewById(R.id.host_button);
        playerButton = (Button) findViewById(R.id.player_button) ;

        hostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearbyHost.startAdvertising();
            }
        });

        playerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearbyPlayer.discover();
            }
        });


        nearbyHost = NearbyHost.getInstance(LoginActivity.this);
        nearbyPlayer = NearbyPlayer.getInstance(LoginActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        apiClient.disconnect();
    }
}
