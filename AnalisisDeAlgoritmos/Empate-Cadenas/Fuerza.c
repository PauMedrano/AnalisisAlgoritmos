#include <stdio.h>
#define max 5000
void FuerzaBruta(char a[max],char b[max]){
	int n,m, i;
	int contador=0;
	//Obtenemos los tamaños de la cadena
	n=strlen(a);
	//Obtenemos el tamaño del patron
    m=strlen(b);
     //Recorremos la cadena desde el intevalo de [0,n-m] ya que no se puede hacer comparaciones en la cadena en el intevalo [n-m,n] ya que se saldria del arreglo
     for( i=0;i<=n-m;i++){
		//Empezamos con un auxiliar poniendolo en la posicion de la cadena a verificar
        int l=i;
		//Empezamos con un auxiliar poniendolo en la posicion del patron a verificar
		int j=0;
		//Se itera hasta que el auxiliar que mueve a la cadena sea mayor que el tamaño del patron y que contenga el mismo caracter en esas posiciones
        while(a[l]==b[j] &&  j<=m) {
			//Se mueven los dos auxliares
            l++; j++;
		}
		//Si el auxiliar que mueve al patron es mayor al tamaño de patron -1 quiere decir que tenemos un encuentro ya que se cimplio que todos los carecatres de ese sub conjunto es igual al patron
        if(j > m-1){
			 //Se imprime la posicion donde se encuentra una pocurrencia
			printf("El patron se encontro en %d \n",i+1);
			//Se aumenta el numero de ocurrencias
    		contador++;
		}
	 }
	 //Si el contador de ocurrencias es mayor que 0 significa que se encontro alemenos una vez de lo contrario no se encontro
	 if(contador > 0)printf("Se encontraron %d ocurrencias del patron \n",contador);
	 else printf("No se encontro el patron");
}

int main(){
	char cadena[max],patron[max];
	int opcion;
	do{
		printf("Emparejamiento de cadenas usando fuerza bruta \n");
		printf("Ingrese la cadena \n");
		scanf("%s",cadena);
		printf("Ingrese el patron \n");
		scanf("%s",patron);
		FuerzaBruta(cadena,patron);
		printf("Deseas ingresar una nueva cadena: \n");
		scanf("%d",&opcion);
	}while(opcion!=2);

}
