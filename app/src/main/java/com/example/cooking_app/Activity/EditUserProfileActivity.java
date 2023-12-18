package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EditUserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);

        DBHandler dbHandler = new DBHandler(this);

        EditText EdiTextName = findViewById(R.id.inputName);
        EditText EditTextOldPassword = findViewById(R.id.inputOldPassword);
        EditText EditTextNewPassword = findViewById(R.id.inputNewPassword);
        Button btnChangeName = findViewById(R.id.btnChangeName);
        Button btnChangePassword = findViewById(R.id.btnChangePassword);

        SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int userId = preferences.getInt("user_id", 0);
        String currentPass = preferences.getString("user_password", "");
        String name = preferences.getString("user_name", "");

        EdiTextName.setText(name);

        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = EdiTextName.getText().toString();
                Boolean check = dbHandler.changeNameUser(userId, newName);
                if (check == true)
                {
                    editor.putString("user_name", newName);
                    editor.apply();
                    Toast.makeText(EditUserProfileActivity.this, "Đổi tên thành công", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(EditUserProfileActivity.this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        });

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass = md5(EditTextNewPassword.getText().toString());
                String oldPassword = md5(EditTextOldPassword.getText().toString());
                if (oldPassword.equals(currentPass)) {
                    Boolean check = dbHandler.changePassword(userId, newPass);
                    if (check == true)
                    {
                        editor.putString("user_password", newPass);
                        editor.apply();
                        Toast.makeText(EditUserProfileActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(EditUserProfileActivity.this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(EditUserProfileActivity.this, "Mật khẩu hiện tại không chính xác", Toast.LENGTH_SHORT).show();
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