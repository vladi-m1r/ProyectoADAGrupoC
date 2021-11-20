package P2_RecorridoGrafos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		testDepthFirstSearch();
	}

	public static void testDepthFirstSearch() {
		System.out.println("DepthFirstSearch");
		try {
			BufferedImage image = ImageIO.read(new File("src/P2_RecorridoGrafos/images/dory.jpg"));
			Raster raster = image.getRaster();
			int [][] componentes = generateComp(raster.getHeight(), raster.getWidth());
			// Busqueda profunda llena una matriz de componentes.
			int rango = 25;
			
			for (int y = 0; y < componentes.length; y++) {
				for (int x = 0; x < componentes[0].length; x++) {
					if(componentes[y][x] == -1) {
						DepthFirstSearch.search(raster, x, y, componentes, raster.getSample(x, y, 0), rango);
					}
				}
			}
			
			showComponents(componentes);
			draw(componentes);
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
			BufferedImage image = ImageIO.read(new File("src/P2_RecorridoGrafos/images/dory.png"));
			Raster raster = image.getRaster();
			for (int i = 0; i < image.getHeight(); i++) {
				for (int j = 0; j < image.getWidth(); j++) {
					System.out.printf("%3d |", raster.getSample(j, i, 0));
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showComponents(int [][] comp) {
		for (int[] is : comp) {
			System.out.print("|");
			for (int is2 : is) {
				System.out.printf("%3d |", is2);
			}
			System.out.println();
		}
	}
	
	public static void draw(int [][] matriz) {
		JFrame jframe = new JFrame();
		jframe.setVisible(true);
		jframe.setSize(1500, 1500);
		Canvas canvas = new Canvas();
		jframe.add(canvas);
		Graphics graph = canvas.getGraphics();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				graph.setColor(new Color(matriz[i][j], matriz[i][j], matriz[i][j]));
				graph.fillRect(j, i, 1, 1);
			}
		}
	}
	
	// Genera un arreglo bidimensional con el numero -1 por defecto en los espacios
	public static int[][] generateComp(int row, int colum) {
		int [][] comps = new int [row][colum];

		for (int y = 0; y < row; y++) {
			for (int x = 0; x < colum; x++) {
				comps[y][x] = -1;
			}
		}
		
		return comps;
	}
}
