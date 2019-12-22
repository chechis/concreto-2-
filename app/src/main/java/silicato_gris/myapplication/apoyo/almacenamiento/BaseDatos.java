package silicato_gris.myapplication.apoyo.almacenamiento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    private static final String tipo = " TEXT";
    private static final String coma = ",";

    private static final String Sentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.TABLE_NAME + " ("
                    + Estructura.EstructuraBase.COLUMN_NAME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.COLUMN_NAME_RESISTENCIA + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_FACTOR + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_ELEMENTO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_TMN + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PESO_CONCRETO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_FINO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_FINO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_GRUESO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_GRUESO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_RELACION_AC + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_CEMENTO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_AGREGADOS + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_ARENA + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_PIEDRIN + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_AGUA + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_ARENA + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_PIEDRIN + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_CEMENTO + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_ARENA + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_PIEDRIN + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_AGUA + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_COSTAL_ARENA + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_COSTAL_PIEDRIN + tipo + coma
                    + Estructura.EstructuraBase.COLUMN_NAME_COSTAL_AGUA + tipo + " )";

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Concreto.sqLite";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Estructura.EstructuraBase.TABLE_NAME;

    public BaseDatos (Context context){

        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Sentencia);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }
}
