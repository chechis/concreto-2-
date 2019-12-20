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
                    + Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_GRUESO + tipo + " )";

    public static final int DATABASE_VERSION = 2;
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
