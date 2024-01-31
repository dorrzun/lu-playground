package lu.playground.exception;

import javax.validation.constraints.NotBlank;

/**
 * Represents any kind of communication exception that occurs when
 * working with a database (Typically an external one, thus making it
 * vulnerable to network failures/service outages)
 * 
 * @apiNote Throw this whenever you attempted to communicate with an external
 *          resource of some kind and failed for any reason
 */
public class DatabaseException extends RuntimeException {
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
