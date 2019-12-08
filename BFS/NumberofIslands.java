// Number of Islands

// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// Input:
// 11110
// 11010
// 11000
// 00000

// Output: 1
// Example 2:

// Input:
// 11000
// 11000
// 00100
// 00011

// Output: 3

class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0 || grid[0]==null || grid[0].length==0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int island = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='1'){
                    bfs_grid_with_mark(grid,i,j);
                    island++;
                }
            }
        }
        return island;
    }
    private void bfs_grid_with_mark(char[][] grid, int i, int j){
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(i,j);
        queue.offer(point);
        //Moving direction: up, down, left, right; upper-left = 0, moving up = x-1, moving right = y+1
        int[] x_direction = {-1,1,0,0};
        int[] y_direction = {0,0,-1,1};
        
        while (!queue.isEmpty()){
            Point cordinate = queue.poll();
            grid[cordinate.x][cordinate.y] = '0';
            for (int k=0;k<4;k++){
                Point cur = new Point(cordinate.x+x_direction[k],cordinate.y+y_direction[k]);
                if (isBound(cur,grid)&&grid[cur.x][cur.y]=='1'){
                    queue.offer(cur);
                    grid[cur.x][cur.y]='0';
                }
            }
        }
    }
    private boolean isBound(Point point, char[][] grid){
        return point.x>=0&&point.x<grid.length&&
               point.y>=0&&point.y<grid[0].length;
    }
}