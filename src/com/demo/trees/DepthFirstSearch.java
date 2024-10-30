package com.demo.trees;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

/**
 * @author Dhruval Vaishnav Created on 25-10-2024
 */
// Implementation of Depth First Search
public class DepthFirstSearch<T> {
    // what is DepthFirstSearch ?:
    // Depth First Search (DFS) algorithm traverses a graph in a depth ward motion and
    // uses a stack to remember to get the next vertex to start a search when a dead end occurs in any iteration.
    // it traverses an every vertex once and only once
    // last in first out

    public void traverseIterative(Vertex<T> startingVertex) {
        // add it into the stack
        Deque<Vertex<T>> stack = new LinkedList<Vertex<T>>();
        stack.push(startingVertex);
        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                Collections.reverse(current.getNeighbours());
                current.getNeighbours().forEach(stack::push);
            }
        }
    }

    public void traverseRecursive(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        // u can use java 8 stream as well
        vertex.getNeighbours().forEach(neighbour -> {
            if (!neighbour.isVisited()) {
                traverseRecursive(neighbour);
            }
        });
    }

}

// Validation
class Test {
    public static void main(String[] args) {
        // create a tree randomly and perform DFS on it using java code
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbours(Arrays.asList(v1, v5, v6));
        v1.setNeighbours(Arrays.asList(v3, v4, v5));
        v4.setNeighbours(Arrays.asList(v2, v6));
        v6.setNeighbours(Arrays.asList(v0));

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.traverseIterative(v0);
        //depthFirstSearch.traverseRecursive(v0);

    }
}