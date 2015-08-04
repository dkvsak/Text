package com.ep.jyq.design;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Joy on 2015/7/15.
 */
public class FirstFragment extends Fragment {

    private LinearLayout ln;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        final View view = inflater.inflate(R.layout.fra1, container, false);
        ln = (LinearLayout) view.findViewById(R.id.ln);
        view.findViewById(R.id.bt);
        view.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Snackbar.make(view, "yeah", Snackbar.LENGTH_SHORT);
            }
        });
        return view;

    }


}
