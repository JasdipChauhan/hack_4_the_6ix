package com.example.jasdipc.hack_the_6ix;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.Nearby;

/**
 * Created by JasdipC on 2016-08-20.
 */
public class APIClient implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static APIClient apiClient;
    private GoogleApiClient mGoogleApiClient;
    private Context mContext;
    private boolean isConnected;

    public static APIClient getApiClientInstance(Context mContext) {
        if (apiClient == null) {
            apiClient = new APIClient(mContext);
        }

        return apiClient;
    }

    private APIClient(Context mContext) {
        this.mContext = mContext;

        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Nearby.CONNECTIONS_API)
                .build();

        mGoogleApiClient.connect();
    }

    public void connect() {
        if (mGoogleApiClient != null && !mGoogleApiClient.isConnected() && !mGoogleApiClient.isConnecting()) {
            mGoogleApiClient.connect();
        }
    }

    public void disconnect() {
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected() && !mGoogleApiClient.isConnecting()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        isConnected = true;
    }

    @Override
    public void onConnectionSuspended(int i) {
        isConnected = false;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        isConnected = false;
    }

    public GoogleApiClient getmGoogleApiClient() {
        return mGoogleApiClient;
    }

    public boolean isConnected() {
        isConnected = mGoogleApiClient.isConnected();
        return isConnected;
    }
}
