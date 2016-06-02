package animations;

import biuoop.DrawSurface;
import interfaces.Animation;
import scores.HighScoresTable;
import shapes.Point;
import sprites.Background;
import sprites.Crown;
import sprites.Square;
import sprites.Text;

import java.awt.Color;

/**
 * @author Raziel Solomon
 * @since 01-Jun-16.
 */
public class HighScoresAnimation implements Animation {
    private HighScoresTable highScores;

    public HighScoresAnimation(HighScoresTable highScores) {
        this.highScores = highScores;
    }

    /**
     * draw one frame.
     *
     * @param d  a drawsurface.
     * @param dt seconds passed.
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        drawBackGround(d);
    }

    private void drawBackGround(DrawSurface d) {
        Background b = new Background();
        Color backColor = Color.RED;

        //crown
        Color cBody = new Color(253, 244, 27);
        Color cScnd = new Color(253, 83, 64);
        Color cBody2 = new Color(253, 185, 73);

        b.addElement(new Square(new Point(0, 0), d.getWidth(), d.getHeight(), Color.RED));
        b.addElement(new Crown(cBody, cScnd, backColor, new Point(d.getWidth() / 2 - 245, 30), 90, 45));
        b.addElement(new Crown(cBody, cScnd, backColor, new Point(d.getWidth() / 2 + 155, 30), 90, 45));
        b.addElement(new Text(Color.YELLOW, new Point(d.getWidth() / 2 - 135, 70), "High Scores", 50));

        Color blockColor = cBody;
        int width = 490;
        int height = 80;
        int x = d.getWidth() / 2 - width / 2;
        int y = 100;

        for (int i = 0; i < highScores.numOfScores(); i++) {
            b.addElement(new Square(new Point(x, y), width, height, blockColor));
            b.addElement(new Text(Color.BLACK, new Point(x + 20, y + 50),
                    highScores.get(i).getName(), 35));
            b.addElement(new Text(Color.BLACK, new Point(x + 300, y + 50),
                    "" + highScores.get(i).getScore(), 35));
            y += height + 5;

            if (i % 2 == 0) {
                blockColor = cBody2;
            } else {
                blockColor = cBody;
            }
        }

        b.drawOn(d);
    }

    /**
     * returns whether turn should stop.
     *
     * @return whether turn should stop.
     */
    @Override
    public boolean shouldStop() {
        return true;
    }
}
