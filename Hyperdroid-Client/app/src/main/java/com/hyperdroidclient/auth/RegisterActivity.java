package com.hyperdroidclient.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hyperdroidclient.R;
import com.hyperdroidclient.common.BaseActivity;
import com.hyperdroidclient.dashboard.MainActivity;
import com.hyperdroidclient.data.local.SharedPreferenceManager;
import com.hyperdroidclient.widgets.BaseButton;
import com.hyperdroidclient.widgets.BaseTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Archish on 10/16/2017.
 */

public class RegisterActivity extends BaseActivity {
    EditText etName, etEmailID, etPassword, etCPassword;
    BaseButton bRegister;
    BaseTextView tvLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void initViews() {
        etName = (EditText) findViewById(R.id.etName);
        etEmailID = (EditText) findViewById(R.id.etEmailId);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etCPassword = (EditText) findViewById(R.id.etCPassword);
        bRegister = (BaseButton) findViewById(R.id.bRegister);
        tvLogin = (BaseTextView) findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
                int check = validation();
                if (check == 0) {
                    dismissProgressDialog();
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();

                    //TODO Network call to register user
                } else if (check == 1) {
                    Toast.makeText(RegisterActivity.this, "Some fields are empty.", Toast.LENGTH_SHORT).show();
                } else if (check == 2) {
                    etCPassword.setFocusable(true);
                    etCPassword.setError("Password does not match!");
                }else if(check == 3){
                    etEmailID.setFocusable(true);
                    etEmailID.setError("Invalid Email ID");
                }
                dismissProgressDialog();


            }
        });
    }

    private int validation() {
        String email = etEmailID.getText().toString();
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        String cpassword = etCPassword.getText().toString();
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

        if (email.isEmpty() || password.isEmpty() || name.isEmpty() || cpassword.isEmpty())
            return 1;
        else if (!matcher.find())
            return 3;
        else if (!password.equals(cpassword))
            return 2;

        return 0;

    }

}
