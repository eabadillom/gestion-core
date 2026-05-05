package com.ferbo.gestion.core.tools;

public class CoreException extends Exception 
{
    private static final long serialVersionUID = 6243100841230323823L;

    public CoreException() {
        super();
    }

    public CoreException(String message) {
        super(message);
    }

    public CoreException(Throwable cause) {
        super(cause);
    }

    public CoreException(String message, Throwable cause) {
        super(message, cause);
    }

}
