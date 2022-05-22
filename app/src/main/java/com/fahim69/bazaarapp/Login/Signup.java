package com.fahim69.bazaarapp.Login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

public class Signup extends AppCompatActivity {

    ImageView topimg;
    TextInputEditText name, email, phone, password;
    TextView haveaccount, Login, signupheadline;
    Button signupButton;
    TextInputLayout namelayout, emaillayout, phonelayout, passwordlayout;
    Guideline guide1, guide2, guide3, guide4;

    //linking with server
    String url = "https://fahim046.000webhostapp.com/Bazaar/signup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        topimg = findViewById(R.id.signup_images);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        haveaccount = findViewById(R.id.have_account);
        Login = findViewById(R.id.login_tv);
        signupheadline = findViewById(R.id.signup_headline);
        signupButton = findViewById(R.id.signupbtn);
        namelayout = findViewById(R.id.namelayout);
        emaillayout = findViewById(R.id.emaillayout);
        phonelayout = findViewById(R.id.phonelayout);
        passwordlayout = findViewById(R.id.passwordlayout);
        guide1 = findViewById(R.id.guideline1);
        guide2 = findViewById(R.id.guideline2);
        guide3 = findViewById(R.id.guideline3);
        guide4 = findViewById(R.id.guideline4);
        //Taking the typed data
        String nameStore = name.getText().toString().trim();
        String phoneStore = phone.getText().toString().trim();
        String emailStore = email.getText().toString().trim();
        String passwordStore = name.getText().toString().trim();

        //On submiting inserting data to server
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valid_name() && valid_email() && valid_phone()) {
                    insert_data();
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields correctly", Toast.LENGTH_SHORT).show();
                }


            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, LoginPage.class);
                startActivity(intent);
                finish();
            }
        });


    }

    //Email validation
    private boolean valid_email() {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String emailStore = email.getText().toString().trim();
        if (emailStore.isEmpty()) {
            emaillayout.setError("Field can not be empty");
            return false;
        } else if (!emailStore.matches(regex)) {
            emaillayout.setError("Invalid Email address");
            return false;
        } else {
            emaillayout.setError(null);
            return true;
        }


    }

    //Phone number validation
    private boolean valid_phone() {
        String phoneStore = phone.getText().toString().trim();

        if (phoneStore.isEmpty()) {
            phonelayout.setError("Field can not be empty");
            return false;
        } else {
            phonelayout.setError(null);
            return true;
        }


    }

    //Name validation
    private boolean valid_name() {
        String new_pattern = "[A-Z][a-z]*";
        String nameStore = name.getText().toString().trim();
        if (nameStore.isEmpty()) {
            namelayout.setError("Field can not be empty");
            return false;
        } else if (!nameStore.matches(new_pattern)) {
            if (nameStore.charAt(0) >= 'a' && nameStore.charAt(0) <= 'z') {
                namelayout.setError("First letter should be capital letter");
                return false;
            }
            else
            {
                namelayout.setError("Only english alphabet letters allowed");
                return false;
            }
        } else {
            return true;
        }
    }


    private void insert_data() {
        StringRequest string_req_sign_up = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                name.setText("");
                email.setText("");
                phone.setText("");
                password.setText("");
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("user_name", name.getText().toString());
                map.put("user_email", email.getText().toString());
                map.put("user_phone", phone.getText().toString());
                map.put("user_password", password.getText().toString());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(string_req_sign_up);
    }
}