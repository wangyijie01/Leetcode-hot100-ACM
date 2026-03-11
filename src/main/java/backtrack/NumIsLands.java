package backtrack;

import java.util.Scanner;

public class NumIsLands {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            String s = sc.nextLine();
            for(int j = 0; j < cols; j++){
                grid[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
