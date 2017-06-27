package com.github.aguilasa;

public class Edge {
	private Vertex source;
	private Vertex destiny;
	private int weight = 0;

	public Edge() {
	}

	public Edge(Vertex source, Vertex destiny, int weight) {
		this.source = source;
		this.destiny = destiny;
		this.weight = weight;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDestiny() {
		return destiny;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(source);
		builder.append(",");
		builder.append(destiny);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destiny == null) ? 0 : destiny.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + weight;
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
		Edge other = (Edge) obj;
		if (destiny == null) {
			if (other.destiny != null)
				return false;
		} else if (!destiny.equals(other.destiny))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

}
