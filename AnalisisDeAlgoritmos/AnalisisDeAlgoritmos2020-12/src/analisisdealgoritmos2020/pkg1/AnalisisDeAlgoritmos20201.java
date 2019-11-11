/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdealgoritmos2020.pkg1;



import java.util.ArrayList;
import ordenamiento.AlgoritmoOrdenamiento;
import ordenamiento.Burbuja;
import ordenamiento.Burbujaopt;
import ordenamiento.Grafica;
import ordenamiento.Herramientas;
import ordenamiento.InsertSort;
import ordenamiento.Manager;
import ordenamiento.MergeSort;
import ordenamiento.QuickSort;

/**
 *
 * @author PHP
 */
public class AnalisisDeAlgoritmos20201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
       //Burbuja  b = new Burbuja(true);
       //Burbujaopt bo = new Burbujaopt(true);
       //InsertSort i = new InsertSort(true);
       MergeSort ms = new MergeSort(true);
      // Burbuja  b3 = new Burbuja();
       //Burbuja  b4 = new Burbuja();
      // Burbuja  b5 = new Burbuja();
     QuickSort qi = new QuickSort(true);
       // double original [] =  Herramientas.generarArregloAleatorio(200000,500);
        ArrayList<AlgoritmoOrdenamiento> lista = new ArrayList();
        //lista.add(b);
        //lista.add(bo);
       // lista.add(i);
      
        lista.add(qi);
        lista.add(ms);

       // lista.add(b3);
        //lista.add(b4);
       // lista.add(b5);
        Manager m = new Manager(lista);
        m.ejecutarPrueba(5000,5,500, true);
        
        
       // double[] datos = new double[20];
        
     /*   for (int i = 0 ; i<20; i++){
         b.definirDatos(original.clone());
         datos[i]=b.ordenarDatos();
         System.out.println(i+": "+datos[i]);
         System.out.println();
        }
      
      
         double[] opc1 = new double[20];
         double[] opc2 = new double[20];
         double[] opc3 = new double[20];
         double[] opc4 = new double[20];
      
         for(int i=0;i<20;i++){
       
          opc1[i]=Math.pow(i,2);
          opc2[i]=Math.pow(i, 3);
          opc3[i]=Math.pow(i, 6);
          opc4[i]=2*i*Math.log(i);           
      }
       
        Grafica g = new Grafica("Iteracion","tiempo","Tiempos Burbuja");
        g.agregarSerie(opc1, "opc1");
        g.agregarSerie(opc2, "opc2");
        g.agregarSerie(opc3, "opc3");
        g.agregarSerie(opc4, "opc4");
        g.creaYmuestraGrafica();
 */
              
    }
    
    
    
}