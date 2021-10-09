import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameGuiWar gameGuiWar = new GameGuiWar();
        gameGuiWar.pack();
        gameGuiWar.setSize(new Dimension(600,400));
        gameGuiWar.setVisible(true);


//        Computer computer = new Computer();
//        //computer.addPositionMove();
//        //System.out.println(computer.getPositionComputer());
//        computer.seeArrays();
//        System.out.println(computer.getPositionComputer()+"\n");
//        computer.getPositionComputer();
//        computer.getPositionComputer();
//        computer.seeArrays();


//        ArrayList<Ship> youShip = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        while (Ship.getShipCount()<5) {
//            System.out.println("Введите позиции ваших кораблей: ");
//            String youPositionShip =  scanner.nextLine();
//            if(youPositionShip.matches("[АБВГД]\\d"))
//            {
//                youShip.add(new Ship(youPositionShip));
//                youShip.forEach(ship -> System.out.println(ship.getPosition()));
//            }
//        }
//        System.out.println("Ура мы вышли из цикла"+"\n"+Ship.getShipCount());


//        HashMap<String, String> ships = new HashMap<>();
//        String[][] arays = {
//                {"A1", "Б1", "В1", "Г1", "Д1"},
//                {"A2", "Б2", "В2", "Г2", "Д2"},
//                {"A3", "Б3", "В3", "Г3", "Д3"},
//                {"A4", "Б4", "В4", "Г4", "Д4"},
//                {"A5", "Б5", "В5", "Г5", "Д5"}
//        };
//        String printLn = "\n";
//        String probel = " ";
//        String x , all="";
//
//            //String coordinates = "Введите ваши корбали: "+scanner.nextLine();
//            for (int i = 0; i < 5; i++) {
//                x ="";
//                for (int j = 0; j < 5; j++) {
//                    //System.out.print(" " + arays[i][j] + " ");
//
//                    x = x+arays[i][j]+probel;
//                    //arays[i][j] = "X";
//
//                }
//                all = all+x+printLn;
//
//            }


        }


    }
