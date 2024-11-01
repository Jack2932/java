package main;
import model.FamilyTree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();

        // Создаем людей
        Person jack = new Person("Jack", 1957);
        Person nally = new Person("Nally", 1958);
        Person jastin = new Person("Jastin", 1981);
// Устанавливаем родительские связи
        jastin.setMother(nally);
        jastin.setFather(jack);
        jack.addChild(jastin);
        nally.addChild(jastin);
// Добавляем людей в древо
        familyTree.addMember(jack);
        familyTree.addMember(nally);
        familyTree.addMember(jastin);
// Сортируем по имени
        System.out.println("Сортировка по имени:");
        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " +
                    person.getBirthYear());
        }
// Сортируем по дате рождения
        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthYear();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " +
                    person.getBirthYear());
        }
// Сохраняем генеалогическое древо в файл
        FileOperations<Person> fileOps = new FileOperationsImpl<>();
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("\nFamily tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
// Загружаем генеалогическое древо из файла
        FamilyTree<Person> loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("familyTree.dat");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
// Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            System.out.println("\nLoaded persons:");
            for (Person person : loadedFamilyTree) {
                System.out.println(person.getName() + ", born in " +
                        person.getBirthYear());
            }
        }
    }
}
