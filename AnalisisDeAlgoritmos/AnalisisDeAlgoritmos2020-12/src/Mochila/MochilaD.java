/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;

/**
 *
 * @author HP
 */

import java.util.ArrayList;
import java.util.Random;
public class MochilaD {
    
    private ArrayList<Item> items;
    private ArrayList<Item> itemsSol;
    private double[][] MATBen;
    private int MP;
    private int maxBenefit;

    public MochilaD(ArrayList<Item> items, int MP) {
        this.items = items;
        this.MP = MP;
        construirMatrizBen();
    }


    private void construirMatrizBen() {
        // construimos la matriz de beneficios 
        this.MATBen = new double[this.items.size()+1][this.MP+1];
        // agregar en la primer columna puros ceros
        for (int x=0;x <= this.items.size();x++)
            this.MATBen[x][0] = 0;
        // agregar en la primer fila puros ceros
        for (int x=0;x <= this.MP;x++)
            this.MATBen[0][x] = 0;
    }
    
    public void buscarSol(){
        
               // calculamos la matriz de beneficios
       for (int i=1;i <= this.items.size();i++)
           for(int w=0; w<= this.MP;w++){
           // verificamos si el item puede ser parte de la solucion
               if  (this.items.get(i-1).getPeso()<= w){
               
                   if ((this.items.get(i-1).getValor()+ this.MATBen[i-1][w-this.items.get(i-1).getPeso()])
                           >this.MATBen[i-1][w]){
                   
                       this.MATBen[i][w] = this.items.get(i-1).getValor()+
                               this.MATBen[i-1][w-this.items.get(i-1).getPeso()];
                       
                   }else{
                   
                        this.MATBen[i][w] = this.MATBen[i-1][w];
                   
                   }
               
               }else{
               this.MATBen[i][w] = this.MATBen[i-1][w];
               }
               
           System.out.print(this.MATBen[i-1][w]);
           }
       System.out.println("la matriz es:");
           System.out.println();
       this.maxBenefit = (int)this.MATBen[items.size()][MP];
       this.itemsSol= new ArrayList<>();
       // calcular los elementos utilizados para _W
       
       int i = this.items.size();
       int j = this.MP;

       while (i > 0 && j > 0){
           double val = this.MATBen[i][j];
          if( val != this.MATBen[i-1][j]){
              this.itemsSol.add(this.items.get(i-1));
              // imprimir el articulo
              String aux =this.items.get(i-1).toString();
              System.out.println(aux);
              i--;
              j = j - this.items.get(i).getPeso();
          } else {
            i--;
          }
                   
       }          
       System.out.println();
        
        }

    public static void main(String[]arg){
        
        
        int n =8;
        int p= 10;
        int v=15;
        
        ArrayList<Item> items = new ArrayList<>();
        for(int i=0; i<n; i++){
            Random rndp= new Random();
            Random rndv = new Random();
            Item it = new Item(rndv.nextInt(v)+1, rndp.nextInt(p)+1);
            items.add(it);
        }
        MochilaD md = new MochilaD(items,8);
        md.construirMatrizBen();
        md.buscarSol(); 
        
        
        
        
//        ArrayList<Item> articulos = new ArrayList<>();
//        articulos.add(new Item(34,3));
//        articulos.add(new Item(28,6));
//        articulos.add(new Item(90,6));
//        articulos.add(new Item(34,3));
//        articulos.add(new Item(23,1));
//        articulos.add(new Item(11,9));
//        articulos.add(new Item(19,1));
//        articulos.add(new Item(7,3));
//        
//        MochilaD md = new MochilaD(articulos,8);
//        md.buscarSol(); 
    }
}