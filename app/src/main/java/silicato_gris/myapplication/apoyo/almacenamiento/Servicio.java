package silicato_gris.myapplication.apoyo.almacenamiento;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import silicato_gris.myapplication.apoyo.Concreto;

public class Servicio {

    private String resistencia;
    private Context context;

    public Servicio(String resistencia, Context context) {
        this.resistencia = resistencia;
        this.context = context;
    }

    public void guardarDatos (double resistencia, int factor, int elemento, int tmn, int pesoConcreto,
                              int pesoSueltoFino, int pesoCompactadoFino, int pesoSueltoGrueso,
                              int pesoCompactadoGrueso, BaseDatos baseDatos, Context activity){

        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(Estructura.EstructuraBase.COLUMN_NAME_RESISTENCIA, resistencia);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_FACTOR, factor);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_ELEMENTO, elemento);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_TMN, tmn);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_CONCRETO, pesoConcreto);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_FINO, pesoSueltoFino);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_FINO, pesoCompactadoFino);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_GRUESO, pesoSueltoGrueso);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_GRUESO, pesoCompactadoGrueso);

        sq.insert(Estructura.EstructuraBase.TABLE_NAME, null, content);
        Toast.makeText(activity, "Base de datos almacenada", Toast.LENGTH_SHORT).show();
    }

    public void modificarDatos (int id, double resistencia, int factor, int elemento, int tmn, int pesoConcreto,
                                int pesoSueltoFino, int pesoCompactadoFino, int pesoSueltoGrueso,
                                int pesoCompactadoGrueso, BaseDatos baseDatos, Context activity){

        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        ContentValues content = new ContentValues();

        String comparador = Estructura.EstructuraBase.COLUMN_NAME_ID + " LIKE "+ id;
        content.put(Estructura.EstructuraBase.COLUMN_NAME_RESISTENCIA, resistencia);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_FACTOR, factor);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_ELEMENTO, elemento);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_TMN, tmn);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_CONCRETO, pesoConcreto);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_FINO, pesoSueltoFino);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_FINO, pesoCompactadoFino);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_GRUESO, pesoSueltoGrueso);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_GRUESO, pesoCompactadoGrueso);

        sq.update(Estructura.EstructuraBase.TABLE_NAME, content, comparador, null);
        Toast.makeText(activity, "Base de datos modificada", Toast.LENGTH_SHORT).show();
    }

    public void eliminarDato (Concreto concreto, BaseDatos baseDatos, Context activity){

        SQLiteDatabase sq = baseDatos.getWritableDatabase();

        sq.execSQL("DELETE FROM "+ Estructura.EstructuraBase.TABLE_NAME+" WHERE ID=?;",
                new Object[]{concreto.getId()});

        Toast.makeText(activity, "Se ha eliminado la tarea", Toast.LENGTH_SHORT).show();

    }


}
