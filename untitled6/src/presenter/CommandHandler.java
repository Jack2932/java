package presenter;
import view.ConsoleTreeView;
public class CommandHandler {
    private TreePresenter presenter;
    private ConsoleTreeView view;
    public CommandHandler(TreePresenter presenter, ConsoleTreeView
            view) {
        this.presenter = presenter;
        this.view = view;
    }
    public void handleUserInput() {
        while (true) {
            view.displayMessage("Enter command (add, list, sortByName, sortByBirthYear, save, load, exit):");
            String command = view.getUserInput();
            presenter.handleCommand(command);
        }
    }
}
