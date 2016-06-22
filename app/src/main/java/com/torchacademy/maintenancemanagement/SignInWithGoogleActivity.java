package com.torchacademy.maintenancemanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by neam.farroukh on 6/21/2016.
 */
public class SignInWithGoogleActivity extends AppCompatActivity
{
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
      // mGoogleApiClient = new GoogleApiClient.Builder(this)
              //  .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
               // .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                //.build();
    }
}
