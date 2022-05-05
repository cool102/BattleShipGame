package battleship;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    final static String ABC = "ABCDEFGHIJ";
    static String order = "1";
    static int cellCounterP1 = 0;
    static int cellCounterP2 = 0;
    static String coordinate1 = "";
    static String coordinate2 = "";
    static String shotCoordinate = "";
    static Scanner scanner = new Scanner(System.in);
    static String AIRCRAFT_CARRIER = "Aircraft Carrier";
    static String BATTLESHIP = "Battleship";
    static String SUBMARINE = "Submarine";
    static String CRUISER = "Cruiser";
    static String DESTROYER = "Destroyer";

    public static void main(String[] args) {

        String[][] player1Field = new String[11][11];
        String[][] enemyOfPlayer1Field = new String[11][11];

        System.out.println("Player 1, place your ships on the game field");
        System.out.println();
        initBattlefield(player1Field);
        initCoverdBattlefield(enemyOfPlayer1Field);
        printBattleField(player1Field);
        /***
         * Aircraft init
         */
        enterAircraft();
        readShipCoordinates();
        validateCoordinates(player1Field, 5, AIRCRAFT_CARRIER);
        Set<String> aircraftCoordinates = createShipCoordinates(coordinate1, coordinate2);
        Aircraft aircraft = new Aircraft(aircraftCoordinates);
        placeShip(player1Field, coordinate1, coordinate2);
        printBattleField(player1Field);
        /***
         * Battleship init
         */
        enterBattleship();
        readShipCoordinates();
        validateCoordinates(player1Field, 4, BATTLESHIP);
        Set<String> battleShipCoordinates = createShipCoordinates(coordinate1, coordinate2);
        BattleShip battleShip = new BattleShip(battleShipCoordinates);
        placeShip(player1Field, coordinate1, coordinate2);
        printBattleField(player1Field);
        /***
         * Submarine init
         */
        enterSubmarine();
        readShipCoordinates();
        validateCoordinates(player1Field, 3, SUBMARINE);
        Set<String> submarineCoordinates = createShipCoordinates(coordinate1, coordinate2);
        Submarine submarine = new Submarine(submarineCoordinates);
        placeShip(player1Field, coordinate1, coordinate2);
        printBattleField(player1Field);
        /***
         * Cruiser init
         */
        enterCruiser();
        readShipCoordinates();
        validateCoordinates(player1Field, 3, CRUISER);
        Set<String> cruiserCoordinates = createShipCoordinates(coordinate1, coordinate2);
        Cruiser cruiser = new Cruiser(cruiserCoordinates);
        placeShip(player1Field, coordinate1, coordinate2);
        printBattleField(player1Field);


        /***
         * Destroyer init
         */
        enterDestroyer();
        readShipCoordinates();
        validateCoordinates(player1Field, 2, DESTROYER);
        Set<String> destroyerCoordinates = createShipCoordinates(coordinate1, coordinate2);
        Destroyer destroyer = new Destroyer(destroyerCoordinates);
        placeShip(player1Field, coordinate1, coordinate2);
        printBattleField(player1Field);


        promptEnterKey();

        String[][] player2Field = new String[11][11];
        String[][] enemyOfPlayer2Field = new String[11][11];


        System.out.println("Player 2, place your ships on the game field");
        System.out.println();
        initBattlefield(player2Field);
        initCoverdBattlefield(enemyOfPlayer2Field);
        printBattleField(player2Field);
        /***
         * Aircraft2 init
         */
        enterAircraft();
        readShipCoordinates();
        validateCoordinates(player2Field, 5, AIRCRAFT_CARRIER);
        Set<String> aircraftCoordinatesP2 = createShipCoordinates(coordinate1, coordinate2);
        Aircraft aircraft2 = new Aircraft(aircraftCoordinatesP2);
        placeShip(player2Field, coordinate1, coordinate2);
        printBattleField(player2Field);
        /***
         * Battleship init
         */
        enterBattleship();
        readShipCoordinates();
        validateCoordinates(player2Field, 4, BATTLESHIP);
        Set<String> battleShipCoordinatesP2 = createShipCoordinates(coordinate1, coordinate2);
        BattleShip battleShip2 = new BattleShip(battleShipCoordinatesP2);
        placeShip(player2Field, coordinate1, coordinate2);
        printBattleField(player2Field);
        /***
         * Submarine init
         */
        enterSubmarine();
        readShipCoordinates();
        validateCoordinates(player2Field, 3, SUBMARINE);
        Set<String> submarineCoordinates2 = createShipCoordinates(coordinate1, coordinate2);
        Submarine submarine2 = new Submarine(submarineCoordinates2);
        placeShip(player2Field, coordinate1, coordinate2);
        printBattleField(player2Field);
        /***
         * Cruiser init
         */
        enterCruiser();
        readShipCoordinates();
        validateCoordinates(player2Field, 3, CRUISER);
        Set<String> cruiserCoordinates2 = createShipCoordinates(coordinate1, coordinate2);
        Cruiser cruiser2 = new Cruiser(cruiserCoordinates2);
        placeShip(player2Field, coordinate1, coordinate2);
        printBattleField(player2Field);


        /***
         * Destroyer init
         */
        enterDestroyer();
        readShipCoordinates();
        validateCoordinates(player2Field, 2, DESTROYER);
        Set<String> destroyerCoordinates2 = createShipCoordinates(coordinate1, coordinate2);
        Destroyer destroyer2 = new Destroyer(destroyerCoordinates2);
        placeShip(player2Field, coordinate1, coordinate2);
        printBattleField(player2Field);


        /**
         * Game starts
         */

        promptEnterKey();

        while (cellCounterP1 != 17 || cellCounterP2 != 17) {
            gameStarts( player1Field, enemyOfPlayer1Field,
                    player2Field,enemyOfPlayer2Field);
            readShotCoordinates();
            validateShotCoordinates();

            takeShot(enemyOfPlayer1Field, player1Field, enemyOfPlayer2Field, player2Field, aircraft,
                    battleShip, submarine, cruiser, destroyer,
                    aircraft2,
                    battleShip2, submarine2, cruiser2, destroyer2);
        }

        System.out.println("You sank the last ship. You won. Congratulations!");


    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        System.out.println("...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> createShipCoordinates(String coordinate1, String coordinate2) {
        Set<String> shipCoordinates = new HashSet();
        int row1 = getLineNumber(coordinate1);
        int col1 = getColumnNumber(coordinate1);
        int row2 = getLineNumber(coordinate2);
        int col2 = getColumnNumber(coordinate2);
        if (coordinate1.charAt(0) == coordinate2.charAt(0) && col2 > col1) {
            for (int i = col1; i <= col2; i++) {
                String first = String.valueOf(coordinate1.charAt(0));
                shipCoordinates.add(first + String.valueOf(i));

            }

        }
        if (coordinate1.charAt(0) == coordinate2.charAt(0) && col1 > col2) {
            for (int i = col2; i <= col1; i++) {
                String first = String.valueOf(coordinate1.charAt(0));
                shipCoordinates.add(first + String.valueOf(i));
            }


        }

        if (coordinate1.charAt(0) != coordinate2.charAt(0) && coordinate2.charAt(0) > coordinate1.charAt(0)) {//A1 E1
            int n = coordinate2.charAt(0) - coordinate1.charAt(0) + 1;
            if (col1 != 10) {
                for (int i = 0; i < n; i++) {
                    shipCoordinates.add(String.valueOf((char) (coordinate1.charAt(0) + i)) + (coordinate1.charAt(1)));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    shipCoordinates.add(String.valueOf((char) (coordinate1.charAt(0) + i)) + String.valueOf(coordinate1.charAt(1))
                            + String.valueOf(coordinate1.charAt(2)));
                }
            }
        }

        if (coordinate1.charAt(0) != coordinate2.charAt(0) && coordinate1.charAt(0) > coordinate2.charAt(0)) { //E1 A1
            int n = Math.abs(coordinate2.charAt(0) - coordinate1.charAt(0)) + 1;
            if (col1 != 10) {
                for (int i = 0; i < n; i++) {
                    shipCoordinates.add(String.valueOf((char) (coordinate2.charAt(0) + i)) + String.valueOf(coordinate1.charAt(1)));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    shipCoordinates.add(String.valueOf((char) (coordinate2.charAt(0) + i)) + String.valueOf(coordinate1.charAt(1))
                            + String.valueOf(coordinate1.charAt(2)));
                }
            }
        }
        return shipCoordinates;
    }

    private static void takeShot(String[][] enemyOfPlayer1Field, String[][] player1Field,
                                 String[][] enemyOfPlayer2Field, String[][] player2Field, Aircraft aircraft,
                                 BattleShip battleShip, Submarine submarine, Cruiser cruiser, Destroyer destroyer,
                                 Aircraft aircraft2,
                                 BattleShip battleShip2, Submarine submarine2, Cruiser cruiser2, Destroyer destroyer2
                                 ) {
        int row1 = getLineNumber(shotCoordinate);
        int col1 = getColumnNumber(shotCoordinate);
        if (order.equals("1")) {
            // выстрел удачный
            if (player2Field[row1][col1].equals("O") || player2Field[row1][col1].equals("X")) {
                enemyOfPlayer1Field[row1][col1] = "X";
                player2Field[row1][col1] = "X";
//печатаем поле
                printCoveredBattleField(enemyOfPlayer1Field);
                printCoveredBattleField(player1Field);
                //логика Уменьшения жизни кораблям
                if (aircraft2.getAircraftCoordinates().contains(shotCoordinate)) {
                    aircraft2.setHealth(1);
                    cellCounterP2++;
                    aircraft2.getAircraftCoordinates().remove(shotCoordinate);

                }
                if (battleShip2.getBattleShipCoordinates().contains(shotCoordinate)) {
                    battleShip2.setHealth(1);
                    cellCounterP2++;
                    battleShip2.getBattleShipCoordinates().remove(shotCoordinate);
                }
                if (submarine2.getSubmarineCoordinates().contains(shotCoordinate)) {
                    submarine2.setHealth(1);
                    cellCounterP2++;
                    submarine2.getSubmarineCoordinates().remove(shotCoordinate);
                }
                if (cruiser2.getCruiserCoordinates().contains(shotCoordinate)) {
                    cruiser2.setHealth(1);
                    cellCounterP2++;
                    cruiser2.getCruiserCoordinates().remove(shotCoordinate);
                }
                if (destroyer2.getDestroyerCoordinates().contains(shotCoordinate)) {
                    destroyer2.setHealth(1);
                    cellCounterP2++;
                    destroyer2.destroyerCoordinates.remove(shotCoordinate);
                }
               //логика обработки полного уничтожения корабля (любого)
                if (aircraft2.getHealth() == 0 || battleShip2.getHealth() == 0 || submarine2.getHealth() == 0
                        || cruiser2.getHealth() == 0 || destroyer2.getHealth() == 0) {
                    if (aircraft2.getHealth() == 0) {
                        aircraft2.setHealth(10);
                    }
                    if (battleShip2.getHealth() == 0) {
                        battleShip2.setHealth(10);
                    }
                    if (submarine2.getHealth() == 0) {
                        submarine2.setHealth(10);
                    }
                    if (cruiser2.getHealth() == 0) {
                        cruiser2.setHealth(10);
                    }
                    if (destroyer2.getHealth() == 0) {
                        destroyer2.setHealth(10);
                    }
                    //если после уменьшения один из этих парметров равен 17 то выходим из метода
                    if (cellCounterP2 == 17) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        return;
                    }
                    if (cellCounterP1 == 17) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        return;
                    }

                    System.out.println("You sank a ship! Specify a new target:");
                    promptEnterKey();
                    if (order.equals("1")) {
                        order = "2";
                        return;
                    }
                    else  {
                        order = "1";
                        return;
                    }


                } else {
                    System.out.println("You hit a ship!");
                    promptEnterKey();
                    if (order.equals("1")) {
                        order = "2";
                        return;
                    }
                    else {
                        order = "1";
                        return;
                    }
                }
            }


            if (player2Field[row1][col1].equals("~")) {
                enemyOfPlayer1Field[row1][col1] = "M";
                player2Field[row1][col1] = "M";
                System.out.println();
                printCoveredBattleField(enemyOfPlayer1Field);
                printCoveredBattleField(player1Field);
                System.out.println("You missed!");
                promptEnterKey();
                if (order.equals("1")) {
                    order = "2";
                    return;
                }
                else {
                    order = "1";
                    return;
                }
            }
        }

        if (order.equals("2")) {
            if (player1Field[row1][col1].equals("O") || player1Field[row1][col1].equals("X")) {
                enemyOfPlayer2Field[row1][col1] = "X";
                player1Field[row1][col1] = "X";

                printCoveredBattleField(enemyOfPlayer2Field);
                printCoveredBattleField(player2Field);
                if (aircraft.getAircraftCoordinates().contains(shotCoordinate)) {
                    aircraft.setHealth(1);
                    cellCounterP1++;
                    aircraft.getAircraftCoordinates().remove(shotCoordinate);

                }
                if (battleShip.getBattleShipCoordinates().contains(shotCoordinate)) {
                    battleShip.setHealth(1);
                    cellCounterP1++;
                    battleShip.getBattleShipCoordinates().remove(shotCoordinate);
                }
                if (submarine.getSubmarineCoordinates().contains(shotCoordinate)) {
                    submarine.setHealth(1);
                    cellCounterP1++;
                    submarine.getSubmarineCoordinates().remove(shotCoordinate);
                }
                if (cruiser.getCruiserCoordinates().contains(shotCoordinate)) {
                    cruiser.setHealth(1);
                    cellCounterP1++;
                    cruiser.getCruiserCoordinates().remove(shotCoordinate);
                }
                if (destroyer.getDestroyerCoordinates().contains(shotCoordinate)) {
                    destroyer.setHealth(1);
                    cellCounterP1++;
                    destroyer.destroyerCoordinates.remove(shotCoordinate);
                }


                if (aircraft.getHealth() == 0 || battleShip.getHealth() == 0 || submarine.getHealth() == 0
                        || cruiser.getHealth() == 0 || destroyer.getHealth() == 0) {
                    if (aircraft.getHealth() == 0) {
                        aircraft.setHealth(10);
                    }
                    if (battleShip.getHealth() == 0) {
                        battleShip.setHealth(10);
                    }
                    if (submarine.getHealth() == 0) {
                        submarine.setHealth(10);
                    }
                    if (cruiser.getHealth() == 0) {
                        cruiser.setHealth(10);
                    }
                    if (destroyer.getHealth() == 0) {
                        destroyer.setHealth(10);
                    }

                    if (cellCounterP2 == 17) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        return;
                    }
                    if (cellCounterP1 == 17) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        return;
                    }
                    System.out.println("You sank a ship! Specify a new target:");
                    promptEnterKey();
                    if (order.equals("1")) {
                        order = "2";
                        return;
                    }
                   else {
                        order = "1";
                        return;
                    }
                   // System.out.print(">");
                   // shotCoordinate = scanner.next();
                } else {
                    System.out.println("You hit a ship!");
                    promptEnterKey();
                    if (order.equals("1")) {
                        order = "2";
                        return;
                    }
                   else {
                        order = "1";
                        return;
                    }
                   //                 System.out.print(">");
                   // shotCoordinate = scanner.next();
                }
            }


            if (player1Field[row1][col1].equals("~")) {
                enemyOfPlayer2Field[row1][col1] = "M";
                player1Field[row1][col1] = "M";
                System.out.println();
                printCoveredBattleField(enemyOfPlayer2Field);
                printCoveredBattleField(player2Field);
                System.out.println("You missed!");
                promptEnterKey();
                if (order.equals("1")) {
                    order = "2";
                }
               else {
                    order = "1";
                }

            }
        }


    }

    private static void gameStarts(String[][] player1Field, String[][] enemyOfPlayer1Field,
                                   String[][] player2Field, String[][] enemyOfPlayer2Field) {

        System.out.println();
        if (order.equals("1")) {
            printBattleField(enemyOfPlayer1Field);
            System.out.println("---------------------");
            printBattleField(player1Field);
            System.out.println("Player 1, it's your turn:");
            System.out.print(">");
        }
        if (order.equals("2")) {
            printBattleField(enemyOfPlayer2Field);
            System.out.println("---------------------");
            printBattleField(player2Field);
            System.out.println("Player 2, it's your turn:");
            System.out.print(">");
        }
    }

    private static void validateCoordinates(String[][] field, int length, String shipType) {
        boolean isWrongLength = true;
        boolean isClose = true;
        boolean isWrongLocation = true;
        while (isWrongLength || isWrongLocation || isClose) {
            isWrongLength = isWrongLength(length, coordinate1, coordinate2);
            if (isWrongLength) {
                System.out.printf("Error! Wrong length of the %s! Try again:\n", shipType);
                System.out.print(">");
                coordinate1 = scanner.next();
                coordinate2 = scanner.next();
            }
            isWrongLocation = isWrongLocation(coordinate1, coordinate2);
            if (isWrongLocation) {
                System.out.printf("Error! Wrong ship location! Try again:\n", shipType);
                System.out.print(">");
                coordinate1 = scanner.next();
                coordinate2 = scanner.next();
            }

            isClose = isClose(field, coordinate1, coordinate2);
            if (isClose) {
                System.out.printf("Error! You placed it too close to another one. Try again:\n", shipType);
                System.out.print(">");
                coordinate1 = scanner.next();
                coordinate2 = scanner.next();
            }
        }
    }

    private static void readShotCoordinates() {
        shotCoordinate = scanner.next();
    }

    private static void validateShotCoordinates() {
        boolean shotIsOK = false;
        while (!shotIsOK) {

            String[] letter = shotCoordinate.split("\\d");
            String[] digit = shotCoordinate.split("\\D");
            int digitCoordinate = Integer.parseInt(digit[1]);
            shotIsOK = letter[0].matches("[A-J]") && digitCoordinate <= 10;
            if (!shotIsOK) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                System.out.print(">");
                shotCoordinate = scanner.next();
            }

        }
    }

    private static void readShipCoordinates() {

        coordinate1 = scanner.next();
        coordinate2 = scanner.next();
    }

    private static void enterDestroyer() {
        System.out.println();
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        System.out.print(">");
    }

    private static void enterCruiser() {
        System.out.println();
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        System.out.print(">");
    }

    private static void enterSubmarine() {
        System.out.println();
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        System.out.print(">");
    }

    private static void enterBattleship() {
        System.out.println();
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        System.out.print(">");
    }

    private static void enterAircraft() {
        System.out.println();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        System.out.print(">");
    }

    private static boolean isClose(String[][] field, String coordinate1, String coordinate2) {
        int line1 = getLineNumber(coordinate1);
        int col1 = getColumnNumber(coordinate1);
        int line2 = getLineNumber(coordinate2);
        int col2 = getColumnNumber(coordinate2);
        boolean sameLetters = coordinate1.charAt(0) == coordinate2.charAt(0);
        boolean goingRight = col2 > col1;
        if (sameLetters && goingRight) {
            if (col2 != 10 && line1 != 10) {
                for (int i = col1; i <= col2; i++) {
                    String actual = field[line1][i];
                    String startLeft = field[line1][i - 1];
                    String startUpperLeft = field[line1 - 1][i - 1];
                    String startAbove = field[line1 - 1][i];
                    String startUnder = field[line1 + 1][i];
                    String startLowerLeft = field[line1 + 1][i - 1];
                    String endRight = field[line1][col2 + 1];
                    String endUpperRight = field[line1 - 1][col2 + 1];
                    String endUnderRight = field[line1 + 1][col2 + 1];

                    if (actual.equals("O") || startUpperLeft.equals("O") || startLeft.equals("O") || endUpperRight.equals("O")
                            || endUnderRight.equals("O")
                            || startAbove.equals("O") || startUnder.equals("O")
                            || endRight.equals("O") || startLowerLeft.equals("O")) {
                        return true;
                    }
                }
            } else {
                for (int i = col1; i <= col2; i++) {
                    String actual = field[line1][i];
                    String startLeft = field[line1][i - 1];
                    String startUpperLeft = field[line1 - 1][i - 1];
                    String startAbove = field[line1 - 1][i];


                    if (actual.equals("O") || startUpperLeft.equals("O") || startLeft.equals("O")
                            || startAbove.equals("O")) {
                        return true;
                    }
                }
            }

        }
        boolean goingLeft = col1 > col2;
        if (sameLetters && goingLeft) {
            if (col1 != 10 && line1 != 10) {
                for (int i = col2; i <= col1; i++) {
                    String actual = field[line1][i];
                    String startLeft = field[line1][i - 1];
                    String startUpperLeft = field[line1 - 1][i - 1];
                    String startAbove = field[line1 - 1][i];
                    String startUnder = field[line1 + 1][i];
                    String startLowerLeft = field[line1 + 1][i - 1];
                    String endRight = field[line1][col1 + 1];
                    String endUpperRight = field[line1 - 1][col1 + 1];
                    String endUnderRight = field[line1 + 1][col1 + 1];

                    if (actual.equals("O") || startUpperLeft.equals("O") || startLeft.equals("O") || endUpperRight.equals("O")
                            || endUnderRight.equals("O")
                            || startAbove.equals("O") || startUnder.equals("O")
                            || endRight.equals("O") || startLowerLeft.equals("O")) {
                        return true;
                    }
                }

            } else {
                for (int i = col2; i <= col1; i++) {
                    String actual = field[line1][i];
                    String startLeft = field[line1][i - 1];
                    String startUpperLeft = field[line1 - 1][i - 1];
                    String startAbove = field[line1 - 1][i];
                    // String startUnder = field[line1 + 1][i];
                    // String startLowerLeft = field[line1 + 1][i - 1];
                    //String endRight = field[line1][col1 + 1];
                    // String endUpperRight = field[line1 - 1][col1 + 1];
                    //String endUnderRight = field[line1 + 1][col1 + 1];

                    if (actual.equals("O") || startUpperLeft.equals("O")
                            || startAbove.equals("O") || startLeft.equals("O")

                    ) {
                        return true;
                    }
                }
            }
        }

        boolean differentLettersGoingUp = coordinate1.charAt(0) != coordinate2.charAt(0) && line1 > line2; //example F10 A10
        if (differentLettersGoingUp) {
            if (line1 != 10 || col1 != 10) {
                for (int i = line2; i <= line1; i++) {
                    String actual = field[i][col1];
                    String startUp = field[i - 1][col1];
                    String startUpperLeft = field[i - 1][col1 - 1];
                    String startUpperRight = field[i - 1][col1 + 1];
                    String startLeft = field[i][col1 - 1];
                    String startRight = field[i][col1 + 1];
                    String endDown = field[i + 1][col1];
                    String endDownRight = field[i + 1][col1 + 1];
                    String endDownLeft = field[i + 1][col1 - 1];
                    if (actual.equals("O") || startUp.equals("O") || startUpperLeft.equals("O")
                            || startUpperRight.equals("O") || startLeft.equals("O") || startRight.equals("O") || endDown.equals("O")
                            || endDownRight.equals("O") || endDownLeft.equals("O")) {
                        return true;
                    }
                }
            } else {
                for (int i = line2; i <= line1; i++) {
                    String actual = field[i][col1];
                    String startUp = field[i - 1][col1];
                    String startUpperLeft = field[i - 1][col1 - 1];
                    //String startUpperRight = field[i - 1][col1 + 1];
                    String startLeft = field[i][col1 - 1];
                    //String startRight = field[i][col1 + 1];
                    //String endDown = field[i + 1][col1];
                    //String endDownRight = field[i + 1][col1 + 1];
                    //String endDownLeft = field[i + 1][col1 - 1];
                    if (actual.equals("O") || startUp.equals("O") || startUpperLeft.equals("O")
                            || startLeft.equals("O")
                    ) {
                        return true;
                    }
                }
            }
        }
        boolean differentLettersGoingDown = coordinate1.charAt(0) != coordinate2.charAt(0) && line2 > line1;// example A10 E10
        if (differentLettersGoingDown) {
            if (line1 != 9) {
                for (int i = line1; i <= line2; i++) {
                    String actual = field[i][col1];
                    String startUp = field[i - 1][col1];
                    String startUpperLeft = field[i - 1][col1 - 1];
                    String startUpperRight = field[i - 1][col1 + 1];
                    String startLeft = field[i][col1 - 1];
                    String startRight = field[i][col1 + 1];
                    String endDown = field[i + 1][col1];
                    String endDownRight = field[i + 1][col1 + 1];
                    String endDownLeft = field[i + 1][col1 - 1];
                    if (actual.equals("O") || startUp.equals("O") || startUpperLeft.equals("O")
                            || startUpperRight.equals("O") || startLeft.equals("O") || startRight.equals("O") || endDown.equals("O")
                            || endDownRight.equals("O") || endDownLeft.equals("O")) {
                        return true;
                    }
                }


            } else {
                for (int i = line1; i <= line2; i++) {
                    String actual = field[i][col1];
                    String startUp = field[i - 1][col1];
                    String startUpperLeft = field[i - 1][col1 - 1];

                    String startLeft = field[i][col1 - 1];

                    if (actual.equals("O") || startUp.equals("O") || startUpperLeft.equals("O")
                            || startLeft.equals("O")
                    ) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private static boolean isWrongLocation(String coordinate1, String coordinate2) {
        int row1 = getLineNumber(coordinate1);
        int col1 = getColumnNumber(coordinate1);
        int row2 = getLineNumber(coordinate2);
        int col2 = getColumnNumber(coordinate2);

        return coordinate1.charAt(0) != coordinate2.charAt(0)
                && col1 != col2;
    }

    private static boolean isWrongLength(int lengthOfShip, String coordinate1, String coordinate2) {
        int row1 = getLineNumber(coordinate1);
        int col1 = getColumnNumber(coordinate1);
        int row2 = getLineNumber(coordinate2);
        int col2 = getColumnNumber(coordinate2);

        if (coordinate1.charAt(0) == coordinate2.charAt(0)) {
            return lengthOfShip != Math.abs(col2 - col1) + 1;
        } else {
            return lengthOfShip != Math.abs(row2 - row1) + 1;
        }
    }

    private static void placeShip(String[][] field, String coordinate1, String coordinate2) {
        int row1 = getLineNumber(coordinate1);
        int col1 = getColumnNumber(coordinate1);
        int row2 = getLineNumber(coordinate2);
        int col2 = getColumnNumber(coordinate2);
        if (coordinate1.charAt(0) == coordinate2.charAt(0) && col2 > col1) {
            for (int i = col1; i <= col2; i++) {
                field[row1][i] = "O";
            }

        }
        if (coordinate1.charAt(0) == coordinate2.charAt(0) && col1 > col2) {
            for (int i = col2; i <= col1; i++) {
                field[row1][i] = "O";
            }


        }

        if (coordinate1.charAt(0) != coordinate2.charAt(0) && row1 > row2) {
            for (int i = row2; i <= row1; i++) {
                field[i][col1] = "O";
            }
        }

        if (coordinate1.charAt(0) != coordinate2.charAt(0) && row2 > row1) {
            for (int i = row1; i <= row2; i++) {
                field[i][col1] = "O";
            }
        }
    }

    private static int getLineNumber(String coordinate) {
        String[] letter = coordinate.split("\\d");
        return ABC.indexOf(letter[0]) + 1;
    }

    private static int getColumnNumber(String coordinate) {
        String[] digit = coordinate.split("\\D");
        return Integer.parseInt(digit[1]);
    }

    private static void printCoveredBattleField(String[][] coverdField) {
        for (int i = 0; i < coverdField.length; i++) {
            for (int j = 0; j < coverdField[i].length; j++) {
                System.out.print(coverdField[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printBattleField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initCoverdBattlefield(String[][] coverdField) {

        for (int i = 1; i < coverdField[0].length; i++) {
            coverdField[0][i] = String.valueOf(i);
        }

        for (int i = 1; i < coverdField.length; i++) {
            coverdField[i][0] = String.valueOf(ABC.charAt(i - 1));
        }


        for (int i = 0; i < coverdField.length; i++) {
            for (int j = 0; j < coverdField[i].length; j++) {
                if (coverdField[i][j] == null) {
                    coverdField[i][j] = "~";
                }
            }
        }
    }

    private static void initBattlefield(String[][] field) {

        for (int i = 1; i < field[0].length; i++) {
            field[0][i] = String.valueOf(i);
        }

        for (int i = 1; i < field.length; i++) {
            field[i][0] = String.valueOf(ABC.charAt(i - 1));
        }


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == null) {
                    field[i][j] = "~";
                }
            }
        }
    }

    public static class Submarine {
        int health = 3;
        Set<String> submarineCoordinates = new HashSet<String>();

        public Submarine(Set<String> submarineCoordinates) {
            this.submarineCoordinates = submarineCoordinates;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int reduceHealth) {
            this.health = health - reduceHealth;
        }

        public Set<String> getSubmarineCoordinates() {
            return submarineCoordinates;
        }

        public void setSubmarineCoordinates(Set<String> submarineCoordinates) {
            this.submarineCoordinates = submarineCoordinates;
        }
    }

    public static class Cruiser {
        int health = 3;
        Set<String> cruiserCoordinates = new HashSet<String>();

        public Cruiser(Set<String> cruiserCoordinates) {
            this.cruiserCoordinates = cruiserCoordinates;
        }

        public Set<String> getCruiserCoordinates() {
            return cruiserCoordinates;
        }

        public void setCruiserCoordinates(Set<String> cruiserCoordinates) {
            this.cruiserCoordinates = cruiserCoordinates;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int reduceHealth) {
            this.health = health - reduceHealth;
        }
    }

    public static class Destroyer {
        int health = 2;
        Set<String> destroyerCoordinates = new HashSet<String>();

        public Destroyer(Set<String> destroyerCoordinates) {
            this.destroyerCoordinates = destroyerCoordinates;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int reduceHealth) {
            this.health = health - reduceHealth;
        }

        public Set<String> getDestroyerCoordinates() {
            return destroyerCoordinates;
        }

        public void setDestroyerCoordinates(Set<String> destroyerCoordinates) {
            this.destroyerCoordinates = destroyerCoordinates;
        }
    }

    public static class BattleShip {
        int health = 4;
        Set<String> battleShipCoordinates = new HashSet<String>();

        public BattleShip(Set<String> battleShipCoordinates) {
            this.battleShipCoordinates = battleShipCoordinates;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int reduceHealth) {
            this.health = health - reduceHealth;
        }

        public Set<String> getBattleShipCoordinates() {
            return battleShipCoordinates;
        }

        public void setBattleShipCoordinates(Set<String> battleShipCoordinates) {
            this.battleShipCoordinates = battleShipCoordinates;
        }
    }

    public static class Aircraft {
        int health = 5;
        Set<String> aircraftCoordinates = new HashSet<String>();

        public Aircraft(Set<String> aircraftCoordinates) {

            this.aircraftCoordinates = aircraftCoordinates;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int reduceHealth) {
            this.health = health - reduceHealth;
        }

        public Set<String> getAircraftCoordinates() {
            return aircraftCoordinates;
        }

        public void setAircraftCoordinates(Set<String> aircraftCoordinates) {
            this.aircraftCoordinates = aircraftCoordinates;
        }
    }


}
