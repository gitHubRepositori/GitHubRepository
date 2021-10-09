import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Person {
    private HashSet<String> positionsShip = new  HashSet();
    HashSet<String> positionsArraysPerson = new HashSet<>();
    Map<String,String> keyShip = new HashMap<>();
    public String[][] araysShip = {
            {"А1", "Б1", "В1", "Г1", "Д1"},
            {"А2", "Б2", "В2", "Г2", "Д2"},
            {"А3", "Б3", "В3", "Г3", "Д3"},
            {"А4", "Б4", "В4", "Г4", "Д4"},
            {"А5", "Б5", "В5", "Г5", "Д5"}
    };
    public Person(){
        creatKeyShip();
    }
    public void setPositionShip(String position){
            if (position.matches("[АБВГД]\\d")) {
                if (positionsShip.contains(position))
                {
                    System.out.println("Эта позиция занята, выберите другую!");
                }
                else {
                    positionsShip.add(position);
                }
            }

    }
    public int getSizePositionsShip(){
        return positionsShip.size();
    }
    public void removeShip(String pos){
        positionsShip.remove(pos);
    }

    private void creatKeyShip(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyShip.put(araysShip[i][j],araysShip[i][j]);
            }
        }
    }

    public HashSet<String> getPositionsShip(){
        return positionsShip;
    }

        public String getArraysWindowPerson(String position, String znak){
            if(positionsShip.contains(position)) {
                keyShip.replace(position,znak);
            }
                String x , all="";
            for (int i = 0; i < 5; i++) {
                x ="";
                for (int j = 0; j < 5; j++) {
                    if(!positionsShip.contains(araysShip[i][j])) {
                        if (araysShip[i][j].equals(position) || positionsArraysPerson.contains(araysShip[i][j])) {
                            keyShip.replace(araysShip[i][j], " X ");
                            x = x + keyShip.get(araysShip[i][j]) + " ";
                            positionsArraysPerson.add(araysShip[i][j]);
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
