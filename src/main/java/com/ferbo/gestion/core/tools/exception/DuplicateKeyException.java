package com.ferbo.gestion.core.tools.exception;

public class DuplicateKeyException extends DatabaseException 
{
    public DuplicateKeyException(String message, Throwable cause) {
        super(message, "DUPLICATE_KEY", cause);
    }
    
}
