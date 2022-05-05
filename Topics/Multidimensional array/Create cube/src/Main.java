class ArrayOperations {
    public static int[][][] createCube() {
        int[][][] threeDimArray = new int[3][3][3];
        int element = 0;

        for (int i = 0; i < threeDimArray.length; i++) {
            element = 0;
            for (int j = 0; j < threeDimArray[i].length; j++) {
                for (int k = 0; k < threeDimArray[i][j].length; k++) {
                    threeDimArray[i][j][k] = element;
                    element++;
                }

            }

        }
        return threeDimArray;
    }
}