/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakura.ventanas;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author ALBERTO
 */
public class Animalitos {
    
    Random numRandom = new Random();
    int num = 1 + numRandom.nextInt(5);
    
    public int getNum(){
        return num;
    }
    
    public static void main(String[]args){

        Animalitos an = new Animalitos();
        System.out.println(an.getNum());
        
        if(an.getNum() == 1)
        System.out.println("Perro");    
        if(an.getNum() == 2)
        System.out.println("Cabra");     
        if(an.getNum() == 3)
        System.out.println("Chivo");      
        if(an.getNum() == 4)
        System.out.println("Bastodonte");     
        if(an.getNum() == 5)
        System.out.println("Maduro");
    }
    
}
