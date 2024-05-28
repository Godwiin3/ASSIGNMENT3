package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) {
        UserService userService = new UserService("data.txt");
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 5 && !loggedIn) {
            System.out.print("Enter your email: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            User user = userService.validateLogin(username, password);
            if (user != null) {
                System.out.println("Welcome " + user.getName());
                loggedIn = true;
            } else {
                attempts++;
                if (attempts < 5) {
                    System.out.println("Invalid login, please try again.");
                }
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }

        scanner.close();
    }
}
