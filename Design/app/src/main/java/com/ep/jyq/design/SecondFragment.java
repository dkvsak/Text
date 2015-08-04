package com.ep.jyq.design;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Joy on 2015/7/15.
 */
public class SecondFragment extends Fragment {
    private CoordinatorLayout rel;
    private FloatingActionButton fabtn;
    private TextInputLayout input;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if (container == null) {
            return null;
        }

        final View view = inflater.inflate(R.layout.fra2, container, false);

        fabtn = (FloatingActionButton) view.findViewById(R.id.btn_float);
        rel = (CoordinatorLayout) view.findViewById(R.id.rootlayout);
        input = (TextInputLayout) view.findViewById(R.id.textInput);
        initview();
        return view;
    }

    private void initview() {
        EditText et = input.getEditText();
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4) {
                    input.setErrorEnabled(true);
                    input.setError("您输入的姓名不能超过4个  ◑﹏◐ sorry！");
                } else {
                    input.setErrorEnabled(false);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(rel, "Hello,This is Snackbar !", Snackbar.LENGTH_LONG).setAction("QAQ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "yeah~! Snackbar", Toast.LENGTH_SHORT).show();

                    }
                }).show();
            }
        });


    }
}
