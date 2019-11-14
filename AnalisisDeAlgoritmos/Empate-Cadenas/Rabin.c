/* Following program is a C implementation of Rabin Karp
Algorithm given in the CLRS book */
#include<stdio.h>
#include<string.h>
#define MAX 5000
// d es el numero de carectares que tiene la entrada
#define d 256
void rabinKarp(char pat[MAX], char txt[MAX], int q){
	//Se obtinen los tamanos del texto y del patron
	int M = strlen(pat);
	int N = strlen(txt);
	int i, j;
	int p = 0; //Valor del hash para el patron
	int t = 0; //Valor del hash para la ventana del texto
	int h = 1;

	//para calcular el hash, el valor que representa la cadena, q es el primo mayor mas proximo al numero de letras
	for (i = 0; i < M-1; i++)
		h = (h*d)%q;
	//Se calcula el hash para el patron y para la primera ventana del texto
	//Ventana es un sub string del texto al que se compara por hash
	for (i = 0; i < M; i++){
		p = (d*p + pat[i])%q;
		t = (d*t + txt[i])%q;
	}
	// //Recorremos el texto desde el intevalo de [0,N-M] ya que no se puede hacer comparaciones en la cadena en el intevalo [N-M,N] ya que se saldria del arreglo
	for (i = 0; i <= N - M; i++){
		//Si el hash de el patron es igual que el hash de el texto
		if ( p == t ){
			//Se hace una comprobacion solo para verificar si son igules
			for (j = 0; j < M; j++){
				if (txt[i+j] != pat[j])
					break;
			}
			//Si al comprabar caracter a caracter son iguales tenemos una ocurrencia
			if (j == M)printf("Patron encontrado en %d \n", i+1);
		}

		//Se calcula el hash para la siguiente ventana
		if ( i < N-M ){
			t = (d*(t - txt[i]*h) + txt[i+M])%q;
			//Si el hash es negativo se hace positivo sumando el primo relativo
			if (t < 0)
			t = (t + q);
		}
	}
}
int main()
{
	char txt[MAX];
	char pat[MAX];
	printf("Emparejamiento de cadenas usando Rabin Karp \n");
	printf("Ingrese la cadena \n");
	scanf("%s",txt);
	printf("Ingrese el patron \n");
	scanf("%s",pat);
	int q = 101; // A prime number
	rabinKarp(pat, txt, q);
	return 0;
}
