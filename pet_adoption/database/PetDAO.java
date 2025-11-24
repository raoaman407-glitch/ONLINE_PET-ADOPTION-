package database;

import java.util.ArrayList;
import core.Pet;

public class PetDAO implements DatabaseOperations<Pet> {

    private ArrayList<Pet> petList = new ArrayList<>();

    @Override
    public void add(Pet pet) {
        petList.add(pet);
        System.out.println("Pet added: " + pet);
    }

    @Override
    public void update(Pet updatedPet) {
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getId() == updatedPet.getId()) {
                petList.set(i, updatedPet);
                System.out.println("Pet Updated Successfully!");
                return;
            }
        }
        System.out.println("Pet Not Found!");
    }

    @Override
    public void delete(int id) {
        petList.removeIf(p -> p.getId() == id);
        System.out.println("Pet Deleted Successfully!");
    }

    @Override
    public Pet getById(int id) {
        for (Pet p : petList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Pet> getAllPets() {
        return petList;
    }
}

