package com.github.aguilasa;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Kruskal {

	private List<Vertex> vertices = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();

	public Vertex addVertex(String name) {
		Vertex v = new Vertex(name);
		int indexOf = vertices.indexOf(v);
		if (indexOf >= 0) {
			return vertices.get(indexOf);
		}
		vertices.add(v);
		return v;
	}

	public Edge addEdge(String source, String destiny, int weight) {
		Edge e = new Edge(addVertex(source), addVertex(destiny), weight);
		int indexOf = edges.indexOf(e);
		if (indexOf >= 0) {
			return edges.get(indexOf);
		}
		edges.add(e);
		return e;
	}

	public List<Edge> kruskal() {
		List<Edge> a = new ArrayList<>();
		Set<VertexSet> sets = makeSets();
		sortEdges();

		for (Edge e : edges) {
			VertexSet u = findSet(sets, e.getSource());
			VertexSet v = findSet(sets, e.getDestiny());

			if (!u.equals(v)) {
				a.add(e);
				union(sets, u, v);
			}

		}

		return a;
	}

	private Set<VertexSet> makeSets() {
		Set<VertexSet> sets = new LinkedHashSet<>();
		for (Vertex v : vertices) {
			sets.add(makeSet(v));
		}

		return sets;
	}

	private VertexSet makeSet(Vertex v) {
		VertexSet vertexSet = new VertexSet(v.getName());
		vertexSet.addVertex(v);
		return vertexSet;
	}

	private VertexSet findSet(Set<VertexSet> sets, Vertex vertex) {
		for (VertexSet vset : sets) {
			if (vset.containsVertex(vertex)) {
				return vset;
			}
		}
		return null;
	}

	private void union(Set<VertexSet> sets, VertexSet u, VertexSet v) {
		sets.remove(u);
		sets.remove(v);
		u.union(v);
		sets.add(u);
	}

	private void sortEdges() {
		edges.sort((Edge e1, Edge e2) -> e1.getWeight() - e2.getWeight());
	}

	public static void main(String[] args) {
		Kruskal g = new Kruskal();
		g.addEdge("A", "B", 4);
		g.addEdge("A", "D", 3);
		g.addEdge("A", "E", 4);
		g.addEdge("B", "C", 8);
		g.addEdge("B", "E", 9);
		g.addEdge("B", "F", 5);
		g.addEdge("C", "D", 9);
		g.addEdge("C", "E", 3);
		g.addEdge("C", "F", 2);
		g.addEdge("D", "F", 7);
		g.addEdge("E", "F", 2);

		List<Edge> a = g.kruskal();
		System.out.println(a);
	}

}
