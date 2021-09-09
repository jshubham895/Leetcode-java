package com.leetcode;

import java.util.*;

public class Graph {

    private LinkedList<Integer> adj[];

    public Graph(int v){
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public int bfs(int source, int destination){
        boolean vis[] = new boolean[adj.length];
        int[] parent = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        parent[source] = -1;
        vis[source] = true;

        while(!q.isEmpty()){
            int current = q.poll();

            if (current == destination)
                break;

            for (int neighbor : adj[current]){
                if (!vis[neighbor]){
                    vis[neighbor] = true;
                    q.add(neighbor);
                    parent[neighbor] = current;
                }
            }
        }

        int curr = destination;
        int distance = 0;
        while(parent[curr] != -1){
            System.out.print(curr+" -> ");
            curr = parent[curr];
            distance++;
        }
        System.out.println("");

        return distance;
    }

    public boolean dfs(int source, int destination){
        boolean[] vis = new boolean[adj.length];
        vis[source] = true;
        return dfsUtil(source,destination,vis);
    }

    private boolean dfsUtil(int source, int destination, boolean vis[]){
        if (source == destination)
            return true;

        for (int neighbor: adj[source]){
            if (!vis[neighbor]){
                vis[neighbor] = true;
                boolean isConnected = dfsUtil(neighbor,destination,vis);
                if (isConnected)
                    return true;
            }
        }

        return false;
    }

    public boolean dfsStack(int source, int destination){
        boolean[] vis = new boolean[adj.length];
        vis[source] = true;

        Stack<Integer> s = new Stack<>();
        s.push(source);

        while(!s.isEmpty()){
            int curr = s.pop();

            if (curr == destination)
                return true;

//            for (int neighbor : adj[curr]){
//                if (!vis[neighbor]){
//                    vis[neighbor] = true;
//                    s.push(neighbor);
//                }
//            }

            for(int i = 0 ; i < adj[curr].size(); i++){
                if (!vis[adj[curr].get(i)]){
                    vis[adj[curr].get(i)] = true;
                    s.push(adj[curr].get(i));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vertices and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph graph = new Graph(v);
        System.out.println("Enter "+e+" edges");
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source,destination);
        }

        System.out.println("Enter source and destination");
        int s = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(graph.dfsStack(s,d));
    }
}
