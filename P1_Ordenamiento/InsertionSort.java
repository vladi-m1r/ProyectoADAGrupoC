package P1_Ordenamiento;

public class InsertionSort {

	public static <T extends Comparable<T>> void sort(T [] array, int ini, int fin) {

		for (int i = ini + 1; i < fin + 1; i++) {
			T value = array[i];
			int j = i - 1;

			while (j >= 0 && array[j].compareTo(value) > 0) {
				array[j+1] = array[j];
				j--;
			}

			array[j+1] = value;
		}
	}
}
