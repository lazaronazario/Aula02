package com.example.edlasoliveira.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Main5Activity extends AppCompatActivity {

    TextView textView1;
    Button botao4;
    Calendar calendar;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        textView1 = (TextView)findViewById(R.id.textView1);
        botao4 = (Button)findViewById(R.id.botao4);

        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar= Calendar.getInstance();
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH);
                int ano = calendar.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Main5Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int nano, int nmes, int ndia) {
                      textView1.setText(ndia + "/" + (nmes+1) +"/"+nano);
                    }
                },dia, mes, ano);
                dpd.show();
            }
        });



    }
}
