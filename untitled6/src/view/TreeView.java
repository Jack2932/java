package view;
import model.Person;
import presenter.TreePresenter;

import java.util.List;
public interface TreeView extends MessageView, PersonView, InputView
{
    void setPresenter(TreePresenter presenter);
}
