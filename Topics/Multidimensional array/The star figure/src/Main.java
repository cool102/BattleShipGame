import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] cinema = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cinema[i][j] = ".";
            }
        }
        int k = (n / 2);
        for (int j = 0; j < n; j++) {
            cinema[j][k] = "*";
        }

        int l = (n / 2);
        for (int i = 0; i < n; i++) {
            cinema[l][i] = "*";
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                cinema[i][j] = "*";
                break;
            }
        }

            for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1 - i; j < n; j++) {
                cinema[i][j] = "*";
                break;
            }
        }





    }
}