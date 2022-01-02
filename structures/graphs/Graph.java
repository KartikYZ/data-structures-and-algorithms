package structures.graphs;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

// TODO:: refactor into AdjacencyList Implementation. Present AdjacencyMap Implementation in separate class.
public class Graph<T> {
    
    private Set<Vertex<T>> vertices;
    private Set<Edge<T>> edges;
    private Map<Vertex<T>, List<Edge<T>>> adjList;
    private int numVertices;
    private int numEdges;

    public Graph() {

    }

    public Graph(Set<Vertex<T>> vertices, Set<Edge<T>> edges) {
        this.vertices = new HashSet<>(vertices);
        this.edges = new HashSet<>(edges);
        this.adjList = new HashMap<>();
        for (Vertex<T> v : vertices) {
            adjList.put(v, new ArrayList<>());
        }

        // for (Edge<T> e : edges) {
        //     if (adjList.containsKey(e.getU())) {
        //         adjList.get(e.getU()).add(
        //             new VertexDistance<>(e.getV(), e.getWeight()));
        //     } else {
        //         throw new IllegalArgumentException("Vertex set must contain all"
        //             + "vertices of the graph.");
        //     }
        // }

    }

    public int numVertices() {
        return this.numVertices;
    }

    public List<Vertex<T>> vertices() {
        return null;
    }

    public int numEdges() {
        return this.numEdges;
    }

    public List<Edge<T>> edges() {
        return null;
    }

    public Edge<T> getEdge(Vertex<T> start, Vertex<T> end) {
        return null;
    }

    public Vertex<T>[] endVertices(Edge<T> e) {
        return null;
    }

    public Vertex<T> opposite(Vertex<T> v, Edge<T> e) {
        return null;
    }

    public int outDegree(Vertex<T> v) {
        return 0;
    }

    public int inDegree(Vertex<T> v) {
        return 0;
    }

    public List<Edge<T>> outgoingEdges(Vertex<T> v) {
        return null;
    }

    public List<Edge<T>> incomingEdges(Vertex<T> v) {
        return null;
    }

    public Vertex<T> insertVertex(T data) {
        return null;
    }
}
