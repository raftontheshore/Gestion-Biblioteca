import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class MisOpciones here.
 * 
 * @author Diosito
 */
public class MisOpciones extends JButton {
    
    public MisOpciones(){
        this.setOpaque(false);
        this.setBackground(new Color(19, 94, 255));
        this.setFont(new Font("Corbel", Font.BOLD, 14));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setForeground(Color.white);
        this.setBorderPainted(false);
        this.setBorder(null);
    } 
    
    public void jbOpcionMouseEntered(MouseEvent evt) {                                           
        this.setOpaque(true);
    }                                          

    public void jbOpcionMouseExited(MouseEvent evt) {                                          
        this.setOpaque(false);
    }
}