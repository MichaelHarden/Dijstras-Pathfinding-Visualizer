public class Dijkstra {

    private int[][] graph = new int[22*22][4];
    
    private int[][] board = new int[22][22];

    private int[] orderVisited = new int[0];


    
    public Dijkstra(int[][] boardIn) {
        board = boardIn;
        createGraph(boardIn);
    }

    public int[][] getGraph() {
        return graph;
    }

    private void addToOrderVisited(int node){
        
        int[] newList = new int[orderVisited.length + 1];

        for (int i = 0; i < newList.length; i++) {
            if (i != orderVisited.length){
                newList[i] = orderVisited[i];
                continue;
            }
            newList[i] = node;
            orderVisited = newList;
        }
    }

    public int[] getOrderVisited() {
        return orderVisited;
    }

    private void createGraph(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int nodePosition = j + (i * board.length);
                
                int up = (i == 0) ? -1 : nodePosition - 22;
                int right = (j == 21) ? -1 : nodePosition + 1;
                int down = (i == 21) ? -1 : nodePosition + 22;
                int left = (j == 0) ? -1 : nodePosition - 1;


                int[] connectionsFromNode = {up, right, down, left};

                for(int c = 0; c < 4; c++) {

                    if (connectionsFromNode[c] == -1) {
                        continue;
                    }

                    //checking for placed walls
                    int columb = connectionsFromNode[c] / 22;
                    int row = connectionsFromNode[c] % 22;
                    if (board[columb][row] == -1) {
                        connectionsFromNode[c] = -1;
                    }
                }
                graph[nodePosition] = connectionsFromNode;
            }
        }
    }

    public void dijkstras(int[][] graph, int start, int destination) {
        int count = graph.length; // 22* 22 = 484
        boolean[] isVisited = new boolean[count];
        int[] distances = new int[count]; 

        for (int i = 0; i < count; i++) {
            if (i == start) {
                distances[start] = 0;
                continue;
            }
            distances[i] = Integer.MAX_VALUE;
            isVisited[i] = false;
        }

        for(int i = 0; i < count; i++) {
            
            int u = findMinDistance(distances, isVisited);
            
            // if a wall is placed in the grid, the node which containes the wall will not be visited. 
            // we will return negitive values for those nodes.
            if (u == -1) {
                continue;
            }
            isVisited[u] = true;

            addToOrderVisited(u);
            for (int v = 0; v < 4; v++) {
                
                //checks neighbor for wall
                if (graph[u][v] == -1) {
                    continue;
                }

                if (!isVisited[graph[u][v]] && graph[u][v] != -1) {
                    distances[graph[u][v]] = distances[u] + 1;
                }
            }
            
        }
        for (int i= 0; i < distances.length; i++) {
            System.out.println(String.format("Distances from %s to %s is %s", start, i, distances[i]));
        }
    }

    private  int findMinDistance(int[] distances, boolean[] isVisited) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        
        for (int i = 0; i < distances.length; i++) {
            if (!isVisited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
}
