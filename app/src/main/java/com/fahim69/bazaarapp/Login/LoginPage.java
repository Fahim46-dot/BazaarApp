package com.fahim69.bazaarapp.Login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fahim69.bazaarapp.FragmentHolder.ShowFragment;
import com.fahim69.bazaarapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends AppCompatActivity {
    TextView signin_headline, forget_pass, need_account, sign_up;
    ImageView sign_in_image;
    TextInputLayout email_layout, password_layout;
    Button signin_btn;
    TextInputEditText email_et, pass_et;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String login_url = "https://fahim046.000webhostapp.com/Bazaar/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        signin_headline = findViewById(R.id.signin_headline);
        forget_pass = findViewById(R.id.forgetpass);
        need_account = findViewById(R.id.need_new_account);
        sign_up = findViewById(R.id.sign_up_tv);
        sign_in_image = findViewById(R.id.signin_images);
        email_et = findViewById(R.id.email_login);
        pass_et = findViewById(R.id.password_login);
        email_layout = findViewById(R.id.email_login_layout);
        password_layout = findViewById(R.id.password_login_layout);
        signin_btn = findViewById(R.id.sign_in_btn);


        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStore = email_et.getText().toString().trim();
                String passwordStore = pass_et.getText().toString().trim();
                if (emailStore.isEmpty() || passwordStore.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All field should be filled", Toast.LENGTH_SHORT).show();
                } else {
                    check_login_info();
                }


            }
        });
        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivity(intent);
                finish();
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void check_login_info() {
        StringRequest login_req = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("success")) {
                    Intent intent = new Intent(getApplicationContext(), ShowFragment.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> login_data = new HashMap<>();
                login_data.put("user_email", email_et.getText().toString().trim());
                login_data.put("user_password", pass_et.getText().toString().trim());
                return login_data;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(login_req);
    }
}