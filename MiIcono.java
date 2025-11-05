import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class MiIcono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiIcono extends JLabel
{
    private Image imagen;

    public MiIcono(String image) {
        // Carga la imagen desde el archivo (puede ser una ruta absoluta o del proyecto)
        imagen = new ImageIcon(getClass().getResource(image)).getImage();
        this.setHorizontalAlignment(SwingConstants.CENTER);// Para que el icono se ubique en el centro 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // limpia el fondo antes de dibujar
        // Dibuja la imagen ajustada al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}