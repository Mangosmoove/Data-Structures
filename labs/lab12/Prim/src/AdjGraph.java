/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 11/13/2020
 */

// C343 Fall 2020
//
// a simple implementation for graphs with adjacency lists

// Problem Set 11 starter file

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class AdjGraph implements Graph {

    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>>  adjList;

    // all the weights of the edges, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjWeight;

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    private int[] dist;

    public AdjGraph() {
        init();
    }

    public AdjGraph(boolean ifdigraph) {
        init();
        digraph = ifdigraph;
    }

    public void init() {
        nodeList = new Vector<String>();
        adjList = new Vector<LinkedList<Integer>>();
        adjWeight = new Vector<LinkedList<Integer>>();
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        dist = new int[totalNodes];
        digraph = false;
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            adjWeight.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        adjWeight.add(new LinkedList<Integer>());
        totalNodes ++;
    }

    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i ++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }

    // return the number of vertices:
    public int length() {
        return nodeList.size();
    }

    // add edge from v1 to v2:
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1,  tmp);
            totalEdges ++;
            LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
            tmp2.add(weight);
            adjWeight.set(v1,  tmp2);
        }
    }

    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2:
            setEdge(getNode(v1), getNode(v2), weight);
            // for undirected graphs, add edge from v2 to v1 as well:
            if (digraph == false) {
                setEdge(getNode(v2), getNode(v1), weight);
            }
        }
    }

    // keep track whether a vertex has been visited or not,
    //    for graph traversal purposes:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }

    public boolean ifVisited(int v) {
        return visited.get(v);
    }


    // new for Problem Set 11:
    public LinkedList<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getWeight(int v, int u) {
        LinkedList<Integer> tmp = getNeighbors(v);
        LinkedList<Integer> weight = adjWeight.get(v);
        if (tmp.contains(u)) {
            return weight.get(tmp.indexOf(u));
        } else {
            return Integer.MAX_VALUE;
        }
    }



    // clean up before traversing the graph:
    public void clearWalk() {
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i ++)
            visited.set(i, false);
    }

    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i ++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) {
                    BFS(i);      // i is the start node
                } else if (method.equals("DFS")) {
                    DFS(i); // i is the start node
                } else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }

    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) {
                DFS(v1);
            }
        }
    }

    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while (toVisit.size() > 0) {
            int v = toVisit.remove(0);   // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if ( (ifVisited(v1) == false) && (toVisit.contains(v1) == false) ) {
                    toVisit.add(v1);
                }
            }
        }
    }

    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }

    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }

    private int minDistVertex(){
        int v = 0;
        for (int i = 0; i < dist.length; i++){
            if (ifVisited(i) == false){
                v = i;
                break;
            }
        }
        for (int i = 0; i < dist.length; i++){
            if (ifVisited(i) == false && (dist[i] < dist[v])){
                v = i;
            }
        }
        return v;
    }

    private void primRelax(int u, int v){
        if (getWeight(u, v) < dist[v]){
            dist[v] = getWeight(u, v);
        }
    }

    public void primMST(){
        dist = new int[nodeList.size()];

        dist[0] = 0;
        for (int i = 1; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        int cost = 0;
        for (int i = 0; i < nodeList.size(); i++){
            int u = minDistVertex();
            setVisited(u);
            cost += dist[u];

            LinkedList<Integer> neighbors = adjList.elementAt(u);
            for (int v : neighbors){
                primRelax(u, v);
            }
        }
        System.out.println(Arrays.toString(dist));
        System.out.println(cost);
    }

    public static void main(String argv[]) {
        AdjGraph g1 = new AdjGraph(true);
        String[] nodes1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        g1.setVertices(nodes1);
        g1.setEdge("A", "B", 20);
        g1.setEdge("B", "C", 10);
        g1.setEdge("C", "D", 3);
        g1.setEdge("A", "C", 5);
        g1.setEdge("C", "E", 2);
        g1.setEdge("A", "B", 5);
        g1.setEdge("B", "H", 25);
        g1.setEdge("C", "H", 5);
        g1.setEdge("D", "I", 15);
        g1.setEdge("C", "J", 10);
        g1.primMST();
        System.out.println();
        //second example: g2
        AdjGraph g2 = new AdjGraph(true);
        String[] nodes2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        g2.setVertices(nodes2);
        g2.setEdge("a", "b", 9);
        g2.setEdge("a", "f", 5);
        g2.setEdge("a", "e", 3);
        g2.setEdge("b", "c", 5);
        g2.setEdge("b", "f", 4);
        g2.setEdge("c", "d", 2);
        g2.setEdge("c", "f", 8);
        g2.setEdge("d", "f", 7);
        g2.setEdge("d", "e", 1);
        g2.setEdge("e", "f", 5);
        g2.setEdge("j", "g", 20);
        g2.setEdge("h", "b", 5);
        g2.setEdge("i", "f", 3);
        g2.setEdge("g", "i", 10);
        g2.setEdge("a", "h", 5);
        g2.setEdge("h", "j", 12);
        g2.primMST();
        System.out.println();

        AdjGraph g3 = new AdjGraph(true);
        String[] nodes3 = {"a", "l", "k", "j", "s", "v", "d", "r", "n", "t"};
        g3.setVertices(nodes3);
        g3.setEdge("a", "j", 30);
        g3.setEdge("a", "l", 5);
        g3.setEdge("a", "k", 25);
        g3.setEdge("a", "v", 15);
        g3.setEdge("a", "d", 10);
        g3.setEdge("a", "s", 5);
        g3.setEdge("s", "n", 10);
        g3.setEdge("n", "t", 30);
        g3.setEdge("t", "k", 5);
        g3.setEdge("d", "v", 5);
        g3.setEdge("j", "r", 20);
        g3.setEdge("l", "s", 15);
        g3.setEdge("l", "d", 10);
        g3.primMST();
    }
} // end of class AdjGraph