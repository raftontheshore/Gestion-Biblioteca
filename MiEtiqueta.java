import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 * Representa una etiqueta (JLabel) personalizada con un estilo predefinido.
 * <p>
 * Establece automáticamente la fuente ("Corbel", negrita, 14) y el color
 * del texto (blanco).
 *
 * @author Aguirre Mauricio Alejandro
 * @version 07/11/25
 */
public class MiEtiqueta extends JLabel {

    /**
     * Construye una nueva MiEtiqueta con el texto especificado y
     * aplica el estilo por defecto.
     *
     * @param text El texto que se mostrará en la etiqueta.
     */
    public MiEtiqueta(String text) {
        this.setText(text);
        this.setFont(new Font("Corbel", Font.BOLD, 14));
        this.setForeground(Color.white);
    }
}