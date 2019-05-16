
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author erickmichael
 */
public class BusquedaOrdenamientoExamn2 {
    public  static int vec[]={20,12,28,24,8,4,16};
        public static void imprimirOrdenamientoRecursivo() {
                System.out.println("Vector original");
                imprimirVector(vec);
                ordenacionRapida(vec);
                System.out.println("\nVector ordenado");
                imprimirVector(vec);
        }
        public static void ordenacionRapida(int vec[]){
                int N=vec.length;
                quickSort(vec, 0, N-1);
        }
        public static void quickSort(int vec[], int inicio, int fin){
                if(inicio>=fin) return;
                int pivote=vec[inicio];
                int elemIzq=inicio+1;
                int elemDer=fin;
                while(elemIzq<=elemDer){
                        while(elemIzq<=fin && vec[elemIzq]<pivote){
                                elemIzq++;
                        }
                        while(elemDer>inicio && vec[elemDer]>=pivote){
                                elemDer--;
                        }
                        if(elemIzq<elemDer){
                                int temp=vec[elemIzq];
                                vec[elemIzq]=vec[elemDer];
                                vec[elemDer]=temp;
                        }
                }
                
                if(elemDer>inicio){
                        int temp=vec[inicio];
                        vec[inicio]=vec[elemDer];
                        vec[elemDer]=temp;
                }
                quickSort(vec, inicio, elemDer-1);
                quickSort(vec, elemDer+1, fin);
        }
        public static void imprimirVector(int vec[]){
                for(int i=0;i<vec.length;i++){
                System.out.print(vec[i]+" ");
                }
        }
        
        public static int busca(int[] array, int chave) {
		return buscaBinariaRecursiva(array, 0, array.length - 1, chave);
	}
	public static int buscaBinariaRecursiva(int[] array, int menor, int mayor,int chave) {
		int media = (mayor + menor) / 2;
		int valorMedio = array[media];

		if (menor > mayor)
			return -1;
		else if(valorMedio == chave) 
			return media;
		else if (valorMedio < chave)
			return buscaBinariaRecursiva(array, media+1, mayor, chave);
		else
			return buscaBinariaRecursiva(array, menor, media-1, chave);
	}
        public static void imprimirBusquedaBinariaRecursiva() {
            int[] array = { 1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90 };
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
                System.out.println("Tamaño: "+array.length);
		System.out.println("El numero 6 esta en la posicion: "+busca(array, 6));
		System.out.println("El numero 78 esta en la posicion: "+busca(array, 67));
		System.out.println("El numero 90 esta en la posicion: "+busca(array, 78));
    }
        public static void main(String[] args) {
	System.out.println("Ingrese la opción que desee probar:");
        Scanner leer=new Scanner(System.in);
        int opcion =leer.nextInt();
        while (opcion!=0) {            
            switch(opcion){
            case 1: imprimirOrdenamientoRecursivo(); break;
            case 2: imprimirBusquedaBinariaRecursiva();break;
            default: System.out.println("Opción Inválida!!");break;
            }  
            System.out.println("\nIngrese la opción que desee probar:");            
            opcion =leer.nextInt();
        }
        }
}
