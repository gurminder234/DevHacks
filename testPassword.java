import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class testPassword {

    private static final String specialChars = "@_#0123456789";

    public static int testPasswordStrength(Password password, String filename) {
        int strength = 0;

        try {
            FileReader fr = new FileReader(filename + ".txt");
            Scanner scnr =  new Scanner(fr);
            String testCurr;
            boolean found = false;
            while (scnr.hasNextLine() && !found) {
                testCurr = scnr.nextLine();
                if (testCurr.equalsIgnoreCase(password.getPassword())) {
                    System.out.println("Password match found! Password: " + testCurr);
                    found = true;
                } else if (password.getPassword().indexOf(testCurr) != -1) {
                    
                    String updateCracked = "";
                    System.out.println(Main.CRACKED.length());
                    for (int j = 0; j < Main.CRACKED.length(); j++) {
                        if (Main.CRACKED.charAt(j) == '*') {
                            if (j == password.getPassword().indexOf(testCurr)) {
                                updateCracked += testCurr;
                                j += testCurr.length() - 1;
                            } else {
                                updateCracked += "*";
                            }
                        } else {
                            updateCracked += Main.CRACKED.charAt(j);
                        }
                    }
                    Main.CRACKED = updateCracked;
                    System.out.println(Main.CRACKED.length());
                    System.out.println("Password contains common password: " + testCurr);
                }
                Main.TRY++;
            }
            scnr.close();
        } catch (IOException ioe) {
            System.out.println();
        }

        return strength;
    }

    public static void testPasswordStrengthInt(Password password) {
        String updateCracked = "";
        System.out.println(Main.CRACKED.length());
        for (int j = 0; j < Main.CRACKED.length(); j++) {
            
            for (int i = 0; i < specialChars.length(); i++) {
                char testCurr = specialChars.charAt(i);
                if (Main.CRACKED.charAt(j) == '*') {
                if (j == password.getPassword().indexOf(testCurr)) {
                    updateCracked += testCurr;
                } else {
                    updateCracked += "*";
                }
            } else {
                updateCracked += Main.CRACKED.charAt(j);
            }
            }
        }
        Main.CRACKED = updateCracked;
        System.out.println(Main.CRACKED.length());
    }
}