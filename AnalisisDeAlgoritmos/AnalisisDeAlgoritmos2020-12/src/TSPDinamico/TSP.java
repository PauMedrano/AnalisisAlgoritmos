/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSPDinamico;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
//Caminos más cortos en dags, revisitados

public class TSP {
    //Matriz
    int matriz[][];
    int INF = 100000000;
    public TSP(){
        ArrayList<Integer> S = new ArrayList<Integer>();
        Tokenizador.leerDatos();
        ArrayList<int[]> distancias = Tokenizador.instancias;
        int n = distancias.size();
    //Creacion de la matriz
        matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = distancias.get(i)[j];
            }
        }
        for(int i = 1;i<n;i++)S.add(i);
        System.out.println("Costo minimo: "+C(0,S));
    }
    public int C(int i,ArrayList<Integer> S){
        //S no tiene datos se hace la busqueda desde 0
        if(S.size() == 0)return matriz[i][0];
        else if(S.size()>0){
            //Si tiene datos se retorna el minimo de la consulta en la matriz mas 
            //la funcion con el conjunto sin el valor que se esta consultando
            int minx = INF;
            for(Integer k : S){
                ArrayList<Integer> X = (ArrayList<Integer>)S.clone();
                X.remove(k);
                minx = Math.min(minx,matriz[i][k.intValue()] + C(k.intValue(),X));
            }
            return minx;
        }
        return 0;
    }
    public static void main(String[] args) {
        TSP tsp = new TSP();
    }
    
}


//ecuacion recursiva: es la que asocia la solucion del problema con las soluciones de los subproblemas 
