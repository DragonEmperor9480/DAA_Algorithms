import java.util.*;
import java.io.*;

class dijkstara {
static int V;
static int minDistance(int dist[], Boolean path[])
{
int min = 99, min_index=-1;
for (int v = 0; v < V; v++)
if (path[v] == false && dist[v] <= min)
{
min = dist[v];
min_index = v;
}
return min_index;
}
static void dijkstra(int graph[][], int src)
{
int dist[] = new int[V];
Boolean path[] = new Boolean[V]; 
for (int i = 0; i < V; i++)
{
dist[i] = 99;
path[i] = false; 
}
dist[src] = 0;
for (int count = 0; count < V - 1; count++)
{
int u = minDistance(dist, path); 

path[u] = true; 
for (int v = 0; v < V; v++) 
if ((!path[v]) && (graph[u][v] != 0) && (dist[u] != 99)&& (dist[u] + graph[u][v] < dist[v]))
dist[v] = dist[u] + graph[u][v];
}
System.out.println("Source Vertex:"+src);
System.out.println("Destination Vertex Distance");
for (int i = 0; i < V; i++)
System.out.println(i + "\t\t\t" + dist[i]);
}
public static void main(String[] args)
{
int cost[][]=new int[10][10];
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of nodes: ");
V=in.nextInt();
System.out.println("Enter the cost matrix");
for(int i=0;i<V;i++)
for(int j=0;j<V;j++)
cost[i][j] = in.nextInt();
dijkstra(cost, 0); 
}}