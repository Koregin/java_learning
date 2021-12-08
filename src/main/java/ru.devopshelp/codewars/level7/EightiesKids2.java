package codewars.level7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EightiesKids2 {
    public static String findSpaceship(String map) {
        String[] maparray = map.split("");
        int rowcount = 0;
        int columncount = 0;
        for (String s : maparray) {
            columncount++;
            if (s.equals("\n")) {
                rowcount++;
            }
        }
        String[][] newmap = new String[rowcount + 1][columncount / (rowcount + 1)];
        int row = 0;
        int column = 0;
        for (String s : maparray) {
            if (s.equals("\n")) {
                row++;
                column = 0;
            } else {
                newmap[row][column] = s;
                column++;
            }
        }
        for (int r = 0; r < newmap.length; r++) {
            for (int c = 0; c < newmap[r].length; c++) {
                System.out.print(newmap[r][c]);
            }
        }
        int rowend = 0;
        int colend = 0;
        for (int r = newmap.length - 1; r >= 0; r--) {
            rowend = r;
            for (int c = 0; c < newmap[r].length; c++) {
                colend = c;
                if (newmap[r][c] == "X") {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append("[" + (column - colend) + ", " + rowend + "]");

        return sb.toString();
    }

    public static void main(String[] args) {
        String map = "..\n.X"; //[1, 0]
        String[] maparray = map.split("");
        System.out.println(Arrays.toString(maparray));
        // count /n in array
        int rowcount = 0;
        int columncount = 0;
        for (String s : maparray) {
            columncount++;
            if (s.equals("\n")) {
                rowcount++;
            }
        }
        System.out.println("Row: " + rowcount + ", Column: " + columncount);
        System.out.println(columncount / (rowcount + 1));
        //create multiarray
        String[][] newmap = new String[rowcount + 1][columncount / (rowcount + 1)];
        int row = 0;
        int column = 0;
        for (String s : maparray) {
            if (s.equals("\n")) {
                row++;
                column = 0;
            } else {
                newmap[row][column] = s;
                column++;
            }
        }
        for (int r = 0; r < newmap.length; r++) {
            for (int c = 0; c < newmap[r].length; c++) {
                System.out.print(newmap[r][c]);
            }
            System.out.print("\n");
        }
        // Поиск Х
        for (int r = newmap.length - 1; r >= 0; r--) {
            row = r;
            for (int c = 0; c < newmap[r].length; c++) {
                column = c;
                if (newmap[r][c] == "X") {
                    System.out.println("X was found");
                    break;
                }
            }
        }
        System.out.println("Row: " + row + ", Column: " + column);
    }
}
