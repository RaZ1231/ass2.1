package scores;

import biuoop.DialogManager;
import biuoop.GUI;

/**
 * Add new high score.
 *
 * @author Raziel Solomon
 * @since 02-Jun-16.
 */
public class NewHighScore {
    private GUI gui;
    private String pName;

    /**
     * constructor.
     *
     * @param gui game gui
     */
    public NewHighScore(GUI gui) {
        this.gui = gui;
        pName = "";
    }

    /**
     * shows add high score dialog.
     */
    public void showDialog() {
        DialogManager dialog = gui.getDialogManager();
        String name = dialog.showQuestionDialog("Name", "What is your name?", "");

        //length fix
        if (name.length() > 16) {
            pName = name.substring(0, 13) + "...";
        } else {
            pName = name;
        }
    }


    /**
     * name getter.
     *
     * @return name
     */
    public String getpName() {
        return pName;
    }
}
