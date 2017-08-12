package com.example.yang.myapplication.base.mvp.reveiver;

public class NetworkStateEvent {
    public boolean hasNetworkConnected;

    public NetworkStateEvent(boolean hasNetworkConnected) {
        this.hasNetworkConnected = hasNetworkConnected;
    }
}
