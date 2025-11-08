import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Representa la ventana principal (JFrame) de la aplicación de gestión de biblioteca.
 * Esta clase maneja toda la interfaz gráfica de usuario (GUI), incluyendo los paneles
 * de navegación, las pestañas y los formularios para gestionar socios, libros y préstamos.
 */
public class Menu extends JFrame {
    // Declaracion de biblioteca
    private Biblioteca miBiblioteca;

    // Botones del panel de opciones (Navegación Principal)
    private ArrayList<MisOpciones> botonesNavegacion;
    private MisOpciones jbOpcionInicio;
    private MisOpciones jbOpcionLibros;
    private MisOpciones jbOpcionPrestamos;
    private MisOpciones jbOpcionSocios;
    private JPanel jpOpciones;

    // Componentes Generales y Paneles Principales
    private JLabel jlTitulo;
    private JTabbedPane jtpEscritorio;
    private MiPanelEscritorio jpCabecera;

    // --- Componentes Panel Inicio ---
    private MiPanelEscritorio jifInicio;
    private JTextArea jtaTextoInicio;

    // --- Componentes Sección Socios ---
    // Panel Principal Socios (Menú)
    private MiPanelEscritorio jifSocio;
    private Titulos jlTituloSocio;
    private MiIcono jlAgregarSocio;
    private MiIcono jlQuitarSocio;
    private MiIcono jlListarSocios;
    private MiBoton jbAgregarSocio;
    private MiBoton jbQuitarSocio;
    private MiBoton jbListarSocios;
    private MiIcono jlDocenteResponsable;
    private MiBoton jbDocenteResponsable;

    // Formulario Agregar Socio
    private MiPanelEscritorio jifAgregarSocio;
    private JRadioButton rbDocente;
    private JRadioButton rbAlumno;
    private ButtonGroup bgTipoSocio;
    private MiEtiqueta jlDNI;
    private JTextField jtfDNI;
    private MiEtiqueta jlNombre;
    private JTextField jtfNombre;
    private MiEtiqueta jlDiasPrestamo;
    private JTextField jtfDiasPrestamo;
    private MiEtiqueta jlCarreraAsignatura;
    private JTextField jtfCarreraAsignatura;
    private MiBoton jbGuardarSocio;

    // Formulario Quitar Socio
    private MiPanelEscritorio jifQuitarSocio;
    private JTextField jtfDNIQuitar;

    // Panel Listar Socios
    private MiPanelEscritorio jifListarSocios;
    private JTextArea taListadoSocios;

    // Panel Docente Responsable
    private MiPanelEscritorio jifDocenteResponsable;
    private JTextArea elListadoDocenteResponsable;
    private JTextArea unListadoDocentesR;
    private MiBoton jbActualizarListaDocenRes;

    // --- Componentes Sección Libros ---
    // Panel Principal Libros (Menú)
    private MiPanelEscritorio jifLibro;
    private Titulos jlTituloLibro;
    private MiIcono jlAgregarLibros;
    private MiIcono jlQuitarLibro;
    private MiIcono jlListarLibros;
    private MiIcono jlBuscarLibro;
    private MiBoton jbAgregarLibro;
    private MiBoton jbQuitarLibro;
    private MiBoton jbListarLibros;
    private MiBoton jbBuscarLibros;

    // Formulario Agregar Libro
    private MiPanelEscritorio jifAgregarLibro;
    private JTextField jtfTituloLibro;
    private JTextField jtfEditorial;
    private JTextField jtfEdicion;
    private JTextField jtfAnio;
    private MiBoton jbGuardarLibro;

    // Formulario Quitar Libro
    private MiPanelEscritorio jifQuitarLibro;
    private JTextField jtfTituloQuitar;
    private MiBoton jbQuitarLibroForm;

    // Panel Listar Libros
    private MiPanelEscritorio jifListarLibros;
    private JTextArea unListadoLibros;
    private MiBoton jbActualizarListaLibros;

    // Formulario Buscar Libro
    private MiPanelEscritorio jifBuscarLibro;
    private JTextField jtfTituloBuscar;
    private MiBoton jbBuscarLibroForm;

    // --- Componentes Sección Préstamos ---
    // Panel Principal Prestamos (Menú)
    private MiPanelEscritorio jifPrestamo;
    private Titulos jlTituloPrestamo;
    private MiIcono jlAgregarPrestamo;
    private MiIcono jlRegistraDevolucion;
    private MiBoton jbAgregarPrestamo;
    private MiBoton jbRegistraDevolucion;

    // Formulario Agregar Prestamo
    private MiPanelEscritorio jifAgregarPrestamo;
    private Titulos jlTituloAgregarPrestamo;
    private MiEtiqueta jlFechaRetiro;
    private MiEtiqueta jlTituloLibroRetiro;
    private MiEtiqueta jlDniSocioRetiro;
    private JTextField jtfFechaRetiro;
    private JTextField jtfTituloLibroRetiro;
    private JTextField jtfDniSocioRetiro;
    private MiBoton jbRegistrarPrestamo;

    // Formulario Registrar Devolucion
    private MiPanelEscritorio jifRegistrarDevolucion;
    private Titulos jlTituloRegistrarDevolucion;
    private MiEtiqueta jlFechaDevolucion;
    private MiEtiqueta jlTituloLibroDevuelto;
    private JTextField jtfFechaDevolucion;
    private JTextField jtfTituloLibroDevuelto;
    private MiBoton jbRegistrarLibroDevolucion;

    /**
     * Constructor de la clase Menu.
     * Inicializa la biblioteca y los componentes de la interfaz gráfica.
     */
    public Menu() {
        this.iniciarBiblioteca();
        this.iniciarComponentes();
    }

    /**
     * Inicializa y configura todos los componentes de la interfaz gráfica (Swing).
     * Esto incluye la ventana principal, paneles, pestañas, botones, etiquetas,
     * y la asignación de sus respectivos listeners de eventos.
     */
    private void iniciarComponentes() {
        this.jlTitulo = new JLabel();
        this.jifInicio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jifSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jifPrestamo = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jifAgregarPrestamo = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jpOpciones = new JPanel();
        this.jbOpcionSocios = new MisOpciones();
        this.jbOpcionLibros = new MisOpciones();
        this.jbOpcionPrestamos = new MisOpciones();
        this.jbAgregarPrestamo = new MiBoton("Registrar Prestamo");
        this.jbRegistraDevolucion = new MiBoton("Registrar Devolucion");
        this.jbOpcionInicio = new MisOpciones();
        this.jtaTextoInicio = new JTextArea();
        this.jlTituloSocio = new Titulos("Socios");
        this.jlTituloPrestamo = new Titulos("Prestamos");
        this.jlTituloAgregarPrestamo = new Titulos("Agregar prestamo");
        this.jtpEscritorio = new JTabbedPane();
        this.jlAgregarPrestamo = new MiIcono("/imagenes/Prestamo_Libro.png");
        this.jlRegistraDevolucion = new MiIcono("/imagenes/Devolver_Libro.png");
        this.jpCabecera = new MiPanelEscritorio("/imagenes/Header_2.jpg");

        this.jpOpciones.setLayout(null);
        this.jtpEscritorio.setLayout(null);

        this.jifSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        this.jlAgregarSocio = new MiIcono("/imagenes/Agregar_Socio.png");
        this.jlAgregarSocio.setBounds(160, 80, 64, 64);
        this.jifSocio.add(this.jlAgregarSocio);

        this.jbAgregarSocio = new MiBoton("Agregar Socio");
        this.jbAgregarSocio.setBounds(120, 160, 140, 40);
        this.jifSocio.add(this.jbAgregarSocio);

        this.jlQuitarSocio = new MiIcono("/imagenes/Borrar_Socio.png");
        this.jlQuitarSocio.setBounds(380, 80, 64, 64);
        this.jifSocio.add(this.jlQuitarSocio);

        this.jbQuitarSocio = new MiBoton("Quitar Socio");
        this.jbQuitarSocio.setBounds(340, 160, 140, 40); 
        this.jifSocio.add(this.jbQuitarSocio);

        this.jlListarSocios = new MiIcono("/imagenes/Lista_Socios.png");
        this.jlListarSocios.setBounds(160, 230, 64, 64);
        this.jifSocio.add(this.jlListarSocios);

        this.jbListarSocios = new MiBoton("Listar Socios");
        this.jbListarSocios.setBounds(120, 310, 140, 40);
        this.jifSocio.add(this.jbListarSocios);

        this.jlDocenteResponsable = new MiIcono("/imagenes/Docente_Responsable.png");
        this.jbDocenteResponsable = new MiBoton("Docentes Responsables");
        this.jifSocio.add(jlDocenteResponsable);       
        this.jbDocenteResponsable.setBounds(340, 310, 140, 40);
        this.jlDocenteResponsable.setBounds(380, 230, 64, 64);

        this.jbAgregarSocio.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbAgregarSocio.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbAgregarSocio.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt) {
                    jtpEscritorio.setSelectedComponent(jifAgregarSocio);
                }
            });

        this.jifSocio.add(jbQuitarSocio);
        this.jbQuitarSocio.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbQuitarSocio.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbQuitarSocio.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt) {
                    jtpEscritorio.setSelectedComponent(jifQuitarSocio);
                }
            });

        this.jbListarSocios.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    jtpEscritorio.setSelectedComponent(jifListarSocios);
                }

                public void mouseEntered(MouseEvent evt) {
                    jbListarSocios.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbListarSocios.jBotonMouseExited(evt);
                }
            });

        this.jifSocio.add(jbDocenteResponsable);
        this.jbDocenteResponsable.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbDocenteResponsable.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbDocenteResponsable.jBotonMouseExited(evt); 
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifDocenteResponsable);
                }
            });

        this.jifLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jlTituloLibro = new Titulos("Libros");
        this.jlAgregarLibros = new MiIcono("/imagenes/Agregar_Libro.png");
        this.jlQuitarLibro = new MiIcono("/imagenes/Quitar_Libro.png"); 
        this.jlListarLibros = new MiIcono("/imagenes/Lista_Libros.png");
        this.jbAgregarLibro = new MiBoton("Agregar Libro");
        this.jbQuitarLibro = new MiBoton("Quitar Libro");
        this.jbListarLibros = new MiBoton("Listar Libros");

        this.jlBuscarLibro = new MiIcono("/imagenes/Buscar_Libro.png");
        this.jbBuscarLibros = new MiBoton("Buscar Libro");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(800, 500));
        this.setResizable(false);
        this.setSize(new Dimension(800, 500));
        this.getContentPane().setLayout(null);

        this.jlTitulo.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.jlTitulo.setIcon(new ImageIcon(getClass().getResource("/imagenes/Libro_Abierto.png")));
        this.jlTitulo.setIconTextGap(10);
        this.jlTitulo.setFont(new Font("Lato", 1, 36));
        this.jlTitulo.setForeground(new Color(255, 255, 255));
        this.jlTitulo.setText(this.miBiblioteca.getNombre());

        // CONFIGURAR PANELES (Socio, Libro, Préstamo)
        configurarPanelAgregarSocio();
        configurarPanelQuitarSocio();
        configurarPanelListarSocios();
        configurarPanelListarDocenteResponsable();

        configurarPanelAgregarLibro();
        configurarQuitarLibro();
        configurarPanelListarLibros();
        configurarPanelBuscarLibro();

        this.configurarPanelAgregarPrestamo();
        this.configurarPanelRegistrarDevolucion();

        this.jpCabecera.add(jlTitulo);
        this.jlTitulo.setBounds(10, 10, 800, 64);        

        this.jifPrestamo.add(jlRegistraDevolucion);
        this.jifPrestamo.add(jlAgregarPrestamo);

        this.jlRegistraDevolucion.setBounds(350, 100, 64, 64); 
        this.jlAgregarPrestamo.setBounds(190, 100, 64, 64); 
        this.jbAgregarPrestamo.setBounds(155, 200, 140, 40); 
        this.jbRegistraDevolucion.setBounds(315, 200, 140, 40);

        this.jifLibro.add(jlAgregarLibros);
        this.jlAgregarLibros.setBounds(160, 80, 64, 64);

        this.jifLibro.add(jlQuitarLibro);
        this.jlQuitarLibro.setBounds(380, 80, 64, 64);

        this.jifLibro.add(jlListarLibros);
        this.jlListarLibros.setBounds(160, 230, 64, 64);

        this.jifLibro.add(jlBuscarLibro);
        this.jlBuscarLibro.setBounds(380, 230, 64, 64);

        this.jifLibro.add(jbAgregarLibro);
        this.jbAgregarLibro.setBounds(120, 160, 140, 40);
        this.jbAgregarLibro.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt){
                    jbAgregarLibro.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbAgregarLibro.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifAgregarLibro);
                }
            });

        this.jifLibro.add(jbQuitarLibro);
        this.jbQuitarLibro.setBounds(340, 160, 140, 40);
        this.jbQuitarLibro.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbQuitarLibro.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbQuitarLibro.jBotonMouseExited(evt); 
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifQuitarLibro);
                }
            });

        this.jifLibro.add(jbListarLibros);
        this.jbListarLibros.setBounds(120, 310, 140, 40);
        this.jbListarLibros.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbListarLibros.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbListarLibros.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifListarLibros);
                }
            });

        this.jifLibro.add(jbBuscarLibros);
        this.jbBuscarLibros.setBounds(340, 310, 140, 40);
        this.jbBuscarLibros.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbBuscarLibros.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbBuscarLibros.jBotonMouseExited(evt); 
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifBuscarLibro);
                }
            });

        this.jtaTextoInicio.setFont(new Font("Corbel", 1, 40));
        this.jtaTextoInicio.setForeground(Color.white);
        this.jtaTextoInicio.setText("                  Bienvenido a\nSistema de Gestión Biblioteca");
        this.jtaTextoInicio.setOpaque(false);
        this.jifInicio.add(jtaTextoInicio);
        this.jtaTextoInicio.setBounds(50, 130, 1000, 100);

        this.jifSocio.add(jlTituloSocio);

        this.jifLibro.add(jlTituloLibro);

        this.jifPrestamo.add(jlTituloPrestamo);
        this.jifAgregarPrestamo.add(jlTituloAgregarPrestamo);

        this.jifPrestamo.add(jbAgregarPrestamo);
        this.jbAgregarPrestamo.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbAgregarPrestamo.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbAgregarPrestamo.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifAgregarPrestamoMouseClicked(evt);
                }
            });

        this.jifPrestamo.add(jbRegistraDevolucion);
        this.jbRegistraDevolucion.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbRegistraDevolucion.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbRegistraDevolucion.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifRegistrarDevolucionMouseClicked(evt);
                }
            });   

        this.jpOpciones.setBackground(new Color(33, 37, 41));

        // Inicio
        this.jbOpcionInicio.setText("Inicio");
        this.jbOpcionInicio.setIcon(new ImageIcon(getClass().getResource("/imagenes/M_Inicio.png"))); 
        this.jpOpciones.add(jbOpcionInicio);
        this.jbOpcionInicio.setBounds(0, 20, 170, 80);

        this.jbOpcionInicio.addMouseListener(new MouseAdapter() { 
                public void mouseEntered(MouseEvent evt) {        
                    jbOpcionInicio.jbOpcionMouseEntered(evt);    
                    setBotonActivo(jbOpcionInicio);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionInicio.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifInicioMouseClicked(evt);
                }
            });

        this.jbOpcionSocios.setText("Socios");
        this.jbOpcionSocios.setIcon(new ImageIcon(getClass().getResource("/imagenes/M_Socios.png"))); 
        this.jpOpciones.add(jbOpcionSocios);
        this.jbOpcionSocios.setBounds(0, 100, 170, 80);
        this.jbOpcionSocios.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionSocios.jbOpcionMouseEntered(evt);
                    setBotonActivo(jbOpcionSocios);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionSocios.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifSocioMouseClicked(evt);
                }
            });

        this.jbOpcionLibros.setText("Libros");
        this.jbOpcionLibros.setIcon(new ImageIcon(getClass().getResource("/imagenes/M_Libros.png"))); 
        this.jpOpciones.add(jbOpcionLibros);
        this.jbOpcionLibros.setBounds(0, 180, 170, 80); 
        this.jbOpcionLibros.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionLibros.jbOpcionMouseEntered(evt);
                    setBotonActivo(jbOpcionLibros);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionLibros.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifLibroMouseClicked(evt);
                }
            });

        this.jbOpcionPrestamos.setText("Prestamos");
        this.jbOpcionPrestamos.setIcon(new ImageIcon(getClass().getResource("/imagenes/M_Prestamos.png"))); 
        this.jpOpciones.add(jbOpcionPrestamos);
        this.jbOpcionPrestamos.setBounds(0, 260, 170, 80);
        this.jbOpcionPrestamos.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionPrestamos.jbOpcionMouseEntered(evt);
                    setBotonActivo(jbOpcionPrestamos);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionPrestamos.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifPrestamoMouseClicked(evt);
                }
            });

        this.getContentPane().add(jtpEscritorio);
        this.jtpEscritorio.setBounds(170, 90, 730, 420);
        this.jtpEscritorio.addTab("tab1", jifInicio);
        this.jtpEscritorio.addTab("tab2", jifSocio);
        this.jtpEscritorio.addTab("tab3", jifPrestamo);
        this.jtpEscritorio.addTab("tab4", jifAgregarSocio); 
        this.jtpEscritorio.addTab("tab5", jifQuitarSocio);
        this.jtpEscritorio.addTab("tab6", jifListarSocios);
        this.jtpEscritorio.addTab("tab7", jifLibro);
        this.jtpEscritorio.addTab("tab8", jifAgregarLibro);
        this.jtpEscritorio.addTab("tab9", jifQuitarLibro);
        this.jtpEscritorio.addTab("tab10", jifListarLibros);
        this.jtpEscritorio.addTab("tab11", jifAgregarPrestamo);
        this.jtpEscritorio.addTab("tab12", jifRegistrarDevolucion);
        this.jtpEscritorio.addTab("tab14", jifBuscarLibro);
        this.jtpEscritorio.addTab("tab15", jifDocenteResponsable);
        this.jifLibro.setBounds(0, 0, 730, 420);

        this.getContentPane().add(jpOpciones);
        this.jpOpciones.setBounds(0, 90, 170, 420);

        this.getContentPane().add(jpCabecera);
        this.jpCabecera.setBounds(0, 0, 900, 100);

        this.pack();
        this.setVisible(true);

        // Extra: Botones
        this.botonesNavegacion = new ArrayList<>();
        this.botonesNavegacion.add(this.jbOpcionInicio);
        this.botonesNavegacion.add(this.jbOpcionSocios);
        this.botonesNavegacion.add(this.jbOpcionLibros);
        this.botonesNavegacion.add(this.jbOpcionPrestamos);
        this.pack();
        this.setVisible(true);

        setBotonActivo(jbOpcionInicio);
    } 

    /**
     * Maneja el evento de clic para la opción "Inicio" del menú.
     * Cambia la pestaña visible al panel de inicio (jifInicio).
     *
     * @param evt El evento del mouse que disparó la acción.
     */
    private void jifInicioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifInicio);
    }

    /**
     * Maneja el evento de clic para la opción "Socios" del menú.
     * Cambia la pestaña visible al panel de socios (jifSocio).
     *
     * @param evt El evento del mouse que disparó la acción.
     */
    private void jifSocioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifSocio);
    }

    /**
     * Maneja el evento de clic para la opción "Préstamos" del menú.
     * Cambia la pestaña visible al panel de préstamos (jifPrestamo).
     *
     * @param evt El evento del mouse que disparó la acción.
     */
    private void jifPrestamoMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifPrestamo);
    }

    /**
     * Maneja el evento de clic para el sub-botón "Agregar Socio".
     * Cambia la pestaña visible al panel de agregar socio (jifAgregarSocio).
     *
     * @param evt El evento del mouse que disparó la acción.
     */
    private void jifAgregarSocioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifAgregarSocio);
    }

    /**
     * Maneja el evento de clic para la opción "Libros" del menú.
     * Cambia la pestaña visible al panel de libros (jifLibro).
     *
     * @param evt El evento del mouse que disparó la acción.
     */
    private void jifLibroMouseClicked(MouseEvent evt){
        this.jtpEscritorio.setSelectedComponent(jifLibro);
    }

    /**
     * Maneja el evento de clic para el sub-botón "Agregar Préstamo".
     * Cambia la pestaña visible al panel de agregar préstamo (jifAgregarPrestamo).
     *
     * @param evt El evento del mouse que disparó la acción.
     */
    private void jifAgregarPrestamoMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifAgregarPrestamo);
    }

    /**
     * Maneja el evento de clic para el sub-botón "Registrar Devolución".
     * Cambia la pestaña visible al panel de registrar devolución (jifRegistrarDevolucion).
     *
     * @param evt El evento del mouse que disparó la acción.
     */
    private void jifRegistrarDevolucionMouseClicked(MouseEvent evt){
        this.jtpEscritorio.setSelectedComponent(jifRegistrarDevolucion);
    }

    /**
     * Configura el panel (jifAgregarSocio) para agregar un nuevo socio (Alumno o Docente).
     * Define las etiquetas, campos de texto, radio buttons y el botón "Guardar"
     * con su lógica de validación y creación de socio.
     */
    private void configurarPanelAgregarSocio() {

        jifAgregarSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        Titulos jlTituloForm = new Titulos("Agregar Nuevo Socio");
        jifAgregarSocio.add(jlTituloForm);

        rbDocente = new JRadioButton("Docente");
        rbDocente.setFont(new Font("Corbel", Font.BOLD, 14));
        rbDocente.setForeground(Color.white);
        rbDocente.setOpaque(false);
        rbDocente.setBounds(220, 70, 100, 30);
        jifAgregarSocio.add(rbDocente);

        rbAlumno = new JRadioButton("Alumno");
        rbAlumno.setFont(new Font("Corbel", Font.BOLD, 14));
        rbAlumno.setForeground(Color.white);
        rbAlumno.setOpaque(false);
        rbAlumno.setSelected(true); 
        rbAlumno.setBounds(330, 70, 100, 30);
        jifAgregarSocio.add(rbAlumno);

        bgTipoSocio = new ButtonGroup();
        bgTipoSocio.add(rbDocente);
        bgTipoSocio.add(rbAlumno);

        jlDNI = new MiEtiqueta("DNI: ");
        jlDNI.setBounds(75, 120, 200, 25);
        jifAgregarSocio.add(jlDNI);

        jtfDNI = new JTextField();
        jtfDNI.setBounds(75, 150, 220, 28);
        jifAgregarSocio.add(jtfDNI);

        jlNombre = new MiEtiqueta("Nombre Completo:");
        jlNombre.setBounds(75, 190, 200, 25);
        jifAgregarSocio.add(jlNombre);

        jtfNombre = new JTextField();
        jtfNombre.setBounds(75, 220, 220, 28);
        jifAgregarSocio.add(jtfNombre);

        jlCarreraAsignatura = new MiEtiqueta("Carrera:"); 
        jlCarreraAsignatura.setBounds(355, 120, 200, 25);
        jifAgregarSocio.add(jlCarreraAsignatura);

        jtfCarreraAsignatura = new JTextField();
        jtfCarreraAsignatura.setBounds(355, 150, 220, 28);
        jifAgregarSocio.add(jtfCarreraAsignatura);

        jlDiasPrestamo = new MiEtiqueta("Días de Préstamo:");
        jlDiasPrestamo.setBounds(355, 190, 200, 25);
        jifAgregarSocio.add(jlDiasPrestamo);

        jtfDiasPrestamo = new JTextField("20"); 
        jtfDiasPrestamo.setEnabled(false); 
        jtfDiasPrestamo.setBounds(355, 220, 220, 28);
        jifAgregarSocio.add(jtfDiasPrestamo);

        jbGuardarSocio = new MiBoton("Guardar Socio");
        jbGuardarSocio.setBounds(240, 300, 140, 40); 
        jifAgregarSocio.add(jbGuardarSocio);

        ActionListener radioListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (rbDocente.isSelected()) {
                        jlCarreraAsignatura.setText("Asignatura:");
                        jtfDiasPrestamo.setText("5");
                    } else if (rbAlumno.isSelected()) {
                        jlCarreraAsignatura.setText("Carrera:");
                        jtfDiasPrestamo.setText("20");
                    }
                }
            };
        rbDocente.addActionListener(radioListener);
        rbAlumno.addActionListener(radioListener);

        jbGuardarSocio.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {

                    try {
                        String dniTexto = jtfDNI.getText().trim();
                        String nombre = jtfNombre.getText().trim();
                        String carreraAsignatura = jtfCarreraAsignatura.getText().trim();
                        String diasTexto = jtfDiasPrestamo.getText().trim();

                        if (dniTexto.isEmpty() || nombre.isEmpty() || carreraAsignatura.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Complete todos los campos correctamente.");
                            return;
                        }

                        int dni = Integer.parseInt(dniTexto);
                        int dias = Integer.parseInt(diasTexto);

                        if (miBiblioteca.buscarSocio(dni) != null) {
                            JOptionPane.showMessageDialog(null, "Ya existe un socio con ese DNI.");
                            return;
                        }

                        if (rbDocente.isSelected()) {
                            miBiblioteca.nuevoSocioDocente(dni, nombre, dias, carreraAsignatura);
                            JOptionPane.showMessageDialog(null, "Docente agregado con éxito.");

                        } else {
                            miBiblioteca.nuevoSocioEstudiante(dni, nombre, dias, carreraAsignatura);
                            JOptionPane.showMessageDialog(null, "Alumno agregado con éxito.");
                        }

                        jtfDNI.setText("");
                        jtfNombre.setText("");
                        jtfCarreraAsignatura.setText("");

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "El DNI debe ser numérico.");
                    }
                }

                public void mouseEntered(MouseEvent evt) {
                    jbGuardarSocio.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbGuardarSocio.jBotonMouseExited(evt);
                }
            });

    }

    /**
     * Configura el panel (jifQuitarSocio) para eliminar un socio existente.
     * Define el campo de texto para el DNI y el botón "Quitar Usuario"
     * con su lógica de búsqueda y eliminación.
     */
    private void configurarPanelQuitarSocio() {
        jifQuitarSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        Titulos jlTituloForm = new Titulos("Quitar Usuario");
        jifQuitarSocio.add(jlTituloForm);

        MiEtiqueta jlDNIQuitar = new MiEtiqueta("DNI:");
        jlDNIQuitar.setBounds(190, 120, 200, 25);
        jifQuitarSocio.add(jlDNIQuitar);

        jtfDNIQuitar = new JTextField();
        jtfDNIQuitar.setBounds(190, 150, 220, 28);
        jifQuitarSocio.add(jtfDNIQuitar);

        MiBoton jbEliminarSocio = new MiBoton("Quitar Usuario");
        jbEliminarSocio.setBounds(240, 300, 140, 40);
        jifQuitarSocio.add(jbEliminarSocio);

        jbEliminarSocio.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    try {
                        String textoDNI = jtfDNIQuitar.getText().trim();

                        if (textoDNI.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese un DNI válido.");
                            return;
                        }

                        int DNI = Integer.parseInt(textoDNI); 
                        Socio socio = miBiblioteca.buscarSocio(DNI);

                        if (socio == null) {
                            JOptionPane.showMessageDialog(null, "No existe un socio con ese DNI.");
                            return;
                        }

                        miBiblioteca.eliminarSocio(socio);
                        JOptionPane.showMessageDialog(null, "Socio eliminado correctamente.");

                        jtfDNIQuitar.setText(""); 

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El DNI debe ser un número.");
                    }
                }

                public void mouseEntered(MouseEvent evt) {
                    jbEliminarSocio.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbEliminarSocio.jBotonMouseExited(evt);
                }
            });
    }

    /**
     * Configura el panel (jifListarSocios) para mostrar un listado de todos los socios.
     * Define un JTextArea dentro de un JScrollPane y un botón "Actualizar Lista"
     * para poblar el área de texto con la información de la biblioteca.
     */
    private void configurarPanelListarSocios() {
        jifListarSocios = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        Titulos jlTitulo = new Titulos("Listado de Socios");
        jifListarSocios.add(jlTitulo);

        taListadoSocios = new JTextArea();
        taListadoSocios.setEditable(false);
        taListadoSocios.setOpaque(false);
        taListadoSocios.setForeground(Color.white);
        taListadoSocios.setFont(new Font("Corbel", Font.BOLD, 14));
        taListadoSocios.setLineWrap(true);
        taListadoSocios.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(taListadoSocios);
        scroll.setBounds(70, 60, 500, 220);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        jifListarSocios.add(scroll);

        MiBoton jbActualizarListarSocios = new MiBoton("Actualizar Lista");
        jbActualizarListarSocios.setBounds(240, 300, 140, 40);
        jifListarSocios.add(jbActualizarListarSocios);

        jbActualizarListarSocios.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    taListadoSocios.setText(miBiblioteca.listarSocio());
                    taListadoSocios.setCaretPosition(0);
                }

                public void mouseEntered(MouseEvent evt) {
                    jbActualizarListarSocios.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbActualizarListarSocios.jBotonMouseExited(evt);
                }
            });

    }

    /**
     * Configura el panel (jifDocenteResponsable) para mostrar un listado de docentes
     * que tienen préstamos vencidos (docentes responsables).
     * Define un JTextArea y un botón de actualización.
     */
    private void configurarPanelListarDocenteResponsable(){
        jifDocenteResponsable = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        Titulos jlTitulo = new Titulos("Listado de Docentes Responsable");
        jifDocenteResponsable.add(jlTitulo);

        elListadoDocenteResponsable = new JTextArea();
        elListadoDocenteResponsable.setEditable(false);
        elListadoDocenteResponsable.setOpaque(false);
        elListadoDocenteResponsable.setForeground(Color.white);
        elListadoDocenteResponsable.setFont(new Font("Corbel", Font.BOLD, 14));
        elListadoDocenteResponsable.setLineWrap(true);
        elListadoDocenteResponsable.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(elListadoDocenteResponsable);
        scroll.setBounds(70, 60, 500, 220);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        jifDocenteResponsable.add(scroll);

        MiBoton jbListaDocenteResponsable = new MiBoton("Actualizar Lista");
        jbListaDocenteResponsable.setBounds(240, 300, 140, 40);
        jifDocenteResponsable.add(jbListaDocenteResponsable);

        jbListaDocenteResponsable.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){
                    elListadoDocenteResponsable.setText(miBiblioteca.listaDeDocentesResponsables());
                    elListadoDocenteResponsable.setCaretPosition(0);
                }

                public void mouseEntered(MouseEvent evt){
                    jbListaDocenteResponsable.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbListaDocenteResponsable.jBotonMouseExited(evt);
                }
            });
    }

    /**
     * Configura el panel (jifAgregarLibro) para agregar un nuevo libro al catálogo.
     * Define los campos de texto (Título, Editorial, Edición, Año) y el botón "Guardar Libro"
     * con su lógica de validación y creación.
     */
    private void configurarPanelAgregarLibro(){
        jifAgregarLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        Titulos jlTituloForm = new Titulos("Agregar Nuevo Libro");
        jifAgregarLibro.add(jlTituloForm);

        MiEtiqueta jlTitulo1 = new MiEtiqueta("Titulo:");
        jlTitulo1.setBounds(75, 90, 200, 25); 
        jifAgregarLibro.add(jlTitulo1);

        jtfTituloLibro = new JTextField();
        jtfTituloLibro.setBounds(75, 120, 220, 28); 
        jifAgregarLibro.add(jtfTituloLibro);

        MiEtiqueta jlEditorial = new MiEtiqueta("Editorial:");
        jlEditorial.setBounds(75, 160, 200, 25); 
        jifAgregarLibro.add(jlEditorial);

        jtfEditorial = new JTextField(); 
        jtfEditorial.setBounds(75, 190, 220, 28); 
        jifAgregarLibro.add(jtfEditorial);

        MiEtiqueta jlEdicion = new MiEtiqueta("Edicion (numero): ");
        jlEdicion.setBounds(355, 90, 200, 25); 
        jifAgregarLibro.add(jlEdicion);

        jtfEdicion = new JTextField();
        jtfEdicion.setBounds(355, 120, 220, 28); 
        jifAgregarLibro.add(jtfEdicion);

        MiEtiqueta jlAnio = new MiEtiqueta("Año (numero):");
        jlAnio.setBounds(355, 160, 200, 25); 
        jifAgregarLibro.add(jlAnio);

        jtfAnio = new JTextField();
        jtfAnio.setBounds(355, 190, 220, 28); 
        jifAgregarLibro.add(jtfAnio);

        jbGuardarLibro = new MiBoton("Guardar Libro");
        jbGuardarLibro.setBounds(240, 300, 140, 40);
        jifAgregarLibro.add(jbGuardarLibro);

        jbGuardarLibro.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){
                    try{
                        String titulo = jtfTituloLibro.getText().trim();
                        String editorial= jtfEditorial.getText().trim();
                        String edicionTexto = jtfEdicion.getText().trim();
                        String anioTexto = jtfAnio.getText().trim();

                        if(titulo.isEmpty() || editorial.isEmpty() || edicionTexto.isEmpty() || anioTexto.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Complete todos los campos para agregar el Libro ");
                            return;
                        }

                        int edicion = Integer.parseInt(edicionTexto);
                        int anio = Integer.parseInt(anioTexto);

                        miBiblioteca.nuevoLibro(titulo, edicion, editorial, anio);
                        JOptionPane.showMessageDialog(null, "Libro agregado con éxito.");

                        jtfTituloLibro.setText("");
                        jtfEditorial.setText("");
                        jtfEdicion.setText("");
                        jtfAnio.setText("");
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Edición y Año deben ser numéricos.");
                    }
                }

                public void mouseEntered(MouseEvent evt){
                    jbGuardarLibro.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbGuardarLibro.jBotonMouseExited(evt);
                }
            });
    }

    /**
     * Configura el panel (jifQuitarLibro) para eliminar un libro del catálogo.
     * Define el campo de texto para el Título y el botón "Quitar Libro"
     * con su lógica de validación (ej. no se puede quitar si está prestado).
     */   
    private void configurarQuitarLibro(){
        jifQuitarLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg"); 

        Titulos jlTituloForm = new Titulos("Quitar Libro del Catálogo");
        jifQuitarLibro.add(jlTituloForm);

        MiEtiqueta jlTituloQuitar = new MiEtiqueta("Titulo del libro:");
        jlTituloQuitar.setBounds(190, 120, 200, 25);
        jifQuitarLibro.add(jlTituloQuitar);

        jtfTituloQuitar = new JTextField();
        jtfTituloQuitar.setBounds(190, 150, 220, 28);
        jifQuitarLibro.add(jtfTituloQuitar);

        jbQuitarLibroForm = new MiBoton("Quitar Libro");
        jbQuitarLibroForm.setBounds(240, 300, 140, 40);
        jifQuitarLibro.add(jbQuitarLibroForm);

        jbQuitarLibroForm.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){
                    String titulo = jtfTituloQuitar.getText().trim();

                    if(titulo.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
                        return;
                    }

                    Libro libro = null;
                    for(Libro unLibro : miBiblioteca.getLibros()){
                        if(titulo.equalsIgnoreCase(unLibro.getTitulo())){
                            libro = unLibro;
                        }
                    }

                    if(libro == null){
                        JOptionPane.showMessageDialog(null,"No existe un libro con ese Título.");
                        return;
                    }

                    if(libro.prestado()){
                        JOptionPane.showMessageDialog(null, "El libro '" + libro.getTitulo() + " no se puede eliminar porque está PRESTADO.");
                        return;
                    }

                    miBiblioteca.quitarLibro(libro);
                    JOptionPane.showMessageDialog(null, "Libro quitado con exito...");

                    jtfTituloQuitar.setText(""); 

                }

                public void mouseEntered(MouseEvent evt){
                    jbQuitarLibroForm.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbQuitarLibroForm.jBotonMouseExited(evt);
                }
            });

    }

    /**
     * Configura el panel (jifListarLibros) para mostrar un listado de todos los libros.
     * Define un JTextArea dentro de un JScrollPane y un botón "Actualizar lista"
     * para poblar el área de texto.
     */
    private void configurarPanelListarLibros(){
        jifListarLibros = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        Titulos jlTitulo = new Titulos("Listado de libros");
        jifListarLibros.add(jlTitulo);

        unListadoLibros = new JTextArea();
        unListadoLibros.setEditable(false);
        unListadoLibros.setOpaque(false);
        unListadoLibros.setForeground(Color.white);
        unListadoLibros.setFont(new Font("Corbel", Font.BOLD, 14));
        unListadoLibros.setLineWrap(true);
        unListadoLibros.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(unListadoLibros);
        scroll.setBounds(70, 60, 500, 220);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        jifListarLibros.add(scroll);

        jbActualizarListaLibros = new MiBoton("Actualizar lista");
        jbActualizarListaLibros.setBounds(240, 300, 140, 40);
        jifListarLibros.add(jbActualizarListaLibros);

        jbActualizarListaLibros.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){

                    unListadoLibros.setText(miBiblioteca.listaDeLibro());
                    unListadoLibros.setCaretPosition(0);

                }

                public void mouseEntered(MouseEvent evt){
                    jbActualizarListaLibros.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbActualizarListaLibros.jBotonMouseExited(evt);
                }
            });

    }

    /**
     * Configura el panel (jifBuscarLibro) para buscar la disponibilidad de un libro.
     * Permite al usuario ingresar un título y muestra un mensaje indicando
     * si el libro está disponible o quién lo tiene prestado.
     */
    private void configurarPanelBuscarLibro(){
        jifBuscarLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        Titulos jlTituloForm = new Titulos("Buscar Libro del Catálogo");
        jifBuscarLibro.add(jlTituloForm);

        MiEtiqueta jlTituloBuscar = new MiEtiqueta("Titulo del libro:");
        jlTituloBuscar.setBounds(190, 120, 200, 25);
        jifBuscarLibro.add(jlTituloBuscar);

        jtfTituloBuscar = new JTextField();
        jtfTituloBuscar.setBounds(190, 150, 220, 28);
        jifBuscarLibro.add(jtfTituloBuscar);

        jbBuscarLibroForm = new MiBoton("Buscar Disponibilidad");
        jbBuscarLibroForm.setBounds(240, 300, 140, 40);
        jifBuscarLibro.add(jbBuscarLibroForm);

        jbBuscarLibroForm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String tituloBuscado = jtfTituloBuscar.getText().trim(); 

                    if (tituloBuscado != null) {
                        boolean encontrado = false;
                        for (Libro unLibro : miBiblioteca.getLibros()) {
                            if (unLibro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                                encontrado = true;
                                try {
                                    String nombreSocio = miBiblioteca.quienTieneElLibro(unLibro);
                                    JOptionPane.showMessageDialog(null, "El libro '" + unLibro.getTitulo() + "' está prestado a " + nombreSocio + ".", 
                                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                } catch (LibroEnBibliotecaException ex) {
                                    JOptionPane.showMessageDialog(null, 
                                        "El libro '" + unLibro.getTitulo() + "' está en la biblioteca (disponible).","Resultado", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break; 
                            }
                        }

                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, 
                                "No se encontró ningún libro con el título '" + tituloBuscado + "'.", "Resultado", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            });
        jbBuscarLibroForm.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbBuscarLibroForm.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbBuscarLibroForm.jBotonMouseExited(evt);
                }
            });
    }

    /**
     * Configura el panel (jifAgregarPrestamo) para registrar un nuevo préstamo.
     * Define campos para la fecha (autocompletada), título del libro y DNI del socio,
     * y el botón "Registrar prestamo" con su lógica de validación.
     */
    private void configurarPanelAgregarPrestamo(){
        Date retiro = new GregorianCalendar().getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaR = formato.format(retiro);

        this.jlFechaRetiro = new MiEtiqueta("Fecha de retiro: ");
        this.jlTituloLibroRetiro = new MiEtiqueta("Titulo del libro a retirar: ");
        this.jlDniSocioRetiro = new MiEtiqueta("Dni del socio: ");
        this.jlTituloAgregarPrestamo = new Titulos("Agregar prestamo");
        this.jtfFechaRetiro = new JTextField();
        this.jtfTituloLibroRetiro = new JTextField();
        this.jtfDniSocioRetiro = new JTextField();
        this.jbRegistrarPrestamo = new MiBoton("Registrar prestamo");

        this.jifAgregarPrestamo.add(jlTituloAgregarPrestamo);

        this.jifAgregarPrestamo.add(jlFechaRetiro);
        this.jlFechaRetiro.setBounds(75, 90, 220, 28);

        this.jtfFechaRetiro.setText(fechaR);
        this.jifAgregarPrestamo.add(jtfFechaRetiro);
        this.jtfFechaRetiro.setBounds(75, 120, 220, 28);

        this.jifAgregarPrestamo.add(jlTituloLibroRetiro);
        this.jlTituloLibroRetiro.setBounds(75, 160, 220, 28);

        this.jifAgregarPrestamo.add(jtfTituloLibroRetiro);
        this.jtfTituloLibroRetiro.setBounds(75, 190, 220, 28);

        this.jifAgregarPrestamo.add(jlDniSocioRetiro);
        this.jlDniSocioRetiro.setBounds(355, 160, 220, 28);

        this.jifAgregarPrestamo.add(jtfDniSocioRetiro);
        this.jtfDniSocioRetiro.setBounds(355, 190, 220, 28);

        this.jifAgregarPrestamo.add(jbRegistrarPrestamo);
        this.jbRegistrarPrestamo.setBounds(250, 270, 130, 40);
        this.jbRegistrarPrestamo.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbRegistrarPrestamo.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbRegistrarPrestamo.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    try{
                        Date hoy = formato.parse(jtfFechaRetiro.getText());
                        Calendar fech =  Calendar.getInstance();
                        fech.setTime(hoy);
                        String titulo = jtfTituloLibroRetiro.getText().trim();
                        if(titulo.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
                            return;
                        }
                        Libro libro = null;
                        for(Libro unLibro : miBiblioteca.getLibros()){
                            if(unLibro.getTitulo().equalsIgnoreCase(titulo)){
                                libro = unLibro;
                            }
                        }
                        if(libro != null && (miBiblioteca.prestarLibro(fech, miBiblioteca.buscarSocio(Integer.parseInt(jtfDniSocioRetiro.getText())), libro))){
                            JOptionPane.showMessageDialog(null, libro.ultimoPrestamo().toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Datos invalidos");
                        }
                    }catch(ParseException ex){
                        JOptionPane.showMessageDialog(null, "Error en la fecha");
                    }
                }
            });
        this.jtfDniSocioRetiro.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent evt){
                    if(jtfDniSocioRetiro.getText().length() <= 10){
                        controlNumeros(evt);
                    } else {
                        evt.consume();
                    }
                }
            });    
    }

    /**
     * Configura el panel (jifRegistrarDevolucion) para registrar la devolución de un libro.
     * Define campos para la fecha (autocompletada) y el título del libro,
     * y el botón "Registrar devolucion" con su lógica.
     */
    private void configurarPanelRegistrarDevolucion(){
        Date retiro = new GregorianCalendar().getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaD = formato.format(retiro);

        this.jifRegistrarDevolucion = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jlTituloRegistrarDevolucion = new Titulos("Registrar devolucion");
        this.jlFechaDevolucion = new MiEtiqueta("Fecha de devolucion: ");
        this.jlTituloLibroDevuelto = new MiEtiqueta("Titulo del libro: ");
        this.jtfFechaDevolucion = new JTextField();
        this.jtfTituloLibroDevuelto = new JTextField();
        this.jbRegistrarLibroDevolucion = new MiBoton("Registrar devolucion");

        this.jifRegistrarDevolucion.add(jlTituloRegistrarDevolucion);
        this.jifRegistrarDevolucion.add(jlFechaDevolucion);
        this.jlFechaDevolucion.setBounds(190, 90, 220, 28);

        this.jtfFechaDevolucion.setText(fechaD);
        this.jifRegistrarDevolucion.add(jtfFechaDevolucion);
        this.jtfFechaDevolucion.setBounds(190, 120, 220, 28);

        this.jifRegistrarDevolucion.add(jlTituloLibroDevuelto);
        this.jlTituloLibroDevuelto.setBounds(190, 160, 220, 28);

        this.jifRegistrarDevolucion.add(jtfTituloLibroDevuelto);
        this.jtfTituloLibroDevuelto.setBounds(190, 190, 220, 28);

        this.jifRegistrarDevolucion.add(jbRegistrarLibroDevolucion);
        this.jbRegistrarLibroDevolucion.setBounds(240, 300, 140, 40);
        this.jbRegistrarLibroDevolucion.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbRegistrarLibroDevolucion.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbRegistrarLibroDevolucion.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    String tituloD = jtfTituloLibroDevuelto.getText().trim();
                    if(tituloD.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
                        return;
                    }
                    Libro libro = null;
                    for(Libro unLibro : miBiblioteca.getLibros()){
                        if(unLibro.getTitulo().equalsIgnoreCase(tituloD)){
                            libro = unLibro;
                        }
                    }
                    if(libro != null){
                        try {
                            miBiblioteca.devolverLibro(libro);
                            JOptionPane.showMessageDialog(null, "Devolucion registrada");
                        } catch (LibroEnBibliotecaException ex) {
                            JOptionPane.showMessageDialog(null, "El libro no figura como prestado");
                        }
                    }
                }
            });
    }

    /**
     * Inicializa la instancia de la Biblioteca con datos de prueba.
     * Carga socios (docentes y estudiantes), libros y registra algunos préstamos
     * para simular un estado inicial de la aplicación.
     */
    private void iniciarBiblioteca(){
        this.miBiblioteca = new Biblioteca("Biblioteca Central");

        this.miBiblioteca.nuevoSocioDocente(14524782, "Juan Perez", 5, "Informática");
        this.miBiblioteca.nuevoSocioDocente(17982110, "Juan Fernández", 5, "Matemática");
        this.miBiblioteca.nuevoSocioDocente(10912002, "María Alegre", 5, "Letras");

        this.miBiblioteca.nuevoSocioEstudiante(28987498, "Francisco Paenza", 20, "Ingeniería");
        this.miBiblioteca.nuevoSocioEstudiante(31987123, "Cesar Milstein", 20, "Medicina");

        this.miBiblioteca.nuevoLibro("JAVA. Como Programar", 9, "Pearson", 2014);
        this.miBiblioteca.nuevoLibro("Longman. Diccionario Pocket", 1, "Longman", 2010);
        this.miBiblioteca.nuevoLibro("Vivir para contarla", 1, "Sudamericana", 2002);
        this.miBiblioteca.nuevoLibro("Programando con JAVA", 1, "Editorial X", 2020); 

        Socio socio1 = this.miBiblioteca.buscarSocio(14524782);
        Libro libro1 = this.miBiblioteca.getLibros().get(1); 
        if (socio1 != null && libro1 != null) {this.miBiblioteca.prestarLibro(new GregorianCalendar(), socio1, libro1);}
        Socio socio2 = miBiblioteca.buscarSocio(28987498);
        Libro libro2 = miBiblioteca.getLibros().get(3); 
        if (socio2 != null && libro2 != null) {this.miBiblioteca.prestarLibro(new GregorianCalendar(), socio2, libro2);}
        Socio socio3 = miBiblioteca.buscarSocio(31987123);
        Libro libro3 = miBiblioteca.getLibros().get(2); 
        if (socio3 != null && libro3 != null) {this.miBiblioteca.prestarLibro(new GregorianCalendar(), socio3, libro3);}

        this.miBiblioteca.nuevoSocioDocente(26987456, "Graciela Vallejos", 5, "Sistemas");
        this.miBiblioteca.nuevoLibro("Sistemas Operativos Modernos", 1, "Global", 2000);
        Calendar fechaVencida = new GregorianCalendar();
        fechaVencida.add(Calendar.DAY_OF_MONTH, -30); 
        Socio socioNoResponsable = this.miBiblioteca.buscarSocio(26987456);
        Libro libro4 = this.miBiblioteca.getLibros().get(4);
        this.miBiblioteca.prestarLibro(fechaVencida, socioNoResponsable, libro4);
    }

    /**
     * Método de utilidad para el control de entrada de teclado.
     * Consume el evento (impide que se escriba) si el carácter es una letra
     * (permitiendo solo números o teclas de control).
     *
     * @param evt El evento de teclado.
     */
    private void controlNumeros(KeyEvent evt){
        if(Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }

    /**
     * Establece un botón de navegación como activo y desactiva todos los demás.
     * @param botonActivo El botón que debe mostrarse como seleccionado.
     */
    private void setBotonActivo(MisOpciones botonActivo) {
        for (MisOpciones boton : botonesNavegacion) {
            if (boton == botonActivo) {
                boton.setActive(true);
            } else {
                boton.setActive(false);
            }
        }
    }
}
