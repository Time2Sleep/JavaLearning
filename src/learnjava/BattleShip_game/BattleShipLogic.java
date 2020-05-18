package learnjava.BattleShip_game;

import java.util.ArrayList;
import java.util.Random;

public class BattleShipLogic {
    int countOfShips = 3;
    int sumOfHealths = 0;
    ArrayList<Ship> ships = new ArrayList();
    ShipPlacer placer = new ShipPlacer();
    public void setUpGame(){
        System.out.println("Preparing ships");
        prepareShips();
    }

    void prepareShips(){
        for(int i=0; i<countOfShips; i++){
            int health = 3;
            sumOfHealths+=health;
            ships.add(new Ship(health));
        }
        for (Ship ship: ships) {
            ship.setCoords(placer.placeShip(ship.health));
        }

        System.out.println("Game is ready");
    }

    void checkDamage(int coord){
        String text = "You missed";
        for(Ship ship: ships){
            for(int i=0; i<ship.coords.size(); i++){
                if(ship.coords.get(i) == coord){
                    text = "You hit one of them";
                    ship.takeDamage();
                    ship.coords.remove(i);
                    sumOfHealths--;
                }
            }
        }
        System.out.println(text);
    }
}
