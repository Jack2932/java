package main;
import model.FamilyTree;
import model.Person;
import presenter.TreePresenter;
import service.FileOperationsImpl;
import view.ConsoleTreeView;
public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        ConsoleTreeView view = new ConsoleTreeView();
        FileOperationsImpl<Person> fileOperations = new
                FileOperationsImpl<>();
        TreePresenter presenter = new TreePresenter(familyTree,
                view, fileOperations);
        presenter.handleUserInput();
    }
}