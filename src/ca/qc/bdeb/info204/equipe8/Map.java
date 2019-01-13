/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import java.io.IOException;
import java.util.ArrayList;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map extends TiledMap {

    private int renderX = 0, renderY = 0;
    private WindowGame1 wg1;
    private ArrayList<Coin> listeCoins = new ArrayList();
    private WindowGame2 wg2;
    private Main main;

    /**
     *
     * @param ref
     * @param wg1 fenetre de jeu 1
     * @param wg2 fenetre de jeu 2
     * @param main la classe Main
     * @throws SlickException
     */
    public Map(String ref, WindowGame1 wg1, WindowGame2 wg2, Main main) throws SlickException {
        super(ref);
        this.main = main;
        this.wg1 = wg1;
        this.wg2 = wg2;
        fillListCoins();
    }

    /**
     *
     * @return la liste des pieces
     */
    public ArrayList<Coin> getListeCoins() {
        return listeCoins;
    }

    /**
     * instancie les pieces
     *
     * @throws SlickException
     */
    public void fillListCoins() throws SlickException {
        if (main.getMapChoisie() == 1) {
            Coin coin = new Coin(18, 9);
            Coin coin1 = new Coin(22, 9);
            Coin coin2 = new Coin(78, 5);
            Coin coin3 = new Coin(80, 5);
            Coin coin4 = new Coin(84, 5);
            Coin coin5 = new Coin(91, 9);
            Coin coin6 = new Coin(97, 9);
            Coin coin7 = new Coin(115, 9);
            Coin coin8 = new Coin(119, 5);
            Coin coin9 = new Coin(126, 5);
            Coin coin10 = new Coin(165, 9);

            listeCoins.add(coin);
            listeCoins.add(coin1);
            listeCoins.add(coin2);
            listeCoins.add(coin3);
            listeCoins.add(coin4);
            listeCoins.add(coin5);
            listeCoins.add(coin6);
            listeCoins.add(coin7);
            listeCoins.add(coin8);
            listeCoins.add(coin9);
            listeCoins.add(coin10);
        } else if (main.getMapChoisie() == 2) {
            Coin coin = new Coin(11, 13);
            Coin coin1 = new Coin(36, 13);
            Coin coin2 = new Coin(44, 13);
            Coin coin3 = new Coin(54, 13);
            Coin coin4 = new Coin(55, 13);
            Coin coin5 = new Coin(74, 13);
            Coin coin6 = new Coin(89, 13);
            Coin coin7 = new Coin(128, 13);
            Coin coin8 = new Coin(129, 13);

            listeCoins.add(coin);
            listeCoins.add(coin1);
            listeCoins.add(coin2);
            listeCoins.add(coin3);
            listeCoins.add(coin4);
            listeCoins.add(coin5);
            listeCoins.add(coin6);
            listeCoins.add(coin7);
            listeCoins.add(coin8);

        }
    }

    /**
     *
     * @param renderX position a gauche de la fenetre affichée
     */
    public void setRenderX(int renderX) {
        this.renderX = renderX;
    }

    /**
     *
     * @return position a gauche de la fenetre affichée
     */
    public int getRenderX() {
        return renderX;
    }

    /**
     *
     * @return position en haut de la fenetre affichée
     */
    public int getRenderY() {
        return renderY;
    }

    /**
     *
     * @return largeur de la fenetre affichée
     */
    @Override
    public int getWidth() {
        return super.getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * gestion du deplacement
     */
    public void avancer() {
        if (main.getMapChoisie() == 1) {
            renderX -= 1;
            for (int i = 0; i < wg1.getListeObjets().size(); i++) {
                for (int j = 0; j < wg1.getListeObjets().get(i).size(); j++) {
                    wg1.getListeObjets().get(i).get(j).setX(wg1.getListeObjets().get(i).get(j).getX() - 1);
                }
            }
            for (int i = 0; i < wg1.getListeWombas().size(); i++) {
                wg1.getListeWombas().get(i).setX(wg1.getListeWombas().get(i).getX() - 1);
                wg1.getListeWombas().get(i).setxMax(wg1.getListeWombas().get(i).getxMax() - 1);
                wg1.getListeWombas().get(i).setxMin(wg1.getListeWombas().get(i).getxMin() - 1);
            }
            for (int i = 0; i < listeCoins.size(); i++) {
                listeCoins.get(i).setX(listeCoins.get(i).getX() - 1);
                listeCoins.get(i).getRectangle().setX(listeCoins.get(i).getRectangle().getX() - 1);
            }
        } else if (main.getMapChoisie() == 2) {
            renderX -= 1;
            for (int i = 0; i < wg2.getListeObjets().size(); i++) {
                for (int j = 0; j < wg2.getListeObjets().get(i).size(); j++) {
                    wg2.getListeObjets().get(i).get(j).setX(wg2.getListeObjets().get(i).get(j).getX() - 1);
                }
            }
            for (int i = 0; i < wg2.getListeWombas().size(); i++) {
                wg2.getListeWombas().get(i).setX(wg2.getListeWombas().get(i).getX() - 1);
                wg2.getListeWombas().get(i).setxMax(wg2.getListeWombas().get(i).getxMax() - 1);
                wg2.getListeWombas().get(i).setxMin(wg2.getListeWombas().get(i).getxMin() - 1);
            }
            for (int i = 0; i < listeCoins.size(); i++) {
                listeCoins.get(i).setX(listeCoins.get(i).getX() - 1);
                listeCoins.get(i).getRectangle().setX(listeCoins.get(i).getRectangle().getX() - 1);
            }
        }

    }

    /**
     * gestion du "scroll" de la map lorsque mario ou l'AI de mario se deplace
     */
    public void avancerMapVsAI() {
        renderX -= 1;
        for (int i = 0; i < wg1.getListeObjets().size(); i++) {
            for (int j = 0; j < wg1.getListeObjets().get(i).size(); j++) {
                wg1.getListeObjets().get(i).get(j).setX(wg1.getListeObjets().get(i).get(j).getX() - 1);
            }
        }
        for (int i = 0; i < wg1.getListeRectangles().size(); i++) {
            wg1.getListeRectangles().get(i).setX(wg1.getListeRectangles().get(i).getX() - 1);
        }
        for (int i = 0; i < wg1.getListeRectanglesDyingSpot().size(); i++) {
            wg1.getListeRectanglesDyingSpot().get(i).setX(wg1.getListeRectanglesDyingSpot().get(i).getX() - 1);
        }

        for (int i = 0; i < wg1.getListeWombas().size(); i++) {
            wg1.getListeWombas().get(i).setX(wg1.getListeWombas().get(i).getX() - 1);
            wg1.getListeWombas().get(i).setxMax(wg1.getListeWombas().get(i).getxMax() - 1);
            wg1.getListeWombas().get(i).setxMin(wg1.getListeWombas().get(i).getxMin() - 1);
        }
        for (int i = 0; i < listeCoins.size(); i++) {
            listeCoins.get(i).setX(listeCoins.get(i).getX() - 1);
            listeCoins.get(i).getRectangle().setX(listeCoins.get(i).getRectangle().getX() - 1);
        }
        wg1.getMario().setX(wg1.getMario().getX() - 1);
        wg1.getMarioAI().setX(wg1.getMarioAI().getX() - 1);

    }
}
