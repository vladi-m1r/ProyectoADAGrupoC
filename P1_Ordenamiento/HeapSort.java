package P1_Ordenamiento;

public class HeapSort {
	
	public static <T extends Comparable<T>> void sort(T [] array) {

		int size = array.length;

		while(size > 1) {
			for (int index = (size / 2) - 1; index >= 0; index--) {
				// 2 child nodes
				int nodePos = index*2 + 1;
				
				for (int i = 1; i <= 2 && nodePos < size; i++) {
					if (array[index].compareTo(array[nodePos]) < 0) {
						swap_keys(array, index, nodePos);
						if (nodePos*2+1 < size) {
							index = nodePos;
						}
					}
					nodePos += i;
				}
			}

			swap_keys(array, 0, size-1);
			size--;
		}
	}
	
	private static <T> void swap_keys(T[] array , int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
