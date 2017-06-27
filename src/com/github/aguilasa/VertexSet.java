package com.github.aguilasa;

import java.util.LinkedHashSet;
import java.util.Set;

public class VertexSet {
	private String identifier = "";
	private Set<Vertex> vertices = new LinkedHashSet<>();

	public VertexSet(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}

	public Set<Vertex> getVertices() {
		return vertices;
	}

	public boolean containsVertex(Vertex vertex) {
		return vertices.contains(vertex);
	}

	public void union(VertexSet other) {
		identifier = identifier.concat(other.getIdentifier());
		vertices.addAll(other.getVertices());
	}

	@Override
	public String toString() {
		String comma = "";
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (Vertex v : vertices) {
			sb.append(comma);
			sb.append(v.getName());
			comma = ", ";
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VertexSet other = (VertexSet) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

}
