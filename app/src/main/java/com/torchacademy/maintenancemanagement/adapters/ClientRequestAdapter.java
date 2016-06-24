package com.torchacademy.maintenancemanagement.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.torchacademy.maintenancemanagement.R;
import com.torchacademy.maintenancemanagement.models.ClientRequest;

import java.util.List;

/**
 * Created by omar.halabi on 6/23/2016.
 */
public class ClientRequestAdapter extends  RecyclerView.Adapter<ClientRequestAdapter.ViewHolder>{


    private static final String TAG = ClientRequestAdapter.class.getSimpleName();
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

        ImageView imageViewstatus;

        imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status1);
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));
        imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status2);
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));
        imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status3);
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));
        imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status4);
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));

        imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status);
        imageViewstatus.setColorFilter(Color.parseColor("#ff0000"));

        switch (clientRequestList.get(position).getStatus()){

            case "Pending":
                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status1);

                imageViewstatus.setBackgroundColor(Color.parseColor("#ff0000"));

                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status);
                imageViewstatus.setImageResource(R.drawable.ic_icon_pending_24dp);
                imageViewstatus.setColorFilter(Color.parseColor("#ff0000"));

                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());



                break;
            case "Open":
                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status2);
                imageViewstatus.setBackgroundColor(Color.parseColor("#ff0000"));
                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());

                break;
            case "Ongoing":
                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status3);
                imageViewstatus.setBackgroundColor(Color.parseColor("#ffff00"));
                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());

                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status);
                imageViewstatus.setImageResource(R.drawable.ic_tab_ongoing);
                imageViewstatus.setColorFilter(Color.parseColor("#ffff00"));
                break;
            case "Completed":

                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status4);
                imageViewstatus.setBackgroundColor(Color.parseColor("#00ff00"));
                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());

                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status);
                imageViewstatus.setImageResource(R.drawable.ic_tab_completed);
                imageViewstatus.setColorFilter(Color.parseColor("#00ff00"));

                break;

        }



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
