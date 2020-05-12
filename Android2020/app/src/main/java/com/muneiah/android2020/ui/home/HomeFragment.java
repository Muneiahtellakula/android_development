package com.muneiah.android2020.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.muneiah.android2020.HelloToast.Hello_Toast_Class;
import com.muneiah.android2020.Intents.IntentsActivity;
import com.muneiah.android2020.MainActivity;
import com.muneiah.android2020.R;
import com.muneiah.android2020.text_and_scrollView.TextAndScrollViewActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final Button toastButton = root.findViewById(R.id.hello_toastApp_btn);
        final Button scrollViewButton = root.findViewById(R.id.text_sroll_btn);
        final Button intentButton = root.findViewById(R.id.intents_button);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), IntentsActivity.class);
                startActivity(intent);
            }
        });
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Hello_Toast_Class.class);
                startActivity(intent);
            }
        });
        scrollViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TextAndScrollViewActivity.class));
            }
        });
       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}
