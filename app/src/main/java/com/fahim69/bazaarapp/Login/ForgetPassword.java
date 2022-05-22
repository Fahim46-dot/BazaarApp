package com.fahim69.bazaarapp.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fahim69.bazaarapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgetPassword extends AppCompatActivity {
    TextView headline, description;
    ImageView forgetImage;
    TextInputLayout email_layout;
    TextInputEditText email_et;
    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        headline = findViewById(R.id.forget_password__headline);
        description = findViewById(R.id.Description);
        forgetImage = findViewById(R.id.forget_image);
        email_layout = findViewById(R.id.email_forget_layout);
        email_et = findViewById(R.id.email_forget);
        submit_btn = findViewById(R.id.email_submit_btn);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}