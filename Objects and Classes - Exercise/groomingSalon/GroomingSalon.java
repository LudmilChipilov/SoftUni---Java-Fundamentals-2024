package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon
{
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity)
    {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet)
    {
        if(data.size() < capacity)
        {
            data.add(pet);
        }
    }
    public boolean remove(String name)
    {
        Pet pet = this.data.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        return data.remove(pet);
    }
    public Pet getPet(String name, String owner)
    {
        Pet pet = this.data.stream().filter(x -> x.getName().equals(name) && x.getOwner().equals(owner)).findFirst().orElse(null);
        return pet;
    }
    public int getCount()
    {
        return data.size();
    }
    public String getStatistics()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The grooming salon has the following clients:%n"));
        for(Pet pet : data)
        {
            sb.append(String.format("%s %s%n", pet.getName(), pet.getOwner()));
        }
        return sb.toString().trim();
    }
}
