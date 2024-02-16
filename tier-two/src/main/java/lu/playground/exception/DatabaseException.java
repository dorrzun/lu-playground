package lu.playground.exception;

import javax.validation.constraints.NotBlank;

/**
 * Represents any kind of unexpected communication error that occurs when
 * working with a database. This error should typically be an external one (e.g: network failures/API outages)
 * 
 * @apiNote Throw this whenever you attempted to communicate with an external
 *          resource of some kind and failed for any reason
 */
public class DatabaseException extends RuntimeException {
    public DatabaseException(){
        super("An unforeseeable communication error has occurred with the database!");
    }
    public DatabaseException(@NotBlank String message) {
        super(message);
    }

    public DatabaseException(@NotBlank String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
