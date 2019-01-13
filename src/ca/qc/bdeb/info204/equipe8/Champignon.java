/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Champignon implements Bougeable {

    private int x, y, vitesseX;
    private boolean goingRight = true, bougeable, aTerre = false;
    private SpriteSheet spriteSheet;
    private Animation[] animations = new Animation[2];
    private int timeSpawn;
    private WindowGame1 wg1;
    private WindowGame2 wg2;
    private FakeRectangle rectangle;
    private Main main;

    /**
     *
     * @param x position initiale en X
     * @param y position initiale en Y
     * @param timeSpawn le temps pour apparaitre lorsque activé
     * @param wg1 fenetre de la map 1
     * @param wg2 fenetre de la map 2
     * @param main la classe Main
     */
    public Champignon(int x, int y, int timeSpawn, WindowGame1 wg1, WindowGame2 wg2, Main main) {
        rectangle = new FakeRectangle(x, y, 16, 16);
        this.x = x;
        this.main = main;
        this.y = y;
        this.wg1 = wg1;
        this.wg2 = wg2;
        try {
            spriteSheet = new SpriteSheet("sprites/champignon.gif", 16, 16);
        } catch (SlickException e) {
        }
        this.timeSpawn = timeSpawn;
        fillAnimations();

    }

    /**
     *
     * @return un objet Animation associé au sprite affiché à ce moment
     */
    public Animation getAnimation() {
        if (main.getMapChoisie() == 1) {
            if ((wg1.getTimer() - timeSpawn) <= 90) {
                return animations[0];
            } else {
                bougeable = true;
                return animations[1];
            }
        } else {
            if ((wg2.getTimer() - timeSpawn) <= 90) {
                return animations[0];
            } else {
                bougeable = true;
                return animations[1];
            }
        }
    }

    /**
     *
     * @return true si va vers la droite, false si va vers la gauche
     */
    public boolean isGoingRight() {
        return goingRight;
    }

    /**
     *
     * @param aTerre Boolean si est à terre ou pas
     */
    public void setATerre(boolean aTerre) {
        this.aTerre = aTerre;
    }

    /**
     * @see ca.qc.bdeb.info204.equipe8.Bougeable
     */
    public void bouger() {
        if (bougeable && aTerre) {
            if (isGoingRight()) {
                vitesseX = 1;
            } else {
                vitesseX = -1;
            }
        }
        x = x + vitesseX;
        rectangle.setX(x);
    }

    /**
     * change la direction de déplacement
     */
    public void changerDirection() {
        goingRight = !goingRight;
    }

    /**
     *
     * @return position en Y
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return position en X
     */
    public int getX() {
        return x;
    }

    /**
     * @see ca.qc.bdeb.info204.equipe8.Bougeable
     */
    public void gravity() {
        if (!aTerre && bougeable) {
            setY(y + 1);
        }
    }

    /**
     * @see ca.qc.bdeb.info204.equipe8.Bougeable
     * @return
     */
    public boolean isBougeable() {
        return bougeable;
    }

    /**
     * @see ca.qc.bdeb.info204.equipe8.Bougeable
     * @param y
     */
    public void setY(int y) {
        this.y = y;
        rectangle.setY(y);
    }

    /**
     * change si l'objet est à terre ou pas
     *
     * @param aTerre Boolean si l'objet est à terre
     */
    public void setaTerre(boolean aTerre) {
        this.aTerre = aTerre;
    }

    /**
     * @see ca.qc.bdeb.info204.equipe8.Bougeable
     * @param x
     */
    public void setX(int x) {
        this.x = x;
        rectangle.setX(x);
    }

    private void fillAnimations() {
        Animation animation = new Animation();
        animation.addFrame(spriteSheet.getSubImage(1, 0), 500);
        animation.addFrame(spriteSheet.getSubImage(2, 0), 500);
        animations[0] = animation;
        Animation animation2 = new Animation();
        animation2.addFrame(spriteSheet.getSubImage(0, 0), 100);
        animations[1] = animation2;

    }

    /**
     * @see ca.qc.bdeb.info204.equipe8.Bougeable
     * @return
     */
    @Override
    public FakeRectangle getRectangle() {
        return rectangle;
    }

}
