import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;

/**
 * Write a description of class MiBoton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiBoton extends JButton
{
    public MiBoton(String text){
        this.setText(text);
        this.setBackground(new Color(19, 94, 255));
        this.setFont(new Font("Corbel", Font.BOLD, 14));
        this.setForeground(Color.white);
        this.setBorderPainted(true);
        this.setBorder(null);
    } 

    public void jBotonMouseEntered(MouseEvent evt) {                                           
        this.setBackground(new Color(121, 164,255));
    }                                          

    public void jBotonMouseExited(MouseEvent evt) {                                          
        this.setBackground(new Color(19, 94, 255));
    }
}