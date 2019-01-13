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
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuAvantPartie extends BasicGameState {

    private Image background;
    private AppGameContainer app;
    private WindowGame1 wg1;
    private StateBasedGame game;

    public static final int ID = 3;
    private Image niveau1;
    private Image niveau2;
    private Image menuPrincipal, niveauvsai;
    private Main state;
    private WindowGame2 wg2;

    /**
     *
     * @param StartMenu objet de la classe StartMenu
     * @param app le GameContainer
     * @param wg1 fenetre de jeu 1
     * @param wg2 fenetre de jeu 2
     * @param state objet de la classe Main
     * @throws SlickException
     */
    public MenuAvantPartie(int StartMenu, AppGameContainer app, WindowGame1 wg1, WindowGame2 wg2, Main state) throws SlickException {
        this.app = app;
        this.wg1 = wg1;
        this.wg2 = wg2;
        this.background = new Image("Images/marioBackground.GIF");
        this.state = state;
    }

    /**
     *
     * @return ID
     */
    @Override
    public int getID() {
        return ID;
    }

    /**
     *
     * @param gc
     * @param sbg
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.game = game;
        niveau1 = new Image("Images/button_niveau_resized.png");
        niveau2 = new Image("Images/button_niveau (1)_resized.png");
        menuPrincipal = new Image("Images/button_menu-principal_resized.png");
        niveauvsai = new Image("Images/niveauvsai.png");
    }

    /**
     *
     * @param gc
     * @param sbg
     * @param g
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        int posX = Mouse.getX();
        int posY = (512 - Mouse.getY());
        // System.out.println("x:" + posX + "y:" + posY);
        background.draw(0, 0, gc.getWidth(), gc.getHeight());

        if (((posX > 116 && posX < 301) && (posY > 181 && posY < 241))) {
            if (Mouse.isInsideWindow()) {
                g.drawImage(niveau1, 108, 110);

            }

            if (Mouse.isButtonDown(0)) {
                app.setDisplayMode(640, 250, false);
                wg1.setAI(false);
                state.setMapChoisie(1);
                wg1.getMap().fillListCoins();
                wg1.setModeDeJeu(2);
                wg1.creerGoombas();
                sbg.enterState(2);
                //   sounds.getItsMe().play();
            }
        }
        if ((posX > 116 && posX < 301) && (posY > 273 && posY < 333)) {
            if (Mouse.isInsideWindow()) {
                g.drawImage(niveau2, 108, 200);
            }
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(4);
                state.setMapChoisie(2);
                wg2.getMap().fillListCoins();
                app.setDisplayMode(640, 250, false);

            }
        }
        if ((posX > 457 && posX < 706) && (posY > 89 && posY < 143)) {
            if (Mouse.isInsideWindow()) {
                g.drawImage(menuPrincipal, 440, 13);

            }
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(1);
                app.setDisplayMode(512, 512, false);

            }
        }

        if ((posX > 358 && posX < 550) && (posY > 178 && posY < 239)) {
            if (Mouse.isInsideWindow()) {
                g.drawImage(niveauvsai, 350, 108);

            }
            if (Mouse.isButtonDown(0)) {
                state.setMapChoisie(1);
                wg1.setModeDeJeu(3);
                wg1.creernouveauAI();
                sbg.enterState(2);
                app.setDisplayMode(640, 250, false);
                wg1.setAI(false);
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
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = (512 - Mouse.getY());
    }

}
