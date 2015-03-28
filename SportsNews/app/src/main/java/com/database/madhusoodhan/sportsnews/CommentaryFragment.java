package com.database.madhusoodhan.sportsnews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by madhusoodhan on 18-Mar-15.
 */
public class CommentaryFragment extends Fragment {

    TextView tvCommentary;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_commentary,container,false);
    }


}
