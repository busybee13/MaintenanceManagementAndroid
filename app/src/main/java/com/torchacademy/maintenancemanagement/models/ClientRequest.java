package com.torchacademy.maintenancemanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar.halabi on 6/23/2016.
 */
public class ClientRequest implements Parcelable {
    String status;
    String name;

    // FIXME: 6/23/2016 this is date
    String time;

    public ClientRequest() {

    }

    public ClientRequest(String name, String status, String time) {
        this.name = name;
        this.status = status;
        this.time = time;

    }

    protected ClientRequest(Parcel in) {
        status = in.readString();
        name = in.readString();
        time = in.readString();
    }

    public static final Creator<ClientRequest> CREATOR = new Creator<ClientRequest>() {
        @Override
        public ClientRequest createFromParcel(Parcel in) {
            return new ClientRequest(in);
        }

        @Override
        public ClientRequest[] newArray(int size) {
            return new ClientRequest[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static List<ClientRequest> dummyList() {
        List<ClientRequest> clientRequests = new ArrayList<>();

        clientRequests.add(new ClientRequest("Request 1", "Pending", "20-1-2016"));
        clientRequests.add(new ClientRequest("Request 2", "Pending", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 3", "Pending", "20-3-2014"));
        clientRequests.add(new ClientRequest("Request 4", "Pending", "20-1-2016"));
        clientRequests.add(new ClientRequest("Request 5", "Completed", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 6", "Ongoing", "20-3-2014"));
        clientRequests.add(new ClientRequest("Request 7", "Ongoing", "20-1-2016"));
        clientRequests.add(new ClientRequest("Request 8", "Completed", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 9", "Completed", "20-3-2014"));
        clientRequests.add(new ClientRequest("Request 10", "Ongoing", "20-1-2016"));
        clientRequests.add(new ClientRequest("Request 11", "Completed", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 12", "Completed", "20-3-2014"));
        return clientRequests;
    }

    public static List<ClientRequest> dummyListPending() {
        List<ClientRequest> clientRequests = new ArrayList<>();

        clientRequests.add(new ClientRequest("Request 1", "Pending", "20-1-2016"));
        clientRequests.add(new ClientRequest("Request 2", "Pending", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 3", "Pending", "20-3-2014"));
        clientRequests.add(new ClientRequest("Request 4", "Pending", "20-1-2016"));
        return clientRequests;
    }

    public static List<ClientRequest> dummyListCompleted() {
        List<ClientRequest> clientRequests = new ArrayList<>();


        clientRequests.add(new ClientRequest("Request 5", "Completed", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 8", "Completed", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 9", "Completed", "20-3-2014"));
        clientRequests.add(new ClientRequest("Request 11", "Completed", "30-6-2015"));
        clientRequests.add(new ClientRequest("Request 12", "Completed", "20-3-2014"));
        return clientRequests;
    }


    public static List<ClientRequest> dummyListOngoing() {
        List<ClientRequest> clientRequests = new ArrayList<>();
        clientRequests.add(new ClientRequest("Request 6", "Ongoing", "20-3-2014"));
        clientRequests.add(new ClientRequest("Request 7", "Ongoing", "20-1-2016"));
        clientRequests.add(new ClientRequest("Request 10", "Ongoing", "20-1-2016"));
        return clientRequests;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(name);
        dest.writeString(time);
    }
}
