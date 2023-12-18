package com.example.cooking_app.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.User;
import com.example.cooking_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class UserActivity extends AppCompatActivity {

    private ActivityResultLauncher<Void> cameraLauncher;
    private ActivityResultLauncher<Intent> galleryLauncher;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        DBHandler dbHandler = new DBHandler(this);
        ImageView imageView = findViewById(R.id.user1);
        FloatingActionButton camera = findViewById(R.id.camera);
        TextView textViewName = findViewById(R.id.textName);
        Button buttonLogout = findViewById(R.id.btn_Logout);
        Button buttonAccount = findViewById(R.id.btn_account);
        Button buttonWishList = findViewById(R.id.btn_wishList);

        SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String userEmail = preferences.getString("user_email", "");
        String name = preferences.getString("user_name", "");
        textViewName.setText(name);

        User user = dbHandler.getUser(userEmail);

        if (user.getEmail() != null)
        {
            imageView.setImageBitmap(user.getImage());
        }


        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        handleImageSelection(result.getData(), imageView);
                    }
                }
        );

        camera.setOnClickListener(view -> openGallery());

        //Sang trang Sửa thông tin
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, EditUserProfileActivity.class);
                startActivity(intent);
            }
        });

        //Sang trang yêu thích
        buttonWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, WishListActivity.class);
                startActivity(intent);
            }
        });

        //Đăng xuất
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(UserActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        gallery.setType("image/*");
        galleryLauncher.launch(gallery);
    }

    private void handleImageSelection(Intent data,ImageView imageView) {
        SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int userId = preferences.getInt("user_id",0);

        DBHandler dbHandler = new DBHandler(this);
        if (data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                Bitmap selectedImageBitmap;
                try {
                    selectedImageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                    imageView.setImageBitmap(selectedImageBitmap);
                    Boolean check = dbHandler.updateImage(userId, selectedImageBitmap);
                    if (check == true)
                    {
                        Toast.makeText(UserActivity.this, "Đổi ảnh thành công", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

