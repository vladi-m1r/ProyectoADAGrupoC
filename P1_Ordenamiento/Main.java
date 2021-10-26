package P1_Ordenamiento;

public class Main {
	public static void main(String[] args) {
		test();
	}
	
	// Test para probar los 3 metodos de ordenamiento : Ok si pasa la prueba y Error si no
	public static void test() {
		// Insertion Sort
		int [] array = {9, 1, 4, 3, 2, 5, 7, 6, 8};
		InsertionSort.sort(array);
		
		// Insertion sort test
		System.out.print("Insertion Sort Test: ");
		if(comparar(array, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9})) {
			System.out.println("OK");
		}else {
			System.out.println("ERROR");
		}
		
	}
	
	// Compara que los elementos de 2 arreglos tengan los mismos elementos en el mismo orden
	public static boolean comparar(int [] arr1, int [] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		
		return true;
	}
}
