public class ToyStoreGiveaway {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавление игрушки в магазин
        toyStore.addToy(new Toy(1, "Игрушка1", 10, 25));
        toyStore.addToy(new Toy(2, "Игрушка2", 5, 15));
        toyStore.addToy(new Toy(3, "Игрушка3", 8, 10));
        toyStore.addToy(new Toy(4, "Игрушка4", 3, 5));

        // Получение призовой игрушки и сохранение в файл.
        Toy prizeToy = toyStore.getPrizeToy();
        System.out.println("Призовая игрушка: " + prizeToy.getName());

        // Проверка количества после получения призовой игрушки
        System.out.println("Количество " + prizeToy.getName() + ": " + prizeToy.getQuantity());
    }
}