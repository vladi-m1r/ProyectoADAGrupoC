package P2_RecorridoGrafos;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File("src/P2_RecorridoGrafos/images/dory.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage depthImage = testDepthFirstSearch(image);
		draw(depthImage, "DepthFirstSearch");
		BufferedImage breadImage = testBreadthFirstSearch(image);
		draw(breadImage, "BreadthFirstSearch");
	}

	public static BufferedImage testDepthFirstSearch(BufferedImage image) {
		System.out.println("DepthFirstSearch");
		
		Raster raster = image.getRaster();
		int [][] componentes = generateComp(raster.getHeight(), raster.getWidth());
		// Busqueda profunda llena una matriz de componentes.
		int rango = 25;
		
		for (int y = 0; y < componentes.length; y++) {
			for (int x = 0; x < componentes[0].length; x++) {
				if(componentes[y][x] == -1)
					DepthFirstSearch.search(raster, x, y, componentes, raster.getSample(x, y, 0), rango);
			}
		}
		
		return buildImage(componentes);
	}
	
	public static BufferedImage testBreadthFirstSearch(BufferedImage image) {
		System.out.println("BreadthFirstSearch");
		
		Raster raster = image.getRaster();
		int [][] componentes = generateComp(raster.getHeight(), raster.getWidth());
		// Busqueda profunda llena una matriz de componentes.
		int rango = 25;
			
		for (int y = 0; y < componentes.length; y++) {
			for (int x = 0; x < componentes[0].length; x++) {
				if(componentes[y][x] == -1) {
					BreadthFirstSearch.search(raster, componentes, x, y, rango);
				}
			}
		}
			
		return buildImage(componentes);
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
	
	public static void draw(BufferedImage img, String title) {
		JFrame jframe = new JFrame();
		jframe.setTitle(title);
		jframe.setVisible(true);
		jframe.add(new JLabel(new ImageIcon(img)));
		jframe.pack();
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
	
	public static BufferedImage buildImage(int [][] rgb) {
		
		BufferedImage image = new BufferedImage(rgb[0].length, rgb.length, 5);
		
		for (int i = 0; i < rgb.length; i++) {
			for (int j = 0; j < rgb[0].length; j++) {
				Color color = new Color(rgb[i][j], rgb[i][j], rgb[i][j]);
				image.setRGB(j, i, color.getRGB());
			}
		}
		return image;
	}
}
