package P2_RecorridoGrafos;

import java.awt.image.Raster;

public class DepthFirstSearch {
	
	/*
	 * Solo se toma en cuenta 4 vecinos
	 * En una imagen matriz parte de tener x, y posicion
	 * 
	 * [P] -> (x, y) Nodo actual
	 * 
	 * Vecinos
	 * [A] -> (x, y - 1)
	 * [B] -> (x + 1, y)
	 * [C] -> (x, y + 1)
	 * [D] -> (x - 1, y)
	 * 
	 * 
	 *      [A]
	 *   [D][P][B]
	 *      [C] 
	 */
	
	public static void search(Raster graph, int x, int y) {
		search(graph, new Node(x, y), new boolean[graph.getHeight()][graph.getWidth()]);
	}
	
	private static void search(Raster graph, Node current, boolean [][] visited) {
		
		// filas y columnas
		visited[current.y][current.x] = true;
		
		Node [] neightbors = new Node[4];
		fillNeighbours(neightbors, graph, current);
		
		for (int i = 0; i < neightbors.length; i++) {
			if(!neightbors[i].deactive && !visited[neightbors[i].y][neightbors[i].x]) {
				System.out.print(graph.getSample(neightbors[i].x, neightbors[i].y, 0) + " - ");
				System.out.println("[" + neightbors[i].y + ", " + neightbors[i].x + "]");
				search(graph, neightbors[i], visited);
			}
		}
	}
	
	private static void fillNeighbours(Node [] neighbours, Raster graph, Node current) {

		neighbours[0] = new Node(current.x, current.y - 1);
		neighbours[1] = new Node(current.x + 1, current.y);
		neighbours[2] = new Node(current.x, current.y + 1);
		neighbours[3] = new Node(current.x - 1, current.y);
		
		for (Node node : neighbours)
			checkLimits(node, graph.getWidth(), graph.getHeight());
	}
	
	// chequea la posicion de x e y de un nodo para que no se salga del limite
	private static void checkLimits(Node node, int x, int y) {
		if(node.x > x - 1 || node.y > y - 1 || node.x < 0 || node.y < 0) {
			node.deactive = true;
		}
	}
}

class Node{
	
	public int x;
	public int y;
	public boolean deactive;
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
