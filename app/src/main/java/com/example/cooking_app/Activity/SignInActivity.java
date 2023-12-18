package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.User;
import com.example.cooking_app.R;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        TextView go_to_sign_up = findViewById(R.id.go_to_sign_up);
        EditText email = findViewById(R.id.input_email);
        EditText password = findViewById(R.id.input_password);
        Button bt_sign_in = findViewById(R.id.btn_signin);

        DBHandler dbHandler = new DBHandler(this);

        bt_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                if (Email.equals("") || Password.equals(""))
                {
                    Toast.makeText(SignInActivity.this, "Nhập thông tin tài khoản và mật khẩu!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean check = dbHandler.CheckEmailPassword(Email, md5(Password));
                    if (check == true)
                    {
                        User user = dbHandler.getUser(Email);
                        SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("user_id", user.getId());
                        editor.putString("user_email", user.getEmail());
                        editor.putString("user_name", user.getName());
                        editor.putString("user_password", user.getPassword());
                        editor.commit();

                        Toast.makeText(SignInActivity.this, "Đăng nhập thành công!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(SignInActivity.this, "Thông tin tài khoản hoặc mật khẩu không chính xác!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        go_to_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
            }
        });

    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(String.format("%02X", messageDigest[i]));

            return hexString.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


}