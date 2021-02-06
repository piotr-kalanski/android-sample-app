package com.github.piotrkalanski.ui.camera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.github.piotrkalanski.R;
import com.github.piotrkalanski.model.Camera;

public class CameraActivity extends AppCompatActivity {

    public static final String KEY_CAMERA = "CAMERA";

    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        camera = (Camera)getIntent().getExtras().get(KEY_CAMERA);

        setTitle(camera.getDescription());

        ImageView imageView = findViewById(R.id.image);
        Drawable drawable = ContextCompat.getDrawable(this, camera.getDrawable());
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(camera.getModel());
    }
}