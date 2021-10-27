package P1_Ordenamiento;

public class QuickSort {

	public static void sort(int [] array, int ini, int fin) {
		if (fin-ini >= 1) {

			int pivot = array[ini];
			int i = ini + 1;
			int j = fin;

			while(i < j) {

				/*
					Tiene un par de estados
					Teniendo i y j
					si arr[i] > pivot > arr[j], intercambia i por j y avanzan ambos
					si arr[i] < pivot, i avanza por la izquierda
					si arr[j] > pivot, j avanza por la derecha
				*/
				if (array[i] >= pivot && array[j] < pivot) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					i++;
					j--;
				} else {
					if (array[i] < pivot) {
						i++;
					}

					if (array[j] >= pivot) {
						j--;
					}
				}
			}

			if (array[i] >= pivot) {
				i = i - 1;
			}

			array[ini] = array[i];
			array[i] = pivot;
			
			// LEFT
			sort(array, ini, i-1);
			// RIGHT
			sort(array, i+1, fin);
		}
	}
}
