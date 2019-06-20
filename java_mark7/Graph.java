import java.util.*;

public class Graph {

    private Map<String, List<String>> adjVertices;

    public Graph(Map<String, List<String>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public List<String> getAdjVertices( String label) {
        return adjVertices.get(label);
    }

    public void setAdjVertices(Map<String, List<String>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    void addVertex(String label) {
        if(!adjVertices.containsKey(label))
        {
            adjVertices.put(label,new ArrayList<String>());
        }
        else
        {
            List<String> temp = adjVertices.get(label);
            adjVertices.put(label, temp);
        }
    }

    void removeVertex(String label) {
        adjVertices.values().stream().forEach(e -> e.remove(label));
        adjVertices.remove(label);
    }

    void addEdge(String label1, String label2) {
        adjVertices.get(label1).add(label2);
        adjVertices.get(label2).add(label1);
    }

    void removeEdge(String label1, String label2) {
        List<String> lab1 = adjVertices.get(label1);
        List<String> lab2 = adjVertices.get(label2);
        if(lab1!=null)
        {
          lab1.remove(label1);
        }
        if(lab2!=null)
        {
           lab2.remove(label2);
        }
    }

    Graph createGraph(Graph graph) {
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (String v : graph.getAdjVertices(vertex)) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }
}
