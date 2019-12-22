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
        public static final String COLUMN_NAME_RELACION_AC = "relacion_ac";
        public static final String COLUMN_NAME_PROP_UNITARIA_CEMENTO = "prop_unitaria_cemento";
        public static final String COLUMN_NAME_PROP_UNITARIA_AGREGADOS = "prop_unitaria_agregados";
        public static final String COLUMN_NAME_PROP_UNITARIA_ARENA = "prop_unitaria_arena";
        public static final String COLUMN_NAME_PROP_UNITARIA_PIEDRIN = "prop_unitaria_piedrin";
        public static final String COLUMN_NAME_PROP_UNITARIA_AGUA = "prop_unitaria_agua";
        public static final String COLUMN_NAME_PROP_VOLUMETRICA_ARENA = "prop_volumetrica_arena";
        public static final String COLUMN_NAME_PROP_VOLUMETRICA_PIEDRIN = "prop_volumetrica_piedrin";
        public static final String COLUMN_NAME_COMPRAR_CEMENTO = "comprar_cemento";
        public static final String COLUMN_NAME_COMPRAR_ARENA = "comprar_arena";
        public static final String COLUMN_NAME_COMPRAR_PIEDRIN = "comprar_piedrin";
        public static final String COLUMN_NAME_COMPRAR_AGUA = "comprar_agua";
        public static final String COLUMN_NAME_COSTAL_ARENA = "costal_arena";
        public static final String COLUMN_NAME_COSTAL_PIEDRIN = "costal_piedrin";
        public static final String COLUMN_NAME_COSTAL_AGUA = "costal_agua";


    }

}
