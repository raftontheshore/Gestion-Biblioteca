import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Menu extends JFrame {
    private Biblioteca miBiblioteca;
    // Declaracion de variables - no modificar
    private MisOpciones jbOpcionInicio;
    private MisOpciones jbOpcionLibros;
    private MisOpciones jbOpcionPrestamos;
    private MisOpciones jbOpcionSocios;

    // Socios
    private MiIcono jlAgregarPrestamo;
    private MiIcono jlRegistraDevolucion;
    private MiIcono jlListarPrestamos;
    private JTextArea taListadoSocios;

    private MiBoton jbAgregarPrestamo;
    private MiBoton jbRegistraDevolucion;
    private MiBoton jbListarPrestamos;
    private JLabel jlTitulo;
    private JTabbedPane jtpEscritorio;
    private MiPanelEscritorio jpCabecera;
    private MiPanelEscritorio jifInicio;
    private MiPanelEscritorio jifSocio;
    private MiPanelEscritorio jifPrestamo;
    private MiPanelEscritorio jifAgregarPrestamo;
    private JPanel jpOpciones;
    private JTextArea jtaTextoInicio;
    private Titulos jlTituloSocio;
    private Titulos jlTituloPrestamo;

    // Iconos Socio
    private MiBoton jbAgregarSocio;
    private MiBoton jbQuitarSocio;
    private MiBoton jbListarSocios;

    private MiIcono jlAgregarSocio;
    private MiIcono jlQuitarSocio;
    private MiIcono jlListarSocios;

    // Componentes De Agregar Socio
    private MiPanelEscritorio jifAgregarSocio;
    private MiPanelEscritorio jifQuitarSocio;
    private MiPanelEscritorio jifListarSocios;
    private JRadioButton rbDocente;
    private JRadioButton rbAlumno;
    private ButtonGroup bgTipoSocio;
    private JLabel jlDNI;
    private JTextField jtfDNI;
    private JTextField jtfDNIQuitar;
    private JLabel jlNombre;
    private JTextField jtfNombre;
    private JLabel jlDiasPrestamo;
    private JTextField jtfDiasPrestamo;
    private JLabel jlCarreraAsignatura; 
    private JTextField jtfCarreraAsignatura;
    private MiBoton jbGuardarSocio; 
    private Titulos jlTituloAgregarPrestamo;

    //agregado mio DE LIBRO 
    private MiPanelEscritorio jifLibro; //Este es el panel o ventana interna principal que contiene todo lo relacionado con los socios. Cuando el usuario hace clic en jbOpcionSocios
    private MiIcono jlAgregarLibros; //Un icono que el usuario puede pulsar para añadir un nuevo libro
    private MiIcono jlQuitarLibro; // lo mismo que agregar
    private MiIcono jlListarLibros; // icono para listar
    private MiBoton jbAgregarLibro;
    private MiBoton jbQuitarLibro; //boton de quitarLibro
    private MiBoton jbListarLibros; // listar los libros
    private Titulos jlTituloLibro;
    //  

    public Menu() {
        this.iniciarBiblioteca();
        this.iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Inicializar los atributos
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
        this.jbListarPrestamos = new MiBoton("Listar Prestamos");
        this.jbOpcionInicio = new MisOpciones();
        this.jtaTextoInicio = new JTextArea();
        this.jlTituloSocio = new Titulos("Socios");
        this.jlTituloPrestamo = new Titulos("Prestamos");
        this.jlTituloAgregarPrestamo = new Titulos("Agregar prestamo");
        this.jtpEscritorio = new JTabbedPane();
        this.jlAgregarPrestamo = new MiIcono("/imagenes/Prestamo_Libro.png");
        this.jlRegistraDevolucion = new MiIcono("/imagenes/Devolver_Libro.png");
        this.jlListarPrestamos = new MiIcono("/imagenes/Lista_Prestamos.png");
        this.jpCabecera = new MiPanelEscritorio("/imagenes/Header.jpeg");

        // Iconos Socios
        this.jifSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jifSocio.setLayout(null);

        // Título
        this.jlTituloSocio = new Titulos("Socios");
        this.jlTituloSocio.setBounds(40, 50, 200, 40);
        this.jifSocio.add(this.jlTituloSocio);

        // Agregar Socio
        this.jlAgregarSocio = new MiIcono("/imagenes/Agregar_Socio.png");
        this.jlAgregarSocio.setBounds(80, 100, 64, 64); // movido
        this.jifSocio.add(this.jlAgregarSocio);

        this.jbAgregarSocio = new MiBoton("Agregar Socio");
        this.jbAgregarSocio.setBounds(40, 180, 140, 40); // igual
        this.jifSocio.add(this.jbAgregarSocio);

        // Quitar Socio
        this.jlQuitarSocio = new MiIcono("/imagenes/Borrar_Socio.png");
        this.jlQuitarSocio.setBounds(280, 100, 64, 64); // movido
        this.jifSocio.add(this.jlQuitarSocio);

        this.jbQuitarSocio = new MiBoton("Quitar Socio");
        this.jbQuitarSocio.setBounds(240, 180, 140, 40); // igual
        this.jifSocio.add(this.jbQuitarSocio);

        // Listar Socios
        this.jlListarSocios = new MiIcono("/imagenes/Lista_Socios.png");
        this.jlListarSocios.setBounds(480, 100, 64, 64); // movido
        this.jifSocio.add(this.jlListarSocios);

        this.jbListarSocios = new MiBoton("Listar Socios");
        this.jbListarSocios.setBounds(440, 180, 140, 40); // igual
        this.jifSocio.add(this.jbListarSocios);

        this.jifSocio.add(jbAgregarSocio);
        this.jbAgregarSocio.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbAgregarSocio.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbAgregarSocio.jBotonMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt) {
                    jtpEscritorio.setSelectedIndex(3); 
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
                    jtpEscritorio.setSelectedIndex(4); 
                }
            });

        this.jbListarSocios.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    int index = jtpEscritorio.indexOfComponent(jifListarSocios);
                    if (index != -1) {
                        jtpEscritorio.setSelectedIndex(index);
                    }
                }

                public void mouseEntered(MouseEvent evt) {
                    jbListarSocios.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbListarSocios.jBotonMouseExited(evt);
                }
            });

        //lo que SE AGREGO DE LIBRO
        this.jifLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jlTituloLibro = new Titulos("Libros");
        this.jlAgregarLibros = new MiIcono("/imagenes/Agregar_Libro.png");// por ahora dejo los mismos que socio y despues busco uno mejor
        this.jlQuitarLibro = new MiIcono("/imagenes/Quitar_Libro.png"); // Equivalente a "Borrar_Socio"
        this.jlListarLibros = new MiIcono("/imagenes/Lista_Libros.png");
        this.jbAgregarLibro = new MiBoton("Agregar Libro");
        this.jbQuitarLibro = new MiBoton("Quitar Libro");
        this.jbListarLibros = new MiBoton("Listar Libros");
        //_--------------------------------------------

        //Settea los atributos de la ventana principal
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(800, 500));
        this.setResizable(false);
        this.setSize(new Dimension(800, 500));
        this.getContentPane().setLayout(null);

        //Settea los atributos del titulo de la cabecera
        this.jlTitulo.setVerticalTextPosition(SwingConstants.BOTTOM);//Posicion vertical del texto respecto al ancho y alto del componente
        this.jlTitulo.setIcon(new ImageIcon(getClass().getResource("/imagenes/Libro_Abierto.png")));//Settea la icono que acompaña al titulo
        this.jlTitulo.setIconTextGap(10);//Settea el espacio que separa al icono del texto
        this.jlTitulo.setFont(new Font("Corbel", 1, 36));//Settea la fuente y el tamaño
        this.jlTitulo.setForeground(new Color(100, 100, 100));//Settea el color de la fuente
        this.jlTitulo.setText(this.miBiblioteca.getNombre());

        // PANELES OPCIONES SOCIOS
        configurarPanelAgregarSocio();
        configurarPanelQuitarSocio();
        configurarPanelListarSocios();

        //Settea el Layout de los paneles a null para ubicar con presicion los componente con coordenadas (x, y)
        this.jpCabecera.setLayout(null);
        this.jpOpciones.setLayout(null);
        this.jtpEscritorio.setLayout(null);
        this.jifInicio.setLayout(null);
        this.jifSocio.setLayout(null);
        this.jifPrestamo.setLayout(null);
        this.jifAgregarPrestamo.setLayout(null);
        //setteo de libro con el layout
        this.jifLibro.setLayout(null);

        //Añade el titulo a la cabecera y settea su ubicacion y tamaño
        this.jpCabecera.add(jlTitulo);
        this.jlTitulo.setBounds(10, 10, 800, 64);        

        //Añadir Iconos Prestamos
        this.jifPrestamo.add(jlRegistraDevolucion);
        this.jlRegistraDevolucion.setBounds(260, 100, 64, 64);

        this.jifPrestamo.add(jlListarPrestamos);
        this.jlListarPrestamos.setBounds(460, 100, 64, 64);

        //Añade icono de agregar prestamo
        this.jifPrestamo.add(jlAgregarPrestamo);
        this.jlAgregarPrestamo.setBounds(60, 100, 64, 64);

        //LO QUE se AGREGO DE LIBRO
        // Añade icono de agregar libro
        this.jifLibro.add(jlAgregarLibros);
        this.jlAgregarLibros.setBounds(60, 100, 64, 64); 

        //Añade icono de quitar libro
        this.jifLibro.add(jlQuitarLibro);
        this.jlQuitarLibro.setBounds(260, 100, 64, 64);

        //Añade icono de listado de libro
        this.jifLibro.add(jlListarLibros);
        this.jlListarLibros.setBounds(460, 100, 64, 64);

        //Añade boton de agregar Libro
        this.jifLibro.add(jbAgregarLibro);
        this.jbAgregarLibro.setBounds(25, 200, 130, 40);
        this.jbAgregarLibro.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt){
                    jbAgregarLibro.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbAgregarLibro.jBotonMouseExited(evt);
                }
            });
        //AÑADIMOSBOTON DE QUITAR LIBRO
        this.jifLibro.add(jbQuitarLibro);
        this.jbQuitarLibro.setBounds(225, 200, 130, 40);
        this.jbQuitarLibro.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbQuitarLibro.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbQuitarLibro.jBotonMouseExited(evt); //
                }
            });

        //AÑADIMOS BOTON DE LISTAR LIBROS
        this.jifLibro.add(jbListarLibros);
        this.jbListarLibros.setBounds(425, 200, 130, 40);
        this.jbListarLibros.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbListarLibros.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbListarLibros.jBotonMouseExited(evt);
                }
            });

        //Settea los atributos del texto en el panel interno Inicio     
        this.jtaTextoInicio.setFont(new Font("Corbel", 1, 40));
        this.jtaTextoInicio.setForeground(Color.white);
        this.jtaTextoInicio.setText("                  Bienvenido a\nSistema de gestion biblioteca");
        this.jtaTextoInicio.setOpaque(false);
        this.jifInicio.add(jtaTextoInicio);
        this.jtaTextoInicio.setBounds(50, 100, 1000, 100);

        //Añade el titulo a la pestaña de socios
        this.jifSocio.add(jlTituloSocio);
        this.jifPrestamo.add(jlTituloPrestamo);

        //Añade el titulo a la pestaña de libro
        this.jifLibro.add(jlTituloLibro);

        //Añade el titulo a la pestaña de prestamos
        this.jifPrestamo.add(jlTituloPrestamo);
        this.jifAgregarPrestamo.add(jlTituloAgregarPrestamo);

        //Añade botones a la pestaña de prestamos
        this.jifPrestamo.add(jbAgregarPrestamo);
        this.jbAgregarPrestamo.setBounds(25, 200, 130, 40);
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
        this.jbRegistraDevolucion.setBounds(225, 200, 130, 40);
        this.jbRegistraDevolucion.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbRegistraDevolucion.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbRegistraDevolucion.jBotonMouseExited(evt);
                }
            });
        this.jifPrestamo.add(jbListarPrestamos);
        this.jbListarPrestamos.setBounds(425, 200, 130, 40);
        this.jbListarPrestamos.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbListarPrestamos.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbListarPrestamos.jBotonMouseExited(evt);
                }
            });    

        //Color de fondo para el panel de opciones
        this.jpOpciones.setBackground(new Color(102, 102, 102));

        //Inicializa el texto de la opcion inicio y añade el boton al panel de opciones
        this.jbOpcionInicio.setText("Inicio");
        this.jpOpciones.add(jbOpcionInicio);
        this.jbOpcionInicio.setBounds(0, 0, 170, 50);
        this.jbOpcionInicio.addMouseListener(new MouseAdapter() { //addMouseListener responde a los eventos que puedan ocurrir
                public void mouseEntered(MouseEvent evt) {        //MouseAdapter es una clase abstracta por lo que debemos  
                    jbOpcionInicio.jbOpcionMouseEntered(evt);     //implementar metodos para darle funcionalidad
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionInicio.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifInicioMouseClicked(evt);
                }
            });

        //Inicializa el texto de la opcion socios y añade el boton al panel de opciones
        this.jbOpcionSocios.setText("Socios");
        this.jpOpciones.add(jbOpcionSocios);
        this.jbOpcionSocios.setBounds(0, 50, 170, 50);
        this.jbOpcionSocios.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionSocios.jbOpcionMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionSocios.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifSocioMouseClicked(evt);
                }
            });

        //Inicializa el texto de la opcion libros y añade el boton al panel de opciones
        this.jbOpcionLibros.setText("Libros");
        this.jpOpciones.add(jbOpcionLibros);
        this.jbOpcionLibros.setBounds(0, 100, 170, 50);
        this.jbOpcionLibros.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionLibros.jbOpcionMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionLibros.jbOpcionMouseExited(evt);
                }

                //LO QUE LE AGREGO 
                public void mouseClicked(MouseEvent evt){
                    jifLibroMouseClicked(evt);// Llama a la función de "Libro"
                }
            });

        //Inicializa el texto de la opcion prestamos y añade el boton al panel de opciones
        this.jbOpcionPrestamos.setText("Prestamos");
        this.jpOpciones.add(jbOpcionPrestamos);
        this.jbOpcionPrestamos.setBounds(0, 150, 170, 50);
        this.jbOpcionPrestamos.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionPrestamos.jbOpcionMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionPrestamos.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifPrestamoMouseClicked(evt);
                }
            });

        //Añade el panel de contenido a la ventana principal
        this.getContentPane().add(jtpEscritorio);
        this.jtpEscritorio.setBounds(170, 90, 730, 420);// Settea su ubicacion
        this.jtpEscritorio.addTab("tab1", jifInicio);// Agrega una ventana interna al panel de contenido
        this.jtpEscritorio.addTab("tab2", jifSocio);
        this.jtpEscritorio.addTab("tab3", jifPrestamo);
        this.jtpEscritorio.addTab("tab4", jifAgregarSocio); 
        this.jtpEscritorio.addTab("tab5", jifQuitarSocio);
        this.jtpEscritorio.addTab("tab6", jifListarSocios);
        this.jtpEscritorio.addTab("tab7", jifLibro);// <-- Añade jifLibro
        this.jtpEscritorio.addTab("tab8", jifAgregarPrestamo);
        this.jifLibro.setBounds(0, 0, 730, 420);
        //Añade el panel de opciones a la ventana principal
        this.getContentPane().add(jpOpciones);
        this.jpOpciones.setBounds(0, 90, 170, 420);
        //Añade el panel de cabecera a la ventana principal
        this.getContentPane().add(jpCabecera);
        this.jpCabecera.setBounds(0, 0, 900, 100);

        this.pack();//Ajusta el tamaño de la ventana y los componentes
        this.setVisible(true);//Hace visible la ventana
    } 

    private void jifInicioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(0);
    }

    private void jifSocioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(1);
    }

    private void jifPrestamoMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(2);
    }

    private void jifAgregarSocioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(3);
    }

    /**
     * Crea, inicializa y posiciona todos los componentes 
     * para el panel de "Agregar Socio" (jifAgregarSocio).
     * (VERSION 4 - Componentes movidos a la izquierda)
     */
    private void configurarPanelAgregarSocio() {

        // 1. Crear el Panel Principal
        jifAgregarSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        jifAgregarSocio.setLayout(null); 

        // --- Definir Fuentes y Colores ---
        Font fontTitulo = new Font("Corbel", Font.BOLD, 24);
        Font fontLabel = new Font("Corbel", Font.BOLD, 14);
        Font fontRadio = new Font("Corbel", Font.PLAIN, 14);
        Color colorTexto = Color.WHITE; 

        // 2. Definir Geometría del Panel
        int panelWidth = 730; 

        // Desplazamiento (Valor Auxiliar Usado Para Centrar Todos Los Elementos, en este caso a la izquierda)
        int desplazamiento = 40; 

        // 3. Crear y posicionar los componentes

        // --- Título ---
        JLabel jlTituloForm = new JLabel("Agregar Nuevo Socio");
        jlTituloForm.setFont(fontTitulo);
        jlTituloForm.setForeground(colorTexto);
        int tituloWidth = 300; 
        // Calculamos el centro y LUEGO restamos el desplazamiento
        int tituloX = ((panelWidth - tituloWidth) / 2); 
        jlTituloForm.setBounds(tituloX, 20, tituloWidth, 30);
        jifAgregarSocio.add(jlTituloForm);

        // --- Radio Buttons ---
        int radioDocenteWidth = 100;
        int radioAlumnoWidth = 100;
        int radioGap = 10;
        int radioBlockWidth = radioDocenteWidth + radioGap + radioAlumnoWidth; 
        int radioStartX = ((panelWidth - radioBlockWidth) / 2) - desplazamiento;

        rbDocente = new JRadioButton("Docente");
        rbDocente.setFont(fontRadio);
        rbDocente.setForeground(colorTexto);
        rbDocente.setOpaque(false);
        rbDocente.setBounds(radioStartX, 70, radioDocenteWidth, 30);
        jifAgregarSocio.add(rbDocente);

        rbAlumno = new JRadioButton("Alumno");
        rbAlumno.setFont(fontRadio);
        rbAlumno.setForeground(colorTexto);
        rbAlumno.setOpaque(false);
        rbAlumno.setSelected(true); 
        rbAlumno.setBounds(radioStartX + radioDocenteWidth + radioGap, 70, radioAlumnoWidth, 30);
        jifAgregarSocio.add(rbAlumno);

        bgTipoSocio = new ButtonGroup();
        bgTipoSocio.add(rbDocente);
        bgTipoSocio.add(rbAlumno);

        // --- Columnas de Campos ---
        int label_ancho = 200;
        int field_ancho = 220; 
        int field_alto = 28;    
        int column_gap = 60;    

        int formBlockWidth = field_ancho + column_gap + field_ancho;
        int col1_x = ((panelWidth - formBlockWidth) / 2) - desplazamiento;
        int col2_x = col1_x + field_ancho + column_gap; 

        // --- Columna Izquierda (DNI y Nombre) ---
        jlDNI = new JLabel("DNI:");
        jlDNI.setFont(fontLabel);
        jlDNI.setForeground(colorTexto);
        jlDNI.setBounds(col1_x, 120, label_ancho, 25);
        jifAgregarSocio.add(jlDNI);

        jtfDNI = new JTextField();
        jtfDNI.setBounds(col1_x, 150, field_ancho, field_alto);
        jifAgregarSocio.add(jtfDNI);

        // Nombre
        jlNombre = new JLabel("Nombre Completo:");
        jlNombre.setFont(fontLabel);
        jlNombre.setForeground(colorTexto);
        jlNombre.setBounds(col1_x, 190, label_ancho, 25);
        jifAgregarSocio.add(jlNombre);

        jtfNombre = new JTextField();
        jtfNombre.setBounds(col1_x, 220, field_ancho, field_alto);
        jifAgregarSocio.add(jtfNombre);

        // --- Columna Derecha (Carrera y Días) ---
        jlCarreraAsignatura = new JLabel("Carrera:"); 
        jlCarreraAsignatura.setFont(fontLabel);
        jlCarreraAsignatura.setForeground(colorTexto);
        jlCarreraAsignatura.setBounds(col2_x, 120, label_ancho, 25);
        jifAgregarSocio.add(jlCarreraAsignatura);

        jtfCarreraAsignatura = new JTextField();
        jtfCarreraAsignatura.setBounds(col2_x, 150, field_ancho, field_alto);
        jifAgregarSocio.add(jtfCarreraAsignatura);

        // Días de Préstamo
        jlDiasPrestamo = new JLabel("Días de Préstamo:");
        jlDiasPrestamo.setFont(fontLabel);
        jlDiasPrestamo.setForeground(colorTexto);
        jlDiasPrestamo.setBounds(col2_x, 190, label_ancho, 25);
        jifAgregarSocio.add(jlDiasPrestamo);

        jtfDiasPrestamo = new JTextField("20"); 
        jtfDiasPrestamo.setEnabled(false); 
        jtfDiasPrestamo.setBounds(col2_x, 220, field_ancho, field_alto);
        jifAgregarSocio.add(jtfDiasPrestamo);

        // --- Botón Guardar ---
        int botonWidth = 150;
        int botonHeight = 40;
        int botonX = ((panelWidth - botonWidth) / 2) - 50;
        jbGuardarSocio = new MiBoton("Guardar Socio");
        jbGuardarSocio.setBounds(botonX, 300, botonWidth, botonHeight); 
        jifAgregarSocio.add(jbGuardarSocio);

        // --- 4. Lógica de los Componentes ---

        // Lógica de Radio Buttons
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

        // Lógica del Botón Guardar
        // Lógica del Botón Guardar
        jbGuardarSocio.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {

                    try {
                        // Obtener valores
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

                        // Verificar si el socio ya existe
                        if (miBiblioteca.buscarSocio(dni) != null) {
                            JOptionPane.showMessageDialog(null, "Ya existe un socio con ese DNI.");
                            return;
                        }

                        // Determinar tipo de socio
                        if (rbDocente.isSelected()) {
                            miBiblioteca.nuevoSocioDocente(dni, nombre, dias, carreraAsignatura);
                            JOptionPane.showMessageDialog(null, "Docente agregado con éxito.");

                        } else {
                            miBiblioteca.nuevoSocioEstudiante(dni, nombre, dias, carreraAsignatura);
                            JOptionPane.showMessageDialog(null, "Alumno agregado con éxito.");
                        }

                        // Limpiar campos
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

    private void configurarPanelQuitarSocio() {

        // 1. Panel Principal
        jifQuitarSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        jifQuitarSocio.setLayout(null);

        // --- Fuentes y Colores ---
        Font fontTitulo = new Font("Corbel", Font.BOLD, 24);
        Font fontLabel = new Font("Corbel", Font.BOLD, 14);
        Color colorTexto = Color.WHITE;

        // Geometría del panel
        int panelWidth = 730;
        int desplazamiento = 40;

        // 2. Título
        JLabel jlTituloForm = new JLabel("Quitar Usuario");
        jlTituloForm.setFont(fontTitulo);
        jlTituloForm.setForeground(colorTexto);
        int tituloWidth = 300;
        int tituloX = ((panelWidth - tituloWidth) / 2) + 37;
        jlTituloForm.setBounds(tituloX, 40, tituloWidth, 30);
        jifQuitarSocio.add(jlTituloForm);

        // 3. DNI
        JLabel jlDNIQuitar = new JLabel("DNI:");
        jlDNIQuitar.setFont(fontLabel);
        jlDNIQuitar.setForeground(colorTexto);
        int labelWidth = 200;
        int fieldWidth = 220;
        int fieldHeight = 28;
        int posX = ((panelWidth - fieldWidth) / 2) - desplazamiento;

        jlDNIQuitar.setBounds(posX, 120, labelWidth, 25);
        jifQuitarSocio.add(jlDNIQuitar);

        jtfDNIQuitar = new JTextField();
        jtfDNIQuitar.setBounds(posX, 150, fieldWidth, fieldHeight);
        jifQuitarSocio.add(jtfDNIQuitar);

        // 4. Botón Quitar
        int botonWidth = 150;
        int botonHeight = 40;
        int botonX = ((panelWidth - botonWidth) / 2) - desplazamiento;
        jbQuitarSocio = new MiBoton("Quitar Usuario");
        jbQuitarSocio.setBounds(botonX, 230, botonWidth, botonHeight);
        jifQuitarSocio.add(jbQuitarSocio);

        // 5. Eventos Botón (lógica tuya luego)
        jbQuitarSocio.addMouseListener(new MouseAdapter() {
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

                        jtfDNIQuitar.setText(""); // Limpia el campo

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El DNI debe ser un número.");
                    }
                }

                public void mouseEntered(MouseEvent evt) {
                    jbQuitarSocio.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbQuitarSocio.jBotonMouseExited(evt);
                }
            });
    }

    private void configurarPanelListarSocios() {
        // Panel Principal con fondo
        jifListarSocios = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        jifListarSocios.setLayout(null);

        Font fontTitulo = new Font("Corbel", Font.BOLD, 24);
        Font fontLabel = new Font("Corbel", Font.BOLD, 14);
        Color colorTexto = Color.WHITE;

        int panelWidth = 730;
        int desplazamiento = 40;

        // Título
        JLabel jlTitulo = new JLabel("Listado de Socios");
        jlTitulo.setFont(fontTitulo);
        jlTitulo.setForeground(colorTexto);
        int tituloWidth = 300;
        int tituloX = ((panelWidth - tituloWidth) / 2) + 23;
        jlTitulo.setBounds(tituloX, 20, tituloWidth, 30);
        jifListarSocios.add(jlTitulo);

        // Área de texto para mostrar el listado
        taListadoSocios = new JTextArea();
        taListadoSocios.setEditable(false);
        taListadoSocios.setOpaque(false);
        taListadoSocios.setForeground(colorTexto);
        taListadoSocios.setFont(new Font("Corbel", Font.PLAIN, 14));
        taListadoSocios.setLineWrap(true);
        taListadoSocios.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(taListadoSocios);
        scroll.setBounds(70, 80, 500, 220);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        jifListarSocios.add(scroll);

        // Botón Actualizar
        jbListarSocios = new MiBoton("Actualizar Lista");
        int botonWidth = 150;
        int botonHeight = 40;
        int botonX = ((panelWidth - botonWidth) / 2) - desplazamiento;
        jbListarSocios.setBounds(botonX, 310, botonWidth, botonHeight);
        jifListarSocios.add(jbListarSocios);

        // Lógica del botón 
        jbListarSocios.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {

                    // Obtener la lista de socios desde la biblioteca
                    String listado = miBiblioteca.listarSocio();

                    // Mostrar la información en el JTextArea
                    taListadoSocios.setText(listado);

                    // Que el cursor vuelva arriba 
                    taListadoSocios.setCaretPosition(0);
                }

                public void mouseEntered(MouseEvent evt) {
                    jbListarSocios.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbListarSocios.jBotonMouseExited(evt);
                }
            });

    }

    //este agrego nuevo
    private void jifLibroMouseClicked(MouseEvent evt){
        this.jtpEscritorio.setSelectedIndex(3);
    }

    private void jifAgregarPrestamoMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(4);
    }

    private void iniciarBiblioteca(){
        this.miBiblioteca = new Biblioteca("Biblioteca Central");
        // Carga de socios docentes
        this.miBiblioteca.nuevoSocioDocente(14524782, "Juan Perez", 5, "Informática");
        this.miBiblioteca.nuevoSocioDocente(17982110, "Juan Fernández", 5, "Matemática");
        this.miBiblioteca.nuevoSocioDocente(10912002, "María Alegre", 5, "Letras");
        // Carga de socios estudiantes
        this.miBiblioteca.nuevoSocioEstudiante(28987498, "Francisco Paenza", 20, "Ingeniería");
        this.miBiblioteca.nuevoSocioEstudiante(31987123, "Cesar Milstein", 20, "Medicina");
        // Carga de libros
        this.miBiblioteca.nuevoLibro("JAVA. Como Programar", 9, "Pearson", 2014);
        this.miBiblioteca.nuevoLibro("Longman. Diccionario Pocket", 1, "Longman", 2010);
        this.miBiblioteca.nuevoLibro("Vivir para contarla", 1, "Sudamericana", 2002);
        this.miBiblioteca.nuevoLibro("Programando con JAVA", 1, "Editorial X", 2020); 
        // Se realizan algunos préstamos de libros
        Socio socio1 = this.miBiblioteca.buscarSocio(14524782);
        Libro libro1 = this.miBiblioteca.getLibros().get(1); 
        if (socio1 != null && libro1 != null) {this.miBiblioteca.prestarLibro(new GregorianCalendar(), socio1, libro1);}
        Socio socio2 = miBiblioteca.buscarSocio(28987498);
        Libro libro2 = miBiblioteca.getLibros().get(3); 
        if (socio2 != null && libro2 != null) {this.miBiblioteca.prestarLibro(new GregorianCalendar(), socio2, libro2);}
        Socio socio3 = miBiblioteca.buscarSocio(31987123);
        Libro libro3 = miBiblioteca.getLibros().get(2); 
        if (socio3 != null && libro3 != null) {this.miBiblioteca.prestarLibro(new GregorianCalendar(), socio3, libro3);}
    }
}