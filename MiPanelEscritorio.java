import java.awt.*;
import javax.swing.*;

/**
 * Representa un panel (JPanel) que utiliza una imagen como fondo,
 * escalándola para que ocupe todo el espacio del panel.
 * <p>
 * Está diseñado para actuar como un 'escritorio' o contenedor principal,
 * utilizando un layout nulo (null layout) y estableciendo un tamaño
 * fijo por defecto.
 *
 * @author Aguirre Mauricio Alejandro
 * @version 07/11/25
 */
public class MiPanelEscritorio extends JPanel {

    /** Almacena la instancia de la imagen de fondo. */
    private Image imagen;

    /**
     * Construye un nuevo panel de escritorio.
     * <p>
     * Carga la imagen de fondo desde la ruta especificada, establece el
     * layout a {@code null} y fija el tamaño (bounds) a 730x420.
     *
     * @param image La ruta del recurso de la imagen de fondo (ej. "/recursos/fondo.png").
     */
    public MiPanelEscritorio(String image) {
        imagen = new ImageIcon(getClass().getResource(image)).getImage();
        this.setBounds(0, 0, 730, 420);
        this.setLayout(null);
    }

    /**
     * Sobrescribe el método de pintado principal.
     * <p>
     * Dibuja la imagen de fondo ({@code imagen}) escalándola para que ocupe
     * exactamente el ancho (getWidth) y alto (getHeight) actuales del panel.
     *
     * @param g El contexto gráfico {@link Graphics} en el que pintar.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}