package com.example.prashant.snapbug;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by prashant on 6/14/16.
 */
public class FragmentA extends Fragment {

  OnNavClickListener listener;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.fragment_a, container, false);
    Button button = (Button) view.findViewById(R.id.FragAButton);
    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        listener.onNavClick(v);
      }
    });
    return view;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    listener = (MainActivity) context;
  }

  @Override public void onStart() {
    super.onStart();
  }

  @Override public void onResume() {
    super.onResume();
  }
}
