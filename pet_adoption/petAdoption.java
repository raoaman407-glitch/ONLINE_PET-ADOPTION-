import core.Pet;
import core.User;
import core.Adopter;
import core.Admin;
import core.NotificationThread;
import core.Shelter;

public class petAdoption {
    public static void main(String[] args) {

        // Create Shelter
        Shelter shelter = new Shelter("Happy Paws Shelter", "Delhi");

        // Create Pets
        Pet p1 = new Pet(101, "Tommy", "Dog", "Available");
        Pet p2 = new Pet(102, "Lucy", "Cat", "Available");

        // Create Adopter
        Adopter adopter = new Adopter("Rahul", "rahul@example.com");

        // Create Admin
        Admin admin = new Admin("Priya", "priya@admin.com");

        // Display Data
        System.out.println("\n=== Shelter Details ===");
        shelter.showDetails();

        System.out.println("\n=== Pets Available ===");
        p1.showPetDetails();
        p2.showPetDetails();

        System.out.println("\n=== Users in System ===");
        adopter.showDetails();
        admin.showDetails();

        // Adopter applies for a pet
        adopter.applyForPet(p1);

        // Admin approves
        admin.approvePet(p1);

        // Notification Thread
        NotificationThread notification =
                new NotificationThread("Your adoption request for " + p1.getName() + " has been approved!");
        notification.start();
    }
}


