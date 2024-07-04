package Controllers;

import Models.NodeGraph;
import Models.User;
import Models.RecommendationEngine;
import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<NodeGraph<T>> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public Graph(List<NodeGraph<T>> nodes) {
        this.nodes = nodes;
    }

    public void addUser(NodeGraph<T> node) {
        nodes.add(node);
    }

    public void addConnection(NodeGraph<T> node1, NodeGraph<T> node2) {
        node1.addFriend(node2.getUser());
        node2.addFriend(node1.getUser());
    }

    public List<NodeGraph<T>> getFriends(NodeGraph<T> node) {
        return node.getFriends();
    }

    public List<NodeGraph<T>> recommendFriends(NodeGraph<T> node) {
       RecommendationEngine engine = new RecommendationEngine ();
        return engine.recommendFriends(node);
    }

    public List<NodeGraph<T>> getNodes() {
        return nodes;
    }

    public void printGraph() {
        for (NodeGraph<T> node : nodes) {
            System.out.print("User " + node.getUser().getName() + " friends: ");
            for (NodeGraph<T> friend : node.getFriends()) {
                System.out.print(" -> " + friend.getUser().getName());
            }
            System.out.println();
        }
    }
}