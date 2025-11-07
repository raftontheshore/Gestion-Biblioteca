import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
/**
 * Write a description of class MiEtiqueta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiEtiqueta extends JLabel
{
    public MiEtiqueta(String text)
    {
        this.setText(text);
        this.setFont(new Font("Corbel", Font.BOLD, 14));
        this.setForeground(Color.white);
    }
}