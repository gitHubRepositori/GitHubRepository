import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Computer {
    private int x,y;
    private String [] letters = {"А","Б","В","Г","Д"};
    private String [] numbers = {"1","2","3","4","5"};
    HashSet<String> positionsArraysComputer = new HashSet<>();
    HashSet<String> positionsShip = new HashSet<>();
    HashSet<String> positionMove = new HashSet<>();
    List list ;
    private   String [] [] araysShip ={
            {"А1","Б1","В1","Г1","Д1"},
            {"А2","Б2","В2","Г2","Д2"},
            {"А3","Б3","В3","Г3","Д3"},
            {"А4","Б4","В4","Г4","Д4"},
            {"А5","Б5","В5","Г5","Д5"}
    };
    HashMap<String,String> keyShip = new HashMap<>();

    public Computer(){
        addPositionMove();
        addPositionShip();
        creatKeyShip();
    }
    private String randomPosition()
    {
        x = (int) (Math.random()*(5-0))+0;
        y =(int) (Math.random()*(5-0))+0;
        String position=letters[x]+numbers[y];
        return position;
    }
    public  void addPositionMove()
    {
        while (positionMove.size()<25){
            positionMove.add(randomPosition());
        }
    }

    public  void addPositionShip()
    {
        while (positionsShip.size()<5){
            positionsShip.add(randomPosition());
        }
    }
    public HashSet<String> getPositionsShip(){
        return positionsShip;
    }

    public void removeShip(String pos)
    {
        positionsShip.remove(pos);

    }
    private void creatKeyShip(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyShip.put(araysShip[i][j],araysShip[i][j]);
            }
        }
    }
    public String getPositionMoveComputer(){

        list = new ArrayList(positionMove);
        x = (int) (Math.random()*(list.size()))+0;
        if (!positionsShip.isEmpty()) {
            String pos = (String) list.get(x);
            positionMove.remove(list.get(x));
            return pos;
        }
        return null;
    }
    public int getSizePositionShips()
    {
        return positionsShip.size();
    }
    public String getArraysWindowComputer(String position,String znak)
    {
        if(getPositionsShip().contains(position)) {
            keyShip.replace(position,znak);
            System.out.println("i am here");
        }
        String x , all="";
        for (int i = 0; i < 5; i++) {
            x ="";
            for (int j = 0; j < 5; j++) {
                if(!positionsShip.contains(araysShip[i][j])) {
                    if (araysShip[i][j].equals(position) || positionsArraysComputer.contains(araysShip[i][j])) {
                        keyShip.replace(araysShip[i][j], " X ");
                        x = x + keyShip.get(araysShip[i][j]) + " ";
                        positionsArraysComputer.add(araysShip[i][j]);
                    } else {
                        x = x + keyShip.get(araysShip[i][j]) + " ";
                    }
                }else {
                    x = x + keyShip.get(araysShip[i][j]) + " ";
                }
            }
            all = all+x+"\n";
        }
        return all;
    }
}
