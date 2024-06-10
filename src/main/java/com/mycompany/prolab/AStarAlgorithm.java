
package com.mycompany.prolab;

import java.util.*;

public class AStarAlgorithm {
    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] grid;
    static int rows, cols;
    static List<Node> treasures;
    static ArrayList<Node> yol;
    static Node karakter;
    
    public AStarAlgorithm(int grid[][],List<Node> treasures, int kareboyut,Node karakter){
        this.rows = kareboyut;
       this.cols = kareboyut;
        this.grid=grid;
        this.treasures=treasures;
        this.karakter=karakter;
        
        
        ArrayList<Node> path = findPath(karakter, treasures.get(0));
        this.yol=path;
 
    }
    
    public ArrayList dondur(){
        return yol;
    }

   static ArrayList<Node> findPath(Node start, Node end) {
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::f));
        Set<Node> closed = new HashSet<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Integer> gScore = new HashMap<>();

        open.add(start);
        gScore.put(start, 0);
        start.h = manhattanDistance(start, end);

        while (!open.isEmpty()) {
            Node current = open.poll();

            if (current.x == end.x && current.y == end.y) {
                ArrayList<Node> path = reconstructPath(current, cameFrom);
                return path;
            }

            closed.add(current);

            for (int[] dir : DIRS) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (isValid(newX, newY)) {
                    Node neighbor = new Node(newX, newY);
                    int tentativeGScore = gScore.getOrDefault(current, Integer.MAX_VALUE) + 1;

                    if (tentativeGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        cameFrom.put(neighbor, current);
                        gScore.put(neighbor, tentativeGScore);
                        neighbor.h = manhattanDistance(neighbor, end);
                        if (!closed.contains(neighbor)) {
                            open.add(neighbor);
                        }
                    }
                }
            }
            
                     if (closed.size() == rows * cols) {
                          System.out.println("Sonsuz döngüye girildi.");
                      break;
                     }
            }
                
        return null;
    }

    static ArrayList<Node> reconstructPath(Node current, Map<Node, Node> cameFrom) {
        ArrayList<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    static int manhattanDistance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 0;
    }
}
