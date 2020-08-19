package app.com.docapp;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PatientActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        final BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        final FloatingActionButton dashboardBtn = findViewById(R.id.dashboardFAB);
        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dashboardBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00b4d8")));

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new PatientProfile())
                        .commit();
                Toast.makeText(getApplicationContext(),"Dashboard", Toast.LENGTH_SHORT).show();

                int size = bottomNavigationView.getMenu().size();
                for (int i = 0; i < size; i++) {
                    bottomNavigationView.getMenu().getItem(i).setChecked(false);
                }

            }
        });

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new PatientProfile())
                    .commit();
            bottomNavigationView.setSelectedItemId(R.id.home_menu);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        final FloatingActionButton dashboardBtn = findViewById(R.id.dashboardFAB);
        dashboardBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dee2e6")));


        int id = item.getItemId();

        switch (id){

            case R.id.profile_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new PatientProfile())
                        .commit();
                Toast.makeText(this,"profile", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }






//    @Override
//    public void onBackPressed() {
//        if(navDrwLayout.isDrawerOpen(GravityCompat.START)){
//            navDrwLayout.closeDrawer(GravityCompat.START);
//        }
//        else {
//            super.onBackPressed();
//        }
//    }
}