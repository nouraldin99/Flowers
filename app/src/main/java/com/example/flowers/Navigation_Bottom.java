package com.example.flowers;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.flowers.adapters.ViewPagerAdapter;
import com.example.flowers.ui.dashboard.DashboardFragment;
import com.example.flowers.ui.home.HomeFragment;
import com.example.flowers.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;

public class Navigation_Bottom extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    FirebaseFirestore db ;
Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__bottom);
        final BottomNavigationView navView = findViewById(R.id.nav_view);

         viewPager =  findViewById(R.id.pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFregment(new HomeFragment());
        viewPagerAdapter.addFregment(new DashboardFragment());
        viewPagerAdapter.addFregment(new NotificationsFragment());

        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.navigation_home)
                {

                    viewPager.setCurrentItem(0);
                    return true;
                }
                if(menuItem.getItemId() == R.id.navigation_dashboard)
                {
                    viewPager.setCurrentItem(1);
                    return true;
                }
                if(menuItem.getItemId() == R.id.navigation_notifications)
                {
                    viewPager.setCurrentItem(2);
                    return true;
                }
                return false;
            }
        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

      //  مهم AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        //        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
         //       .build();

       // مهم NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // مهم NavigationUI.setupWithNavController(navView, navController);


    }
   /* private void setupViewPager() {
        FraAdapter fraAdapter = new FraAdapter(getSupportFragmentManager());
        addTabs(fraAdapter);
    }*/
    /*public void addTabs(final FraAdapter fraAdapter){
        db.collection("Flowers").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(queryDocumentSnapshots != null && queryDocumentSnapshots.size()>0){
                    for(QueryDocumentSnapshot doc : queryDocumentSnapshots){
                        Flowers flowers = doc.toObject(Flowers.class);
                        fraAdapter.addTab(new Tab(flowers.getTittle(),new HomeFragment(flowers.getId())));
                    }
                    viewPager.setAdapter(fraAdapter);
                    tabLayout.setupWithViewPager(viewPager);
                }
            }
        });
            }
        }*/








}
