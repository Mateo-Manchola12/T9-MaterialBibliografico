package app.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner in = new Scanner(System.in);

    public static String getString(String msg) {
        String s;
        while (true) {
            System.out.printf("%n%s: ", msg);
            s = in.nextLine().trim();

            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Error: no puede estar vacío.");
        }
    }

    public static int getInt(String msg, Integer min, Integer max) {
        int n;
        while (true) {
            System.out.printf("%n%s: ", msg);
            try {
                n = Integer.parseInt(in.nextLine().trim());
                if ((min == null || n >= min) && (max == null || n <= max))
                    return n;
                else if (min == null && max != null)
                    System.out.printf("Error: debe ser un número menor o igual a %d.", max);
                else if (min != null && max == null)
                    System.out.printf("Error: debe ser un número mayor o igual a %d.", min);
                else
                    System.out.printf("Error: debe ser un número entre %d y %d.", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ser un número.");
            }
        }
    }
}
