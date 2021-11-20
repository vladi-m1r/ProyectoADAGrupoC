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
		
		comp[current.y][current.x] = mark;
		Link linklist = buildLink(graph, range, current, comp);
		
		while(!linklist.isEmpty()) {
			search(graph, linklist.getNode(), comp, mark, range);
		}

	}
	
	private static Link buildLink(Raster graph, Range range, Node current, int[][] comp) {
		Link link = new Link();
		int x, y;
		
		x = current.x;
		y = current.y - 1;
		if(checkLimits(x, y, range, graph, comp)) {
			link.addNode(new Node(x, y));
		}
		
		x = current.x + 1;
		y = current.y;
		if(checkLimits(x, y, range, graph, comp)) {
			link.addNode(new Node(x, y));
		}
		
		x = current.x;
		y = current.y + 1;
		if(checkLimits(x, y, range, graph, comp)) {
			link.addNode(new Node(x, y));
		}
		
		x = current.x - 1;
		y = current.y;
		if(checkLimits(x, y, range, graph, comp)) {
			link.addNode(new Node(x, y));
		}
		
		return link;
	}
	
	// chequea la posicion de x e y de un nodo para que no se salga del limite
	private static boolean checkLimits(int x, int y, Range range, Raster graph, int [][] visited) {
		// El nodo no se usa si no esta en el rango o esta fuera de los limites
		if(x > graph.getWidth() - 1 || y > graph.getHeight() - 1 || x < 0 || y < 0) {
			return false;
		}else {
			return visited[y][x] == -1 && range.inTheRange(graph.getSample(x, y, 0));
		}
	}
}

class Node{
	
	public int x;
	public int y;
	public boolean deactive;
	public Node next;
	
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

class Link {
	public Node head;
	
	public void addNode(Node node) {
		if(head == null) {
			head = node;
		}else {
			node.next = node;
		}
	}
	
	public Node getNode() {
		Node node = head;
		head = head.next;
		return node;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}
