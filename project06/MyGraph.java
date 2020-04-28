 /***************************************************************
 * Programming Project 6 - Graph Application and Implementation
 * ------------------------------------------------------------
 * Extension of the UnweightedGraph class that adds the
 * functionality of five methods: isGraphConnected,
 * getConnectedComponents, getPath, isCyclic, and findCycle.
 * Additional methods are helper methods.
 * ------------------------------------------------------------
 * Roy Chung
 * 20200426
 * CMSC 256 Section 902
 ***************************************************************/

package cmsc256.project06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyGraph<V> extends UnweightedGraph<V> {

    public MyGraph() {
        super();
    }

    public MyGraph(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public MyGraph(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public MyGraph(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    public MyGraph(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    //reads a graph from a file and determines whether the graph is connected
    public boolean isGraphConnected(String fileName) throws FileNotFoundException {
        if (fileName == null) {
            System.out.println("File name cannot be null.");
            return false;
        }

        MyGraph<V> g = readFile(fileName);

        //Invoke following method to display all edges
        g.printEdges();

        //invoke dfs() to obtain an instance tree of UnweightedGraph.SearchTree
        SearchTree tree = g.dfs(g.getIndex(g.getVertex(0)));

        if (g.vertices.size() < 2 || g.cloneEdges().size() == 0) {
            return false;
        } else return tree.getNumberOfVerticesFound() == g.vertices.size();
    }

    //finds all connected components in a graph instance
    public List<List<Integer>> getConnectedComponents() {
        //List object holds each component list as the result list
        List<List<Integer>> result = new ArrayList<>();
        List<V> temp = new ArrayList<>(vertices);

        while (temp.size() > 0) {
            //starting at a selected vertex, perform a dfs and add the resulting SearchTree to the result list
            result.add(dfs((Integer) temp.get(0)).getSearchOrder());
            //remove the visited vertices from the temporary vertex list
            temp.removeAll(dfs((Integer)temp.get(0)).getSearchOrder());
        }

        return result;
    }

    //finds path between two vertices
    public List<Integer> getPath(int origin, int destination) {
        List<Integer> path = new ArrayList<>();

        //get a bfs SearchTree rooted at the origin
        SearchTree tree = bfs(origin);
        List<Integer> searchOrder = tree.getSearchOrder();

        //if the destination is not in the SearchTree, return null
        if (!searchOrder.contains(destination)) {
            return null;
        } else { //iterate through searchOrder and copy values to path until destination is reached
            int i = 0;
            boolean destinationReached = false;
            while (!destinationReached) {
                path.add(searchOrder.get(i));
                if(searchOrder.get(i) == destination)
                    destinationReached = true;
                i++;
            }
            return path;
        }
    }

    //determines whether there is a cycle in a graph
    public boolean isCyclic() {
        //Create and populate a list of all vertices
        List<Integer> allVertices = new ArrayList<>();
        for (V vertex : vertices) {
            allVertices.add((Integer) vertex);
        }

        // Initialize parent[i] to -1
        int[] parent = new int[vertices.size()];
        Arrays.fill(parent, -1);

        // Mark visited vertices
        boolean[] isVisited = new boolean[vertices.size()];

        //recursively search each vertex until a cycle is found
        while (allVertices.size() > 0) {
            int v = allVertices.get(0);
            if (isCyclic(v, parent, allVertices, isVisited))
                return true;
        }
        return false;
    }

    //recursive isCyclic
    private boolean isCyclic(int u, int[] parent, List<Integer> allVertices, boolean[] isVisited) {
        //remove vertex u from allVertices
        allVertices.remove(Integer.valueOf(u));
        //mark current vertex as visited
        isVisited[u] = true;

        for (Edge e : neighbors.get(u)) { // iterate over neighbors edge list
            //if visited and not current vertex's parent, cycle is found and return true
            if (!isVisited[e.v]) { // if not visited,
                parent[e.v] = u; // update parent array
                return isCyclic(e.v, parent, allVertices, isVisited); // recursively call isCyclic
            } else if (parent[u] != e.v) { //if visited and not current vertex's parent
                return true;
            }
        }
        //if no cycles found
        return false;
    }

    //returns a list that contains all the vertices in a cycle starting from u if they exist. returns null if otherwise
    public List<Integer> findCycle(int u) {
        //Create and populate a list of all vertices
        List<Integer> allVertices = new ArrayList<>();
        for (V vertex : vertices) {
            allVertices.add((Integer) vertex);
        }

        //Initialize a list for the path to be returned
        List<Integer> path = new ArrayList<>();

        //Make a copy of all the edges in the adjacency matrix
        List<List<Edge>> clonedEdges = cloneEdges();

        //there cannot be a cycle with less than 3 vertices
        if (getSize() < 3) {
            return null;
        }

        // Initialize parent[i] to -1
        int[] parent = new int[vertices.size()];
        Arrays.fill(parent, -1);

        //create stack
        Stack<Integer> stack = new Stack<>();

        // Mark visited vertices
        boolean[] isVisited = new boolean[vertices.size()];

        for (Edge e : clonedEdges.get(u)) {
            //if the neighboring vertex has not been visited
            if (!isVisited[e.u]) {
                //get vertex
                int v = allVertices.get(e.u);
                //push vertex onto a stack
                stack.push(v);
                //add vertex to path
                path.add(v);
                //remove vertex from working list of vertices
                allVertices.remove(Integer.valueOf(u));
                //mark vertex visited
                isVisited[u] = true;

                while (!stack.isEmpty()){
                    //peek a vertex from the stack
                    int next = stack.peek();

                    //if the vertex has no neighbor, remove it from the stack
                    if (getNeighbors(next) == null) {
                        stack.pop();
                    } else {
                        for (int i : getNeighbors(next)) {
                            //if it has not been visited
                            if (!isVisited[i]) {
                                //set the parent of this vertex
                                parent[i] = u;
                                //add a new neighbor to the stack
                                stack.add(i);
                                //set vertex to visited
                                isVisited[i] = true;
                                //add this vertex to the path list
                                path.add(i);
                            } else { //if it has already been visited
                                //and the current starting vertex is not the parent, a cycle has been found
                                if(parent[i] != e.u)
                                    return path;
                            }
                        }
                    }
                }
            }
        }
        //no cycle found
        return null;
    }

    //helper method that clones edges
    private List<List<Edge>> cloneEdges() {

        List<List<Edge>> neighborCopy = new ArrayList<>();

        for (int i = 0; i < neighbors.size(); i++) {
            List<Edge> edges = new ArrayList<>();

            for (Edge e : neighbors.get(i)) {
                edges.add(e);
            }
            neighborCopy.add(edges);
        }
        return neighborCopy;
    }

    //helper method that reads files
    private MyGraph readFile(String fileName) throws FileNotFoundException, NumberFormatException {

        List<Edge> edges = new ArrayList<>();

        //create scanner object and pass in file, if the file doesn't exist as typed, then display error message
        Scanner in = null;
        File graphFile = new File(fileName);
        in = new Scanner(graphFile);


        //scan the first line and store it as number of vertices
        int numberOfVertices = -1;
        if (in.hasNextLine())
            numberOfVertices = Integer.parseInt(in.nextLine());
        else
            throw new IllegalArgumentException("Incompatible file.");

        //do the following for the remaining lines
        String line = null;
        while (in.hasNextLine()) {
            //create array of numbers from line
            line = in.nextLine();
            String[] tokens = line.split(" ");
            int[] vertices = new int[tokens.length];

            //convert string numbers into integers and create edges
            for (int i = 0; i < tokens.length; i++){
                vertices[i] = Integer.parseInt(tokens[i]);
                if (i > 0) {
                    edges.add(new Edge(vertices[0], vertices[i]));
                }
            }
        }
        in.close();
        return new MyGraph<V>(edges, numberOfVertices);
    }

    public static void main(String[] args) {
        MyGraph<Integer> myGraph = new MyGraph<>();

        try {
            System.out.println("null MyGraph test of is Connected => " + myGraph.isGraphConnected(null));
            System.out.println("Single vertex MyGraph test of is Connected => " + myGraph.isGraphConnected("test0.txt"));
            System.out.println("Empty MyGraph test of getConnectedComponents => " + myGraph.getConnectedComponents());
            MyGraph<Integer> myGraph0 = myGraph.readFile("test0.txt");
            System.out.println("Single vertex MyGraph test of getConnectedComponents => " + myGraph0.getConnectedComponents());
            System.out.println("Single vertex MyGraph test of findCycle => " + myGraph0.findCycle(0));

            System.out.println();

            MyGraph<Integer> myGraph1 = myGraph.readFile("test1.txt");
            List<List<Integer>> components1 = myGraph1.getConnectedComponents();
            System.out.println("Graph of text1.txt");
            System.out.println("is Connected => " + myGraph.isGraphConnected("test1.txt"));
            System.out.println("Connected components: " + components1);
            System.out.println("A path from 0 to 0 is " + myGraph1.getPath(0, 0));
            System.out.println("A path from 0 to 1 is " + myGraph1.getPath(0, 1));
            System.out.println("isCyclic() returns " + myGraph1.isCyclic());
            System.out.println("findCycle(0) returns " + myGraph1.findCycle(0));

            System.out.println();

            MyGraph<Integer> myGraph2 = myGraph.readFile("test2.txt");
            List<List<Integer>> components2 = myGraph2.getConnectedComponents();
            System.out.println("Graph of text2.txt");
            System.out.println("is Connected => " + myGraph.isGraphConnected("test2.txt"));
            System.out.println("Connected components: " + components2);
            System.out.println("A path from 0 to 4 is " + myGraph2.getPath(0, 4));
            System.out.println("isCyclic() returns " + myGraph2.isCyclic());
            System.out.println("findCycle(0) returns " + myGraph2.findCycle(0));

            System.out.println();

            MyGraph<Integer> myGraph3 = myGraph.readFile("test3.txt");
            List<List<Integer>> components3 = myGraph3.getConnectedComponents();
            System.out.println("Graph of text3.txt");
            System.out.println("is Connected => " + myGraph.isGraphConnected("test3.txt"));
            System.out.println("Connected components: " + components3);
            System.out.println("A path from 0 to 4 is " + myGraph3.getPath(0, 4));
            System.out.println("A path from 5 to 4 is " + myGraph3.getPath(5, 4));
            System.out.println("isCyclic() returns " + myGraph3.isCyclic());
            System.out.println("findCycle(0) returns " + myGraph3.findCycle(0));
        }

        catch(Exception e) {
            System.out.println("Oops, something went wrong.");
            e.printStackTrace();
        }
    }
}