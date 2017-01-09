package com.erickrim;

import com.erickrim.entities.*;

/**
 * Created by krime on 1/3/17.
 */
public class RunDemoWithoutSpring {

    public static void main(String[] args) {

        // teams
        Team redsox = new RedSox();
        Team cubs = new Cubs();
        // game
        Game game = new BaseballGame(redsox, cubs);
        System.out.println(game.playGame());


    }
}
