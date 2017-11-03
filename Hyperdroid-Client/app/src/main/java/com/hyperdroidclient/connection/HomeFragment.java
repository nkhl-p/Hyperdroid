package com.hyperdroidclient.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyperdroidclient.R;
import com.hyperdroidclient.androidVNC.androidVNC;
import com.hyperdroidclient.widgets.BaseButton;

/**
 * Created by Archish on 10/16/2017.
 */

public class HomeFragment extends Fragment {
    BaseButton bVNC;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        bVNC = (BaseButton) rootView.findViewById(R.id.bVnc);
        bVNC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),androidVNC.class);
                startActivity(i);
            }

        });
        return rootView;
    }
}
