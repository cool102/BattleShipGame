import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] cinema = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cinema[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        int counter = 0;
        for (int i = 0; i < n; i++) {
            counter=0;
            for (int j = 0; j < m; j++) {
                if (cinema[i][j] ==0 ) {
                    counter++;
                    if (counter >= k) {
                        System.out.println(i + 1);
                        return;
                    }
                }
                if (cinema[i][j] ==1) {
                    if (counter >= k) {
                        System.out.println(i+1);
                        return;
                    }
                    else {
                        counter=0;

                    }



                }
            }

        }
        System.out.println(0);


    }
}