package com.example.jasdipc.hack_the_6ix;

/**
 * Created by JasdipC on 2016-08-20.
 */
public class HostModel {
    private String endpointID;
    private String deviceID;
    private String serviceID;
    private String name;

    public HostModel(String endpointID, String deviceID, String serviceID, String name) {
        this.endpointID = endpointID;
        this.deviceID = deviceID;
        this.serviceID = serviceID;
        this.name = name;
    }

    public String getEndpointID() {
        return endpointID;
    }

    public void setEndpointID(String endpointID) {
        this.endpointID = endpointID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
