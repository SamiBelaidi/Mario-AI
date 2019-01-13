/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Coin {

    private Animation animation = new Animation();
    private FakeRectangle rectangle;
    private int x, y;

    JFrame f = new JFrame("Animation");

    /**
     *
     * @param x position initial en X
     * @param y position initiale en Y
     * @throws SlickException
     */
    public Coin(int x, int y) throws SlickException {
        rectangle = new FakeRectangle(x * 16, y * 16, 16, 16);
        this.x = x * 16;
        this.y = y * 16;
        initialiserAnimation();
    }

    /**
     *
     * @return position en Y
     */
    public int getY() {
        return y;
    }

    private void initialiserAnimation() throws SlickException {
        animation.addFrame(new Image("Images/coin0.gif"), 100);
        animation.addFrame(new Image("Images/coin1.gif"), 100);
        animation.addFrame(new Image("Images/coin2.gif"), 100);
        animation.addFrame(new Image("Images/coin3.gif"), 100);
    }

    /**
     *
     * @return un objet de type Animation associé à l'image présentement
     * affichée
     */
    public Animation getAnimation() {
        return animation;
    }

    /**
     *
     * @return position en X
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return Rectangle associé au contour de l'image de l'objet
     */
    public FakeRectangle getRectangle() {
        return rectangle;
    }

    /**
     *
     * @param x position en X
     */
    public void setX(int x) {
        this.x = x;
    }

}
