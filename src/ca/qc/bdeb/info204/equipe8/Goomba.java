package ca.qc.bdeb.info204.equipe8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Goomba {

    private int compteur;
    private int x, y, vitesseX;
    private Animation[] animations = new Animation[3];
    private boolean isDead = false;
    private SpriteSheet spriteSheet, spriteSheetVide;
    private int xMax;
    private boolean ecrase;
    private int xMin;
    private FakeRectangle rectangle;
    private WindowGame1 wg1;
    private int timerEcrase;
    private WindowGame2 wg2;
    private Main main;

    /**
     *
     * @param x position initiale en X
     * @param y position initiale en Y
     * @param xMax limites de déplacement en X
     * @param wg1 fenetre de jeu 1
     * @param wg2 fenetre de jeu 2
     * @param main classe Main
     * @throws SlickException
     */
    public Goomba(int x, int y, int xMax, WindowGame1 wg1, WindowGame2 wg2, Main main) throws SlickException {
        this.main = main;
        this.x = x;
        this.y = y;
        this.wg2 = wg2;
        xMin = x;
        this.wg1 = wg1;
        rectangle = new FakeRectangle(x, y, 16, 16);
        this.xMax = xMax;
        spriteSheet = new SpriteSheet("sprites/woomba.gif", 16, 16);
        spriteSheetVide = new SpriteSheet("sprites/vide.gif", 16, 16);
        fillAnimations();
    }

    /**
     * instancie les animations
     */
    public void fillAnimations() {
        Animation animation = new Animation();
        animation.addFrame(spriteSheet.getSubImage(0, 0), 100);
        animation.addFrame(spriteSheet.getSubImage(1, 0), 100);
        animations[0] = animation;
        Animation animation2 = new Animation();
        animation2.addFrame(spriteSheet.getSubImage(2, 0), 100);
        animations[1] = animation2;
        Animation animation3 = new Animation();
        animation3.addFrame(spriteSheetVide.getSubImage(0, 0), 100);
        animations[2] = animation3;
    }

    /**
     * gere le deplacment de l'objet
     */
    public void bouger() {
        if (x == xMin) {
            vitesseX = 1;
        } else if (x == xMax) {
            vitesseX = -1;
        }
        if (!ecrase) {
            x = x + vitesseX;
            rectangle.setX(x);
        }
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
     * @return Boolean si mario a sauté dessus
     */
    public boolean isEcrase() {
        return ecrase;
    }

    /**
     *
     * @param ecrase ecrase le Goomba
     */
    public void setEcrase(boolean ecrase) {
        if (ecrase) {
            if (main.getMapChoisie() == 1) {
                timerEcrase = wg1.getTimer();
            } else {
                timerEcrase = wg2.getTimer();
            }
        }
        this.ecrase = ecrase;
    }

    /**
     *
     * @param x la position en X
     */
    public void setX(int x) {
        this.x = x;
        rectangle.setX(x);
    }

    /**
     *
     * @param xMax le deplacement maximal en X
     */
    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    /**
     *
     * @param xMinle deplacement minimal en X ou la position initiale de l,objet
     */
    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    /**
     *
     * @return
     */
    public int getxMin() {
        return xMin;
    }

    /**
     *
     * @return
     */
    public int getxMax() {
        return xMax;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return
     */
    public FakeRectangle getRectangle() {
        return rectangle;
    }

    /**
     *
     * @return l'animation actuellement affichée
     */
    public Animation getAnimation() {
        if (main.getMapChoisie() == 1) {
            if (!ecrase) {
                return animations[0];
            } else if ((wg1.getTimer() - timerEcrase) < 40) {
                return animations[1];
            } else {
                return animations[2];
            }
        } else {
            if (!ecrase) {
                return animations[0];
            } else if ((wg2.getTimer() - timerEcrase) < 40) {
                return animations[1];
            } else {
                return animations[2];
            }
        }
    }
}
