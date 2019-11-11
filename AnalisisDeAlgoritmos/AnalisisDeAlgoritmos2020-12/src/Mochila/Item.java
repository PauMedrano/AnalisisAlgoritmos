/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Item {
    private double beneficio;
    private int peso;

    public Item(double beneficio, int peso) {
        this.beneficio = beneficio;
        this.peso = peso;
    }

    public double getValor() {
        return beneficio;
    }

    public void setValor(double valor) {
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        String aux ="";
        aux+=this.peso+"-"+this.beneficio;
        return aux; 
    }

    
    public static ArrayList<Item> geraraitems(int n, int v, int p){
        ArrayList<Item> items= new ArrayList<>();
        for(int i =0; i<n; i++){
             Random rndp = new Random();
             Random rndv = new Random();
             Item it= new Item(rndv.nextInt(v)+1,rndp.nextInt(p)+1);
             items.add(it);
        }
        return items;
    }
    
}