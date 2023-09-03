import java.util.*;
class hamiltonian
{
final int V = 6;
int path[];
boolean isSafe(int v, int graph[][], int path[], int pos)
{//check if an edge from this vertex to previous vertex
if (graph[path[pos - 1]][v] == 0)
return false;
for (int i = 0; i < pos; i++)
if (path[i] == v)
 return false;
return true;
}
boolean check(int graph[][], int path[], int pos)
{
if (pos == V)
{ //verify edge from last vertex back to first vertex
if (graph[path[pos - 1]][path[0]] == 1)
return true;
else
return false;
}
for (int v = 1; v < V; v++)
{
/* Check if this vertex can be added to Hamiltonian Cycle */
if (isSafe(v, graph, path, pos))
{
path[pos] = v;
if (check(graph, path, pos + 1) == true)
return true;
path[pos] = -1;
}
}
return false;
}
int findcycle(int graph[][])
{
path = new int[V];
for (int i = 0; i < V; i++)
 path[i] = -1;
path[0] = 0;
if (check(graph, path, 1) == false)
{
System.out.println("\nSolution does not exist");
return 0;
}
printSolution(path);
return 1;
}
void printSolution(int path[])
{
System.out.println("Solution Exists: Following" + " is one Hamiltonian Cycle");
for (int i = 0; i < V; i++)
 System.out.print(" " + path[i] + " ");
 
System.out.println(" " + path[0] + " ");
}
public static void main(String args[])
{
hamiltonian h =new hamiltonian();
int graph1[][] = {{0,1,1,1,0,0},
{1,0,1,0,0,1},
{1,1,0,1,1,0},
{1,0,1,0,1,0},
{0,0,1,1,0,1},{0,1,0,0,1,0}
};
h.findcycle(graph1);
}
}