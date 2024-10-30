package com.demo.trees;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private final T data;
    private boolean isVisited;
    private List<Vertex<T>> neighbours = new ArrayList<>();

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + '}';
    }
}
