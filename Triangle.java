/**
 * Created by Hanen Borchani on 22-09-2016.
 */
import java.util.*;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class determines whether a triangle is valid, and if so, provides its type,
 * namely equilateral, isosceles or scalene based on the lengths of its three sides.
 */
public class Triangle {

    // Check if the three side lengths can make a valid triangle
    public static boolean validTriangle(double s1, double s2, double s3) {
        if (s1 <= 0 || s2 <= 0 || s3 <= 0){
            return false;
        }else if ((s1 + s2 <= s3) || (s1 +s3 <= s2) || (s2 +s3 <= s1)){
            return false;
        }else{
            return true;
        }
    }

    // Return the type of the triangle: equilateral, isosceles or scalene
    public static String typeTriangle(double s1 , double s2, double s3) {
        if (validTriangle(s1,s2,s3)) {
            if (s1 == s2 && s1 == s3) {
                return "equilateral";    /* The three side lengths are equal */
            }
            else if ((s1 == s2)||(s1 == s3)||(s2 == s3)) {
                return "isosceles";      /* Only two side lengths are equal */
            }
            else {
                return "scalene";        /* The three side lengths are not equal */
            }
        }else{
            return "invalid";
        }
    }

    public static void main (String args[]) throws IOException, InputMismatchException {
        System.out.println("\t --- Please enter the triangle's side lengths ---");
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        try {
            System.out.println("First side length:");
            double s1 = input.nextDouble();
            System.out.println("Second side length:");
            double s2 = input.nextDouble();
            System.out.println("Third side length:");
            double s3 = input.nextDouble();
            System.out.println("\t ----- Result: This triangle is " + typeTriangle(s1,s2,s3) + " -----");
        } catch (InputMismatchException e) {
            System.out.println("\n Error! Please enter a valid positive number for the triangle's side length.");
        }
    }
}