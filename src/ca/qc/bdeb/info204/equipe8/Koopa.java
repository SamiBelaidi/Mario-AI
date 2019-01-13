/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

@Deprecated
public class Koopa implements Bougeable {

    /*
    animation 0 > marche droite
    animation1 > marche gauche
    animation 2 > broken immobile
    animation 3> broken mobile
     */
    private int x, y, vitesseX;
    private boolean goingRight;
    private Animation[] animations = new Animation[4];
    private boolean isBroken, isMoving;
    private SpriteSheet spriteSheetRight, spriteSheetLeft;
    private int xMax;
    private FakeRectangle rectangle;

    /**
     *
     * @param x
     * @param y
     * @param xMax deplacement max en X
     * @throws SlickException
     */
    public Koopa(int x, int y, int xMax) throws SlickException {
        this.x = x;
        this.y = y;
        rectangle = new FakeRectangle(x, y, 16, 16);
        this.xMax = xMax;
        spriteSheetRight = new SpriteSheet("sprites/koopaRight.gif", 16, 16);
        spriteSheetLeft = new SpriteSheet("sprite/koopaLeft.gif", 16, 16);
        fillAnimations();
    }

    private void fillAnimations() {
        Animation animation = new Animation();
        animation.addFrame(spriteSheetRight.getSubImage(5, 0), 100);
        animation.addFrame(spriteSheetRight.getSubImage(4, 0), 100);
        animation.addFrame(spriteSheetRight.getSubImage(3, 0), 100);
        animation.addFrame(spriteSheetRight.getSubImage(2, 0), 100);
        animations[0] = animation;
        Animation animation2 = new Animation();
        animation.addFrame(spriteSheetLeft.getSubImage(0, 0), 100);
        animation.addFrame(spriteSheetLeft.getSubImage(1, 0), 100);
        animation.addFrame(spriteSheetLeft.getSubImage(2, 0), 100);
        animation.addFrame(spriteSheetLeft.getSubImage(3, 0), 100);
        animations[1] = animation2;
        Animation animation3 = new Animation();
        animation3.addFrame(spriteSheetRight.getSubImage(0, 0), 100);
        animations[2] = animation3;
        Animation animation4 = new Animation();
        animation4.addFrame(spriteSheetRight.getSubImage(0, 0), 100);
        animation4.addFrame(spriteSheetRight.getSubImage(1, 0), 100);
        animations[3] = animation4;
    }

    /**
     * gestion du deplacement
     */
    @Override
    public void bouger() {
        if (x < xMax) {
            x++;
        } else {
            x--;
        }
        rectangle.setX(x);
    }

    /**
     *
     * @return
     */
    @Override
    public Animation getAnimation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public FakeRectangle getRectangle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @Override
    public void gravity() {
    }

    /**
     *
     * @param y
     */
    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isBougeable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param x
     */
    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param aTerre
     */
    @Override
    public void setATerre(boolean aTerre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
