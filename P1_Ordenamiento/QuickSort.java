package P1_Ordenamiento;

public class QuickSort {

	/*
	 * Algoritmo hibrido de Quicksort con Insertion Sort.
	 * 
	 * Segun el articulo de https://www.geeksforgeeks.org/advanced-quick-sort-hybrid-algorithm/
	 * La combinacion de quicksort e insertion sort llega es mas eficiente ya que quicksort para datos
	 * mas grandes es eficiente mientras que insertion sort hace lo mismo con datos menores.
	 * 
	 * Esto sucede apartir del tamaño 10.
	 * Si n es menor que 10 entonces se usa insertion sort
	 * Si n es mayor o igual que 10 entonces se usa quick sort
	 */
	
	public static <T extends Comparable<T>> void sort(T [] array, int ini, int fin) {
		if (fin-ini >= 1) {
			
			if( fin - ini + 1 < 10) {
				InsertionSort.sort(array, ini, fin);
				return;
			}
			
			T pivot = array[ini];
			int i = ini + 1;
			int j = fin;

			while(i < j) {
				if (array[i].compareTo(pivot) >= 0 && array[j].compareTo(pivot) < 0) {
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					i++;
					j--;
				} else {
					if (array[i].compareTo(pivot) < 0) {
						i++;
					}

					if (array[j].compareTo(pivot) >= 0) {
						j--;
					}
				}
			}

			if (array[i].compareTo(pivot) >= 0) {
				i = i - 1;
			}
			
			array[ini] = array[i];
			array[i] = pivot;
			sort(array, ini, i-1);
			sort(array, i+1, fin);
		}
	}
}
