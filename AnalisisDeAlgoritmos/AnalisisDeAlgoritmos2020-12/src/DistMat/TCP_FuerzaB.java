/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistMat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class TCP_FuerzaB {
    static int menor = Integer.MAX_VALUE;
    static String menorPer = "";
    static void permutar(ArrayList<int[]> distancias ,int[] arr,int l,int r){
        //si l es = a r es una permutacion l pos izq y r es la pos derecha 
    
        
        if(l == r){
            int suma = 0;
            String str = "";
            //suma acumulada de las distancias del arreglo que permutamos 
            for(int i = 0;i<arr.length-1;i++){
                if(distancias.get(arr[i])[arr[i+1]] != 0)
                    suma += distancias.get(arr[i])[arr[i+1]];
                else
                    suma += distancias.get(arr[i+1])[arr[i]];
            }
            //la suma de la ultima ciudad con la primera 
            if(distancias.get(arr[arr.length-1])[arr[0]] != 0)
                suma += distancias.get(arr[arr.length-1])[arr[0]];
            else 
                 suma += distancias.get(arr[0])[arr[arr.length-1]];
            
            str = Arrays.toString(arr);
            if(suma < menor){
                menor = suma;
                menorPer = str;
            }
            System.out.println("Suma = "+ suma + " orden de ciudades: " +str);
        }
        else{
            //se hacen las permutacioneshaceiendo intercambios 
            for(int i = l;i <= r;i++){
                
               int aux = arr[l];
               arr[l] = arr[i];
               arr[i] = aux;
               
               permutar(distancias,arr,l+1,r);
               
               aux = arr[l];
               arr[l] = arr[i];
               arr[i] = aux;
            }
        }
    }
    public static void main(String[] args) {
        Tokenizador.leerDatos(); //obtiene la matriz del csv
        ArrayList<int[]> distancias = Tokenizador.instancias; //se guarda en un arraylist de arreglo de enteros 
        int tam = distancias.get(0).length; //se obtiene el tamaño de la matriz 
        //para mostrar la matriz
        for(int x=0;x<distancias.size();x++){ 
            for(int y=0;y<distancias.get(x).length;y++){
                System.out.print(distancias.get(x)[y] +",");
            }
            System.out.println("");
        }
        //se crea un arreglo donde se pondran las ciudades disponibles 
        int a[] = new int[tam];
        for(int i = 0;i<tam;i++)a[i]= i;
       
        //se manda a permutar el arreglo a  y se manda las distancias para consultar las distancias 
        permutar(distancias,a,0,a.length-1);
        
        
        System.out.println("la menor = "+ menor + " orden de ciudades: " +menorPer);
    }

    

}
