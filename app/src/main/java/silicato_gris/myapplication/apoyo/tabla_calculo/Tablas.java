package silicato_gris.myapplication.apoyo.tabla_calculo;

public class Tablas {


        int cantidadAgua;
        double cantidadArena;

        int asentamiento;
        int tmn;
        int fc;

    public Tablas(int asentamiento, int tmn, int fc) {
        this.asentamiento = asentamiento;
        this.tmn = tmn;
        this.fc = fc;
    }

    double cantidadArenaArreglo [] = new double[5];
        int aguaArreglo [][]= new int[3][5];

        public int tablaAgua (int asentamiento, int tmn){

            aguaArreglo [0][0]= 205;
            aguaArreglo [1][0]= 225;
            aguaArreglo [2][0]= 240;

            aguaArreglo [0][1]= 200;
            aguaArreglo [1][1]= 215;
            aguaArreglo [2][1]= 230;

            aguaArreglo [0][2]= 185;
            aguaArreglo [1][2]= 200;
            aguaArreglo [2][2]= 210;

            aguaArreglo [0][3]= 180;
            aguaArreglo [1][3]= 195;
            aguaArreglo [2][3]= 205;

            aguaArreglo [0][4]= 175;
            aguaArreglo [1][4]= 180;
            aguaArreglo [2][4]= 200;

            return cantidadAgua = aguaArreglo[asentamiento][tmn];
        }

        public double tablaArena (int tmn){

            cantidadArenaArreglo [0] = 0.48;
            cantidadArenaArreglo [1] = 0.46;
            cantidadArenaArreglo [2] = 0.44;
            cantidadArenaArreglo [3] = 0.42;
            cantidadArenaArreglo [4] = 0.40;

            return cantidadArena = cantidadArenaArreglo [tmn];
        }
}
