/**
 * La clase Docente hereda de Socio
 * Tiene beneficios adicionales y reglas de responsabilidad
 * Permite ver su historial de prestamos y cambiar sus dias de prestamo
 * @author (Escubilla Micaela Belén) 
 * @version (28/10/2025)
 */
import java.util.Calendar;
import java.util.ArrayList;
public class Docente extends Socio{
    private String area;
    /**
     * Constructor de la clase Docente
     * @param int p_dni
     * @param String p_nombre 
     * @param int p_diasPrestamo 
     * @param String p_area 
     */
    public Docente(int p_dni, String p_nombre, int p_diasPrestamo, String p_area){
        super(p_dni, p_nombre, p_diasPrestamo);
        this.setArea(p_area);
    }

    // Setters
    private void setArea(String p_area){
        this.area = p_area;
    }

    // Getters
    public String getArea(){
        return this.area;
    }

    // Métodos
    /**
     * Verifica el historial del Docente para ver si es responsable
     * @return true si el docente es responsable, nunca tuvo ni tiene un prestamo vencido
     */

    public boolean esResponsable(){
        if(super.getDiasPrestamo() == -1){
            return false; //si ya fue marcado con -1 entonces no es responsable
        }
        Calendar fechaHoy = Calendar.getInstance();
        for(Prestamo unPrestamo : super.getPrestamos()){
            boolean esVencido;
            if(unPrestamo.getFechaDevolucion() != null){
                esVencido = unPrestamo.vencido(unPrestamo.getFechaDevolucion()); 
            } else {
                esVencido = unPrestamo.vencido(fechaHoy); //verifica si el prestamo sigue vencido hasta el dia de la fecha
            }
            if (esVencido) {
                super.setDiasPrestamo(-1); //marca definitivamente la irresponsabilidad 
                return false;
            }
        }
        return true;
    }
    
    /**
     * Agrega dias de prestamo a la cantidad de dias base del docente como recomprensa por la responsabilidad
     * @param int p_dias, cantidad de dias que se pueden agregar al periodo de prestamo
     */
    public void cambiarDiasDePrestamo(int p_dias){
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }

    /**
     * Determina si el docente puede pedir un nuevo libro
     * @return true si el docente es responsable
     */
    @Override
    public boolean puedePedir(){
        return this.esResponsable();
    }

    /**
     * Devuelve el tipo de clase del socio
     * @return un String "Docente"
     */
    @Override
    public String soyDeLaClase(){
        return "Docente";
    }
}