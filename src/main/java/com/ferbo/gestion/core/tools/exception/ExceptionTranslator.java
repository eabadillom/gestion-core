package com.ferbo.gestion.core.tools.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLTransientConnectionException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;

public class ExceptionTranslator 
{
    private static final List<BiFunction<Exception, Throwable, Optional<RuntimeException>>> RULES = Arrays.asList(
        (e, cause) -> (e instanceof IllegalArgumentException && e.getMessage() != null && e.getMessage().contains("No query defined for that name"))
                ? Optional.of(new QueryNotFoundException("Consulta no definida", e)) : Optional.empty(),

        (e, cause) -> (e instanceof ConstraintViolationException || cause instanceof SQLIntegrityConstraintViolationException)
                ? Optional.of(new DuplicateKeyException("Registro duplicado", e)) : Optional.empty(),

        (e, cause) -> (e instanceof PersistenceException)
                ? Optional.of(new DatabaseException("Error de persistencia", e)) : Optional.empty(),

        (e, cause) -> (e instanceof JDBCConnectionException || cause instanceof SQLNonTransientConnectionException || cause instanceof SQLTransientConnectionException)
                ? Optional.of(new ConnectionException("Error de conexión con la base de datos", e)) : Optional.empty()
    );
    
    public static RuntimeException translate(Exception e) 
    {
        Throwable cause = getRootCause(e);

        return RULES.stream()
            .map(rule -> rule.apply(e, cause))
            .filter(Optional::isPresent) // En Java 8 usamos filter + findFirst
            .map(Optional::get)
            .findFirst()
            .orElse(new DatabaseException("Error inesperado en BD", e));
    }
    
    private static Throwable getRootCause(Throwable e) 
    {
        Throwable cause = e;
        while (cause.getCause() != null && cause.getCause() != cause) {
            cause = cause.getCause();
        }
        return cause;
    }

}
