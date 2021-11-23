package P2_RecorridoGrafos;

import java.awt.image.Raster;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	
	public static void search(Raster graph, int [][] comps, int x, int y, int rang) {
		
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(x, y));
		Range range = new Range(graph.getSample(x, y, 0), rang);
		int grayScale = graph.getSample(x, y, 0);
		
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			// Se resuelve las colas
			comps[current.y][current.x] = grayScale;
			// Se forma colas
			buildQueue(queue, current, graph, range, comps);				
		}
	}
	
	public static void buildQueue(Queue<Node> queue, Node current, Raster graph, Range range, int [][] comp) {
		
		int x, y;
		
		x = current.x;
		y = current.y - 1;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.add(new Node(x, y));
			comp[y][x] = graph.getSample(x, y, 0);
		}
		
		x = current.x + 1;
		y = current.y;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.add(new Node(x, y));
			comp[y][x] = graph.getSample(x, y, 0);
		}
		
		x = current.x;
		y = current.y + 1;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.add(new Node(x, y));
			comp[y][x] = graph.getSample(x, y, 0);
		}
		
		x = current.x - 1;
		y = current.y;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.add(new Node(x, y));
			comp[y][x] = graph.getSample(x, y, 0);
		}
		
	}
	
	private static boolean checkLimits(int x, int y, Range range, Raster graph, int [][] visited) {
		// El nodo no se usa si no esta en el rango o esta fuera de los limites
		if(x > graph.getWidth() - 1 || y > graph.getHeight() - 1 || x < 0 || y < 0) {
			return false;
		}else {
			return visited[y][x] == -1 && range.inTheRange(graph.getSample(x, y, 0));
		}
	}
}



