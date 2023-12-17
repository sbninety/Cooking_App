package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText email = findViewById(R.id.input_email);
        EditText password = findViewById(R.id.input_password);
        EditText check_password = findViewById(R.id.input_check_password);
        EditText name = findViewById(R.id.input_name);
        Button sign_up = findViewById(R.id.btn_signup);

        TextView go_to_sign_in = findViewById(R.id.go_to_sign_in);

        DBHandler dbHandler = new DBHandler(this);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String CheckPassword = check_password.getText().toString();
                String Name = name.getText().toString();

                if (Email.equals("") || Password.equals("") || CheckPassword.equals("") || Name.equals("")){
                    Toast.makeText(SignUpActivity.this, "Phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Password.equals(CheckPassword)){
                        Boolean checkUserEmail = dbHandler.CheckEmail(Email);

                        if (checkUserEmail == false){
                            try {
                                Password = md5(Password);
                                dbHandler.addUser(Email, Password, Name);
                                Toast.makeText(SignUpActivity.this, "Đăng ký thành công!!!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                startActivity(intent);
                            }
                            catch (Exception e)
                            {
                                Toast.makeText(SignUpActivity.this, "Đăng ký thất bại!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignUpActivity.this, "Email đã tồn tại!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Mật khẩu nhập lại không chính xác!!!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        go_to_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
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