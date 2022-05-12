/**
 * Arinah Karim, ankarim
 * CSCI-C 343 / Fall 2020
 * 11/4/2020
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

    // Problem Set 10 TODO:

    // --- write a main() method here ---

    // Provide 3 different graph examples,
    //   with at least 10 nodes for each different graph,
    //   following these steps 1) ... 4) for each graph:

    // 1) instantiate a new graph,
    // 2) assign2 vertices and edges to the graph,
    // 3) then display2 the graph's content (use display() )
    // 4) finally call your componentsAndSizes() method to provide
    //    output results as from Problem Set 10 instructions

    public static void main(String[] args){
        //TESTING ADJGRAPH
        AdjGraph test = new AdjGraph();
        test.addVertex("A");
        test.addVertex("B");
        test.addVertex("C");
        test.setEdge("A","B",5);
        test.setEdge("A","C",5);
        test.addVertex("D");
        test.addVertex("E");
        test.setEdge("C","D",5);
        test.setEdge("B","E",5);
        test.setEdge("D","E",5);
        test.addVertex("F");
        test.addVertex("G");
        test.addVertex("H");
        test.setEdge("C","G",5);
        test.setEdge("B","F",5);
        test.addVertex("I");
        test.addVertex("J");
        test.display();
        test.componentsAndSizes();
        System.out.println();

        AdjGraph test2 = new AdjGraph();
        test2.addVertex("A");
        test2.addVertex("B");
        test2.addVertex("C");
        test2.setEdge("A","B",5);
        test2.setEdge("B","C",5);
        test2.setEdge("A","C",5);
        test2.addVertex("D");
        test2.addVertex("E");
        test2.setEdge("B","D",5);
        test2.setEdge("C","E",5);
        test2.setEdge("A","D",5);
        test2.setEdge("D","E",5);
        test2.addVertex("F");
        test2.addVertex("G");
        test2.addVertex("H");
        test2.setEdge("F","G",5);
        test2.setEdge("C","F",5);
        test2.setEdge("A","H",5);
        test2.setEdge("G","H",5);
        test2.setEdge("B","G",5);
        test2.addVertex("I");
        test2.addVertex("J");
        test2.setEdge("I","J",5);
        test2.display();
        test2.componentsAndSizes();
        System.out.println();

        AdjGraph test3 = new AdjGraph();
        test3.addVertex("A");
        test3.addVertex("B");
        test3.addVertex("C");
        test3.addVertex("D");
        test3.setEdge("A","B",5);
        test3.setEdge("B","C",5);
        test3.setEdge("C","D",5);
        test3.setEdge("D","A",5);
        test3.setEdge("B","D",5);
        test3.addVertex("E");
        test3.setEdge("C","E",5);
        test3.addVertex("F");
        test3.addVertex("G");
        test3.addVertex("H");
        test3.addVertex("I");
        test3.setEdge("C","F",5);
        test3.setEdge("A","I",5);
        test3.setEdge("B","F",5);
        test3.setEdge("I","E",5);
        test3.setEdge("B","I",5);
        test3.addVertex("J");
        test3.setEdge("E","F",5);
        test3.setEdge("F","G",5);
        test3.setEdge("C","H",5);
        test3.setEdge("A","E",5);
        test3.setEdge("F","H",5);
        test3.display();
        test3.componentsAndSizes();
    }

} // end of class AdjGraph