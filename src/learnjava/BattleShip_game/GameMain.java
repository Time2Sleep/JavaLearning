package learnjava.BattleShip_game;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        BattleShipLogic bsl = new BattleShipLogic();
        bsl.setUpGame();

        Scanner sc = new Scanner(System.in);
        while (bsl.sumOfHealths>0){
            int coord = sc.nextInt();
            bsl.checkDamage(coord);

        }
    }
}
