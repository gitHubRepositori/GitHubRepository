import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameGuiWar extends JFrame {
    private JPanel panel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JLabel labelPerson;
    private JLabel labelComputer;
    Computer computer = new Computer();
    Person person = new Person();
    public GameGuiWar()
{
    setContentPane(panel);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    button1.addActionListener(new MyButtonListener());
    button2.addActionListener(new MyButtonListener1());
    button2.setVisible(false);
    textArea2.setText("Вводите координаты 5 кораблей,"+"\n"+"чтобы вступить в противодействие"+"\n"+
            " с противником."+" Вот так будут выглядить "+
            "\n"+"ваши корабли на карте: {^} ."+"\n"+
            "Если в корабль попадут,"+"\n"+" он будет выглядить вот так : D .");

}
private class MyButtonListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!(person.getSizePositionsShip() == 5))
        {
            person.setPositionShip(textField1.getText());
            textArea1.setText(Integer.toString(person.getSizePositionsShip()));
            textArea1.setText(person.getArraysWindowPerson(textField1.getText(),"{^}"));

        }
        else {
            button1.setVisible(false);
            textArea2.setText("Все корабли" +"на позициях," +"\n"+"Вводите любое значение,"+"\n"+
                    " чтобы сделать выстрел по противнику"+"\n"+
                    " нажимай старт "+"\n"+"и игра начинается");
            person.positionsArraysPerson.clear();
            button1.setVisible(false);
            button2.setVisible(true);
            textField1.setText("");
        }
    }
}

    private class MyButtonListener1 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String pos = textField1.getText();

            System.out.println(computer.getPositionsShip());
            labelComputer.setText("Оставшиеся корабли: "+computer.getSizePositionShips());

            if (pos.matches(("[АБВГД]\\d")))
            {
                textArea2.setText(computer.getArraysWindowComputer(pos," D "));

                if (computer.getPositionsShip().contains(pos)) {
                    computer.removeShip(pos);
                    labelComputer.setText("Оставшиеся корабли: " + computer.getSizePositionShips());
                }


                String posit = computer.getPositionMoveComputer();
                textArea1.setText(person.getArraysWindowPerson(posit," D "));
                labelPerson.setText("Оставшиеся корабли: "+person.getSizePositionsShip());

                if(person.getPositionsShip().contains(posit)) {
                    person.removeShip(posit);
                    labelPerson.setText("Оставшиеся корабли: " + person.getSizePositionsShip());
                }

                if (person.getPositionsShip().isEmpty() || computer.getPositionsShip().isEmpty()){
                    if(person.getSizePositionsShip()==0){
                        textArea2.setText(" Компьютер выйграл человека ");
                        labelPerson.setText("Оставшиеся корабли: " + person.getSizePositionsShip());
                        button2.setVisible(false);
                        textField1.setVisible(false);
                    }else if(computer.getSizePositionShips()==0){
                        labelComputer.setText("Оставшиеся корабли: " + computer.getSizePositionShips());
                        textArea1.setText(" Человек выйграл компьютер ");
                        button2.setVisible(false);
                        textField1.setVisible(false);
                    }

                }

            }
        }
    }




}
