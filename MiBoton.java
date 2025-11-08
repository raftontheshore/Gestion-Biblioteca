import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 * Representa un botón personalizado que extiende {@link JButton} para incluir
 * esquinas redondeadas, fondos con gradiente y efectos visuales para los
 * estados normal, hover (sobre el botón) y presionado.
 * <p>
 * Este botón maneja su propio pintado sobrescribiendo {@code paintComponent}
 * y deshabilita el pintado por defecto de Swing (fondo, borde y foco).
 * @author Aguirre Mauricio Alejandro, Iturrieta Waldemar
 * @version 07/11/25
 */
public class MiBoton extends JButton {

    /** Color base del botón en estado normal. */
    private Color colorPrincipal = new Color(19, 94, 255);
    /** Color del botón cuando el cursor está encima (hover). */
    private Color colorHover = new Color(121, 164, 255);
    /** Color del botón cuando está siendo presionado. */
    private Color colorPressed = new Color(10, 50, 150);

    /**
     * Controla el estado visual actual del botón.
     * 0 = Normal, 1 = Hover, 2 = Presionado.
     */
    private int estadoMouse = 0;

    /**
     * Construye un nuevo MiBoton con el texto especificado.
     * <p>
     * Inicializa la apariencia base (fuente, color de texto) y configura
     * los listeners de mouse necesarios para gestionar los estados visuales.
     * Deshabilita el pintado de fondo, foco y borde por defecto.
     *
     * @param text El texto que se mostrará en el botón.
     */
    public MiBoton(String text) {
        super(text);

        setFont(new Font("Corbel", Font.BOLD, 14));
        setForeground(Color.white);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                estadoMouse = 2;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (getModel().isRollover()) {
                    estadoMouse = 1;
                } else {
                    estadoMouse = 0;
                }
                repaint();
            }
        });
    }

    /**
     * Maneja el evento de entrada del mouse (hover).
     * Establece el estado a 'hover' (1) y solicita un repintado.
     *
     * @param evt El evento del mouse.
     */
    public void jBotonMouseEntered(MouseEvent evt) {
        estadoMouse = 1;
        repaint();
    }

    /**
     * Maneja el evento de salida del mouse.
     * Restablece el estado a 'normal' (0) y solicita un repintado.
     *
     * @param evt El evento del mouse.
     */
    public void jBotonMouseExited(MouseEvent evt) {
        estadoMouse = 0;
        repaint();
    }

    /**
     * Sobrescribe el método de pintado principal del componente.
     * <p>
     * Dibuja el fondo del botón con un gradiente y esquinas redondeadas.
     * El color del gradiente cambia según el {@code estadoMouse} (normal,
     * hover o presionado).
     * <p>
     * Finalmente, llama a {@code super.paintComponent(g)} para asegurar
     * que el texto del botón y otros elementos (como íconos) se dibujen
     * correctamente encima del fondo personalizado.
     *
     * @param g El contexto gráfico {@link Graphics} en el que pintar.
     */
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color colorArriba;
        Color colorAbajo;

        switch (estadoMouse) {
            case 1: // Hover
                colorArriba = colorHover.brighter();
                colorAbajo = colorHover;
                break;
            case 2: // Presionado
                colorArriba = colorPressed.brighter();
                colorAbajo = colorPressed;
                break;
            default: // 0 = Normal
                colorArriba = colorPrincipal.brighter();
                colorAbajo = colorPrincipal;
                break;
        }

        GradientPaint gp = new GradientPaint(
                0, 0, colorArriba,
                0, getHeight(), colorAbajo);

        g2.setPaint(gp);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));

        g2.setColor(colorAbajo.darker());
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));

        g2.dispose();

        super.paintComponent(g);
    }
}