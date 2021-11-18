package P2_RecorridoGrafos;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
	public static void main(String[] args) {
		testDepthFirstSearch();
	}

	public static void testDepthFirstSearch() {
		System.out.println("DepthFirstSearch");
		try {
			BufferedImage image = ImageIO.read(new File("src/P2_RecorridoGrafos/images/image3.png"));
			Raster raster = image.getRaster();
			int [][] componentes = new int [raster.getHeight()][raster.getWidth()];
			
			// Busqueda profunda llena una matriz de componentes.
			int index = 1;
			int rango = 10;
			
			for (int i = 0; i < componentes.length; i++) {
				for (int j = 0; j < componentes[0].length; j++) {
					if(componentes[i][j] == 0) {
						DepthFirstSearch.search(raster, j, i, componentes, index, rango);
						index++;
					}
				}
			}
			
			mostrarComponentes(componentes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testBreadthFirstSearch() {
		try {
			BufferedImage image = ImageIO.read(new File("src/P2_RecorridoGrafos/images/image2.png"));
			Raster raster = image.getRaster();
			// sin definir
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Prueba del cargado de imagen en escala de grises
	public static void testGrayScale() {
		try {
			BufferedImage image = ImageIO.read(new File("src/P2_RecorridoGrafos/images/image.png"));
			Raster raster = image.getRaster();
			for (int i = 0; i < image.getHeight(); i++) {
				for (int j = 0; j < image.getWidth(); j++) {
					System.out.print(raster.getSample(j, i, 0) + " - ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mostrarComponentes(int [][] comp) {
		for (int[] is : comp) {
			System.out.print("|");
			for (int is2 : is) {
				System.out.printf("%3d |", is2);
			}
			System.out.println();
		}
	}
}
