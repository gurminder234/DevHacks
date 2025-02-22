import java.io.*;
import java.util.Scanner;

public class test {
    public static void modifyCommonPasswords(String filename) {
        try {
            FileWriter fw = new FileWriter(filename + "updated.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 8; i < 16; i++) {
                pw.append(readFile(filename, i));
            }
            pw.close();

        } catch (IOException ioe){
            System.out.println("File not found.");
        }
    }

    public static String readFile(String filename, int len) {
        String result = "";
        try {
            FileReader fw = new FileReader(filename + ".txt");
            Scanner scnr = new Scanner(fw);
            
            String line;
            while (scnr.hasNextLine()) {
                line = scnr.nextLine();
                if (line.length() == len) {
                    result += line + "\n";
                }
            }
            
            scnr.close();
        } catch (IOException ioe) {

        }
        return result;
    }

    public static void makeCombinations(String[] args) {
        combinations("bob");
    }

    private static void combinations(String name) {
        char[] chars  = name.toCharArray();

        for (int i = 0; i < Math.pow(2, chars.length); i++) {
            char[] result = new char[chars.length];

            for (int n = 0; n < chars.length; n++) {
                result[n] = isBitSet(i, n) ? Character.toUpperCase(chars[n])
                                           : Character.toLowerCase(chars[n]);
            }

            System.out.println(result);
        }
    }

    private static boolean isBitSet(int i, int n) {
        return ((i & (1 << n)) != 0);
    }
}