import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        boolean p1 = true;
        boolean p2 = false;

        int p1turn = 0;
        int p2turn = 0;

        boolean turn = true;

        int[][] gameBoard = new int[6][7];


        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 5; column++) {

                gameBoard[row][column] = ' ';

            }
        }

        printBoard(gameBoard);
        int winner = 0;
        while (winner == 0) {

            if (turn) {
                System.out.println("Player 1's Turn.");
            }
            if (p1) {
                askColumn(gameBoard, 1);
            } else {
                System.out.println("Player 2's Turn");
            }
            if (p2) {
                askColumn(gameBoard, 2);
            }
        }

        winner = whoWins(gameBoard);
        turn = !turn;

        if (p1 == true && p2 == false && winner == 2) {
            if (p2 == true && p1 == false && winner == 1) {
                System.out.println("You Lose");
            } else if (winner == 1) {
                System.out.println("Winner: Player 1");
            } else if (winner == 2) {
                System.out.println("Winner: Player 2");
            } else {
                System.out.println("Draw");
            }
        }
    }

    public static void printBoard(int[][] grid) {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < 6; row++) {
            System.out.print("|");
            for (int col = 0; col < 5; col++) {
                System.out.print(grid[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }

    public static int askColumn(int[][] board, int stuffs) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("column;  ");
            int col = sc.nextInt() - 1;

            if (col > 0 && col < 5) {
                for (int row = 5; row >= 0; --row) {
                    if (board[col][row] == 0) {
                        stuffs = board[col][row];
                        return stuffs;
                    }
                }
                System.out.println("Column is Full");
            } else {
                System.out.println("Invalid");
            }
        }
    }


    public static char whoWins(int[][] gameBoard) {
        int p1 = 0;
        int p2 = 0;

        int tied = 0;

        for (int j = 0; j < 6; ++j) {
            for (int i = 0; i < 7; ++i) {
                if (gameBoard[i][j] == 0) {
                    p1 = 0;
                    p2 = 0;
                } else if (gameBoard[i][j] == 1) {
                    ++p1;
                    p2 = 0;
                    ++tied;
                } else if (gameBoard[i][j] == 2) {
                    p1 = 0;
                    ++p2;
                    ++tied;
                }
                if (p1 == 4) {
                    return 1;
                } else if (p2 == 4) {
                    return 2;
                }
            }
            p1 = 0;
            p2 = 0;
        }

        if (tied == 42) {
            return 3;
        }

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (gameBoard[i][j] == 0) {
                    p1 = 0;
                    p2 = 0;
                } else if (gameBoard[i][j] == 1) {
                    ++p1;
                    p2 = 0;
                } else if (gameBoard[i][j] == 2) {
                    p1 = 0;
                    ++p2;
                }
                if (p1 == 4) {
                    return 1;
                } else if (p2 == 4) {
                    return 2;
                }
            }
            p1 = 0;
            p2 = 0;
        }


        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 4; ++i) {
                if (gameBoard[i][j] == gameBoard[i + 1][j + 1]
                        && gameBoard[i][j] == gameBoard[i + 2][j + 2]
                        && gameBoard[i][j] == gameBoard[i + 3][j + 3]) {
                    if (gameBoard[i][j] == 1) {
                        return 1;
                    } else if (gameBoard[i][j] == 2) {
                        return 2;
                    }
                }
            }
        }
        for (int j = 0; j < 3; ++j) {
            for (int i = 6; i >= 3; --i) {
                if (gameBoard[i][j] == gameBoard[i - 1][j + 1]
                        && gameBoard[i][j] == gameBoard[i - 2][j + 2]
                        && gameBoard[i][j] == gameBoard[i - 3][j + 3]) {
                    if (gameBoard[i][j] == 1) {
                        return 1;
                    } else if (gameBoard[i][j] == 2) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }
}
