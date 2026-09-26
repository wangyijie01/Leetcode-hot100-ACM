package backtrack;

import java.util.Scanner;

/**
 * 200. 岛屿数量
 */
public class NumIsLands {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[row][col];
        for(int i = 0; i < row; i++){
            String line = sc.nextLine();
            for(int j = 0; j < col; j++){
                grid[i][j] = line.charAt(j);
            }
        }

        System.out.println(numIslands(grid));
    }


    public static int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1'){
            return;
        }


        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
