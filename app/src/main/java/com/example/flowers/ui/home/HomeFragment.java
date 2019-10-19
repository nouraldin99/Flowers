package com.example.flowers.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowers.R;
import com.example.flowers.adapters.FViewAdapter;
import com.example.flowers.models.Flowers;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView rv ;
    private int flwoer_id ;

    FirebaseFirestore db;
  HomeViewModel homeViewModel;
  SearchView searchView ;
    FirebaseAuth mAuth;

    public HomeFragment() {
    }

    public HomeFragment(int flwoer_id) {
        this.flwoer_id = flwoer_id;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        rv = root.findViewById(R.id.fragment_home_rv_ver);
      db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        db.collection("Flowers")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            ArrayList<Flowers>flower = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Flowers f = document.toObject(Flowers.class);
                                flower.add(f);
                                Toast.makeText(getContext(), flower.size()+"", Toast.LENGTH_SHORT).show();
                            }
                            FViewAdapter fViewAdapter = new FViewAdapter(flower);
                            //ViewPager fViewAdapter = new ViewPager(flower);

                            rv.setAdapter(fViewAdapter);
                            rv.setLayoutManager(new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false));
                            rv.setHasFixedSize(true);


                        } else {
                            Toast.makeText(getContext(), "no flower found/n"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            Log.d("ee2",task.getException().getMessage());

                        }
                    }
                });






       return root;
}
}


