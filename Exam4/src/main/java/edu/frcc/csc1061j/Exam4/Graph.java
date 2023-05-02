package edu.frcc.csc1061j.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;


public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	
	public class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();
		
		public Vertex (E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}
		
		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;
			
			if (elem.equals(((Vertex)other).elem)) {
				return true;
			}
			return false;		
		}
		
		@Override 
		public String toString() {
			return elem.toString();
		}
	}

	
	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}
	
	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	//We can only add one of each vertex
	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {
		
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) { //if s does not have the edge as neighbor add it
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for(Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}
	//We should try walking through this
	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int)edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		//We visit every neighboring edge and add the points they led to.
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}
	
	/* TODO: Implement the DFS algorithm for a graph either recursively
	** or iteratively using a stack. It should return a list of all the 
	** vertices in the pre-order depth-first traversal.
	*/
	//With starting vertex specified
	public List<Vertex> dfs(Vertex root) {
		List<Vertex> dfsList = new ArrayList<Vertex>();
		dfsList.add(root);
		return innerDfs(dfsList, root);
	}
	//without starting vertex specified
	public List<Vertex> dfs() {
		Vertex root = vertices.get(0);
		if(root == null) {
			return null;
		}
		List<Vertex> dfsList = new ArrayList<Vertex>();
		dfsList.add(root);
		return innerDfs(dfsList, root);
	}
	
	//Preorder depth-first
	private List<Vertex> innerDfs(List<Vertex> dfsList, Vertex v) {
		List<Vertex> n = getChildNodes(v);
		for(int i = 0; i < n.size(); i++) {
			if(!(dfsList.contains(n.get(i)))) {
				//if the neighbors is not in our list
				dfsList.add(n.get(i));
				dfsList = innerDfs(dfsList, n.get(i));
			}
		}
		return dfsList;
	}

	/* TODO: Implement the BFS algorithm for a graph. It should return a list 
	** of all the vertices in the breadth-first traversal.
	*/
	public List<E> bfs(Vertex v) {
		List<E> bfsList = new ArrayList<E>();
		Deque<Vertex> needToCheck = new ArrayDeque<Vertex>();
		needToCheck.add(v);
		while (!needToCheck.isEmpty()) { //We will add all of it's children to the stack, then repeat this process for each of them
			Vertex next = needToCheck.pop();
			bfsList.add(next.elem);
			List<Vertex> vChild = getChildNodes(next);
			for (Vertex child: vChild) {
				if (!bfsList.contains(child.elem)) {
					//if it's already on the list then we don't need to visit it again
					needToCheck.add(child);
				}
			}
		}
		
		return bfsList;
	}
	
	public List<E> bfs() {
		List<E> bfsList = new ArrayList<E>();
		Deque<Vertex> needToCheck = new ArrayDeque<Vertex>();
		needToCheck.add(vertices.get(0));
		while (!needToCheck.isEmpty()) { //We will add all of it's children to the stack, then repeat this process for each of them
			Vertex next = needToCheck.pop();
			bfsList.add(next.elem);
			List<Vertex> vChild = getChildNodes(next);
			for (Vertex child: vChild) {
				if ((!bfsList.contains(child.elem)) & !(needToCheck.contains(child))) {
					//if it's already on the list then we don't need to visit it again
					needToCheck.add(child);
					
				}
			}
		}
		
		return bfsList;
	}
	

	/* TODO: Create a spanning tree using Kruskal's Algorithm and return it. 
	** The spanning tree will be a new graph
	*/
	public Graph<E> findMinimumSpanningTree() {
		
		return null;
	}
}
