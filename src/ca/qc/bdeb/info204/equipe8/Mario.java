/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Sami
 */
public class Mario {

    private int x = 32, y = 100, vitesseX = 3, vitesseY = 0;
    private FakeRectangle rectangle;
    private boolean goingRight, big;
    private boolean moving = false;
    private Animation[] animations = new Animation[21];
    private final SpriteSheet[] sprites = new SpriteSheet[4];
    private Animation animation;
    private int positionAnimation;
    private Map map;
    private WindowGame1 window1;
    private WindowGame2 window2;
    private boolean conditionThread, aTerre = false, conditionThreadAI;
    private boolean rectVisible;
    private SoundFx sounds = new SoundFx();
    private int nombreCoins = 0;
    private Main main;
    private boolean AI;

    /**
     *
     */
    public enum State {

        /**
         * etat accroupi
         */
        CROUCH,
        /**
         * etat dans les airs
         */
        JUMP,
        /**
         * etat mort
         */
        DEAD,
        /**
         * etat a terre
         */
        GROUND;
    }
    private State state;

    /**
     *
     * @param goingRight si va vers la droite . true si vers la droite, false si
     * vers la gauche
     * @param map la map active
     * @param window1 fenetre de jeu 1
     * @param window2 fenetre de jeu 2
     * @param main la classe Main
     * @param AI Boolean si l'intelligence artificielle est active
     * @throws SlickException
     */
    public Mario(boolean goingRight, Map map, WindowGame1 window1, WindowGame2 window2, Main main, boolean AI) throws SlickException {
        this.AI = AI;
        this.state = State.GROUND;
        this.goingRight = goingRight;
        fillSprites();
        setAnimations();
        setAnimation(animations[1]);
        positionAnimation = 1;
        this.map = map;
        this.window1 = window1;
        this.window2 = window2;
        if (isBig()) {
            rectangle = new FakeRectangle(x, y, 16, 32);
        } else {
            rectangle = new FakeRectangle(x, y, 16, 16);
        }
        this.main = main;
    }

    /**
     *
     * @param animation Animation présentement affichée
     */
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    /**
     *
     * @return Animation présentement affichée
     */
    public Animation getAnimation() {
        return animation;
    }

    private void setAnimations() {
        for (int i = 0; i < sprites.length; i++) {
            Animation animation = new Animation();
            animations[i] = creerAnimationDebout(sprites[i]);
            animations[i + 4] = creerAnimationMarche(sprites[i]);
            animations[i + 8] = creerAnimationSaut(sprites[i]);
            animations[i + 12] = creerAnimationChangementDeDirection(sprites[i]);
            animations[i + 16] = creerAnimationCrouchMort(sprites[i]);

        }
        animations[20] = new Animation();
        animations[20].addFrame(sprites[1].getSubImage(6, 0), 100);
    }

    private Animation creerAnimationDebout(SpriteSheet sprite) {
        Animation animation = new Animation();
        animation.addFrame(sprite.getSubImage(0, 0), 100);
        return animation;
    }

    private Animation creerAnimationMarche(SpriteSheet sprite) {
        Animation animation = new Animation();

        animation.addFrame(sprite.getSubImage(1, 0), 100);
        animation.addFrame(sprite.getSubImage(2, 0), 100);
        animation.addFrame(sprite.getSubImage(3, 0), 100);
        return animation;
    }

    private Animation creerAnimationSaut(SpriteSheet sprite) {
        Animation animation = new Animation();
        animation.addFrame(sprite.getSubImage(4, 0), 100);
        return animation;
    }

    private Animation creerAnimationChangementDeDirection(SpriteSheet sprite) {
        Animation animation = new Animation();
        return animation;
    }

    private Animation creerAnimationCrouchMort(SpriteSheet sprite) {
        Animation animation = new Animation();
        animation.addFrame(sprite.getSubImage(6, 0), 100);
        return animation;
    }

    /**
     *
     * @return si va vers la droite . true si vers la droite, false si vers la
     * gauche
     */
    public boolean isGoingRight() {
        return goingRight;
    }

    /**
     *
     * @param moving si l'objet bouge ou pas
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     *
     * @return si l'objet bouge ou pas
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @param goingRight si va vers la droite . true si vers la droite, false si
     * vers la gauche
     */
    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }

    /**
     *
     * @return si Mario est grand. Sert pour les sprites utilisés
     */
    public boolean isBig() {
        return big;
    }

    /**
     *
     * @param bigsi Mario est grand. Sert pour les sprites utilisés
     */
    public void setBig(boolean big) {
        this.big = big;
        if (isBig()) {
            rectangle = new FakeRectangle(x, y - 2, 16, 32);
        } else {
            rectangle = new FakeRectangle(x, y - 2, 16, 16);
        }
    }

    /**
     *
     * @return si les rectangles entourant les objets sont visibles
     */
    public boolean isRectVisible() {
        return rectVisible;
    }

    /**
     *
     * @param rectVisible si les rectangles entourant les objets sont visibles
     */
    public void setRectVisible(boolean rectVisible) {
        this.rectVisible = rectVisible;
    }

    /**
     *
     * @return les rectangles des contours des objets
     *
     */
    public FakeRectangle getRectangle() {
        return rectangle;
    }

    /**
     *
     * @param state l'état actuel
     */
    public void setState(State state) {
        this.state = state;
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
    public int getX() {
        return x;
    }

    /**
     *
     * @param conditionThread si le thread associé au fait que mario est dans
     * les air est debuté ou pas
     */
    public void setConditionThread(boolean conditionThread) {
        this.conditionThread = conditionThread;

    }

    /**
     *
     * @param conditionThreadAI si le thread associé au fait que mario est dans
     * les air est debuté ou pas. Pour le mario de l'intelligence artificielle
     */
    public void setConditionThreadAI(boolean conditionThreadAI) {
        this.conditionThreadAI = conditionThreadAI;
    }

    /**
     * gere le calcul de mario lorsquil a sauté
     */
    public void AIJumpTrou() {
        setState(State.JUMP);
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 20) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }

                setY(y - 2);
                i++;

            }
        });
        if (aTerre) {
            thread.start();
        }
    }

    /**
     *
     * @param hauteurObstacle hauteur de l'obstacle devant l'AI de mario
     */
    public void AIjump(float hauteurObstacle) {
        conditionThreadAI = true;
        if (isBig()) {
            sounds.getJumpSuper().play();
        } else {
            sounds.getJumpSmall().play();
        }
        Thread thread = new Thread(() -> {
            int i = 0;
            while (conditionThreadAI) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
                setY(y - 2);
                i++;
                if (getY() < (hauteurObstacle - 64)) {
                    //do nothing   
                    setConditionThreadAI(false);
                    setMoving(true);
                    break;
                }
            }
        });
        if (aTerre) {
            thread.start();
        }
    }

    /**
     *
     * @param hauteurJump hauteur du saut de l'AI
     */
    public void jump(int hauteurJump) {
        conditionThread = true;

        if (isBig()) {
            sounds.getJumpSuper().play();
        } else {
            sounds.getJumpSmall().play();
        }

        Thread thread = new Thread(() -> {
            int i = 0;
            while (conditionThread && i < hauteurJump) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }

                setY(y - 2);
                i++;
            }

        });
        thread.start();

    }

    /**
     * gestion du saut par dessus un monstre
     */
    public void jumpMonstre() {
        if (isBig()) {
            sounds.getJumpSuper().play();
        } else {
            sounds.getJumpSmall().play();
        }
        Thread thread = new Thread(() -> {
            boolean movingBMonster = isMoving() == false;
            int i = 0;
            setState(State.JUMP);
            if (main.getMapChoisie() == 1) {
                window1.setTouchesActives(false);
            } else {
                window2.setTouchesActives(false);
            }
            while (i < 30) {

                if (goingRight && !movingBMonster) {
                    setX(x + 1);
                } else if (!movingBMonster) {
                    setX(x - 1);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
                setY(y - 2);
                i++;
            }
            if (main.getMapChoisie() == 1) {
                window1.setTouchesActives(true);
            } else {
                window2.setTouchesActives(true);
            }
        });
        thread.start();
    }

    /**
     *
     * @return la vitesse en X
     */
    public int calculerVitesseX() {
        if (isMoving()) {
            if (isGoingRight()) {
                vitesseX = 16;
            } else {
                vitesseX = -16;
            }
        }
        return vitesseX;
    }

    /**
     *
     * @param vitesseY la vitesse en Y
     */
    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    /**
     *
     * @return si le thread associé au fait que mario est dans les air est
     * debuté ou pas
     */
    public boolean isConditionThread() {
        return conditionThread;
    }

    /**
     *
     * @return deplacement de la fenetre lorsque le niveau est joueur contre AI
     */
    public boolean bougerNiveauVsAi() {
        if (isMoving()) {
            if (isGoingRight()) {
                if ((x + 1) < 420) {
                    vitesseX = 1;
                } else {
                    if (window1.isAvance() == true) {
                        map.avancerMapVsAI();
                        window1.setAvance(false);
                    }
                }
            } else {
                vitesseX = -1;
            }
            if ((x + vitesseX) > 0) {
                x = x + vitesseX;
            } else {
                return true;
            }
        }
        rectangle.setX(x);
        rectangle.setY(y);
        return false;
    }

    /**
     * gestion du mouvement
     *
     * @param g
     */
    public void bouger(Graphics g) {
        if (main.getMapChoisie() == 1) {
            if (isMoving()) {
                if (isGoingRight()) {
                    if (x < (window1.getWidth() / 3)) {
                        vitesseX = 1;
                    } else if (Math.abs(map.getRenderX()) <= (map.getWidth() * 16 - 720)) {
                        vitesseX = 0;
                        map.avancer();
                        for (int i = 0; i < window1.getListeRectangles().size(); i++) {
                            window1.getListeRectangles().get(i).setX(window1.getListeRectangles().get(i).getX() - 1);
                        }
                        for (int i = 0; i < window1.getListeRectanglesDyingSpot().size(); i++) {
                            window1.getListeRectanglesDyingSpot().get(i).setX(window1.getListeRectanglesDyingSpot().get(i).getX() - 1);
                        }
                    } else {
                        vitesseX = 1;
                    }
                } else {
                    vitesseX = -1;
                }
                if ((x + vitesseX) > 0) {
                    x = x + vitesseX;
                }
            }
            rectangle.setX(x);
            rectangle.setY(y);
        } else {
            if (isMoving()) {
                if (isGoingRight()) {
                    if (x < (window2.getWidth() / 3)) {
                        vitesseX = 1;
                    } else if (Math.abs(map.getRenderX()) <= (map.getWidth() * 16 - 720)) {
                        vitesseX = 0;
                        map.avancer();
                        for (int i = 0; i < window2.getListeRectangles().size(); i++) {
                            window2.getListeRectangles().get(i).setX(window2.getListeRectangles().get(i).getX() - 1);
                        }
                    } else {
                        vitesseX = 1;
                    }
                } else {
                    vitesseX = -1;
                }
                if ((x + vitesseX) > 0) {
                    x = x + vitesseX;
                }
            }
            rectangle.setX(x);
            rectangle.setY(y);
        }

    }

    /**
     * grandissement de Mario, associé aux sprites qui seront utilisés
     */
    public void grandir() {
        big = true;
        setY(y - 16);
        rectangle.setHeight(32);

    }

    /**
     * changement de la grandeur de mario
     */
    public void rapetisser() {
        big = false;
        rectangle.setHeight(16);
    }

    /**
     *
     * @return la vitesse en Y selon si va vers le haut ou le bas
     */
    public int getVitesseY() {
        return 16;
    }

    /**
     * lorsqu'une piece est collecté
     */
    public void gagnerCoin() {
        nombreCoins++;
    }

    /**
     * a utiliser lorsquon reinitialise le jeu
     */
    public void reinitialiserCoin() {
        nombreCoins = 0;
    }

    /**
     *
     * @return le nombre de pieces actuelles
     */
    public int getNombreCoins() {
        return nombreCoins;
    }

    /**
     *
     * @return vitesse en X
     */
    public int getVitesseX() {
        return 16;
    }

    /**
     *
     * @return l'Etat de Mario, voir State
     */
    public State getState() {
        return state;
    }

    /**
     * mise a jour de l'animation presentement affichée
     */
    public void updateAnimation() {
        if (state == State.DEAD) {
            animation = animations[20];
        } else {
            if (isBig()) {
                if (isGoingRight()) {
                    switch (state) {
                        case JUMP:
                            animation = animations[8];
                            break;
                        case CROUCH:
                            animation = animations[16];
                            break;
                        case GROUND:
                            if (isMoving()) {
                                animation = animations[4];
                            } else {
                                animation = animations[0];
                            }
                            break;
                    }
                } else {
                    switch (state) {
                        case JUMP:
                            animation = animations[10];
                            break;
                        case CROUCH:
                            animation = animations[18];
                            break;
                        case GROUND:
                            if (isMoving()) {
                                animation = animations[6];
                            } else {
                                animation = animations[2];
                            }
                            break;
                    }
                }
            } else {
                if (isGoingRight()) {
                    switch (state) {
                        case JUMP:
                            animation = animations[9];
                            break;
                        case CROUCH:
                            animation = animations[1];
                            break;
                        case GROUND:
                            if (isMoving()) {
                                animation = animations[5];
                            } else {
                                animation = animations[1];
                            }
                            break;
                    }
                } else {
                    switch (state) {
                        case JUMP:
                            animation = animations[11];
                            break;
                        case CROUCH:
                            animation = animations[3];
                            break;
                        case GROUND:
                            if (isMoving()) {
                                animation = animations[7];
                            } else {
                                animation = animations[3];
                            }
                            break;
                    }
                }
            }
        }
    }

    private void fillSprites() throws SlickException {
        if (!AI) {
            sprites[0] = new SpriteSheet("sprites/mario_big_right.gif", 16, 32);
            sprites[1] = new SpriteSheet("sprites/mario_mini_right.gif", 16, 16);
            sprites[2] = new SpriteSheet("sprites/mario_big_left.gif", 16, 32);
            sprites[3] = new SpriteSheet("sprites/mario_mini_left.gif", 16, 16);
        } else {
            sprites[0] = new SpriteSheet("sprites/mario_big_right_AI.png", 16, 32);
            sprites[1] = new SpriteSheet("sprites/mario_mini_right_AI.png", 16, 16);
            sprites[2] = new SpriteSheet("sprites/mario_big_left_AI.png", 16, 32);
            sprites[3] = new SpriteSheet("sprites/mario_mini_left_AI.png", 16, 16);
        }
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * gestion de la gravité lorsque mario est dans les airs
     */
    public void gravity() {
        if (!aTerre) {
            setY(y + 1);
        }
    }

    /**
     *
     * @return si est a terre ou pas
     */
    public boolean isaTerre() {
        return aTerre;
    }

    /**
     *
     * @param aTerre si est a terre ou pas
     */
    public void setaTerre(boolean aTerre) {
        this.aTerre = aTerre;
    }
}
