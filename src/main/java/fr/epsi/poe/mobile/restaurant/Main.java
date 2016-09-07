package fr.epsi.poe.mobile.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Fly on 20/07/2016.
 */

@SpringBootApplication
public class Main {
    public static  void main (String [] args) {
        //classe pour transformer l'apli en appli web à l'aide de framework Spring
        SpringApplication.run(Main.class, args);
        //Spring va creer un serveur web
    }



}
