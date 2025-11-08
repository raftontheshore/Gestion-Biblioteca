import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Insets;

/**
 * Representa un botón personalizado diseñado para un panel de navegación lateral
 * (ej. "Inicio", "Socios", etc.).
 * <p>
 * Extiende {@link JButton} y añade un estado visual 'activo', además de
 * efectos 'hover', gestionando su opacidad.
 *
* @author Aguirre Mauricio Alejandro, Iturrieta Waldemar
 * @version 07/11/25
 */
public class MisOpciones extends JButton {

    /** Bandera para rastrear si el botón está actualmente seleccionado o 'activo'. */
    private boolean isActive = false;

    /**
     * Construye un nuevo botón de navegación.
     * <p>
     * Inicializa el estilo visual por defecto, estableciéndolo como no opaco,
     * definiendo fuentes y colores, eliminando bordes y organizando el ícono
     * y el texto en una pila vertical (ícono arriba, texto abajo).
     */
    public MisOpciones() {
        this.setOpaque(false);
        this.setBackground(new Color(19, 94, 255));
        this.setFont(new Font("Corbel", Font.BOLD, 14));
        this.setForeground(Color.white);

        this.setFocusPainted(false);
        this.setBorder(null);
        this.setBorderPainted(false);

        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setIconTextGap(5);
    }

    /**
     * Maneja el evento de entrada del mouse (hover).
     * Hace el botón opaco para proporcionar retroalimentación visual.
     *
     * @param evt El evento del mouse.
     */
    public void jbOpcionMouseEntered(MouseEvent evt) {
        this.setOpaque(true);
    }

    /**
     * Maneja el evento de salida del mouse.
     * Vuelve el botón transparente (no opaco), *a menos* que esté
     * actualmente marcado como 'activo'.
     *
     * @param evt El evento del mouse.
     */
    public void jbOpcionMouseExited(MouseEvent evt) {
        if (!this.isActive) {
            this.setOpaque(false);
        }
    }

    /**
     * Define si este botón debe mostrarse como la pestaña activa.
     * Un botón activo permanece opaco (resaltado) incluso cuando el
     * mouse no está sobre él.
     *
     * @param active true si el botón debe marcarse como activo, false si no.
     */
    public void setActive(boolean active) {
        this.isActive = active;
        this.setOpaque(active);
        this.repaint();
    }
}