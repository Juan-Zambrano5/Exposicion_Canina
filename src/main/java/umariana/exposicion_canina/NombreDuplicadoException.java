package umariana.exposicion_canina;

/**
 *
 * @author Santiago Luna y Juan Zambrano
 */
public class NombreDuplicadoException extends Exception {
    public NombreDuplicadoException() {
        
        super ("Ya existe un perro con ese nombre, intentelo nuevamente");

    }
}
