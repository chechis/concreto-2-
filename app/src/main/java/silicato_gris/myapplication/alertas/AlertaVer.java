package silicato_gris.myapplication.alertas;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import silicato_gris.myapplication.R;
import silicato_gris.myapplication.apoyo.ConcretoAlerta;

public class AlertaVer extends DialogFragment {

    private TextView nombreProyecto, resistencia, factor, cantidadMaterial,
        cantidadSacos, cantidadArena, cantidadPiedrin, cantidadAgua;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.alerta_ver,null);
        builder.setView(view);

        nombreProyecto = (TextView) view.findViewById(R.id.txt_ver_nombre_proyecto);
        resistencia = (TextView) view.findViewById(R.id.txt_ver_resistencia);
        factor = (TextView) view.findViewById(R.id.txt_ver_factor);
        cantidadMaterial = (TextView) view.findViewById(R.id.txt_ver_cantidad);
        cantidadSacos = (TextView) view.findViewById(R.id.txt_ver_sacos);
        cantidadArena = (TextView) view.findViewById(R.id.txt_ver_arena);
        cantidadPiedrin = (TextView) view.findViewById(R.id.txt_ver_piedrin);
        cantidadAgua = (TextView) view.findViewById(R.id.txt_ver_agua);
        Button button = (Button) view.findViewById(R.id.btn_ver_cancelar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        llenando();

        return builder.create();
    }

    private String nombre, resistenciaAlerta, factorSeguridad, cantidadMat, cantidadSaco,
        cantidadFino, cantidadGrueso, cantidadAguua;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResistenciaAlerta(String resistenciaAlerta) {
        this.resistenciaAlerta = resistenciaAlerta;
    }

    public void setFactorSeguridad(String factorSeguridad) {
        this.factorSeguridad = factorSeguridad;
    }

    public void setCantidadMat(String cantidadMat) {
        this.cantidadMat = cantidadMat;
    }

    public void setCantidadSaco(String cantidadSaco) {
        this.cantidadSaco = cantidadSaco;
    }

    public void setCantidadFino(String cantidadFino) {
        this.cantidadFino = cantidadFino;
    }

    public void setCantidadGrueso(String cantidadGrueso) {
        this.cantidadGrueso = cantidadGrueso;
    }

    public void setCantidadAguua(String cantidadAguua) {
        this.cantidadAguua = cantidadAguua;
    }

    private void llenando(){
        nombreProyecto.setText("Proyecto:  "+this.nombre);
        resistencia.setText("Resistencia:  "+this.resistenciaAlerta+" kg/cm2");
        factor.setText("Factor de seguridad:  "+this.factorSeguridad+ " kg/cm2");
        cantidadMaterial.setText("Volumen del proyecto:  "+this.cantidadMat+"  m3");
        cantidadSacos.setText("Cantidad de sacos de cemento a usar:  "+this.cantidadSaco);
        cantidadArena.setText("Metros cúbicos de arena a usar:  "+cantidadFino);
        cantidadPiedrin.setText("Metros cúbicos de piedrín a usar:  "+cantidadGrueso);
        cantidadAgua.setText("Metros cúbicos de agua a usar:  "+cantidadAguua);
    }
}
