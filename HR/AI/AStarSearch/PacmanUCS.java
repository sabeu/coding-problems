package HR.AI.AStarSearch;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PacmanUCS {
    static class Node {
        int r, c, cost;
        Node parent;
        Node (int r, int c, int cost, Node parent) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.parent = parent;
        }
    }
    
    static void nextMove(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, String [] grid){
         // check for edge cases
        if (r < 3 && c < 3) return;
        
        // queues for UCS
        Queue<Node> q = new PriorityQueue<Node>(1, custComprtr);
        Queue<Node> tmpQ = new PriorityQueue<Node>(1, custComprtr);
        
        // array for tracking visited nodes
        boolean[][] visited = new boolean[r][c];
        
        // enqueue the starting node - 'P'
        q.add(new Node(pacman_r, pacman_c, 0, null));
        visited[pacman_r][pacman_c] = true;
        
        // UCS traversal
        // to pass all the tests the following 2 crucial conditions must satisfy:
        while (!q.isEmpty()) {
            Node node = q.poll();

            // if the goal is reached print out and abort
            if (grid[node.r].charAt(node.c) == '.') {                
                printOutResults(node);
                break;
            }
            tmpQ = getNextLocations(node, grid, visited);
            
            // 1 - push the nodes in the specific order as
            // specified in 'getNextLocations() method
            q.addAll(tmpQ);

            // 2 - mark nodes as visited after nodes were
            // enqueued into the queue, and not when dequeued.
            while (!tmpQ.isEmpty()) {
                Node n = tmpQ.poll();
                visited[n.r][n.c] = true;
            }
        }
    }
    // helper method for debugging
    public static void printQueue(Queue<Node> queue) {
        Queue<Node> q = new LinkedList<Node>();
        q.addAll(queue);
        if (!q.isEmpty()) {
            Node node = null;
            while (!q.isEmpty()) {
                node = q.remove();
                System.out.print(node.r + " " + node.c + " " + node.cost + ", ");
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty");
        }
    }
    
    // helper method for printing the results
    public static void printOutResults(Node goalNode) {
        Stack<Node> path = new Stack<Node>();
        while (goalNode != null) {
            path.push(goalNode);
            goalNode = goalNode.parent;
        }
        
        // print out the length of path and the path itself
        System.out.println(path.size()-1);
        Node n = null;
        while (!path.isEmpty()) {
            n = path.pop();
            System.out.println(n.r + " " + n.c);
        }
    }
    
    // Helper method for choosing next moves and enqueuing them into priority queue
    public static Queue<Node> getNextLocations(Node node, String[] grid, boolean[][] visited) {
        Queue<Node> q = new PriorityQueue<Node>(1, custComprtr);
        int x = node.r;
        int y = node.c;
        int cost = node.cost;
        
        // add next locations, order doesn't matter in UCS because
        // nodes are retrieved based on their cost priorities. Since
        // each step's cost is 1, the algorithm follows BFS strategy
        if ((grid[x-1].charAt(y) != '%') && (!visited[x-1][y])) {
            Node nodeUp = new Node(x-1, y, cost+1, node);
            q.add(nodeUp);
        }
        if ((grid[x].charAt(y-1) != '%') && (!visited[x][y-1])) {
            Node nodeLeft = new Node(x, y-1, cost+1, node);
            q.add(nodeLeft);
        }
        if ((grid[x].charAt(y+1) != '%') && (!visited[x][y+1])) {
            Node nodeRight = new Node(x, y+1, cost+1, node);
            q.add(nodeRight);
        }
        if ((grid[x+1].charAt(y) != '%') && (!visited[x+1][y])) {
            Node nodeDown = new Node(x+1, y, cost+1, node);
            q.add(nodeDown);
        }

        return q;
    }
    
    // custom comparator for retrieving nodes in smallest cost first order
    public static Comparator<Node> custComprtr = new Comparator<Node>(){

        @Override
        public int compare(Node a, Node b) {
            return (int) (a.cost - b.cost);
        }

    };

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int pacman_r = in.nextInt();
        int pacman_c = in.nextInt();

        int food_r = in.nextInt();
        int food_c = in.nextInt();

       int r = in.nextInt();
        int c = in.nextInt();
    
        String grid[] = new String[r];

        for(int i = 0; i < r; i++) {
            grid[i] = in.next();
        }

        nextMove( r, c, pacman_r, pacman_c, food_r, food_c, grid);
    }
}
