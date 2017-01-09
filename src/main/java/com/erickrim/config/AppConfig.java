package com.erickrim.config;

import com.erickrim.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by krime on 1/3/17.
 */
@Configuration
//@Import(InfrastructureConfig.class)
@ComponentScan(basePackages =  "com.erickrim")
@EnableAspectJAutoProxy
public class AppConfig {

    @Autowired
    private DataSource dataSource;

//    @Autowired @Qualifier("redSox")
//    private Team home;
//    @Autowired @Qualifier("cubs")
//    private Team away;

//    @Resource
//    private Team redSox;
//    @Resource
//    private Team cubs;

    @Autowired
    private List<Team> teams;

    @Bean
    //@Bean(initMethod = "startGame", destroyMethod = "endGame")
    @Scope("prototype")
    public Game game() {

        // probably a good idea to check we have 2 teams to start with
        BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));

        // using autowiring by type with @Qualifier annotation
        //BaseballGame baseballGame = new BaseballGame(home, away);

        // using autowiring by name with the @Resource annotation
        //BaseballGame baseballGame = new BaseballGame(redSox, cubs);
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
    @Bean
    public NumberFormat nf() {
        return NumberFormat.getCurrencyInstance();
    }
}
