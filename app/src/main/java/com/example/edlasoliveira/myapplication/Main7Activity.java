package com.example.edlasoliveira.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main7Activity extends AppCompatActivity {
    EditText tel;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        tel = (EditText) findViewById(R.id.editTextTelefone);
        btn = (Button) findViewById(R.id.btnLigar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = tel.getText().toString();

                Uri uri = Uri.parse( "tel:"+ num );

                Intent intent = new Intent(Intent.ACTION_CALL, uri);

                if (ActivityCompat.checkSelfPermission(Main7Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Main7Activity.this, new String[]{Manifest.permission.CALL_PHONE } ,1);
                    return;
                }
                startActivity(intent);


            }
        });
    }
}
