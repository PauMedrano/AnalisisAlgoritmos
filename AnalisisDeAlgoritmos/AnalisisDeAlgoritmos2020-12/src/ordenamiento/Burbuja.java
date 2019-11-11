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
public class Burbuja implements AlgoritmoOrdenamiento, Runnable{

    private double[] arreglo;
    private double tt;
    private boolean thread;
    
    public Burbuja() {
        this.thread = false;
        this.arreglo = null;
    }
    
    public Burbuja(boolean thread){
        this.thread = thread;
        this.arreglo = null;
    }
      
    @Override
    public void definirDatos(double[] arreglo) {
       this.arreglo = arreglo;
    }

    @Override
    public void ordenarDatos() {
        if (this.thread){
            Thread hilo =new Thread(this);
            hilo.start();
        }else{
            run();
        }
        
    }

    @Override
    public void run() {
                // calcular cuando empieza 
        double ti = System.currentTimeMillis();
        // ordenamos
        for(int i=1;i<arreglo.length;i++){
            for(int j=0;j<arreglo.length-1;j++){
                if(arreglo[j]>arreglo[j+1]){
                    double temp=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=temp;
                }
            }
        }
        // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        // calculamos el tiempo total
       this.tt = tf - ti;
    }
    @Override
   public double getTt(){
       return tt; 
   }
    
}