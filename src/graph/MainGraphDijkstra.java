package graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MainGraphDijkstra {
    public static void main(String[] args) {

        Map<Integer, List<Vertex>> graph = Map.of(
                0, List.of(new Vertex(1, 5), new Vertex(5, 0)),
                1, List.of(new Vertex(2, 15), new Vertex(4, 20)),
                2, List.of(new Vertex(3, 20)),
                3, Collections.EMPTY_LIST,
                4, List.of(new Vertex(3, 10)),
                5, List.of(new Vertex(2, 30), new Vertex(4, 35))
        );
        dijkstra(graph, 3);
    }

    private static void dijkstra(Map<Integer, List<Vertex>> graph, int destinationVertex) {
        int[] prev = new int[graph.size()];
        Arrays.fill(prev, -1);

        boolean[] seen = new boolean[graph.size()];
        Arrays.fill(seen, false);

        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        while (hasUnvisited(seen)) {
            int currentVertex = getLowestUnvisited(seen, distances);
            seen[currentVertex] = true;

            for (Vertex neighboringVertex : graph.get(currentVertex)) {
                Integer neighboringVertexIndex = neighboringVertex.getIndex();
                if (seen[neighboringVertexIndex]) {
                    continue;
                }

                int dist = distances[currentVertex] + neighboringVertex.getDist();
                if (dist < distances[neighboringVertexIndex]) {
                    distances[neighboringVertexIndex] = dist;
                    prev[neighboringVertexIndex] = currentVertex;
                }
            }
        }

        MainGraphDfsAndBfs.printPath(prev, 0, destinationVertex);
        System.out.println("Distance from " + 0 + " to " + destinationVertex + " -> " + distances[destinationVertex]);
    }

    private static boolean hasUnvisited(boolean[] seen) {
        for (boolean b : seen) {
            if (!b) {
                return true;
            }
        }
        return false;
    }

    private static int getLowestUnvisited(boolean[] seen, int[] dists) {
        int index = -1;
        int lowestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < seen.length; i++) {
            if (seen[i]) {
                continue;
            }
            if (dists[i] < lowestDistance) {
                lowestDistance = dists[i];
                index = i;
            }
        }
        return index;
    }

    private static class Vertex {

        Integer index;
        Integer dist;

        public Vertex(Integer index, Integer dist) {
            this.index = index;
            this.dist = dist;
        }

        public Integer getIndex() {
            return index;
        }

        public Integer getDist() {
            return dist;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "index=" + index +
                    ", dist=" + dist +
                    '}';
        }
    }
}
