package com.example.homework5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {
    TextView txt_item_task, txt_item_task_description;
    RecyclerView recyclerView;
    TaskModel taskModel;
    FloatingActionButton btn_FAB;
    int positionn;
    boolean isEdit = true;
    private Adapter adapter;
    List<TaskModel> list = new ArrayList<>();


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }


    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        adapter = new Adapter(list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_FAB = view.findViewById(R.id.btn_FAB);
        recyclerView = view.findViewById(R.id.recycler_view_fragment_list);
        recyclerView.setAdapter(adapter);

        btn_FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment s1 = new SecondFragment();
                FragmentTransaction fT = getActivity().getSupportFragmentManager().beginTransaction();
                fT.replace(R.id.fragment, s1);
                fT.commit();
            }
        });
    }

    private void save(){
       // getParentFragmentManager().setFragmentResultListener("");
    }


    //public void  onMoveTo (int position)

}