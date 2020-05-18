package learnjava.BattleShip_game;

import java.util.ArrayList;

public class ShipPlacer {
    int[] grid = new int[49];
    int startCoord;

    public ArrayList<Integer> placeShip(int size){
        ArrayList<Integer> coords = new ArrayList<>(); //передадим сразу все готовые коордиаты
         //задаем рандомно горизонтально или вертикально бует корабль
        int startX;
        int startY;
        boolean success = false; //смогли ли мы поставить корабль
        while (!success) {
            getStartCoords();
            coords.clear();
            success = true;
            int horOrVer = (int)(Math.random()*2);
            if (horOrVer == 0) { //горизонтально
                startX = startCoord/7+1;
                if(startX+1>7) success = false;
                if((grid[startCoord] | grid [startCoord+1] | grid[startCoord-1]) == 1)
                    success = false;
                startY = startCoord%7;
                if(success){
                    for(int i =0;i<size;i++){
                        coords.add((startX-1+i)*10+startY);
                        grid[7*startY+startX-1+i]=1;
                    }
                }

            } else { //вертикально
                startX = startCoord/7+1;
                if(startCoord-7 >= 0 && startCoord+7<=48){
                    if((grid[startCoord] | grid [startCoord+7] | grid[startCoord-7]) == 1)
                        success = false;
                }else success=false;

                startY = startCoord%7;
                if(startY+1>7) success = false;
                if(success){
                    for(int i =0;i<size;i++){
                        coords.add((startX)*10+startY-1+i);
                        grid[7*(startY-1+i)+startX]=1;
                    }
                }
            }
        }
        System.out.println("Ship is ready");
        return coords;
    }

    public void getStartCoords(){
        startCoord = (int)(Math.random()*47+1);
        System.out.println("Starting coordinate is = " + startCoord);
    }
}
