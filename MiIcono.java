import javax.swing.*;
import java.awt.*;

/**
 * Representa una etiqueta (JLabel) diseñada para mostrar una imagen
 * que se escala automáticamente para llenar el tamaño completo del componente.
 *
 * @author Aguirre Mauricio Alejandro, Iturrieta Waldemar
 * @version 07/11/25
 */
public class MiIcono extends JLabel {

    /** Almacena la instancia de la imagen que se va a dibujar. */
    private Image imagen;

    /**
     * Construye un nuevo MiIcono cargando una imagen desde la ruta especificada.
     * <p>
     * La ruta de la imagen se resuelve relativa a la ubicación de la clase.
     * La alineación horizontal se establece en CENTRO por defecto.
     *
     * @param image La ruta del recurso de la imagen (ej. "/recursos/icono.png").
     */
    public MiIcono(String image) {
        imagen = new ImageIcon(getClass().getResource(image)).getImage();
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Sobrescribe el método de pintado principal para dibujar la imagen.
     * <p>
     * Dibuja la {@code imagen} almacenada escalándola para que ocupe
     * exactamente el ancho (getWidth) y alto (getHeight) actuales del JLabel.
     *
     * @param g El contexto gráfico {@link Graphics} en el que pintar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}