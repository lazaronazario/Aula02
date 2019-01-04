package com.example.edlasoliveira.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class Main6Activity extends AppCompatActivity {

    private Button botaoTexto;
    private Button botaoimagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
         botaoimagem = (Button)findViewById(R.id.botaoimagem);
         botaoTexto= (Button)findViewById(R.id.botaoTexto);


         botaoTexto.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                     Intent share = new Intent(android.content.Intent.ACTION_SEND);
                     share.setType("text/plain");
                     share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                     share.putExtra(Intent.EXTRA_SUBJECT, "Titulo do compartilhamento");
                     share.putExtra(Intent.EXTRA_TEXT, "http://www.matheuspiscioneri.com.br/blog");

                     startActivity(Intent.createChooser(share, "Compartilhar link!"));
             }
         });
         botaoimagem.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent share = new Intent(Intent.ACTION_SEND);

                 // Se desejar compartilhar somente PNG use:
                 // setType("image/png"); ou para jpeg: setType("image/jpeg");
                 share.setType("image/*");

                 // Necessario ter a imagem no diretorio
                 String imagePath = Environment.getExternalStorageDirectory() + "/myImage.png";

                 File imageFileToShare = new File(imagePath);

                 Uri uri = Uri.fromFile(imageFileToShare);
                 share.putExtra(Intent.EXTRA_STREAM, uri);

                 startActivity(Intent.createChooser(share, "Compartilhar imagem"));
             }
         });

    }


}
