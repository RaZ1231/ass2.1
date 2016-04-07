package tests;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import com.sun.deploy.util.ArrayUtil;
import motion.Velocity;
import org.junit.Test;
import shapes.Ball;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Elisheva
 * @since 05/04/2016.
 */
public class RectangleTest {

    @Test
    public void fourLines() throws Exception {
        List<Rectangle> rects = new ArrayList<>();
        List<Line> lines = new ArrayList<>();


        for(int i=20;i<100;i+=20){
            for(int j=20;j<260;j+=30){
                rects.add(new Rectangle(j,i,30,20));
            }
        }

        for (Rectangle rect : rects) {
            Collections.addAll(lines, rect.fourLines());
        }

        Ball ball = new Ball(0, 0, 5, Color.MAGENTA, null);
        ball.setVelocity(new Velocity(3, 1));
        Point start, end;

        for (int i = 0; i < 300; i++) {
            start = ball.getCenter();
            ball.moveOneStep();
            end = ball.getCenter();
            lines.add(new Line(start, end));
        }

        GUI gui = new GUI("Arkanoid", 300, 300);
        DrawSurface d = gui.getDrawSurface();
        for (Line line : lines) {
            line.drawOn(d);
        }

        d.setColor(Color.RED);
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 1; j < lines.size(); j++) {
                if (lines.get(i).isIntersecting(lines.get(j))) {
                    lines.get(i).intersectionWith(lines.get(j)).drawOn(d, 3);
                }
            }
        }
        gui.show(d);

        Sleeper sleep = new Sleeper();
        sleep.sleepFor(999999999);
    }
}