package com.yoqsetioxdxd.practica_1;

import android.app.Application;
import android.content.Context;

import android.util.Log;

import java.util.Calendar;

/**
 * Created by ALUMNEDAM on 07/10/2016.
 */
public class Logic extends Application {

    String nombre;
    int sexo;
    int fechaNacimiento;
    boolean juegos;
    boolean drogas;
    boolean futbol;
    boolean comida;
    Context ctx;

    String[] datos;

    public Logic(String nombre, int sexo, int fechaNacimiento, boolean juegos, boolean drogas, boolean futbol, boolean comida, Context ctx) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.juegos = juegos;
        this.drogas = drogas;
        this.futbol = futbol;
        this.comida = comida;
        this.ctx = ctx;
    }

    public String[] generarMensajesLapida() {
        String[] datos = new String[3];
        Log.d("Logic", "Sexo: " +sexo);
        Log.d("Logic", ctx.getResources().getString(R.string.nuse));
        //Tratamiento
        String strTratamiento = tratamiento(sexo);
        datos[0] = strTratamiento + " " + nombre;

        //Cuando moriras

        datos[1]= calcularAnyoMuerte(fechaNacimiento);

        //Tu "estado vital" segun tus vicios;
        int estadoVicios = 0;
        if (drogas == true) {
            estadoVicios += 3;
        }
        if (juegos == true) {
            estadoVicios += 5;
        }
        if (futbol == true) {
            estadoVicios += 7;
        }
        if (comida == true) {
            estadoVicios += 11;
        }
        //Como moriras
        datos[2] = calcularCausaMuerte(estadoVicios);



    return datos;
    }

    public String tratamiento (int sexo) {
        switch (sexo) {
            case 0:
                return ctx.getResources().getString(R.string.don);
            case 1:
                return ctx.getResources().getString(R.string.dona);
            case 2:
                return ctx.getResources().getString(R.string.nuse);
            default:
                return ctx.getResources().getString(R.string.nuse);
        }
    }

    public String calcularAnyoMuerte(int anyoNacimiento){
        Calendar cal = Calendar.getInstance();

        int anyosDeVida = (int) (Math.random()*(40 - 1) + 1);
        int anyoMuerte = cal.get(Calendar.YEAR)+anyosDeVida;
        cal.get(Calendar.YEAR);

        return "Moriras en el " + anyoMuerte + " a los " + (anyoMuerte - anyoNacimiento) + " años.";
    }

    public String calcularCausaMuerte(int estadoVicios){
        switch(estadoVicios){
            case 3:
                return ctx.getResources().getString(R.string.d);
            case 5:
                return ctx.getResources().getString(R.string.v);
            case 7:
                return ctx.getResources().getString(R.string.f);
            case 11:
                return ctx.getResources().getString(R.string.c);
            case 8:
                return ctx.getResources().getString(R.string.dv);
            case 10:
                return ctx.getResources().getString(R.string.df);
            case 14:
                return ctx.getResources().getString(R.string.dc);
            case 12:
                return ctx.getResources().getString(R.string.vf);
            case 16:
                return ctx.getResources().getString(R.string.vc);
            case 18:
                return ctx.getResources().getString(R.string.cf);
            case 15:
                return ctx.getResources().getString(R.string.dvf);
            case 21:
                return ctx.getResources().getString(R.string.dfc);
            case 26:
                return ctx.getResources().getString(R.string.dvfc);
            case 19:
                return ctx.getResources().getString(R.string.dvc);
            case 23:
                return ctx.getResources().getString(R.string.vfc);
            default:
                return ctx.getResources().getString(R.string.no);

        }
    }

}
