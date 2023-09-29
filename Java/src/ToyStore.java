import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public Toy getPrizeToy() {
        Toy prizeToy = getRandomToy();
        toys.remove(prizeToy);
        decreaseQuantity(prizeToy);
        saveToFile(prizeToy);
        return prizeToy;
    }

    private Toy getRandomToy() {
        double totalFrequency = 0;
        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }

        double randomValue = Math.random() * totalFrequency;
        double cumulativeFrequency = 0;

        for (Toy toy : toys) {
            cumulativeFrequency += toy.getFrequency();
            if (randomValue <= cumulativeFrequency) {
                return toy;
            }
        }

        // Этого не должно произойти, но в случае ошибки верните первую игрушку.
        return toys.get(0);
    }

    private void decreaseQuantity(Toy toy) {
        toy.quantity--;
    }

    private void saveToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write(toy.getName() + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
        }
    }
}