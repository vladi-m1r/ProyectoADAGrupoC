package P2_RecorridoGrafos;

import java.awt.image.Raster;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {
	
	public static void search(Raster graph, int x, int y, int[][] comp, int gray, int range) {
		int count = 0;
		search(graph, new Node(x, y), comp, gray, new Range(graph.getSample(x, y, 0), range), count);
	}
	
	private static void search(Raster graph, Node current, int[][] comp, int gray, Range range, int count) {
		
		comp[current.y][current.x] = gray;
		Stack<LinkedList<Node>> stack = new Stack<LinkedList<Node>>();
		stack.add(buildLink(graph, range, current, comp));
		
		while(!stack.isEmpty()) {
		
			LinkedList<Node> tempList = stack.pop();
			
			while(!tempList.isEmpty()) {
				Node node = tempList.remove();
				if(canBeVisited(node.x, node.y, comp)) {
					comp[node.y][node.x] = gray;
					
					if(!tempList.isEmpty()) {
						stack.add(tempList);
					}
					
					stack.add(buildLink(graph, range, node, comp));
					break;
				}
			}
		}
	}
	
	private static LinkedList<Node> buildLink(Raster graph, Range range, Node current, int[][] comp) {
		
		LinkedList<Node> link = new LinkedList<Node>();
		int x, y;
		
		x = current.x;
		y = current.y - 1;
		if(checkLimits(x, y, range, graph) && canBeVisited(x, y, comp)) {
			link.add(new Node(x, y));
		}
		
		x = current.x + 1;
		y = current.y;
		if(checkLimits(x, y, range, graph) && canBeVisited(x, y, comp)) {
			link.add(new Node(x, y));
		}
		
		x = current.x;
		y = current.y + 1;
		if(checkLimits(x, y, range, graph) && canBeVisited(x, y, comp)) {
			link.add(new Node(x, y));
		}
		
		x = current.x - 1;
		y = current.y;
		if(checkLimits(x, y, range, graph) && canBeVisited(x, y, comp)) {
			link.add(new Node(x, y));
		}
		
		return link;
	}
	
	// chequea la posicion de x e y de un nodo para que no se salga del limite
	private static boolean checkLimits(int x, int y, Range range, Raster graph) {
		// El nodo no se usa si no esta en el rango o esta fuera de los limites
		if(x > graph.getWidth() - 1 || y > graph.getHeight() - 1 || x < 0 || y < 0) {
			return false;
		}else {
			return range.inTheRange(graph.getSample(x, y, 0));
		}
	}
	
	private static boolean canBeVisited(int x, int y, int [][] visited) {
		return visited[y][x] == -1;
	}
}

class Node{
	
	public int x;
	public int y;
	
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