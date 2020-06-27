package com.muneiah.android2020.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muneiah.android2020.AlarmManger.AlarmActivity;
import com.muneiah.android2020.HelloToast.Hello_Toast_Class;
import com.muneiah.android2020.InputControls.InputControlActivity;
import com.muneiah.android2020.Intents.IntentsActivity;
import com.muneiah.android2020.MainActivity;
import com.muneiah.android2020.NavigationComponent.NavigationActivity;
import com.muneiah.android2020.R;
import com.muneiah.android2020.RecyclerDiffUtil.RecyclerDiffUtilActivity;
import com.muneiah.android2020.RecyclerView.RecyclerViewDemo;
import com.muneiah.android2020.TabNavigation.TabNavActivity;
import com.muneiah.android2020.text_and_scrollView.TextAndScrollViewActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
RecyclerView rv;
MainAdapter adapter;
TextView tv;
    String titiles[];
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       /* final Button toastButton = root.findViewById(R.id.hello_toastApp_btn);
        final Button scrollViewButton = root.findViewById(R.id.text_sroll_btn);
        final Button intentButton = root.findViewById(R.id.intents_button);
        final Button rec = root.findViewById(R.id.rec_button);
        final Button usrInput = root.findViewById(R.id.button_input);
        final Button sharedbtn = root.findViewById(R.id.button_Shared);
        final Button nav_btn = root.findViewById(R.id.button_navigation);*/
       tv=root.findViewById(R.id.tv_data_intent);
        rv=root.findViewById(R.id.rec_main);
        titiles=getResources().getStringArray(R.array.topic_names);
        adapter=new MainAdapter(titiles);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
       /* nav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), NavigationActivity.class);
                startActivity(intent);
            }
        });
        sharedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        usrInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), InputControlActivity.class);
                startActivity(intent);
            }
        });
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), RecyclerViewDemo.class);
                startActivity(intent);
            }
        });
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
        });*/
       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.option_menus, menu);

    }
    public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        String titiles[];

        public MainAdapter(String[] titiles) {
            this.titiles = titiles;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(getContext()).inflate(R.layout.main_recycler_design,parent,false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            holder.data.setText(titiles[position]);
        }

        @Override
        public int getItemCount() {
            return titiles.length;
        }

        public class MainViewHolder extends RecyclerView.ViewHolder {
            TextView data;
            public MainViewHolder(@NonNull View itemView) {
                super(itemView);
                data=itemView.findViewById(R.id.tv_main_rec_titile);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (getAdapterPosition()){
                            case 0:
                                Intent hloTost=new Intent(getContext(),Hello_Toast_Class.class);
                                getContext().startActivity(hloTost);
                                break;
                            case 1:
                                Intent textScroll=new Intent(getContext(), TextAndScrollViewActivity.class);
                                getContext().startActivity(textScroll);
                                break;
                            case 2:
                                Intent intents=new Intent(getContext(), IntentsActivity.class);
                                getContext().startActivity(intents);
                                break;
                            case 3:
                                Intent activtiylifecycle=new Intent(getContext(), IntentsActivity.class);
                                getContext().startActivity(activtiylifecycle);
                                break;
                            case 4:
                                /*Intent menus=new Intent(getContext(), Menus.class);
                                getContext().startActivity(menus);*/
                                break;
                            case 5:
                                Intent navigation=new Intent(getContext(), NavigationActivity.class);
                                getContext().startActivity(navigation);
                                break;
                            case 6:
                                Intent nav_componetnts=new Intent(getContext(), NavigationActivity.class);
                                getContext().startActivity(nav_componetnts);
                                break;
                            case 7:
                                Intent nav_drawe=new Intent(getContext(), MainActivity.class);
                                getContext().startActivity(nav_drawe);
                                break;
                            case 8:
                                Intent tabNav=new Intent(getContext(), TabNavActivity.class);
                                getContext().startActivity(tabNav);
                                break;
                            case 9:
                                Intent inputcontroller=new Intent(getContext(), InputControlActivity.class);
                                getContext().startActivity(inputcontroller);
                                break;
                            case 10:
                                Intent recyclerview=new Intent(getContext(), RecyclerViewDemo.class);
                                getContext().startActivity(recyclerview);
                                break;
                            case 15:
                                /*Intent databinding=new Intent(getContext(), DataBindingActivity.class);
                                getContext().startActivity(databinding);
                                break;*/
                            case 16:
                                Intent diff=new Intent(getContext(), RecyclerDiffUtilActivity.class);
                                getContext().startActivity(diff);
                                break;
                            case 17:
                                Intent al=new Intent(getContext(), AlarmActivity.class);
                                getContext().startActivity(al);
                                break;
                        }
                    }
                });
            }
        }
    }

}
