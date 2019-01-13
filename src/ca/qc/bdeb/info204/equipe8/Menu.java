/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

    private Image background;
    private final Image menu;

    public static final int ID = 1;
    private StateBasedGame game;
    private AppGameContainer app;
    private Graphics g;
    private SoundFx sounds = new SoundFx();
    private WindowGame1 wg1;
    private WindowGame2 wg2;
    private Main main;

    /**
     *
     * @param startMenu objet de la classe StartMenu
     * @param app le GameContainer
     * @param wg1 fenetre de jeu 1
     * @param wg2 fenetre de jeu 2
     * @param main l'objet de la classe Main
     * @throws SlickException
     */
    public Menu(int startMenu, AppGameContainer app, WindowGame1 wg1, WindowGame2 wg2, Main main) throws SlickException {
        this.app = app;
        this.wg1 = wg1;
        this.wg2 = wg2;
        menu = new Image("Images/menu.png");
        this.main = main;
    }

    /**
     *
     * @param gc
     * @param sbg
     * @throws SlickException
     */
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.game = game;
        this.background = new Image("Images/backgroundMario.png");

    }

    /**
     *
     * @param gc
     * @param sbg
     * @param g
     * @throws SlickException
     */
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        int posX = Mouse.getX();
        int posY = (512 - Mouse.getY());
        //   System.out.println("x:" + posX + "y:" + posY);

        background.draw(0, 0, gc.getWidth(), gc.getHeight());

        if ((posX > 146 && posX < 350) && (posY > 240 && posY < 253)) {
            if (Mouse.isInsideWindow()) {
                g.drawImage(menu, 113, 236);
            }

            if (Mouse.isButtonDown(0)) {
                sbg.enterState(3);
                app.setDisplayMode(710, 444, false);
                //   sounds.getItsMe().play();

            }
        }

        if ((posX > 146 && posX < 350) && (posY > 288 && posY < 302)) {
            if (Mouse.isInsideWindow()) {
                g.drawImage(menu, 113, 282);
            }
            if (Mouse.isButtonDown(0)) {
                wg1.setModeDeJeu(4);
                wg1.setAI(false);
                wg1.creernouveauAI();
                app.setDisplayMode(650, 250, false);
                main.setMapChoisie(1);
                sbg.enterState(2);
            }
        }

        if ((posX > 238 && posX < 270) && (posY > 336 && posY < 351)) {
            if (Mouse.isInsideWindow()) {
                g.drawImage(menu, 208, 330);
            }
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(2);

                wg1.setAI(true);
                wg1.setModeDeJeu(1);
                app.setDisplayMode(650, 250, false);
                main.setMapChoisie(1);
                wg1.getMap().fillListCoins();
            }
        }
    }

    /**
     *
     * @param gc
     * @param sbg
     * @param i
     * @throws SlickException
     */
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();

    }

    /**
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

}
