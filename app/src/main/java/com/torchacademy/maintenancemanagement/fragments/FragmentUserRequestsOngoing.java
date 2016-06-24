package com.torchacademy.maintenancemanagement.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.torchacademy.maintenancemanagement.ClientRequestViewActivity;
import com.torchacademy.maintenancemanagement.R;
import com.torchacademy.maintenancemanagement.adapters.ClientRequestAdapter;
import com.torchacademy.maintenancemanagement.models.ClientRequest;

/**
 * Created by ahmad.masri on 6/22/2016.
 */
public class FragmentUserRequestsOngoing extends Fragment {

    private RecyclerView recyclerview_ongoing;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_request_ongoing, container, false);

        recyclerview_ongoing = (RecyclerView) view.findViewById(R.id.recyclerview_ongoing);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerview_ongoing.setLayoutManager(linearLayoutManager);

        final ClientRequestAdapter clientRequestAdapter = new ClientRequestAdapter(getContext(),
                ClientRequest.dummyListOngoing());
        clientRequestAdapter.setTouchListener(new ClientRequestAdapter.TouchListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), ClientRequestViewActivity.class);
                intent.putExtra("request", clientRequestAdapter.getClientRequestList().get(position));
                startActivity(intent);
            }
        });
        recyclerview_ongoing.setAdapter(clientRequestAdapter);



        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
