package com.ferbo.gestion.core.tools.exception;

public class QueryNotFoundException extends DatabaseException 
{
    public QueryNotFoundException(String message, Throwable cause) {
        super(message, "QUERY_NOT_FOUND", cause);
    }
    
}
