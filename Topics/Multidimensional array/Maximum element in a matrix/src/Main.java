import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        findIndexces(n, m, arr, max);

    }

    private static void findIndexces(int n, int m, int[][] arr, int max) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == max) {
                    System.out.print(i + " ");
                    System.out.print(j);
                    return;

                }
            }
        }
    }
}