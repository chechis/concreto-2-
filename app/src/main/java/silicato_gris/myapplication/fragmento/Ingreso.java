package silicato_gris.myapplication.fragmento;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import silicato_gris.myapplication.R;
import silicato_gris.myapplication.apoyo.Concreto;
import silicato_gris.myapplication.apoyo.almacenamiento.BaseDatos;
import silicato_gris.myapplication.apoyo.almacenamiento.Servicio;

public class Ingreso extends Fragment {

    private TextInputLayout editResistencia, editPesoConcreto, editPesoFinoSuelto,
            editPesoFinoComp, editPesoGruesoSuelto, editPesoGruesoCompac;
    private Spinner spnFactor, spnElemento, spnTMN;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingreso, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editResistencia = (TextInputLayout) view.findViewById(R.id.edit_resistencia);
        editPesoConcreto = (TextInputLayout) view.findViewById(R.id.edit_peso_concreto);
        editPesoFinoSuelto = (TextInputLayout) view.findViewById(R.id.edit_peso_fino_suelto);
        editPesoFinoComp = (TextInputLayout) view.findViewById(R.id.edit_peso_fino_compactado);
        editPesoGruesoSuelto = (TextInputLayout) view.findViewById(R.id.edit_peso_grueso_suelto);
        editPesoGruesoCompac = (TextInputLayout) view.findViewById(R.id.edit_peso_grueso_compactado);

        spnFactor = (Spinner) view.findViewById(R.id.spinner_factor);
        spnElemento = (Spinner) view.findViewById(R.id.spinner_elemento);
        spnTMN = (Spinner) view.findViewById(R.id.spinner_tmn);


        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.ingreso_btn_flotante);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }

    private void agregarMezcla (){

        Context context = getContext();

        boolean login = true;
        if (editResistencia !=null && editPesoConcreto != null){
            int resistencia = Integer.parseInt(editResistencia.getEditText().getText().toString());
            int pesoConcreto = Integer.parseInt(editPesoConcreto.getEditText().getText().toString());
            int pesoFinoSuelto = Integer.parseInt(editPesoFinoSuelto.getEditText().getText().toString());
            int pesoFinoCompac = Integer.parseInt(editPesoFinoComp.getEditText().getText().toString());
            int pesoGruesoSuelto = Integer.parseInt(editPesoGruesoSuelto.getEditText().getText().toString());
            int pesoGruesoCompac = Integer.parseInt(editPesoGruesoCompac.getEditText().getText().toString());

            Concreto.Factor factor = Concreto.Factor.veinticinco;
            switch (spnFactor.getSelectedItemPosition()){
                case 0:
                    factor = Concreto.Factor.veinticinco;
                    break;
                case 1:
                    factor = Concreto.Factor.treinta;
                    break;
                case 2:
                    factor = Concreto.Factor.treintaYCinco;
                    break;
                case 3:
                    factor = Concreto.Factor.cuarenta;
                    break;
                case 4:
                    factor = Concreto.Factor.cincuenta;
                    break;
                case 5:
                    factor = Concreto.Factor.cero;
                    break;
            }

            Concreto.Asentamiento asentamiento = Concreto.Asentamiento.diez;
            switch (spnElemento.getSelectedItemPosition()){
                case 0:
                    asentamiento = Concreto.Asentamiento.diez;
                    break;
                case 1:
                    asentamiento = Concreto.Asentamiento.ocho;
                    break;
                case 2:
                    asentamiento = Concreto.Asentamiento.cinco;
                    break;
            }

            Concreto.Tmn tmn = Concreto.Tmn.tresOctavos;
            switch (spnFactor.getSelectedItemPosition()){
                case 0:
                    tmn = Concreto.Tmn.tresOctavos;
                    break;
                case 1:
                    tmn = Concreto.Tmn.media;
                    break;
                case 2:
                    tmn = Concreto.Tmn.tresCuartos;
                    break;
                case 3:
                    tmn = Concreto.Tmn.una;
                    break;
                case 4:
                    tmn = Concreto.Tmn.unaYMedia;
                    break;

            }

            BaseDatos baseDatos = new BaseDatos(getContext());

            SQLiteDatabase sq = baseDatos.getWritableDatabase();
            Servicio servicio = new Servicio("resistencia", context);
            servicio.guardarDatos();


        }



    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Ingreso de datos");
    }
}
