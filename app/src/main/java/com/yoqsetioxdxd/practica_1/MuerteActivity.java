package com.yoqsetioxdxd.practica_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MuerteActivity extends AppCompatActivity {
    TextView tvNombre;
    TextView tvEdadMuerte;
    TextView tvCausaMuerte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muerte);

        String[] datos = getIntent().getStringArrayExtra("datos");
        tvNombre = (TextView) findViewById(R.id.tv_nombre);
        tvEdadMuerte = (TextView) findViewById(R.id.tv_edadMuerte);
        tvCausaMuerte = (TextView) findViewById(R.id.tv_causaMuerte);

        tvNombre.setText(datos[0]);
        tvEdadMuerte.setText(datos[1]);
        tvCausaMuerte.setText(datos[2]);
    }
}
