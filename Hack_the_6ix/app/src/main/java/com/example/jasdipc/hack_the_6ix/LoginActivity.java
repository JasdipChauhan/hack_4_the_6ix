package com.example.jasdipc.hack_the_6ix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    NearbyHost nearbyHost;
    NearbyPlayer nearbyPlayer;
    APIClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nearbyHost = NearbyHost.getInstance(LoginActivity.this);
        nearbyPlayer = NearbyPlayer.getInstance(LoginActivity.this);
    }

    public void host_game_clicked(View view) {
        nearbyHost.startAdvertising();
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
