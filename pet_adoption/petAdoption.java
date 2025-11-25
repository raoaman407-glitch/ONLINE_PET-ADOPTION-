import core.Pet;
import core.User;
import core.Adopter;
import core.Shelter;
import core.NotificationThread;
import database.PetDAO;
import database.UserDAO;

public class petAdoption {
    public static void main(String[] args) {

        // Using DAO for database operations
        PetDAO petDAO = new PetDAO();
        UserDAO userDAO = new UserDAO();

        // Creating Users
        User adopter = new Adopter("Rahul", "rahul@example.com");
        User shelter = new Shelter("Happy Paws Shelter", "shelter@gmail.com");

        // Adding Users to DAO
        userDAO.add(adopter);
        userDAO.add(shelter);

        // Creating Pets
        Pet pet1 = new Pet(101, "Tommy", "Dog", "Available");
        Pet pet2 = new Pet(102, "Milo", "Cat", "Available");

        // Adding Pets to DAO
        petDAO.add(pet1);
        petDAO.add(pet2);

        // Show Data from DAO
        System.out.println("\n=== Users in System ===");
        for (User u : userDAO.getAllUsers()) {
            u.showDetails();
        }

        System.out.println("\n=== Pets in System ===");
        for (Pet p : petDAO.getAllPets()) {
            p.showPetDetails();
        }

        // Adoption simulation
        ((Adopter) adopter).applyForPet(pet1);
        ((Shelter) shelter).listPet(pet1);

        // Notification Thread Start
        NotificationThread t = new NotificationThread("Pet Adoption Request Received");
        t.start();
    }
}



