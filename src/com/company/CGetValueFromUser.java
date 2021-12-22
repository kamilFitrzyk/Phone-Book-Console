package com.company;

import java.util.Scanner;

public class CGetValueFromUser {

    private static final Scanner scan = new Scanner(System.in);

    public CGetValueFromUser() {
    }

    public int getIntFromConsole(String title) throws InterruptedException {

        int number = 0;
        Boolean correct = true;

        do {
            System.out.println(title);
            String text = scan.nextLine();
            try {
                number = Integer.parseInt(text);
                correct = true;
            } catch (NumberFormatException e) {
                System.out.println(CConfig.badValue);
                Thread.sleep(1500);
                correct = false;
            }
        }while (correct != true);

        return number;
    }

    public String getStringFromConsole(String title) throws InterruptedException {

        Boolean correct = true;
        String text="";

        do {
            try {
                System.out.println(title);
                text = scan.nextLine();
                correct = true;
            } catch (Exception e) {
                System.out.println(CConfig.badValue);
                Thread.sleep(1500);
                correct = false;
            }
        }while (correct != true);

        return text;
    }




}
