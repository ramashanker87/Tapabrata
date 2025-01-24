package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void validate(int age) throws TapabrataException{
        if (age != 23){
            throw new TapabrataException("This is not his correct age");
        }
        else{
            System.out.println("Yes this is correct");
        }
    }


    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Tapabrata,s age: ");
        int a = sc.nextInt();
        try{
            validate(a);
        } catch(TapabrataException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Invalid Input");
        }
    }
}
