
package snake2d;

import java.awt.Color;
import javax.swing.JFrame;


public class Snake2d {

   
    Snake2d(){
         
        JFrame obj = new JFrame("SNAKE GAME");
        Gameplay gameplay = new Gameplay();
        obj.setBounds(10,10,905,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);        
       
    }
    
}
