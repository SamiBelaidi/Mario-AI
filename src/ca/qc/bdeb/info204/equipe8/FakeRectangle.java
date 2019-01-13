/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.newdawn.slick.geom.Rectangle;

public class FakeRectangle extends Rectangle {

    /**
     *
     * @param x position initiale en X
     * @param y position initiale en Y
     * @param w largeur
     * @param h hauteur
     */
    public FakeRectangle(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    /**
     *
     * @return limites du rectangle avec les librairies de Java
     */
    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public String toString() {
        return "X = " + x + " y = " + y;
    }

}
