package learnjava.BattleShip_game;

import java.util.ArrayList;

public class Ship {
    int health;
    ArrayList<Integer> coords = new ArrayList();

    public Ship(int health){
        this.health = health;
    }

    public void setCoords(ArrayList<Integer> coords){
        this.coords = coords;
    }

    public void takeDamage(){
        health--;
        if(health <= 0){
            System.out.println("You beat me");
        }
    }
}
