package dataStructuresArraysAndLists;

import java.util.*;

class Camera {
    private String brand;
    private String model;
    private double rentalAmount;

    public Camera(String brand, String model, double rentalAmount) {
        this.brand = brand;
        this.model = model;
        this.rentalAmount = rentalAmount;
    }

    public String getDetails() {
        return "Brand: " + brand + ", Model: " + model + ", Rental Amount: $" + rentalAmount;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }
}

class User {
    private double walletAmount;

    public User() {
        this.walletAmount = 0.0;
    }

    public void addWalletAmount(double amount) {
        this.walletAmount += amount;
    }

    public double getWalletAmount() {
        return walletAmount;
    }
}

public class CameraRentalApp {
    private static List<Camera> cameras = new ArrayList<>();
    private static User user = new User();

    public static void main(String[] args) {
        initializeCameras();
        showWelcomeScreen();
    }

    private static void initializeCameras() {
        cameras.add(new Camera("Canon", "EOS 5D Mark IV", 50.0));
        cameras.add(new Camera("Nikon", "D850", 55.0));
        cameras.add(new Camera("Sony", "Alpha A7 III", 60.0));
    }

    private static void showWelcomeScreen() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to rentmycam.io");
            System.out.println("Developer: Shubham\n");

            System.out.println("Options:");
            System.out.println("1. List Cameras");
            System.out.println("2. Rent a Camera");
            System.out.println("3. Add/View Wallet Amount");
            System.out.println("4. Navigate to Main Context");
            System.out.println("5. Close Application");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listCameras();
                    break;
                case 2:
                    rentCamera();
                    break;
                case 3:
                    manageWallet();
                    break;
                case 4:
                    System.out.println("Navigating to Main Context...");
                    break;
                case 5:
                    System.out.println("Closing the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listCameras() {
        System.out.println("Available Cameras:");
        for (int i = 0; i < cameras.size(); i++) {
            System.out.println((i + 1) + ". " + cameras.get(i).getDetails());
        }
    }

    private static void rentCamera() {
        Scanner scanner = new Scanner(System.in);
        listCameras();

        System.out.print("Enter the camera number to rent: ");
        int cameraNumber = scanner.nextInt();

        if (cameraNumber >= 1 && cameraNumber <= cameras.size()) {
            Camera selectedCamera = cameras.get(cameraNumber - 1);
            System.out.println("Selected Camera: " + selectedCamera.getDetails());

            System.out.print("Enter the rental duration (in days): ");
            int rentalDays = scanner.nextInt();

            double totalAmount = rentalDays * selectedCamera.getRentalAmount();
            System.out.println("Total Rental Amount: $" + totalAmount);

            if (user.getWalletAmount() >= totalAmount) {
                user.addWalletAmount(-totalAmount);
                System.out.println("Camera rented successfully!");
            } else {
                System.out.println("Insufficient funds in the wallet. Please add money.");
            }
        } else {
            System.out.println("Invalid camera number. Please try again.");
        }
    }

    private static void manageWallet() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wallet Amount: $" + user.getWalletAmount());
        System.out.println("Options:");
        System.out.println("1. Add Money to Wallet");
        System.out.println("2. View Wallet Amount");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the amount to add to the wallet: $");
                double amountToAdd = scanner.nextDouble();
                user.addWalletAmount(amountToAdd);
                System.out.println("Money added to the wallet successfully!");
                break;
            case 2:
                System.out.println("Current Wallet Amount: $" + user.getWalletAmount());
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

