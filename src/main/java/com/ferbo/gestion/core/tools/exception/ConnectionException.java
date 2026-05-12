package com.ferbo.gestion.core.tools.exception;

public class ConnectionException extends DatabaseException 
{
    public ConnectionException(String message, Throwable cause) {
        super(message, "CONNECTION_ERROR", cause);
    }
    
}
