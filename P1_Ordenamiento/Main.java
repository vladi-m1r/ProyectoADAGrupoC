package P1_Ordenamiento;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("[QuickSort Test]");
		testQuickSort();
		
		System.out.println("\n\n[InsertionSort Test]");
		testHeapSort();
	}

	// Test con 3 casos de prueba
	public static void testQuickSort() {
		String arr[] = generateStr(10, 2, 10);
		Integer arr2[] = generateInt(10);
		Integer arr3[] = generateInt(10);
		
		System.out.println("Caso 1");
		System.out.println("Input: ");
		mostrarArr(arr);
		System.out.println("Output: ");
		QuickSort.sort(arr, 0, arr.length - 1);
		mostrarArr(arr);
		
		System.out.println("\nCaso 2");
		System.out.println("Input: ");
		mostrarArr(arr2);
		System.out.println("Output: ");
		QuickSort.sort(arr2, 0, arr2.length - 1);
		mostrarArr(arr2);
		
		
		System.out.println("\nCaso 3");
		System.out.println("Input: ");
		mostrarArr(arr3);
		System.out.println("Output: ");
		QuickSort.sort(arr3, 0, arr2.length - 1);
		mostrarArr(arr3);
	}
	
	public static void testHeapSort() {
		String arr[] = generateStr(10, 2, 10);
		Integer arr2[] = generateInt(10);
		Integer arr3[] = generateInt(10);
		
		System.out.println("Caso 1");
		System.out.println("Input: ");
		mostrarArr(arr);
		System.out.println("Output: ");
		HeapSort.sort(arr);
		mostrarArr(arr);
		
		System.out.println("\nCaso 2");
		System.out.println("Input: ");
		mostrarArr(arr2);
		System.out.println("Output: ");
		HeapSort.sort(arr2);
		mostrarArr(arr2);
		
		
		System.out.println("\nCaso 3");
		System.out.println("Input: ");
		mostrarArr(arr3);
		System.out.println("Output: ");
		HeapSort.sort(arr3);
		mostrarArr(arr3);
	}

	public static Integer[] generateInt(int n) {
		Random rd = new Random();
		
		Integer array [] = new Integer[n];
		
		for(int i=0; i < n; i++) {
			array[i] = rd.nextInt(n);
		}
		
		return array;
	}
	
	/*
	 * n -> numeros de elementos
	 * min -> minimo numero de letras por palabra generada
	 * max -> máximo numero de letras por palabra generada
	 */
	public static String[] generateStr(int n, int min, int max) {

		Random rd = new Random();
		String array [] = new String[n];
		
		for(int i=0; i < n; i++) {
			array[i] = "";
			for(int j=0; j < min + rd.nextInt(max - min); j++) {
				array[i] += (char)(rd.nextInt(25) + 97);
			}
		}
		
		return array;
	}

	public static <T> void mostrarArr(T[] array) {
		
		String arrStr = "[";
		
		for (int i = 0; i < array.length; i++) {
			arrStr += array[i];
			if(i != array.length - 1) {
				arrStr += ", ";
			}
		}
		
		arrStr += "]";
		
		System.out.println(arrStr);
	}
}
