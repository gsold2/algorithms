package graph;

import java.util.*;

public class MainGraphDfsAndBfs {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList =
                Map.of(0, List.of(1, 2, 3),
                        1, List.of(0),
                        2, List.of(3),
                        3, List.of(4),
                        4, Collections.EMPTY_LIST);
        System.out.println("hasPathBFS");
        System.out.println(hasPathBFS(4, 4, adjList));
        System.out.println("hasPathDFS");
        System.out.println(hasPathDFS(1, 4, adjList));
    }

    private static boolean hasPathDFS(int sourceVertex, int destinationVertex, Map<Integer, List<Integer>> adjList) {
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(sourceVertex, destinationVertex, adjList, visited);
    }

    private static boolean hasPathDFS(int sourceVertex, int destinationVertex, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(sourceVertex)) {
            return false;
        }

        visited.add(sourceVertex);
        if (sourceVertex == destinationVertex) {
            return true;
        }

        for (int vertex : adjList.get(sourceVertex)) {
            if (hasPathDFS(vertex, destinationVertex, adjList, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasPathBFS(int sourceVertex, int destinationVertex, Map<Integer, List<Integer>> adjList) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(sourceVertex);
        int[] path = new int[adjList.size()];
        Arrays.fill(path, -1);
        while (!queue.isEmpty()) {
            int vertex = queue.remove();

            if (vertex == destinationVertex) {
                printPath(path, sourceVertex, destinationVertex);
                return true;
            }

            if (visited.contains(vertex)) {
                continue;
            }

            visited.add(vertex);
            for (int newVertex : adjList.get(vertex)) {
                if (path[newVertex] == -1) {
                    path[newVertex] = vertex;
                }
                queue.add(newVertex);
            }
        }
        return false;
    }

    private static void printPath(int[] path, int sourceVertex, int destinationVertex) {
        List<Integer> listOfVertexes = new ArrayList<>();
        listOfVertexes.add(destinationVertex);
        int index = destinationVertex;
        if (path[index] != -1) {
            while (path[index] != sourceVertex) {
                listOfVertexes.add(path[index]);
                index = path[index];
            }
            listOfVertexes.add(sourceVertex);
            Collections.reverse(listOfVertexes);
        }
        System.out.println("Path -> " + listOfVertexes);
    }
}