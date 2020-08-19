package app.com.docapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DoctorActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        bottomNavigationView = findViewById(R.id.doctor_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.doctor_profile_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new DoctorProfile())
                        .commit();
                Toast.makeText(this,"profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.patient_list_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new DoctorAllPatient())
                        .commit();
                Toast.makeText(this,"dashboard", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}