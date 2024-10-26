import java.util.ArrayList;
import java.util.List;
// Класс, представляющий человека
class Person {
    private String name;
    private int birthYear;
    private Person mother;
    private Person father;
    private List<Person> children;
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }
    public void setFather(Person father) {
        this.father = father;
    }
    public void addChild(Person child) {
        this.children.add(child);
    }
    public List<Person> getChildren() {
        return children;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }
}
// Класс для работы с генеалогическим древом
class FamilyTree {
    private List<Person> people;
    public FamilyTree() {
        this.people = new ArrayList<>();
    }
    public void addPerson(Person person) {
        this.people.add(person);
    }
    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }
    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        
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
        familyTree.addPerson(jack);
        familyTree.addPerson(nally);
        familyTree.addPerson(jastin);
// Пример получения всех детей Джона
        List<Person> jackChildren = familyTree.getChildren(jack);
        for (Person child : jackChildren) {
            System.out.println("jack's child: " + child.getName());
        }
    }
}