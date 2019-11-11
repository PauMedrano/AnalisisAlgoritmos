/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caballo;

/**
 *
 * @author HP
 */
public class caballoA {
    
    private final int nFilas;
    private final int nCol;
    private final int[][] tablero;
    private int     cont;
 
    public caballoA(int n) {
        cont =0;
        nFilas = n;
        nCol = n;
        //creamos un tablero de n*n
        tablero     = new int[n][n];
    }

    @Override
    public String toString() {
        for (int[] fila : tablero) {
            for (int j = 0; j < fila.length; j++) {
                System.out.printf(" %2d ", fila[j]);
            }
            System.out.println();
            for (int j = 0; j < fila.length; j++) {
               
            }
            System.out.println();
        }
        return "cont "+this.cont ;
    }
 
 
 public boolean Solucion(int f, int c) {
        cont++;
        tablero[f][c] =cont;
        //caso base
        if(cont==nFilas*nCol) return true;
        //caso especifico
        int[][] posibles = Casillas(f, c); 
        //se buscan todos los movimientos posibles de la posicion
        if (posibles.length != 0 ){
            // Ordeno los datos por el menor num de movimiento de la siguiente posicion
            Movimientos(posibles);        
            // si la siguiente casilla tiene solucion, ese camino es una solucion
            if (Solucion(posibles[0][0], posibles[0][1])) { 
                return true;
            }
        }
      
        return false;
 }

 
// nuevo método: ordena el arreglo de casillas a saltar 
void Movimientos(int[][] movimientos) {
    //Ordenamiento burbuja para cambiar el orden en el que se encuentran los saltos
    for(int i=0; i<movimientos.length; i++) {
        for(int j=i+1; j<movimientos.length; j++) {
            //Vease como se calcularan los movimientos de cada casilla
            int cuantosPosiblesI = Casillas(movimientos[i][0], movimientos[i][1]).length;
            int cuantosPosiblesJ = Casillas(movimientos[j][0], movimientos[j][1]).length;
            //Orden por los menores movimientos posibles de la sig posición
            if(cuantosPosiblesJ<cuantosPosiblesI) { 
                int tmp0 = movimientos[i][0];
                movimientos[i][0] = movimientos[j][0];
                movimientos[j][0] = tmp0;
                int tmp1 = movimientos[i][1];
                movimientos[i][1] = movimientos[j][1];
                movimientos[j][1] = tmp1;
            }
        }
    }
}

    int[][] Casillas(int x, int y) {
        //cantidad maxima de casillas que pueden ser un movimieto
        int[][] resp = new int[8][2];
        // inicialización de casillas disponibles
        int     aux  = 0; 
             
                
        //la coordenada a donde va a salta
        //Chequeo de posiciones validas
        if(pmh(x-2,y-1)){ resp[aux][0]=x-2; resp[aux++][1]=y-1; }
        if(pmh(x-2,y+1)){ resp[aux][0]=x-2; resp[aux++][1]=y+1; }
        if(pmh(x-1,y-2)){ resp[aux][0]=x-1; resp[aux++][1]=y-2; }
        if(pmh(x-1,y+2)){ resp[aux][0]=x-1; resp[aux++][1]=y+2; }
        if(pmh(x+2,y-1)){ resp[aux][0]=x+2; resp[aux++][1]=y-1; }
        if(pmh(x+2,y+1)){ resp[aux][0]=x+2; resp[aux++][1]=y+1; }
        if(pmh(x+1,y-2)){ resp[aux][0]=x+1; resp[aux++][1]=y-2; }
        if(pmh(x+1,y+2)){ resp[aux][0]=x+1; resp[aux++][1]=y+2; }
        int[][] tmp = new int[aux][2];
        for(int i=0; i<aux; i++) { tmp[i][0] = resp[i][0]; tmp[i][1]=resp[i][1]; }
        //retorna la matriz del tamaño del numero de casillas disponibles [2] siendo el num de casillas en coordenadas 
        return tmp;
    }
 
    boolean pmh(int f, int c) {
               return !(f<0 || f>nFilas-1 || c<0 || c>nCol-1||tablero[f][c]!=0);
    }
}
