package com.torchacademy.maintenancemanagement.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.torchacademy.maintenancemanagement.R;
import com.torchacademy.maintenancemanagement.models.ClientRequest;

import java.util.List;

/**
 * Created by omar.halabi on 6/23/2016.
 */
public class ClientRequestAdapter extends  RecyclerView.Adapter<ClientRequestAdapter.ViewHolder>{


    private List<ClientRequest> clientRequestList;
    private Context context;

    public ClientRequestAdapter(Context context, List<ClientRequest> clientRequests) {
        this.clientRequestList = clientRequests;
        this.context = context;
    }

    public void setClientRequestList(List<ClientRequest> clientRequestList) {
        this.clientRequestList = clientRequestList;
        notifyDataSetChanged();
    }

    public List<ClientRequest> getClientRequestList() {
        return clientRequestList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.request_list_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ClientRequest clientRequest = clientRequestList.get(position);
        holder.textView_request_status.setText("\"" + clientRequest.getName() + "\" is " + clientRequest.getStatus());
    }

    @Override
    public int getItemCount() {
        return clientRequestList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_request_status;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_request_status = (TextView) itemView.findViewById(R.id.textView_request_status);
        }
    }
}
