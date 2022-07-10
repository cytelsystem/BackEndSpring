package com.dh.odontologica.model;



public class Lenguaje {

    private String tipo;
    private boolean esOrientadoAObjetos;

    //****************************Constructores************************************//
    public Lenguaje(String tipo, boolean esOrientadoAObjetos) {
        this.tipo = tipo;
        this.esOrientadoAObjetos = esOrientadoAObjetos;
    }

    //****************************Getter y Setter***********************************//

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEsOrientadoAObjetos() {
        return esOrientadoAObjetos;
    }

    public void setEsOrientadoAObjetos(boolean esOrientadoAObjetos) {
        this.esOrientadoAObjetos = esOrientadoAObjetos;
    }
    //*****************************************************************************//


}
