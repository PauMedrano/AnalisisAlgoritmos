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
public class caballo 
{
    public int [][] tablero;
    public int mx[]={-2,-1,1,2,2,1,-1,-2}; //Movimientos posibles del Caballo en X
    public int my[]={1,2,2,1,-1,-2,-2,-1}; //Movimientos posibles del Caballo en Y 
    boolean exito=true;
    
    //Constructor
    public caballo() 
    {
        this.tablero=new int[8][8];//Se crea un tablero de 8x8;
    }
    
    //Metodo para revolver el algoritmo
    public void resolver()
    {
        int px=0, py=0;//El caballo comienza en la posicion (0,0) del tablero.
        int pxaux=0, pyaux=0;//Nos ayuda con la posicion del posible siguiente movimiento del caballo.
        int cont=1;//El contador comienza en 1 indicando la primer casilla visitada del caballo.
        int posi=9;//Las posibilidades del siguiente movimiento se inicia en 9,
        //si no hay posibilidad menor quiere decir que el caballo ya no se puede mover.
        int aux=0;//Nos ayuda con las posibilidades potenciales del posible siguietne movimieno del caballo.
        
        this.tablero[px][py]=1;//Se marca la casilla (0,0) como visitada.
        do
        {
            pxaux=px;//Se asigna la nueva posicion x.
            pyaux=py;//Se asigna la nueva posicion y.
            for(int i=0; i<8; i++)//Un for de 0 a 8 ya que los movimientos posibles maximos del caballo son 8
            {
                if(validar(px, py, mx[i], my[i])==1)// el movimiento sea valido.
                {
                    
                    for(int j=0; j<8; j++)//Un for de 0 a 8 ya que los movimientos posibles del movimiento potencial del caballo son maximo 8
                    {
                        aux+=validar(px+mx[i], py+my[i], mx[j], my[j]);//Se cuentan las posibilidades que tiene el movimiento potencial.
                    }
                    if ((aux<posi && aux!=0) || (aux<posi && aux==0 && cont==63))//Se comprueba si el nuevo movimiento 
                        //tiene menos posibilidades que el anterior siguiendo el principio avido del algoritmo.
                    {
                        pxaux=px+mx[i];//Se asignan las nuevas posiciones potenciales para mover al caballo en x.
                        pyaux=py+my[i];//Se asignan las nuevas posiciones potenciales para mover al caballo en y.
                        posi=aux;//Se asigna la nueva cantidad de posibilidades para verificar si hay una menor.
                    }
                    aux=0;//Se resetea el numero de posibilidades.
                }
            }
            if(posi==9)//Quiere decir que no hay mas movimientos posibles para el caballo por lo tanto el programa termina.
            {
                exito=false;
            }
            else
            {
                cont++;//Aumenta el contador para indicar el numero de movimientos que van.
                this.tablero[pxaux][pyaux]=cont;//Se marca en el tablero la casilla visitada con el numero de movimiento.
                posi=9;//Se resetean las posibilidades.
                px=pxaux;//Se asigna la nueva posicion del caballo en x.
                py=pyaux;//Se asigna la nueva posicion del caballo en y.
            }
            System.out.println("px="+px+", py="+py);//Se imprime las nuevas coordenadas del caballo.
            imprimirTablero();//Se imprime el tablero actualizado al numero de movimientos.
        }while((exito==true) && cont!=64);//Si el contador llega a 64 significa que el tablero se lleno o si exito es falso quiere decir que el caballo ya no se puede mover.
        
        
    }
    public int validar(int px, int py, int x, int y) //recibe la posicion en x,y del caballo y el movimiento
    {
        if(((px+x)>=0 && (px+x)<=7) && ((py+y)>=0 && (py+y)<=7)) //verifica que el movimiento esta dentro del tablero
        {
            if(tablero[px+x][py+y]==0) //verificar que el movimiento
            {
                return 1;// el movimiento es valido
            }
            else
            {
                return 0; // el movimiento no es valido
            }
        }
        else
        {
            return 0; //el movimiento no es valido
        }
    }
    public void imprimirTablero () // imprime el tablero
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                System.out.print(""+tablero[i][j]+"\t");
            }
            System.out.println();
        }
    
    }
}