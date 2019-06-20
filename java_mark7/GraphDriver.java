import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphDriver {

    public static void main(String args[])
    {
        Map<String,List<String>> ajList = new HashMap<>();
        Graph g = new Graph(ajList);
        g.createGraph(g);
        Set<String > answer = g.depthFirstTraversal(g,"Alice");
        for(String a : answer)
        {
            System.out.println(a);
        }
    }


}
