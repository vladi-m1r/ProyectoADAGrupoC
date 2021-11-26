package Examen;

public class MaximumLoot {
	
	public static int maxLoot(int [] v, int [] c, int volumen) {
		//
		int [][] array = new int [v.length + 1][volumen + 1];
		for(int i = 1; i < array.length; i++) {
			for (int j = 1; j < array[0].length; j++) {
				if(j >= c[i - 1]) {
					int max = Math.max(array[i - 1][j], v[i-1] + array[i-1][j-c[i-1]]);
					array[i][j] = max;
				}else {
					array[i][j] = array[i-1][j];
				}
			}
		}
		
		return array[array.length-1][array[0].length-1];
	}
	

	public static void main(String[] args) {
		int [] valor1 = {5, 2, 4, 1};
		int [] costo1 = {6, 2, 1, 2};
		int [] valor2 = {1, 3, 2, 3, 1, 1, 3, 2, 4, 2};
		int [] costo2 = {1, 2, 2, 1, 1, 2, 3, 1, 2, 2};
		int resp1 = maxLoot(valor1, costo1, 6);
		int resp2 = maxLoot(valor2, costo2, 5);
		System.out.println(resp1);
		System.out.println(resp2);
	}
}
