package silicato_gris.myapplication.alertas;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import silicato_gris.myapplication.R;
import silicato_gris.myapplication.apoyo.tabla_calculo.Calculos;

public class AlertaPUC extends DialogFragment {

    private Button btnCancelar, btnCalcular;
    private TextInputLayout editCemento, editArena, editPiedrin;
    private TextView textView;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogo = inflater.inflate(R.layout.alerta_peso_concreto, null);

        builder.setView(dialogo);

        textView = (TextView) dialogo.findViewById(R.id.txt_view_puc);

        editCemento = (TextInputLayout) dialogo.findViewById(R.id.edit_puc_cemento);
        editArena = (TextInputLayout) dialogo.findViewById(R.id.edit_puc_arena);
        editPiedrin= (TextInputLayout) dialogo.findViewById(R.id.edit_puc_piedrin);

        btnCancelar = (Button) dialogo.findViewById(R.id.btn_alerta_puc_cancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnCalcular = (Button) dialogo.findViewById(R.id.btn_alerta_puc_registrar);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });




        return builder.create();
    }

    private void calcular(){

        boolean login = true;

        if (editCemento!= null && editArena!=null && editPiedrin !=null ){

            if (editCemento.getEditText().getText().toString().equals("")){
                editCemento.setError("El peso especifico es requerido");
                login = false;
            }
            if (editArena.getEditText().getText().toString().equals("")){
                editArena.setError("El peso especifico es requerido");
                login = false;
            }
            if (editPiedrin.getEditText().getText().toString().equals("")){
                editPiedrin.setError("El peso especifico es requerido");
                login = false;
            }
            if (login){

                double cemento = Double.parseDouble(editCemento.getEditText().getText().toString());
                double arena = Double.parseDouble(editArena.getEditText().getText().toString());
                double piedrin = Double.parseDouble(editPiedrin.getEditText().getText().toString());

                Calculos calculos = new Calculos();
                String pesoConcreto = String.valueOf(calculos.pesoConcreto(cemento, arena, piedrin));

                textView.setText("Peso Unitario Concreto  "+pesoConcreto);
            }

        }


    }
}
