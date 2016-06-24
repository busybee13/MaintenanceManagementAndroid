package com.torchacademy.maintenancemanagement.adapters;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.torchacademy.maintenancemanagement.ClientRequestViewActivity;
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
    private TouchListener touchListener;

    public ClientRequestAdapter(Context context, List<ClientRequest> clientRequests) {
        this.clientRequestList = clientRequests;
        this.context = context;
    }

    public void setClientRequestList(List<ClientRequest> clientRequestList) {
        this.clientRequestList = clientRequestList;
        notifyDataSetChanged();
    }

    public void setTouchListener(TouchListener touchListener) {
        this.touchListener = touchListener;
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
    public void onBindViewHolder(ViewHolder holder, final int position) {

        ClientRequest clientRequest = clientRequestList.get(position);
        holder.textView_request_status.setText("\"" + clientRequest.getName() + "\" is " + clientRequest.getStatus());

        ImageView imageViewstatus;

        imageViewstatus = holder.imageView_request_status1;
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));
        imageViewstatus = holder.imageView_request_status2;
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));
        imageViewstatus = holder.imageView_request_status3;
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));
        imageViewstatus = holder.imageView_request_status4;
        imageViewstatus.setBackgroundColor(Color.parseColor("#a3a3a3"));

        imageViewstatus = holder.imageView_request_status;
        imageViewstatus.setColorFilter(Color.parseColor("#ff0000"));
        imageViewstatus = holder.imageButton_open_request_status;
        imageViewstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                if (touchListener != null) {
                    touchListener.onClick(v, position);
                }
            }
        });


        color_view(holder,clientRequestList,position);

    }

    public static void color_view(ViewHolder holder,
                                  List<ClientRequest> clientRequestList,
                                  int position){
        ImageView imageViewstatus;
        switch (clientRequestList.get(position).getStatus()){

            case "Pending":
                imageViewstatus = holder.imageView_request_status1;

                imageViewstatus.setBackgroundColor(Color.parseColor("#ff0000"));

                imageViewstatus = holder.imageView_request_status;
                imageViewstatus.setImageResource(R.drawable.ic_icon_pending_24dp);
                imageViewstatus.setColorFilter(Color.parseColor("#ff0000"));

                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());



                break;
            case "Open":
                imageViewstatus = holder.imageView_request_status2;
                imageViewstatus.setBackgroundColor(Color.parseColor("#ff0000"));
                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());

                break;
            case "Ongoing":
                imageViewstatus = holder.imageView_request_status3;
                imageViewstatus.setBackgroundColor(Color.parseColor("#ffff00"));
                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());

                imageViewstatus = (ImageView) holder.itemView.findViewById(R.id.imageView_request_status);
                imageViewstatus.setImageResource(R.drawable.ic_tab_ongoing);
                imageViewstatus.setColorFilter(Color.parseColor("#ffff00"));
                break;
            case "Completed":

                imageViewstatus = holder.imageView_request_status4;
                imageViewstatus.setBackgroundColor(Color.parseColor("#00ff00"));
                Log.d(TAG, "onBindViewHolder: " + clientRequestList.get(position).getName() + " postion:" + position+" id:" +holder.itemView.findViewById(R.id.imageView_request_status1).getId());

                imageViewstatus = holder.imageView_request_status;
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
        public ImageView imageView_request_status;
        public ImageView imageView_request_status1;
        public ImageView imageView_request_status2;
        public ImageView imageView_request_status3;
        public ImageView imageView_request_status4;
        public ImageButton imageButton_open_request_status;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_request_status = (TextView) itemView.findViewById(R.id.textView_request_status);
            imageView_request_status = (ImageView) itemView.findViewById(R.id.imageView_request_status);
            imageButton_open_request_status = (ImageButton) itemView.findViewById(R.id.imageButton_open_request_status);
            imageView_request_status1 = (ImageView) itemView.findViewById(R.id.imageView_request_status1);
            imageView_request_status2 = (ImageView) itemView.findViewById(R.id.imageView_request_status2);
            imageView_request_status3 = (ImageView) itemView.findViewById(R.id.imageView_request_status3);
            imageView_request_status4 = (ImageView) itemView.findViewById(R.id.imageView_request_status4);
        }
    }

    public interface TouchListener {
        void onClick(View view, int position);


    }
}
