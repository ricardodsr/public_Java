import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Usado o grafo em graph_example
public class Grafo {
    private Map<Integer, Set<Integer>> adj;

    // Construtores
    public Grafo() {
        this.adj = new HashMap<>();
    }

    public Grafo(Map<Integer, Set<Integer>> adj) {
        this.adj = new HashMap<>();
        for (Integer nodo : adj.keySet()) {
            Set<Integer> adjacentes = new HashSet<>(adj.get(nodo));
            this.adj.put(nodo, adjacentes);
        }
    }

    // Instance methods
    void addArco(Integer vOrig, Integer vDest) {
        if (!this.adj.containsKey(vOrig)) {
            this.adj.put(vOrig, new HashSet<>());
        }
        this.adj.get(vOrig).add(vDest);
    }

    boolean isSink(Integer v) {
        return this.adj.get(v).size() == 0;
    }

    boolean isSource(Integer v) {
        return this.adj.keySet()
                        .stream()
                        .map(a -> this.adj.get(a))
                        .noneMatch(set -> set.contains(v));
    }

    int size() {
        int ret = 0;
        for (Integer nodo : this.adj.keySet()) {
            ret += 1;
            for (Integer nodo_adj : this.adj.get(nodo))
                ret += 1;
        }
        return ret;
    }

    int nrVertices() {
        return this.adj.keySet().size();
    }

    boolean haCaminho(Integer vOrig, Integer vDest) {
        if (!(this.adj.containsKey(vOrig) && this.adj.containsKey(vDest))) return false;

        Map<Integer, Boolean> visited = new HashMap<>();
        for (Integer nodo : this.adj.keySet())
            visited.put(nodo, false);

        visited.put(vOrig, true);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vOrig);

        while (queue.size() != 0) {
            vOrig = queue.poll();

            Iterator<Integer> adjacentes_it = this.adj.get(vOrig).iterator();
            while (adjacentes_it.hasNext()) {
                int n = adjacentes_it.next();
                if (n == vDest)
                    return true;

                if (!visited.get(n)) {
                    visited.put(n, true);
                    queue.add(n);
                }
            }
        }
        return false;
    }

    // Not implemented yet
    List<String> getCaminho(Integer vOrig, Integer vDest) {
        if (!haCaminho(vOrig, vDest)) return null;

        List<String> caminho = new LinkedList<>();
        return caminho;
    }

    Set<Map.Entry<Integer, Integer>> fanOut(Integer v) {
        Set<Map.Entry<Integer, Integer>> ret = new HashSet<>();
        for (Integer dest : this.adj.get(v)) {
            ret.add(new AbstractMap.SimpleEntry(v, dest));
        }
        return ret;
    }

    // Overrided methods
    @Override
    public String toString() {
        String ret = "";
        for (Integer nodo : this.adj.keySet()) {
            ret += "Nodo: " + nodo + "\n";
            ret += "Nodos adjacentes: " + this.adj.get(nodo) + "\n";
        }
        return ret;
    }

    // Testing only
    public static void main(String[] args) {
        Set<Integer> adj_1 = Stream.of(3, 5).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> adj_2 = Stream.of(1, 4).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> adj_3 = Stream.of(4).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> adj_4 = Stream.of(5).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> adj_5 = new HashSet<>();

        Map<Integer, Set<Integer>> adj_original = new HashMap<>();
        adj_original.put(1, adj_1);
        adj_original.put(2, adj_2);
        adj_original.put(3, adj_3);
        adj_original.put(4, adj_4);
        adj_original.put(5, adj_5);

        Grafo g = new Grafo(adj_original);

        // Para testar o encapsulamento + toString
        adj_1.add(999);
        System.out.println(g);

        // Teste addArco
        g.addArco(6, 99);
        g.addArco(6, 98);
        g.addArco(4, 1);
        System.out.println(g);

        // Teste isSink
        System.out.println("Testes isSink: ");
        System.out.println("(Expected: false) Nodo 1: " + g.isSink(1));
        System.out.println("(Expected: false) Nodo 2: " + g.isSink(2));
        System.out.println("(Expected: false) Nodo 3: " + g.isSink(3));
        System.out.println("(Expected: false) Nodo 4: " + g.isSink(4));
        System.out.println("(Expected: true)  Nodo 5: " + g.isSink(5));
        System.out.println("(Expected: false) Nodo 6: " + g.isSink(6));

        // Teste isSource
        System.out.println("\nTestes isSource:");
        System.out.println("(Expected: false) Nodo 1: " + g.isSource(1));
        System.out.println("(Expected: true)  Nodo 2: " + g.isSource(2));
        System.out.println("(Expected: false) Nodo 3: " + g.isSource(3));
        System.out.println("(Expected: false) Nodo 4: " + g.isSource(4));
        System.out.println("(Expected: false) Nodo 5: " + g.isSource(5));
        System.out.println("(Expected: true)  Nodo 6: " + g.isSource(6));

        // Teste size
        System.out.println("\nTeste size");
        System.out.println("(Expected: 15): " + g.size());

        // Teste haCaminho
        System.out.println("\nTeste haCaminho");
        System.out.println("(Expected: false) Teste 1: " + g.haCaminho(1, 7));
        System.out.println("(Expected: true)  Teste 2: " + g.haCaminho(1, 3));
        System.out.println("(Expected: false) Teste 3: " + g.haCaminho(1, 2));
        System.out.println("(Expected: false) Teste 4: " + g.haCaminho(5, 4));
        System.out.println("(Expected: true)  Teste 5: " + g.haCaminho(4, 5));

        // Teste fanOut
        System.out.println("\nTeste fanOut");
        System.out.println(g.fanOut(1));
        System.out.println(g.fanOut(2));
        System.out.println(g.fanOut(3));
        System.out.println(g.fanOut(4));
        System.out.println(g.fanOut(5));
    }
}
