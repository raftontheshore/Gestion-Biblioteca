import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Menu extends JFrame {
    //Declaracion de biblioteca
    private Biblioteca miBiblioteca;

    //Botones del panel de opciones
    private MisOpciones jbOpcionInicio;
    private MisOpciones jbOpcionLibros;
    private MisOpciones jbOpcionPrestamos;
    private MisOpciones jbOpcionSocios;

    // Socios
    private MiIcono jlAgregarPrestamo;
    private MiIcono jlRegistraDevolucion;
    private JTextArea taListadoSocios;

    private MiBoton jbAgregarPrestamo;
    private MiBoton jbRegistraDevolucion;
    private JLabel jlTitulo;
    private JTabbedPane jtpEscritorio;
    private MiPanelEscritorio jpCabecera;
    private MiPanelEscritorio jifInicio;
    private MiPanelEscritorio jifSocio;
    private MiPanelEscritorio jifPrestamo;

    private JPanel jpOpciones;
    private JTextArea jtaTextoInicio;
    private Titulos jlTituloSocio;
    private Titulos jlTituloPrestamo;

    private MiPanelEscritorio jifAgregarPrestamo;
    private Titulos jlTituloAgregarPrestamo;
    private MiEtiqueta jlFechaRetiro;
    private MiEtiqueta jlTituloLibroRetiro;
    private MiEtiqueta jlDniSocioRetiro;
    private JTextField jtfFechaRetiro;
    private JTextField jtfTituloLibroRetiro;
    private JTextField jtfDniSocioRetiro;
    private MiBoton jbRegistrarPrestamo;

    private MiPanelEscritorio jifRegistrarDevolucion;
    private Titulos jlTituloRegistrarDevolucion;
    private MiEtiqueta jlFechaDevolucion;
    private MiEtiqueta jlTituloLibroDevuelto;
    private JTextField jtfFechaDevolucion;
    private JTextField jtfTituloLibroDevuelto;
    private MiBoton jbRegistrarLibroDevolucion;

    // Iconos Socio
    private MiBoton jbAgregarSocio;
    private MiBoton jbQuitarSocio;
    private MiBoton jbListarSocios;

    private MiIcono jlAgregarSocio;
    private MiIcono jlQuitarSocio;
    private MiIcono jlListarSocios;

    //icono docente responsable
    private MiIcono jlDocenteResponsable;
    private MiBoton jbDocenteResponsable;

    // Componentes De Agregar Socio
    private MiPanelEscritorio jifAgregarSocio;
    private MiPanelEscritorio jifQuitarSocio;
    private MiPanelEscritorio jifListarSocios;
    private JRadioButton rbDocente;
    private JRadioButton rbAlumno;
    private ButtonGroup bgTipoSocio;
    private MiEtiqueta jlDNI;
    private JTextField jtfDNI;
    private JTextField jtfDNIQuitar;
    private MiEtiqueta jlNombre;
    private JTextField jtfNombre;
    private MiEtiqueta jlDiasPrestamo;
    private JTextField jtfDiasPrestamo;
    private MiEtiqueta jlCarreraAsignatura; 
    private JTextField jtfCarreraAsignatura;
    private MiBoton jbGuardarSocio; 

    //componentes docente responsable
    private JTextArea elListadoDocenteResponsable;
    private MiPanelEscritorio jifDocenteResponsable;
    private JTextArea unListadoDocentesR;
    private MiBoton jbActualizarListaDocenRes;

    //agregado mio DE LIBRO 
    private MiPanelEscritorio jifLibro; //Este es el panel o ventana interna principal que contiene todo lo relacionado con los socios. Cuando el usuario hace clic en jbOpcionSocios
    private MiIcono jlAgregarLibros; //Un icono que el usuario puede pulsar para añadir un nuevo libro
    private MiIcono jlQuitarLibro; // lo mismo que agregar
    private MiIcono jlListarLibros; // icono para listar
    private MiIcono jlBuscarLibro; //ICONO PARA BUSCAR
    private MiBoton jbAgregarLibro;
    private MiBoton jbQuitarLibro; //boton de quitarLibro
    private MiBoton jbListarLibros; // listar los libros
    private MiBoton jbBuscarLibros; //BOTON PARA BUSCAR
    private Titulos jlTituloLibro;

    //Agregar libros
    private MiPanelEscritorio jifAgregarLibro;// El panel principal del formulario

    private JTextField jtfTituloLibro;
    private JTextField jtfEditorial;
    private JTextField jtfEdicion;
    private JTextField jtfAnio;

    private MiBoton jbGuardarLibro;
    //quitar un libro
    private MiPanelEscritorio jifQuitarLibro;
    private JTextField jtfTituloQuitar;
    private MiBoton jbQuitarLibroForm;

    //LISTAR LIBROS
    private MiPanelEscritorio jifListarLibros;
    private JTextArea unListadoLibros;
    private MiBoton jbActualizarListaLibros;

    //buscar libro
    private MiPanelEscritorio jifBuscarLibro;
    private JTextField jtfTituloBuscar;
    private MiBoton jbBuscarLibroForm;

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
        this.jbOpcionInicio = new MisOpciones();
        this.jtaTextoInicio = new JTextArea();
        this.jlTituloSocio = new Titulos("Socios");
        this.jlTituloPrestamo = new Titulos("Prestamos");
        this.jlTituloAgregarPrestamo = new Titulos("Agregar prestamo");
        this.jtpEscritorio = new JTabbedPane();
        this.jlAgregarPrestamo = new MiIcono("/imagenes/Prestamo_Libro.png");
        this.jlRegistraDevolucion = new MiIcono("/imagenes/Devolver_Libro.png");
        this.jpCabecera = new MiPanelEscritorio("/imagenes/Header.jpeg");

        this.jpOpciones.setLayout(null);
        this.jtpEscritorio.setLayout(null);

        // Iconos Socios
        this.jifSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

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

        //listar docentes responsables
        this.jlDocenteResponsable = new MiIcono("/imagenes/Docente_Responsable.png");
        this.jbDocenteResponsable = new MiBoton("Docentes Responsables");

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

        //se agrega el boton de docentes responsables
        this.jifSocio.add(jbDocenteResponsable);
        this.jbDocenteResponsable.setBounds(240, 320, 140, 40); 
        this.jbDocenteResponsable.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbDocenteResponsable.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbDocenteResponsable.jBotonMouseExited(evt); //
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifDocenteResponsable);
                }
            });
        //agregar icono de docente responsable
        this.jifSocio.add(jlDocenteResponsable);
        this.jlDocenteResponsable.setBounds(280, 250, 64, 64);        

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
        //buscar libro 
        this.jlBuscarLibro = new MiIcono("/imagenes/Buscar_Libro.png");
        this.jbBuscarLibros = new MiBoton("Buscar Libro");

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
        configurarPanelListarDocenteResponsable();

        //PANEL AGREGAR LIBROS / QUITAR LIBRO/ LISTAR LIBROS / BUSCAR LIBROS
        configurarPanelAgregarLibro();
        configurarQuitarLibro();
        configurarPanelListarLibros();
        configurarPanelBuscarLibro();

        //Panel prestamos
        this.configurarPanelAgregarPrestamo();
        this.configurarPanelRegistrarDevolucion();

        //Añade el titulo a la cabecera y settea su ubicacion y tamaño
        this.jpCabecera.add(jlTitulo);
        this.jlTitulo.setBounds(10, 10, 800, 64);        

        //Añadir Iconos Prestamos
        this.jifPrestamo.add(jlRegistraDevolucion);
        this.jlRegistraDevolucion.setBounds(390, 100, 64, 64);

        //Añade icono de agregar prestamo
        this.jifPrestamo.add(jlAgregarPrestamo);
        this.jlAgregarPrestamo.setBounds(150, 100, 64, 64);

        //LO QUE se AGREGO DE LIBRO
        // Añade icono de agregar libro
        this.jifLibro.add(jlAgregarLibros);
        this.jlAgregarLibros.setBounds(80, 100, 64, 64); 

        //Añade icono de quitar libro
        this.jifLibro.add(jlQuitarLibro);
        this.jlQuitarLibro.setBounds(280, 100, 64, 64);

        //Añade icono de listado de libro
        this.jifLibro.add(jlListarLibros);
        this.jlListarLibros.setBounds(480, 100, 64, 64);

        //se añade icono de buscar libro
        this.jifLibro.add(jlBuscarLibro);
        this.jlBuscarLibro.setBounds(280, 250, 64, 64);

        //Añade boton de agregar Libro
        this.jifLibro.add(jbAgregarLibro);
        this.jbAgregarLibro.setBounds(40, 180, 140, 40);
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
        //AÑADIMOSBOTON DE QUITAR LIBRO
        this.jifLibro.add(jbQuitarLibro);
        this.jbQuitarLibro.setBounds(240, 180, 140, 40);
        this.jbQuitarLibro.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbQuitarLibro.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbQuitarLibro.jBotonMouseExited(evt); //
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifQuitarLibro);
                }
            });

        //AÑADIMOS BOTON DE LISTAR LIBROS
        this.jifLibro.add(jbListarLibros);
        this.jbListarLibros.setBounds(440, 180, 140, 40);
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
        //se añade el boton de buscar libro
        this.jifLibro.add(jbBuscarLibros);
        this.jbBuscarLibros.setBounds(240, 320, 130, 40);
        this.jbBuscarLibros.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent evt){
                    jbBuscarLibros.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt){
                    jbBuscarLibros.jBotonMouseExited(evt); //
                }

                public void mouseClicked(MouseEvent evt){
                    jtpEscritorio.setSelectedComponent(jifBuscarLibro);
                }
            });

        //Settea los atributos del texto en el panel interno Inicio     
        this.jtaTextoInicio.setFont(new Font("Corbel", 1, 40));
        this.jtaTextoInicio.setForeground(Color.white);
        this.jtaTextoInicio.setText("                  Bienvenido a\nSistema de Gestión Biblioteca");
        this.jtaTextoInicio.setOpaque(false);
        this.jifInicio.add(jtaTextoInicio);
        this.jtaTextoInicio.setBounds(50, 100, 1000, 100);

        //Añade el titulo a la pestaña de socios
        this.jifSocio.add(jlTituloSocio);

        //Añade el titulo a la pestaña de libro
        this.jifLibro.add(jlTituloLibro);

        //Añade el titulo a la pestaña de prestamos
        this.jifPrestamo.add(jlTituloPrestamo);
        this.jifAgregarPrestamo.add(jlTituloAgregarPrestamo);

        //Añade botones a la pestaña de prestamos
        this.jifPrestamo.add(jbAgregarPrestamo);
        this.jbAgregarPrestamo.setBounds(115, 200, 140, 40);
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
        this.jbRegistraDevolucion.setBounds(355, 200, 140, 40);
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
        this.jtpEscritorio.addTab("tab8", jifAgregarLibro);
        this.jtpEscritorio.addTab("tab9", jifQuitarLibro);
        this.jtpEscritorio.addTab("tab10", jifListarLibros);
        this.jtpEscritorio.addTab("tab11", jifAgregarPrestamo);
        this.jtpEscritorio.addTab("tab12", jifRegistrarDevolucion);
        this.jtpEscritorio.addTab("tab14", jifBuscarLibro);
        this.jtpEscritorio.addTab("tab15", jifDocenteResponsable);
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
        this.jtpEscritorio.setSelectedComponent(jifInicio);
    }

    private void jifSocioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifSocio);
    }

    private void jifPrestamoMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifPrestamo);
    }

    private void jifAgregarSocioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifAgregarSocio);
    }

    //este agrego nuevo
    private void jifLibroMouseClicked(MouseEvent evt){
        this.jtpEscritorio.setSelectedComponent(jifLibro);
    }

    private void jifAgregarPrestamoMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedComponent(jifAgregarPrestamo);
    }

    private void jifRegistrarDevolucionMouseClicked(MouseEvent evt){
        this.jtpEscritorio.setSelectedComponent(jifRegistrarDevolucion);
    }

    /**
     * Crea, inicializa y posiciona todos los componentes 
     * para el panel de "Agregar Socio" (jifAgregarSocio).
     * (VERSION 4 - Componentes movidos a la izquierda)
     */
    private void configurarPanelAgregarSocio() {

        // 1. Crear el Panel Principal
        jifAgregarSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        // --- Título ---
        Titulos jlTituloForm = new Titulos("Agregar Nuevo Socio");
        jifAgregarSocio.add(jlTituloForm);

        // --- Radio Buttons ---
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

        // --- Columna Izquierda (DNI y Nombre) ---
        jlDNI = new MiEtiqueta("DNI: ");
        jlDNI.setBounds(75, 120, 200, 25);
        jifAgregarSocio.add(jlDNI);

        jtfDNI = new JTextField();
        jtfDNI.setBounds(75, 150, 220, 28);
        jifAgregarSocio.add(jtfDNI);

        // Nombre
        jlNombre = new MiEtiqueta("Nombre Completo:");
        jlNombre.setBounds(75, 190, 200, 25);
        jifAgregarSocio.add(jlNombre);

        jtfNombre = new JTextField();
        jtfNombre.setBounds(75, 220, 220, 28);
        jifAgregarSocio.add(jtfNombre);

        // --- Columna Derecha (Carrera y Días) ---
        jlCarreraAsignatura = new MiEtiqueta("Carrera:"); 
        jlCarreraAsignatura.setBounds(355, 120, 200, 25);
        jifAgregarSocio.add(jlCarreraAsignatura);

        jtfCarreraAsignatura = new JTextField();
        jtfCarreraAsignatura.setBounds(355, 150, 220, 28);
        jifAgregarSocio.add(jtfCarreraAsignatura);

        // Días de Préstamo
        jlDiasPrestamo = new MiEtiqueta("Días de Préstamo:");
        jlDiasPrestamo.setBounds(355, 190, 200, 25);
        jifAgregarSocio.add(jlDiasPrestamo);

        jtfDiasPrestamo = new JTextField("20"); 
        jtfDiasPrestamo.setEnabled(false); 
        jtfDiasPrestamo.setBounds(355, 220, 220, 28);
        jifAgregarSocio.add(jtfDiasPrestamo);

        // --- Botón Guardar ---
        jbGuardarSocio = new MiBoton("Guardar Socio");
        jbGuardarSocio.setBounds(240, 300, 140, 40); 
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

        // 2. Título
        Titulos jlTituloForm = new Titulos("Quitar Usuario");
        jifQuitarSocio.add(jlTituloForm);

        // 3. DNI
        MiEtiqueta jlDNIQuitar = new MiEtiqueta("DNI:");
        jlDNIQuitar.setBounds(190, 120, 200, 25);
        jifQuitarSocio.add(jlDNIQuitar);

        jtfDNIQuitar = new JTextField();
        jtfDNIQuitar.setBounds(190, 150, 220, 28);
        jifQuitarSocio.add(jtfDNIQuitar);

        // 4. Botón Quitar
        MiBoton jbEliminarSocio = new MiBoton("Quitar Usuario");
        jbEliminarSocio.setBounds(240, 300, 140, 40);
        jifQuitarSocio.add(jbEliminarSocio);

        // 5. Eventos Botón (lógica tuya luego)
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

                        jtfDNIQuitar.setText(""); // Limpia el campo

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

    private void configurarPanelListarSocios() {
        // Panel Principal con fondo
        jifListarSocios = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        // Título
        Titulos jlTitulo = new Titulos("Listado de Socios");
        jifListarSocios.add(jlTitulo);

        // Área de texto para mostrar el listado
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

        // Botón Actualizar
        MiBoton jbActualizarListarSocios = new MiBoton("Actualizar Lista");
        jbActualizarListarSocios.setBounds(240, 300, 140, 40);
        jifListarSocios.add(jbActualizarListarSocios);

        // Lógica del botón 
        jbActualizarListarSocios.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    // Mostrar la información en el JTextArea
                    taListadoSocios.setText(miBiblioteca.listarSocio());

                    // Que el cursor vuelva arriba 
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
     * Listar Docentes Responsables
     */
    private void configurarPanelListarDocenteResponsable(){
        //panel principal
        jifDocenteResponsable = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        //titulo
        Titulos jlTitulo = new Titulos("Listado de Docentes Responsable");
        jifDocenteResponsable.add(jlTitulo);

        // area texto para mostrar el listado
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

        //boton de actualizar
        MiBoton jbListaDocenteResponsable = new MiBoton("Actualizar Lista");
        jbListaDocenteResponsable.setBounds(240, 300, 140, 40);
        jifDocenteResponsable.add(jbListaDocenteResponsable);

        jbListaDocenteResponsable.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){
                    elListadoDocenteResponsable.setText(miBiblioteca.listaDeDocentesResponsables());//lista de los docentes responsables
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
     * AGREGAR LIBRO
     */
    private void configurarPanelAgregarLibro(){
        //creo el panel principal
        jifAgregarLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        //creamos y posicionamos los componente
        //titulo
        Titulos jlTituloForm = new Titulos("Agregar Nuevo Libro");
        jifAgregarLibro.add(jlTituloForm);

        // titulo y editorial
        MiEtiqueta jlTitulo1 = new MiEtiqueta("Titulo:");
        jlTitulo1.setBounds(75, 90, 200, 25); // (75, 90, 200, 25)
        jifAgregarLibro.add(jlTitulo1);

        jtfTituloLibro = new JTextField();// (Usa la variable de clase)
        jtfTituloLibro.setBounds(75, 120, 220, 28); // (75, 120, 220, 28)
        jifAgregarLibro.add(jtfTituloLibro);

        //editorial
        MiEtiqueta jlEditorial = new MiEtiqueta("Editorial:");
        jlEditorial.setBounds(75, 160, 200, 25); // (75, 160, 200, 25)
        jifAgregarLibro.add(jlEditorial);

        jtfEditorial = new JTextField(); 
        jtfEditorial.setBounds(75, 190, 220, 28); // (75, 190, 220, 25)
        jifAgregarLibro.add(jtfEditorial);

        //columna derecha
        MiEtiqueta jlEdicion = new MiEtiqueta("Edicion (numero): ");
        jlEdicion.setBounds(355, 90, 200, 25); // (355, 90, 200, 25)
        jifAgregarLibro.add(jlEdicion);

        jtfEdicion = new JTextField();
        jtfEdicion.setBounds(355, 120, 220, 28); // (355, 120, 220, 28)
        jifAgregarLibro.add(jtfEdicion);

        //anio
        MiEtiqueta jlAnio = new MiEtiqueta("Año (numero):");
        jlAnio.setBounds(355, 160, 200, 25); // (355, 160, 200, 25)
        jifAgregarLibro.add(jlAnio);

        jtfAnio = new JTextField();
        jtfAnio.setBounds(355, 190, 220, 28); // (355, 190, 220, 28)
        jifAgregarLibro.add(jtfAnio);

        //Boton de guardar
        jbGuardarLibro = new MiBoton("Guardar Libro");
        jbGuardarLibro.setBounds(240, 300, 140, 40);
        jifAgregarLibro.add(jbGuardarLibro);

        jbGuardarLibro.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){
                    //ESTA ES LA LÓGICA me FALTABA
                    try{
                        //obtener valore
                        String titulo = jtfTituloLibro.getText().trim();
                        String editorial= jtfEditorial.getText().trim();
                        String edicionTexto = jtfEdicion.getText().trim();
                        String anioTexto = jtfAnio.getText().trim();

                        //validar campos vacios
                        if(titulo.isEmpty() || editorial.isEmpty() || edicionTexto.isEmpty() || anioTexto.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Complete todos los campos para agregar el Libro ");
                            return;
                        }
                        // 3. Convertir a números
                        int edicion = Integer.parseInt(edicionTexto);
                        int anio = Integer.parseInt(anioTexto);

                        // 4. Validar si el libro ya existe
                        // if (miBiblioteca.buscarLibro(titulo) != null) 

                        //llamamos a biblioteca para agregar los libros
                        miBiblioteca.nuevoLibro(titulo, edicion, editorial, anio);
                        JOptionPane.showMessageDialog(null, "Libro agregado con éxito.");

                        //limpiar campo
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
     * quitar libro 
     */    
    private void configurarQuitarLibro(){
        //panel principal
        jifQuitarLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg"); 
        
        //titulo 
        Titulos jlTituloForm = new Titulos("Quitar Libro del Catálogo");
        jifQuitarLibro.add(jlTituloForm);

        //titulo del libr
        MiEtiqueta jlTituloQuitar = new MiEtiqueta("Titulo del libro:");
        jlTituloQuitar.setBounds(190, 120, 200, 25);
        jifQuitarLibro.add(jlTituloQuitar);

        jtfTituloQuitar = new JTextField();
        jtfTituloQuitar.setBounds(190, 150, 220, 28);
        jifQuitarLibro.add(jtfTituloQuitar);

        //botono quitar
        jbQuitarLibroForm = new MiBoton("Quitar Libro");
        jbQuitarLibroForm.setBounds(240, 300, 140, 40);
        jifQuitarLibro.add(jbQuitarLibroForm);

        //ahora lo que seria la accion de quitar el libro
        jbQuitarLibroForm.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){
                    //vamos a eliminar libro por su titulo
                    String titulo = jtfTituloQuitar.getText().trim();

                    //verificamos si esta vacio
                    if(titulo.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
                        return;
                    }

                    //buscamos el libro
                    Libro libro = null;
                    for(Libro unLibro : miBiblioteca.getLibros()){
                        if(titulo.equalsIgnoreCase(unLibro.getTitulo())){
                            libro = unLibro;
                        }
                    }
                    //validamos que exista el libro
                    if(libro == null){
                        JOptionPane.showMessageDialog(null,"No existe un libro con ese Título.");
                        return;
                    }
                    //validamos que el libro no este prestado
                    if(libro.prestado()){
                        JOptionPane.showMessageDialog(null, "El libro '" + libro.getTitulo() + " no se puede eliminar porque está PRESTADO.");
                        return;
                    }
                    // eliminamos el libro
                    miBiblioteca.quitarLibro(libro);
                    JOptionPane.showMessageDialog(null, "Libro quitado con exito...");

                    jtfTituloQuitar.setText(""); // Limpia el campo

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
     * LISTADO DE LIBROS
     */
    private void configurarPanelListarLibros(){
        jifListarLibros = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        //Titulo
        Titulos jlTitulo = new Titulos("Listado de libros");
        jifListarLibros.add(jlTitulo);

        //lugar donde muestro el listado
        unListadoLibros = new JTextArea();
        unListadoLibros.setEditable(false);
        unListadoLibros.setOpaque(false);
        unListadoLibros.setForeground(Color.white);
        unListadoLibros.setFont(new Font("Corbel", Font.BOLD, 14));
        unListadoLibros.setLineWrap(true);
        unListadoLibros.setWrapStyleWord(true);

        //para scrollear
        JScrollPane scroll = new JScrollPane(unListadoLibros);
        scroll.setBounds(70, 60, 500, 220);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        jifListarLibros.add(scroll);

        //boton actualizar
        jbActualizarListaLibros = new MiBoton("Actualizar lista");
        jbActualizarListaLibros.setBounds(240, 300, 140, 40);
        jifListarLibros.add(jbActualizarListaLibros);

        jbActualizarListaLibros.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){

                    //le mandamos listar libro y lo mostramos por el jtext
                    unListadoLibros.setText(miBiblioteca.listaDeLibro());
                    //q el cursor vuelva arriba
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
     * Buscar libro
     */
    private void configurarPanelBuscarLibro(){
        //panel principal
        jifBuscarLibro = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");

        //titulo 
        Titulos jlTituloForm = new Titulos("Buscar Libro del Catálogo");
        jifBuscarLibro.add(jlTituloForm);

        //titulo del libro
        MiEtiqueta jlTituloBuscar = new MiEtiqueta("Titulo del libro:");
        jlTituloBuscar.setBounds(190, 120, 200, 25);
        jifBuscarLibro.add(jlTituloBuscar);

        jtfTituloBuscar = new JTextField();
        jtfTituloBuscar.setBounds(190, 150, 220, 28);
        jifBuscarLibro.add(jtfTituloBuscar);

        //boton buscar
        jbBuscarLibroForm = new MiBoton("Buscar Disponibilidad");
        jbBuscarLibroForm.setBounds(240, 300, 140, 40);
        jifBuscarLibro.add(jbBuscarLibroForm);

        //operacion buscar quien tiene el libro
        jbBuscarLibroForm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // se pide el titulo al usuario
                    String tituloBuscado = jtfTituloBuscar.getText().trim(); 
                    // se verifica que haya escrito algo
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
                                break; // dejamos de buscar una vez que lo encontramos
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
        //carga de socios docentes no responsables
        this.miBiblioteca.nuevoSocioDocente(26987456, "Graciela Vallejos", 5, "Sistemas");
        this.miBiblioteca.nuevoLibro("Sistemas Operativos Modernos", 1, "Global", 2000);
        Calendar fechaVencida = new GregorianCalendar();
        fechaVencida.add(Calendar.DAY_OF_MONTH, -30); //prestamo vencido hace 30 dias
        Socio socioNoResponsable = this.miBiblioteca.buscarSocio(26987456);
        Libro libro4 = this.miBiblioteca.getLibros().get(4);
        this.miBiblioteca.prestarLibro(fechaVencida, socioNoResponsable, libro4);
    }
    
    private void controlNumeros(KeyEvent evt){
        if(Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }
}