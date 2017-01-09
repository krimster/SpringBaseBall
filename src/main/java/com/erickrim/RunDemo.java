package com.erickrim;

import com.erickrim.config.AppConfig;
import com.erickrim.entities.Game;
import com.erickrim.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.NumberFormat;

/**
 * Created by krime on 1/3/17.
 */
public class RunDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");


        // factory bean test
        NumberFormat nf = context.getBean(NumberFormat.class);
        double amount = 12345678.9012345;
        System.out.println(nf.format(amount));

        Team royals = context.getBean("royals", Team.class);

        Game game1 = context.getBean("game", Game.class);
        System.out.println(game1);
        game1.playGame();

        Game game2 = context.getBean("game", Game.class);
        game2.setAwayTeam(royals);
        System.out.println(game2);

        game2.playGame();

        System.out.println(game1);

        System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
