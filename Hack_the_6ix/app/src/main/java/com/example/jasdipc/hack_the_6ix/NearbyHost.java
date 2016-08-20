package com.example.jasdipc.hack_the_6ix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.common.api.Status;


/**
 * Created by JasdipC on 2016-08-20.
 */
public class NearbyHost implements Connections.MessageListener,
        Connections.ConnectionRequestListener {

    private static NearbyHost nearbyHost;
    private static Context mContext;
    private APIClient apiClient;


    public static NearbyHost getInstance(Context mContext) {
        if (nearbyHost == null) {
            nearbyHost = new NearbyHost(mContext);
        }
        nearbyHost.mContext = mContext;
        return nearbyHost;
    }

    public NearbyHost(Context mContext) {
        this.mContext = mContext;
        apiClient = APIClient.getApiClientInstance(mContext);
        apiClient.connect();
    }

    @Override
    public void onMessageReceived(String s, byte[] bytes, boolean b) {

    }

    @Override
    public void onDisconnected(String s) {

    }

    @Override
    public void onConnectionRequest(String remoteEndpointID, String remoteDeviceID, String remoteEndpointName, byte[] payload) {
        Toast.makeText(mContext, remoteEndpointName + " wants to connect", Toast.LENGTH_SHORT).show();

        Nearby.Connections.acceptConnectionRequest(apiClient.getmGoogleApiClient(), remoteEndpointID, payload, this).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
                if (status.isSuccess()) {
                    Toast.makeText(mContext, "acceptance went well", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void startAdvertising() {

        if(apiClient.isConnected()) {
            Nearby.Connections.startAdvertising(apiClient.getmGoogleApiClient(), "name", null, 0L, this).setResultCallback(new ResultCallback<Connections.StartAdvertisingResult>() {
                @Override
                public void onResult(@NonNull Connections.StartAdvertisingResult result) {
                    if (result.getStatus().isSuccess()) {
                        Toast.makeText(mContext, "Advertising", Toast.LENGTH_SHORT).show();
                    } else {
                        int statusCode = result.getStatus().getStatusCode();
                        // Advertising failed - see statusCode for more details
                    }

                }
            });
        }

    }


}

