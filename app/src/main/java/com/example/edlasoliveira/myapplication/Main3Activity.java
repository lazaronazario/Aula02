package com.example.edlasoliveira.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    EditText edt;
    ArrayList<String> nomes;
    ArrayAdapter<String> adapter;
    private Button botao2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        botao2 = (Button) findViewById(R.id.button);
        nomes = new ArrayList<String>();
        edt = (EditText)findViewById(R.id.editText1);
        ListView listView = (ListView)findViewById(R.id.listView1);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);

    }
    public void meuBotaoClick(View v){
        nomes.add(edt.getText().toString());
        edt.setText("");
        adapter.notifyDataSetChanged();




    }
}
