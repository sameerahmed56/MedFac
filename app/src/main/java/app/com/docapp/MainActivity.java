package app.com.docapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView signUpTextView;
    Button logInBtn;
    EditText emailEditText, passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passEditText = findViewById(R.id.passEditText);
        logInBtn = findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = emailEditText.getText().toString();
                String passValue = passEditText.getText().toString();

                if(emailValue.equals("patient") && passValue.equals("1234")) {
                    Intent myIntent = new Intent(MainActivity.this, DoctorActivity.class);
                    MainActivity.this.startActivity(myIntent);
                }
                else if (emailValue.equals("doctor") && passValue.equals("1234")) {
                    Intent myIntent = new Intent(MainActivity.this, PatientActivity.class);
                    MainActivity.this.startActivity(myIntent);
                }
                else if (emailValue.equals("manager") && passValue.equals("1234")) {
                    Intent myIntent = new Intent(MainActivity.this, DoctorActivity.class);
                    MainActivity.this.startActivity(myIntent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpTextView = findViewById(R.id.signUpTextView);
        signUpTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}