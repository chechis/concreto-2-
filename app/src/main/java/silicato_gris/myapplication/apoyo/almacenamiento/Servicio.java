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

    public void guardarDatos (String nombreProyecto, double resistencia, int factor, int elemento, int tmn, int pesoConcreto,
                              int pesoSueltoFino, int pesoCompactadoFino, int pesoSueltoGrueso,
                              int pesoCompactadoGrueso, double relAc, double propUniCemento, double propUniAgregados,
                              double propUniArena, double propUniPiedrin, double propUniAgua, double propVolArena,
                              double propVolPiedrin, double comprarCemento, double comprarArena, double comprarPiedrin,
                              double comprarAgua, double costalArena, double costalPiedrin, double costalAgua,
                              BaseDatos baseDatos, Context activity){

        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROYECTO, nombreProyecto);
        content.put(Estructura.EstructuraBase.COLUMN_NAME_RESISTENCIA, String.valueOf(resistencia));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_FACTOR, Integer.toString(factor));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_ELEMENTO, Integer.toString(elemento));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_TMN, Integer.toString(tmn));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_CONCRETO, Integer.toString(pesoConcreto));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_FINO, Integer.toString(pesoSueltoFino));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_FINO, Integer.toString(pesoCompactadoFino));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_GRUESO, Integer.toString(pesoSueltoGrueso));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_GRUESO, Integer.toString(pesoCompactadoGrueso));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_RELACION_AC, String.valueOf(relAc));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_CEMENTO, String.valueOf(propUniCemento));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_AGREGADOS, String.valueOf(propUniAgregados));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_ARENA, String.valueOf(propUniArena));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_PIEDRIN, String.valueOf(propUniPiedrin));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_AGUA, String.valueOf(propUniAgua));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_ARENA, String.valueOf(propVolArena));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_PIEDRIN, String.valueOf(propVolPiedrin));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_CEMENTO, String.valueOf(comprarCemento));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_ARENA, String.valueOf(comprarArena));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_PIEDRIN, String.valueOf(comprarPiedrin));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_AGUA, String.valueOf(comprarAgua));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_ARENA, String.valueOf(costalArena));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_PIEDRIN, String.valueOf(costalPiedrin));
        content.put(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_AGUA, String.valueOf(costalAgua));

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
