package com.code.practice.graph;

import java.util.LinkedList;

public class Graph {
	private int noOfVertices;

	private LinkedList<Integer> adjList[];

	public Graph(int vertex) {
		this.noOfVertices = vertex;

		adjList = new LinkedList[vertex];
		for (int i = 0; i < vertex; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination) {
		//add edge
		adjList[source].addFirst(destination);
		
		//add back edge [[for undirected]]
		adjList[destination].addFirst(source);
	}
}
