/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.newdawn.slick.Animation;

public interface Bougeable {

    /**
     * gestion de la facon de bouger de l'objet
     */
    public void bouger();

    /**
     *
     * @return un objet de type Animation associé à l'image présentement
     * affichée
     */
    public Animation getAnimation();

    /**
     *
     * @return la position de l'objet en X
     */
    public int getX();

    /**
     *
     * @return la position de l'objet en Y
     */
    public int getY();

    /**
     *
     * @return Rectangle associé au contour de l'image de l'objet
     */
    public FakeRectangle getRectangle();

    /**
     * gestion de l'effet de la gravité sur l'objet
     */
    public void gravity();

    /**
     *
     * @param y la position en Y de l'objet
     */
    public void setY(int y);

    /**
     *
     * @param x position en X de l'objet
     */
    public void setX(int x);

    /**
     *
     * @return Boolean si l'objet est déplaaceable
     */
    public boolean isBougeable();

    /**
     *
     * @param aTerre Boolean si l'objet est a terre ou pas
     */
    public void setATerre(boolean aTerre);
}
