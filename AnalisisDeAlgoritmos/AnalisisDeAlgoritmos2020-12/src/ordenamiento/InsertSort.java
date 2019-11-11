/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author HP
 */
public class InsertSort implements AlgoritmoOrdenamiento, Runnable{
private double[] arreglo;
private double tt;
private boolean thread;

public InsertSort() {
    this.thread = false;
    this.arreglo=null;
    
}
public InsertSort(boolean thread){
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
    double aux;
        int j;
        double ti = System.currentTimeMillis();
        for(int i = 1; i < arreglo.length;i++){
            aux = arreglo[i];
            j = i - 1;
            while(j >= 0 && arreglo[j] > aux){
                arreglo[j+1] = arreglo[j];
                j--;
            }
            arreglo[j+1] = aux;
        }
       // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        // calculamos el tiempo total
        this.tt = tf -ti;
    
    }
    @Override
    public double getTt() {
       return tt;
    }
    
}
