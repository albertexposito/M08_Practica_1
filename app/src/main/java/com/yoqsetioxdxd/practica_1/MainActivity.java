package com.yoqsetioxdxd.practica_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] datos;

    //Nombre
    String nombre;
    EditText etNombre;

    //Año nacimiento
    int anyoNacimiento;
    EditText etAnyoNac;

    //Sexo
    int sexo = 2;

    //VICIOS
    boolean juegos;
    boolean comida;
    boolean drogas;
    boolean futbol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("myTag", "On create");
        Log.d("myTag", nombre + ", " + anyoNacimiento + ", Sexo: " + sexo + ", Drogas: " + drogas + ", Videojuegos: " + juegos + ", Comida: " + comida + ", Futbol: " + futbol);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcular = (Button) findViewById(R.id.btn_calcular);
        btnCalcular.setOnClickListener(this);

        RadioButton radDef = (RadioButton) findViewById(R.id.radio_nuse);
        radDef.setChecked(true);

    }

    ///////////////ONCLICK/////////////////
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_calcular) {

            //GET NOMBRE
            etNombre = (EditText) findViewById(R.id.et_nombre);
            nombre = etNombre.getText().toString();


            //GET FECHA NACIMIENTO
            etAnyoNac = (EditText) findViewById(R.id.et_anyoNac);

            try {
                anyoNacimiento = Integer.parseInt(etAnyoNac.getText().toString());
            } catch (Exception e) {
                anyoNacimiento = 0;
            }

            Log.d("myTag", nombre + ", " + anyoNacimiento + ", Sexo: " + sexo + ", Drogas: " + drogas + ", Videojuegos: " + juegos + ", Comida: " + comida + ", Futbol: " + futbol);
            Log.d("myTag", getString(R.string.nuse));

            //CREAR LOGIC
            Logic logic = new Logic(nombre, sexo, anyoNacimiento, juegos, drogas, futbol, comida, this);
            datos = logic.generarMensajesLapida();

            Intent intent = new Intent(this, MuerteActivity.class);

            intent.putExtra("datos", datos);
            startActivityForResult(intent, 1);
        }
    }


    /////////////////////////////////////////
    ///////////SAVEDINSTANCESTATE///////////////

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sexo", this.sexo);
        outState.putBoolean("drogas", this.drogas);
        outState.putBoolean("juegos", this.juegos);
        outState.putBoolean("futbol", this.futbol);
        outState.putBoolean("comida", this.comida);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        sexo = savedInstanceState.getInt("sexo");
        drogas = savedInstanceState.getBoolean("drogas");
        juegos = savedInstanceState.getBoolean("juegos");
        futbol = savedInstanceState.getBoolean("futbol");
        comida = savedInstanceState.getBoolean("comida");
    }

    ////////////RADIO BUTTONS//////////
    public void onRadioButtonClicked(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch (v.getId()) {
            case R.id.radio_hombre:
                if (checked)
                    sexo = 0;
                break;
            case R.id.radio_mujer:
                if (checked)
                    sexo = 1;
                break;
            case R.id.radio_nuse:
                if (checked)
                    sexo = 2;
                break;
        }
    }

    ///////////CHECKBOXES///////////
    public void onCheckboxClicked(View v) {
        boolean checked = ((CheckBox) v).isChecked();

        switch (v.getId()) {
            case R.id.cbx_comida:
                if (checked) {
                    comida = true;
                    break;
                } else {
                    comida = false;
                    break;
                }
            case R.id.cbx_drogas:
                if (checked) {
                    drogas = true;
                    break;
                } else {
                    drogas = false;
                    break;
                }
            case R.id.cbx_futbol:
                if (checked) {
                    futbol = true;
                    break;
                } else {
                    futbol = false;
                    break;
                }
            case R.id.cbx_juegos:
                if (checked) {
                    juegos = true;
                    break;
                } else {
                    juegos = false;
                    break;
                }
        }
    }
}
