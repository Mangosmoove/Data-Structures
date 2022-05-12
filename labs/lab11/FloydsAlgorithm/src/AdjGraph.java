/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 11/6/2020
 */

import java.util.ArrayList;
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

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    private int totalComps;

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
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = totalComps = 0;
        digraph = false;
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
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

    // Problem Set 10 TODO:
    public void componentsAndSizes() {
        for (int i = 0; i < nodeList.size(); i++) {
            if (!(ifVisited(i))) {
                totalComps++;
                System.out.println("Component " + (totalComps - 1) + " contains " + (modBFS(i)) + " node(s).");
            }
        }
        displayComps();
    }

    //modified version of BFS
    public int modBFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        int size = 0;
        toVisit.add(s);
        while(toVisit.size() > 0) {
            int v = toVisit.remove(0); // first-in, first-visit
            setVisited(v);
            size++;
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for(int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if((ifVisited(v1) == false) && (toVisit.contains(v1) == false) && (adjList.elementAt(s).contains(v1))) {
                    toVisit.add(v1);
                }
            }
        }
        return size;
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

    public void displayComps() {
        System.out.println("Total components: " + totalComps);
    }

    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }

    public void floydNoWeights(){
        int n = nodeList.size();
        int[][]  noFE = new int[n][n];
        //set all counters to 0 where we know they are 0
        for (int i = 0; i < n; i++){
            noFE[i][i] = 0;
        }

        //for each of the existing edge (u, v)
        for (int u = 0; u < n; u++){
            for (int v = 0; v < n; v++){
                if (u != v){
                    if (adjList.elementAt(u).contains(v)){
                        noFE[u][v] = 1;
                    }
                    //else make it equal to some big number
                    else {
                        noFE[u][v] = 99999;
                    }
                }
            }
        }

        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (noFE[i][j] > noFE[i][k] + noFE[k][j]){
                        noFE[i][j] = noFE[i][k] + noFE[k][j];
                    }
                }
            }
        }

        //display
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(noFE[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        AdjGraph test = new AdjGraph();
        test.addVertex("A");
        test.addVertex("B");
        test.addVertex("C");
        test.addVertex("D");
        test.addVertex("E");
        test.addVertex("F");
        test.addVertex("G");
        test.addVertex("H");
        test.setEdge("A", "B", 1);
        test.setEdge("B", "E", 1);
        test.setEdge("A", "E", 1);
        test.setEdge("F", "C", 1);
        test.setEdge("B", "E", 1);
        test.setEdge("B", "C", 1);
        test.setEdge("A", "G", 1);
        test.setEdge("B", "G", 1);
        test.setEdge("H", "D", 1);
        test.setEdge("D", "G", 1);
        test.setEdge("B", "G", 1);
        test.floydNoWeights();
        System.out.println();

        AdjGraph test2 = new AdjGraph();
        test2.addVertex("1");
        test2.addVertex("2");
        test2.addVertex("3");
        test2.addVertex("4");
        test2.addVertex("5");
        test2.addVertex("6");
        test2.setEdge("1", "5", 1);
        test2.setEdge("3", "6", 1);
        test2.setEdge("2", "5", 1);
        test2.setEdge("4", "2", 1);
        test2.setEdge("4", "5", 1);
        test2.setEdge("6", "2", 1);
        test2.setEdge("4", "1", 1);
        test2.setEdge("6", "5", 1);
        test2.floydNoWeights();
        System.out.println();

        AdjGraph test3 = new AdjGraph();
        test3.addVertex("Mitja");
        test3.addVertex("Brendan");
        test3.addVertex("Peter");
        test3.addVertex("Anshul");
        test3.addVertex("Brooklyn");
        test3.addVertex("Bryan");
        test3.addVertex("Vijay");
        test3.addVertex("Harshad");
        test3.addVertex("Andrew");
        test3.setEdge("Mitja", "Brendan", 1);
        test3.setEdge("Brendan", "Anshul", 1);
        test3.setEdge("Brendan", "Brooklyn", 1);
        test3.setEdge("Anshul", "Andrew", 1);
        test3.setEdge("Andrew", "Harshad", 1);
        test3.setEdge("Andrew", "Peter", 1);
        test3.setEdge("Harshad", "Vijay", 1);
        test3.setEdge("Vijay", "Bryan", 1);
        test3.floydNoWeights();
    }

} // end of class AdjGraph