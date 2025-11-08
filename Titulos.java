import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 * Representa una etiqueta (JLabel) diseñada para usarse como un título grande.
 * <p>
 * Establece automáticamente una fuente grande ("Corbel", negrita, 40),
 * color de texto (blanco) y una posición y tamaño fijos (bounds).
 *
 * @author Aguirre Mauricio Alejandro
 * @version 07/11/25
 */
public class Titulos extends JLabel {

    /**
     * Construye una nueva etiqueta de Título con el texto especificado
     * y aplica el estilo de título por defecto.
     *
     * @param text El texto que se mostrará en el título.
     */
    public Titulos(String text) {
        this.setText(text);
        this.setFont(new Font("Corbel", Font.BOLD, 40));
        this.setForeground(Color.white);
        this.setBounds(10, 0, 600, 60);
    }
}