public class Dog {
    int size;
    String breed;
    String name;

    void bark() {
        //int forBreed = Integer.parseInt(breed);
        for (int i = 0; i < size; i++) {
            int breedCount = i + 1;
            if (breedCount % 4 == 0) {
                System.out.println(breed + " say: Ruff! Ruff! " + breedCount + " time");
            }
        }
        System.out.println("Yes. This is " + name + "!");
    }
}
