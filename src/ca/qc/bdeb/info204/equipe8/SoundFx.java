/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info204.equipe8;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class SoundFx {

    private Music coin;
    private Music oneUp;
    private Music breakBlock;
    private Music jumpSmall;
    private Music jumpSuper;
    private Music die;
    private Music itsMe;
    private Music bye;
    private Music mushroom;
    private Music stomp;
    private Music stageClear;

    /**
     *
     * @throws SlickException
     */
    public SoundFx() throws SlickException {

        coin = new Music("SoundFx/coin.wav");
        oneUp = new Music("SoundFx/1-up.wav");
        breakBlock = new Music("SoundFx/breakblock.wav");
        jumpSmall = new Music("SoundFx/jumpsmall.wav");
        jumpSuper = new Music("SoundFx/jumpsuper.wav");
        die = new Music("SoundFx/die.wav");
        itsMe = new Music("SoundFx/itsme.wav");
        bye = new Music("SoundFx/byebye.wav");
        mushroom = new Music("SoundFx/mushroom.wav");
        stomp = new Music("SoundFx/stomp.wav");
        stageClear = new Music("SoundFx/stageclear.wav");

    }

    /**
     *
     * @return Music associée au block brisé
     */
    public Music getBreakBlock() {
        return breakBlock;
    }

    /**
     *
     * @return Music de fin
     */
    public Music getBye() {
        return bye;
    }

    /**
     *
     * @return Music lorsque collection d'une piece
     */
    public Music getCoin() {
        return coin;
    }

    /**
     *
     * @return Music lorsque Mario meurt
     */
    public Music getDie() {
        return die;
    }

    /**
     *
     * @return Music de debut de jeu
     */
    public Music getItsMe() {
        return itsMe;
    }

    /**
     *
     * @return Music de saut lorsque petit mario
     */
    public Music getJumpSmall() {
        return jumpSmall;
    }

    /**
     *
     * @return Music de saut lorsque gros mario
     */
    public Music getJumpSuper() {
        return jumpSuper;
    }

    /**
     *
     * @return Music lorsque collection de champignon
     */
    public Music getMushroom() {
        return mushroom;
    }

    /**
     *
     * @return Music de grandissement
     */
    public Music getOneUp() {
        return oneUp;
    }

    /**
     *
     * @return Music de reussite de partie
     */
    public Music getStageClear() {
        return stageClear;
    }

    /**
     *
     * @return Music d'ecrasement de monstre
     */
    public Music getStomp() {
        return stomp;
    }

}
