
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g.sesena.pascacio
 */
public class Inicio {
    public static void main(String[] args){
        int menuOption = -1;
        String[] buttons = {"1. Watch cats",
            "2. Exit"
        };
        do{
            //Menu main
            String option = (String) JOptionPane.showInputDialog(null, "Java Cats",
                    "Main menu", JOptionPane.INFORMATION_MESSAGE,
                    null, buttons, buttons[0]);
            
            //Valid the option that user selects
            for(int i=0; i < buttons.length; i++){
                if(option.equals(buttons[i])){
                    menuOption = i;
                }
            }
            
            switch(menuOption){
                case 0:
                    CatService.watchCats();
                    break;
                default:
                    break;
            }
            
        }while(menuOption != 1);
    }
}
