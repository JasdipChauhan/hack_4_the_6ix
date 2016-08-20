package com.example.jasdipc.hack_the_6ix;

import android.content.ContentValues;
import android.content.Context;

import com.google.android.gms.nearby.connection.Connections;

/**
 * Created by JasdipC on 2016-08-20.
 */
public class NearbyPlayer implements Connections.MessageListener,
        Connections.EndpointDiscoveryListener {

    private static NearbyPlayer nearbyPlayer;
    private static Context mContext;
    private APIClient apiClient;


    public static NearbyPlayer getInstance(Context mContext) {
        if (nearbyPlayer == null) {
            nearbyPlayer = new NearbyPlayer(mContext);
        }
        nearbyPlayer.mContext = mContext;
        return nearbyPlayer;
    }

    public NearbyPlayer(Context mContext) {
        this.mContext = mContext;
        apiClient = APIClient.getApiClientInstance(mContext);
        apiClient.connect();
    }

    @Override
    public void onEndpointFound(String s, String s1, String s2, String s3) {
        
    }

    @Override
    public void onEndpointLost(String s) {

    }

    @Override
    public void onMessageReceived(String s, byte[] bytes, boolean b) {

    }

    @Override
    public void onDisconnected(String s) {

    }
}
