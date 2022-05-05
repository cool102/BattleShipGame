import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] matrix = new int[size][size];
        boolean isSymmetric = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] !=matrix[j][i]) {
                    isSymmetric =false;
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }
}