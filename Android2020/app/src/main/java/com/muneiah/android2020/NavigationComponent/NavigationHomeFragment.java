package com.muneiah.android2020.NavigationComponent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.muneiah.android2020.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationHomeFragment extends Fragment {

    public NavigationHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_navigation_home, container, false);
        Button flgred=view.findViewById(R.id.redbtn);
        Button grnred=view.findViewById(R.id.greenbtn);
        Button whired=view.findViewById(R.id.whitbtn);
        flgred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigationHomeFragment_to_redFragment);
            }
        });
        grnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigationHomeFragment_to_greenFragment);
            }
        });

        whired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigationHomeFragment_to_whiteFragment);
            }
        });
        return view;
    }
}
