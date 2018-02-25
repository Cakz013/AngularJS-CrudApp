package com.example.cesar.util;


public class ErrorDTO {

    private String mensajeError;

    public ErrorDTO(String mensajeError){
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

}
