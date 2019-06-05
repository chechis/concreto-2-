package silicato_gris.myapplication.apoyo.almacenamiento;

import android.provider.BaseColumns;

public class Estructura {

    public Estructura() {
    }

    public static abstract class EstructuraBase implements BaseColumns{
        public static final String TABLE_NAME = "Proporcion";
        public static final String COLUMN_NAME_ID ="Id";
        public static final String COLUMN_NAME_RESISTENCIA = "resistencia";
        public static final String COLUMN_NAME_FACTOR = "factor";
        public static final String COLUMN_NAME_ELEMENTO = "elemento";
        public static final String COLUMN_NAME_TMN = "tmn";
        public static final String COLUMN_NAME_PESO_CONCRETO = "peso_concreto";
        public static final String COLUMN_NAME_PESO_SUELTO_FINO = "suelto_fino";
        public static final String COLUMN_NAME_PESO_COMPACTADO_FINO = "compactado_fino";
        public static final String COLUMN_NAME_PESO_SUELTO_GRUESO = "suelto_grueso";
        public static final String COLUMN_NAME_PESO_COMPACTADO_GRUESO = "compactado_grueso";

    }

}
