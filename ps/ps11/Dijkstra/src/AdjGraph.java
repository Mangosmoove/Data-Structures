/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 11/12/2020
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

    //array of distances
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

    // Problem Set 11 TODO:
    //
    // write your methods here.
    //

    public void relax(int u, int v, int w){
        if(dist[v] > (dist[u] + w)){
            dist[v] = dist[u] + w;
        }
    }

    private int minDistVertex(){
        int v = 0;

        for (int i = 0; i < totalNodes; i++){
            if (ifVisited(i) == false){
                v = i;
                break;
            }
        }

        for (int i = 0; i < totalNodes; i++){
            if ((ifVisited(i) == false) && (dist[i] < dist[v])){
                v = i;
            }
        }
        return v;
    }

    public void dijkstra1(String srcVertex){
        dist = new int[totalNodes];
        int src = getNode(srcVertex);

        for (int i = 0; i < totalNodes; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 0; i < totalNodes; i++){
            int v = minDistVertex();
            setVisited(v);

            if (dist[v] == Integer.MAX_VALUE){ //unreachable vertex
                return;
            }

            for (int neighbors : adjList.elementAt(v)){
                relax(v, neighbors, getWeight(v, neighbors));
            }

            for (int j = 0; j < totalNodes; j++){
                System.out.print(dist[j] + " ");
            }
            System.out.println("");
        }
    }

 /*   public void dijkstra2(String srcVertex){
        int v;
        int src = getNode(srcVertex);

        DijkElem[] E = new DijkElem[nodeList.size()];
        E[0] = new DijkElem(src, 0);
        MinHeap<DijkElem> H = new MinHeap<DijkElem>(E, 1, nodeList.size());
        int[] D = new int[totalNodes];

        for (int i = 0; i < nodeList.size(); i++){
            D[i] = Integer.MAX_VALUE;
        }
        D[src] = 0;

        for (int i = 0; i < nodeList.size(); i++){
            do { v = (H.removeMin()).vertex(); }
                    while(ifVisited(v) == true);
            setVisited(v);
            if (D[v] == Integer.MAX_VALUE) return;
            for (int w : adjList.elementAt(v)){
                if (D[w] > D[v] + getWeight(v, w)){
                    D[w] = D[v] + getWeight(v, w);
                    H.insert(new DijkElem((w, D[w])));
                }
            }
        }

    }

    class DijkElem implements Comparable<DijkElem>{
        private int vertex;
        private int weight;

        public DijkElem(int inv, int inw){
            vertex = inv;
            weight = inw;
        }

        public DijkElem(){
            vertex = 0;
            weight = 0;
        }

        public int key(){
            return weight;
        }

        public int vertex(){
            return vertex;
        }

        public int compareTo(DijkElem that){
            if (weight < that.key()){
                return -1;
            }
            else if (weight == that.key()){
                return 0;
            }
            else{
                return 1;
            }
        }
    }*/

    public void topologicalSortWithQueue(){
        LinkedList<Integer> L = new LinkedList<Integer>();
        int[] C = new int[nodeList.size()];
        for (int u = 0; u < nodeList.size(); u++){
            for (int v = 0; v < nodeList.size(); v++){
                if (adjList.elementAt(u).contains(v)){
                    C[v]++;
                }
            }
        }

        Queue<Integer> Q = new LinkedList<Integer>();
        for (int i = 0; i < C.length; i++){
            if (C[i] == 0){
                Q.add(i);
            }
        }

        while(Q.isEmpty() == false){
            int u = Q.remove();
            L.addLast(u);
            for (int i = 0; i < adjList.elementAt(u).size(); i++){
                int v = adjList.elementAt(u).get(i);
                C[v]--;

                if (C[v] == 0){
                    Q.add(v);
                }
            }
        }

        if (L.size() == nodeList.size()){
            System.out.println(L.toString());
        }
        else{
            System.out.println("Solution not found.");
        }
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

    // Problem Set 11 TODO:

    // write your new main() method here:

    // for Problem Set 11 Task B:
    //   provide 3 different examples, using the two different versions of Dijkstra's algorithm
    //   with at least 10 nodes for each different graph

    // for Problem Set 11 Task C:
    //   provide 3 different examples, using the two different versions of Dijkstra's algorithm
    //   with at least 10 nodes for each different graph
    public static void main(String[] arg){
        AdjGraph test = new AdjGraph(true);
        String[] nodes = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        test.setVertices(nodes);
        test.setEdge("A", "B", 10);
        test.setEdge("A", "D", 20);
        test.setEdge("C", "D", 3);
        test.setEdge("C", "F", 30);
        test.setEdge("E", "H", 15);
        test.setEdge("G", "H", 5);
        test.setEdge("D", "E", 5);
        test.setEdge("B", "G", 30);
        test.setEdge("E", "I", 15);
        test.setEdge("F", "J", 45);
        test.dijkstra1("A");
        test.topologicalSortWithQueue();
        System.out.println();

        AdjGraph test2 = new AdjGraph(true);
        String[] nodes2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        test2.setVertices(nodes2);
        test2.setEdge("A", "B", 10);
        test2.setEdge("A", "D", 20);
        test2.setEdge("A", "C", 5);
        test2.setEdge("A", "J", 60);
        test2.setEdge("A", "G", 40);
        test2.setEdge("A", "H", 60);
        test2.setEdge("A", "J", 35);
        test2.setEdge("A", "I", 25);
        test2.setEdge("A", "F", 20);
        test2.setEdge("A", "E", 15);
        test2.dijkstra1("A");
        test.topologicalSortWithQueue();
        System.out.println();

        AdjGraph test3 = new AdjGraph(true);
        String[] nodes3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        test3.setVertices(nodes3);
        test3.setEdge("A", "C", 10);
        test3.setEdge("C", "G", 15);
        test3.setEdge("C", "H", 11);
        test3.setEdge("H", "J", 20);
        test3.setEdge("B", "E", 10);
        test3.setEdge("B", "D", 20);
        test3.setEdge("D", "I", 13);
        test3.setEdge("G", "E", 12);
        test3.dijkstra1("B");
        test3.topologicalSortWithQueue();
    }
} // end of class AdjGraph