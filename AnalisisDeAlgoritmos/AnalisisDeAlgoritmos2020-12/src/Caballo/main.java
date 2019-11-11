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
public class main {
     
    public static void main(String[] args) {
        caballoA caballo = new caballoA(8);
        caballo.Solucion(0, 0);
        System.out.println(caballo.toString());
 
    }
}
