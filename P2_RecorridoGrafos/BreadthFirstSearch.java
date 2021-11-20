package P2_RecorridoGrafos;

import java.awt.image.Raster;

public class BreadthFirstSearch {
	
	public static void search(Raster graph, int [][] comps, int x, int y, int rang) {
		
		Queue queue = new Queue();
		queue.push(new Node(x, y));
		Range range = new Range(graph.getSample(x, y, 0), rang);
		int grayScale = graph.getSample(x, y, 0);
		
		while(!queue.isEmpty()) {
			Node current = queue.pop();
			// Se resuelve las colas
			comps[current.y][current.x] = grayScale;
			// Se forma colas
			buildQueue(queue, current, graph, range, comps);				
		}
	}
	
	public static void buildQueue(Queue queue, Node current, Raster graph, Range range, int [][] comp) {
		
		int x, y;
		
		x = current.x;
		y = current.y - 1;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.push(new Node(x, y));
		}
		
		x = current.x + 1;
		y = current.y;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.push(new Node(x, y));
		}
		
		x = current.x;
		y = current.y + 1;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.push(new Node(x, y));
		}
		
		x = current.x - 1;
		y = current.y;
		if(checkLimits(x, y, range, graph, comp)) {
			queue.push(new Node(x, y));
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

class Queue{
	
	public Node front;
	public Node behind;
	
	public void push(Node node) {
		if(front == null)
			front = node;
		else {
			front.next = node;
			behind = node;
		}
	}
	
	public Node pop() {
		Node popNode = front;
		front = front.next;
		return popNode;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
}



