/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    /**
     * le nome de la fenetre
     */
    public static String gameName = "Smart Mario";

    /**
     *
     */
    public static int startMenu = 1;

    /**
     *
     */
    public static int windowGame1 = 2;

    /**
     *
     */
    public static int menuAvantPartie = 3;

    /**
     *
     */
    public static int windowGame = 4;
    private static AppGameContainer app;
    boolean focus = false;
    SoundFx sounds = new SoundFx();
    WindowGame1 wg1;
    WindowGame2 wg2;
    private int mapChoisie = 0;

    /**
     *
     * @param args
     * @throws SlickException
     */
    public static void main(String[] args) throws SlickException {
        try {
            app = new AppGameContainer(new Main(gameName));
            app.setDisplayMode(512, 512, false);

            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param gameName le nom de la fenetre
     * @throws SlickException
     */
    public Main(String gameName) throws SlickException {
        super(gameName);
    }

    /**
     *
     * @param gc
     * @throws SlickException
     */
    public void initStatesList(GameContainer gc) throws SlickException {
        wg1 = new WindowGame1(250, 640, windowGame1, app, this);
        wg2 = new WindowGame2(250, 640, windowGame, app, this);
        app.setShowFPS(false);
        this.addState(new Menu(startMenu, app, wg1, wg2, this));
        this.addState(wg1);
        this.addState(new MenuAvantPartie(menuAvantPartie, app, wg1, wg2, this));
        this.addState(wg2);
        this.enterState(startMenu);

    }

    /**
     *
     * @return la map active
     */
    public int getMapChoisie() {
        return mapChoisie;
    }

    /**
     *
     * @param mapChoisie la map choisi
     */
    public void setMapChoisie(int mapChoisie) {
        this.mapChoisie = mapChoisie;
    }

}
