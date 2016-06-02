package scores;

import biuoop.DialogManager;
import biuoop.GUI;

/**
 * @author Raziel Solomon
 * @since 02-Jun-16.
 */
public class NewHighScore {
    GUI gui;
    private String pName;

    public NewHighScore(GUI gui) {
        this.gui = gui;
        pName = "";
    }

    public void showDialog() {
        DialogManager dialog = gui.getDialogManager();
        String name = dialog.showQuestionDialog("Name", "What is your name?", "");
        pName = name;
    }


    public String getpName() {
        return pName;
    }
}
