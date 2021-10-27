package P1_Ordenamiento;

public class HeapSort {
	
	public static void sort(int [] array) {
		/*
			3 Pasos Recursivos hasta que el tamaño del arreglo sea igual a 1:
			1 -> Conseguir Max Heap
			2 -> Comparar el nodo modificado
			3 -> Intercambiar el primer nodo con el ultimo y borrar el ultimo
		*/
		int fakeSize = array.length;

		while(fakeSize > 1) {
			// Visita todo los nodos empezando desde el ultimo
			for (int index = (fakeSize / 2) - 1; index >= 0; index--) {
				// 2 child nodes
				int nodePos = index*2 + 1;
				
				for (int i = 1; i <= 2 && nodePos < fakeSize; i++) {
					if (array[index] < array[nodePos]) {
						swap_keys(array, index, nodePos);
						if (nodePos*2+1 < fakeSize) {
							index = nodePos;
						}
					}
					nodePos += i;
				}
			}

			swap_keys(array, 0, fakeSize-1);
			fakeSize--;
		}
	}

	private static void swap_keys(int[] array , int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
