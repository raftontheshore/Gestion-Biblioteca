 

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionBiblioteca {

    public static void main(String[] args) {
        
        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central");
        System.out.println("Se ha creado la " + miBiblioteca.getNombre() + "\n");

        miBiblioteca.nuevoSocioDocente(14524782, "Juan Perez", 5, "Informática");
        miBiblioteca.nuevoSocioDocente(17982110, "Juan Fernández", 5, "Matemática");
        miBiblioteca.nuevoSocioDocente(10912002, "María Alegre", 5, "Letras");

        miBiblioteca.nuevoSocioEstudiante(28987498, "Francisco Paenza", 20, "Ingeniería");
        miBiblioteca.nuevoSocioEstudiante(31987123, "Cesar Milstein", 20, "Medicina");

        miBiblioteca.nuevoLibro("JAVA. Como Programar", 9, "Pearson", 2014);
        miBiblioteca.nuevoLibro("Longman. Diccionario Pocket", 1, "Longman", 2010);
        miBiblioteca.nuevoLibro("Vivir para contarla", 1, "Sudamericana", 2002);
        miBiblioteca.nuevoLibro("Programando con JAVA", 1, "Editorial X", 2020); 

        System.out.println("... Socios y Libros cargados en el sistema ...\n");

        Socio socio1 = miBiblioteca.buscarSocio(14524782);
        Libro libro1 = miBiblioteca.getLibros().get(1); 
        if (socio1 != null && libro1 != null) {
            miBiblioteca.prestarLibro(new GregorianCalendar(), socio1, libro1);
        }

        Socio socio2 = miBiblioteca.buscarSocio(28987498);
        Libro libro2 = miBiblioteca.getLibros().get(3); 
        if (socio2 != null && libro2 != null) {
            miBiblioteca.prestarLibro(new GregorianCalendar(), socio2, libro2);
        }
        
        Socio socio3 = miBiblioteca.buscarSocio(31987123);
        Libro libro3 = miBiblioteca.getLibros().get(2); 
        if (socio3 != null && libro3 != null) {
             miBiblioteca.prestarLibro(new GregorianCalendar(), socio3, libro3);
        }
        
        System.out.println("... Se realizaron 3 préstamos de ejemplo ...\n");

        System.out.println("--- Cantidad de Socios por Tipo ---");
        int cantEstudiantes = miBiblioteca.cantidadDeSociosPorTipos("Estudiante");
        System.out.println("Cantidad de Socios del tipo Estudiante: " + cantEstudiantes);
        
        int cantDocentes = miBiblioteca.cantidadDeSociosPorTipos("Docente");
        System.out.println("Cantidad de Socios del tipo Docente: " + cantDocentes);
        System.out.println("**************************************\n");


        System.out.println("--- Lista de Docentes Responsables ---");
        System.out.println(miBiblioteca.listaDeDocentesResponsables());
        System.out.println("**************************************\n");

        System.out.println("--- Lista de Libros ---");
        System.out.println(miBiblioteca.listaDeLibro()); 
        System.out.println("**************************************\n");
        
        System.out.println("--- Lista de Socios ---");
        System.out.println(miBiblioteca.listarSocio()); 
        System.out.println("**************************************\n");

        Libro libroJava = miBiblioteca.getLibros().get(3); 

        System.out.println("--- Quién tiene 'Programando con JAVA' ---");
        try {
            if (libroJava != null) {
                String nombreSocio = miBiblioteca.quienTieneElLibro(libroJava);
                System.out.println("El libro 'Programando con JAVA' lo tiene: " + nombreSocio);
            } else {
                System.out.println("El libro 'Programando con JAVA' no se encontró en la biblioteca.");
            }
        } catch (LibroEnBiblioteca e) {
            System.out.println(e.getMessage());
        }
        System.out.println("**************************************\n");

        Libro libroNoPrestado = miBiblioteca.getLibros().get(0); 

        System.out.println("--- Quién tiene 'JAVA. Como Programar' (Prueba de excepción) ---");
        try {
            if (libroNoPrestado != null) {
                String nombreSocio = miBiblioteca.quienTieneElLibro(libroNoPrestado);
                System.out.println("El libro 'JAVA. Como Programar' lo tiene: " + nombreSocio);
            }
        } catch (LibroEnBiblioteca e) {
            System.out.println("Respuesta esperada: \n" + e.getMessage());
        }
        System.out.println("**************************************\n");
    }
}
