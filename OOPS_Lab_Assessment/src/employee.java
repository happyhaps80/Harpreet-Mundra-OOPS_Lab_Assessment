import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class employee {
    String x, y;
    employee(String firstName, String lastName){
        this.x = firstName;
        this.y = lastName;
    }

    private static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    public static String generateEmailAddress(int x)
    {
        String firstName = "Harshit";
        String lastName = "choudary";
        employee obj = new employee(firstName, lastName);
        String email = obj.x + obj.y + "@";
        if(x==1){
            email = email + "tech";
        } else if (x==2) {
            email = email + "admin";
        } else if (x==3) {
            email = email + "hr";
        } else if (x==4) {
            email = email + "legal";
        }
        email = email + ".abc.com";
        return email;
    }

    public static void showCredentials(){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        String email = generateEmailAddress(x);
        System.out.println("Dear Harshit your generated credentials are as follows");
        System.out.println("Email --->" + email);
        String pass = String.valueOf(generatePassword(8));
        System.out.println("Password -->"+pass);
    }

    public static void main(String[] args) {
        System.out.println("Please enter the department from the following:");
        System.out.println("1. Technical\n2. Admin\n3. Human Resource\n4. Legal");
        showCredentials();
    }
}
