package com.example.flowers.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowers.R;
import com.example.flowers.adapters.SViewAdapter;
import com.example.flowers.models.Flowers;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
        RecyclerView rv;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        rv = root.findViewById(R.id.s_rv_dash);
        //  db = FirebaseFirestore.getInstance();
        //mAuth = FirebaseAuth.getInstance();
        ArrayList<Flowers> flower = new ArrayList<>();


        flower.add(new Flowers(1,"https://firebasestorage.googleapis.com/v0/b/flowers-41fd6.appspot.com/o/background-of-pink-roses-P4XSGUE.png?alt=media&token=af0cd7d4-8b59-48e4-acc3-9a45b97df191","noor","ahmedsdfsdv0"));
        SViewAdapter sViewAdapter = new SViewAdapter(flower);
        rv.setAdapter(sViewAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,true));
        rv.setHasFixedSize(true);
        return root;
    }
}