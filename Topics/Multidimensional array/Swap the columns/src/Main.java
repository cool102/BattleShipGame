import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int col1 = sc.nextInt();
        int col2 = sc.nextInt();

        int[][] box = new int[matrix.length][1];

        for (int i = 0; i < matrix.length; i++) {
            box[i][0] = matrix[i][col1];
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col1] = matrix[i][col2];
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col2] = box[i][col1];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
}