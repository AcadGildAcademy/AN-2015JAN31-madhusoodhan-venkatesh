package com.database.madhusoodhan.sportsnews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by madhusoodhan on 17-Mar-15.
 */
public class ScoreFragment extends Fragment {

    TextView tvBlue, tvGray;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_score,container,false);

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvGray = (TextView)getActivity().findViewById(R.id.tv_first);
        tvBlue = (TextView)getActivity().findViewById(R.id.tv_second);

        tvGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvGray.setVisibility(View.GONE);
                tvBlue.setVisibility(View.VISIBLE);
            }
        });

        tvBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBlue.setVisibility(View.GONE);
                tvGray.setVisibility(View.VISIBLE);
            }
        });
    }
}
