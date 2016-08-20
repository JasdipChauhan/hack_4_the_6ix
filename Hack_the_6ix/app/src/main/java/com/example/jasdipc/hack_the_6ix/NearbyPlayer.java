package com.example.jasdipc.hack_the_6ix;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;

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

    public void discover() {

        String serviceID = mContext.getString(R.string.service_id);

        Nearby.Connections.startDiscovery(apiClient.getmGoogleApiClient(), serviceID, 0L, this).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
                if (status.isSuccess()) {
                    Toast.makeText(mContext, "Discovering", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i("discovering", "failed");
                }
            }
        });

    }


    @Override
    public void onEndpointFound(String endpointID, String deviceID, String serviceID, String name) {
        Nearby.Connections.sendConnectionRequest(apiClient.getmGoogleApiClient(), usersName, endpointID, null, new Connections.ConnectionResponseCallback() {
            @Override
            public void onConnectionResponse(String remoteEndpointID, Status status, byte[] payload) {
                switch (status.getStatusCode()) {
                    case ConnectionsStatusCodes.STATUS_OK:
                        Toast.makeText(mContext, "Connection Successful!", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(mContext, "No response", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, this);

    }

    @Override
    public void onEndpointLost(String endpointID) {

    }

    @Override
    public void onMessageReceived(String s, byte[] bytes, boolean b) {

    }

    @Override
    public void onDisconnected(String s) {

    }
}
