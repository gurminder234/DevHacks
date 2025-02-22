import java.util.ArrayList;
import java.util.Scanner;
public class Main {

      public static int TRY = 0;
      public static String CRACKED = "";

      public static void main(String[] args){
            Scanner scnr = new Scanner(System.in);
            test.modifyCommonPasswords("commonPasswords");

            System.out.println("---- WELCOME TO CYBER AWARENESS ----\n" 
            + "This is a password security challenge:\n" 
            + "\t> You are going to see a login page.\n" 
            + "\t> You will be asked to submit a login form.\n" 
            + "\t> You will be ranked on the strength of your password.");

            System.out.print("Enter your last name: ");
            String lastName = scnr.nextLine();
            System.out.print("Enter your first name: ");
            String firstName = scnr.nextLine();
            System.out.print("Enter your preferred name: ");
            String preferredName = scnr.nextLine();
            System.out.print("Enter your Date of Birth(YYYY-MM-DD): ");
            String dob = scnr.nextLine();
            System.out.print("Enter your Hometown: ");
            String hometown = scnr.nextLine();

            PersonData person = new PersonData(firstName, lastName, preferredName, dob, hometown);
            
            Password pass;
            boolean valid = true;
            

            do {
                  System.out.print("Enter your password: ");
                  String password = scnr.nextLine();
                  pass = new Password(password);
                  
            } while(pass.checkLength());


            Password passConfirm;
            do {
                  System.out.print("Confirm your password: ");
                  String passwordConfir = scnr.nextLine();
                  passConfirm = new Password(passwordConfir);
                  
            } while(pass.isEqual(passConfirm));


            ArrayList<String> questions = new ArrayList<String>();
            Question ques = new Question(questions);
            ques.ques();
            System.out.println("So now the computer will try to guess your password !!!!");
            System.out.println(questions.get(0));
            
            int num = validIntLength();
            
            for(int i = 0; i < num; i++){
                  CRACKED  += "*";
            }
            
            testPassword.testPasswordStrength(pass, "commonPasswords");
            System.out.println("Password cracked: " + CRACKED);
            
            testPassword.testPasswordStrengthInt(pass);
            
            
            System.out.println("Password cracked: " + CRACKED);

            



                

                
                
                

            

            //testPassword.testPasswordStrength(pass);

    



            

            
           

            
            
                  
        scnr.close();
      }

      public static int validIntLength(){
            Scanner scanner = new Scanner(System.in);
            String input;
            int num = -1;

            while (num < 0) {
                  System.out.print("Enter your answer: ");
                  input = scanner.nextLine();
                  
                  try {
                        num = Integer.parseInt(input);
                  } catch(NumberFormatException nfe) {
                        System.out.println("Please enter a number.");
                  }
            }
            return num; 
      }
    }


     


