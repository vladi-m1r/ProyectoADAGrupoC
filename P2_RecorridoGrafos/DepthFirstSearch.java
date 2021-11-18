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
	
	public static void search(Raster graph, int x, int y, int[][] comp, int mark, int range) {
		search(graph, new Node(x, y), comp, mark, new Range(graph.getSample(x, y, 0), range));
	}
	
	private static void search(Raster graph, Node current, int[][] comp, int mark, Range range) {
		
		// filas y columnas
		comp[current.y][current.x] = mark;
		
		Node [] neightbors = new Node[4];
		fillNeighbours(neightbors, graph, current, range);
		
		for (int i = 0; i < neightbors.length; i++) {
			if(!neightbors[i].deactive && comp[neightbors[i].y][neightbors[i].x] == 0) {
				search(graph, neightbors[i], comp, mark, range);
			}
		}
	}
	
	// Mejorar esta funcion, tiene muchos errores
	private static void fillNeighbours(Node [] neighbours, Raster graph, Node current, Range range) {

		neighbours[0] = new Node(current.x, current.y - 1);
		neighbours[1] = new Node(current.x + 1, current.y);
		neighbours[2] = new Node(current.x, current.y + 1);
		neighbours[3] = new Node(current.x - 1, current.y);
		
		for (Node node : neighbours)
			checkLimits(node, range, graph);
	}
	
	// chequea la posicion de x e y de un nodo para que no se salga del limite
	private static void checkLimits(Node node, Range range, Raster graph) {
		// El nodo no se usa si no esta en el rango o esta fuera de los limites
		if(node.x > graph.getWidth() - 1 || node.y > graph.getHeight() - 1 || node.x < 0 || node.y < 0) {
			node.deactive = true;
		}else {
			if(!range.inTheRange(graph.getSample(node.x, node.y, 0))) {
				node.deactive = true;
			}
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

class Range{
	
	public int inf;
	public int sup;
	
	Range(int mid, int range){
		this.inf = mid - range;
		this.sup = mid + range;
	}
		
	public boolean inTheRange(int number) {
		return number >= inf && number <= sup;
	}
}
