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
		try {
			BufferedImage image = ImageIO.read(new File("src/P2_RecorridoGrafos/images/image3.png"));
			Raster raster = image.getRaster();
			// Busqueda profunda, imprime en la consola grayscale, fila y columna correspondiente
			DepthFirstSearch.search(raster, 0, 0);
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

}
