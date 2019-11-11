/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.Arrays;

/**
 *
 * @author HP
 */
public class QuickSort implements AlgoritmoOrdenamiento, Runnable{
    private double[] arreglo;
    private double tt;
    private boolean thread;
    private double ti;
    private double tf;

public QuickSort(){
      this.thread = false;
    this.arreglo=null;
}

public QuickSort(boolean thread){
    this.thread = false;
    this.arreglo = null;
}



    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo=arreglo;
    }

    @Override
    public void ordenarDatos() {
          if(this.thread){
            Thread hilo = new Thread(this);
            hilo.start();
        }else{
            run();
        }
    }
    
    @Override
    public void run() {
      if (arreglo.length> 0){
         
         this.ti = System.currentTimeMillis();
         ordenarQuick(arreglo,0,arreglo.length-1); 
         this.tf = System.currentTimeMillis();
       
      }
      this.tt= this.tf - this.ti;

    }
    
    private void ordenarQuick(double[] tmpArray, int izq, int der) {
        double pivote = tmpArray[izq];
        int i = izq;
        int j = der;
        double aux;
        while (i<j){
            while (tmpArray[i]<= pivote && i<j) i++;
            while(tmpArray[j]>pivote) j--;
          if (i < j) {
          aux = tmpArray[i];
          tmpArray[i] = tmpArray[j];
          tmpArray[j] = aux;
          
          }
        }
        tmpArray[izq] = tmpArray[j];
        tmpArray[j] = pivote;
        if (izq<j-1)
            ordenarQuick(tmpArray,izq,j-1);
        if (j+1 < der)
            ordenarQuick(tmpArray, j+1, der);
        
    }
    
     @Override
    public double getTt() {
        return tt;
    }
    
}