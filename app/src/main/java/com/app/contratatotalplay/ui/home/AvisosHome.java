package com.app.contratatotalplay.ui.home;


public class AvisosHome {


    //asi se llaman en la bd de firebase
    private String imagen;
    private String nombrepaquete;
    private String numerodelvendedor;



    public AvisosHome(String imagen,String nombrepaquete,String numerodelvendedor) {
        this.imagen = imagen;
        this.nombrepaquete = nombrepaquete;
        this.numerodelvendedor = numerodelvendedor;
    }
    public AvisosHome(){
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombrepaquete(){
        return nombrepaquete;
    }

    public void setNombrepaquete(String nombrepaquete){
        this.nombrepaquete = nombrepaquete;
    }

    public String getNumerodelvendedor() {
        return numerodelvendedor;
    }

    public void setNumerodelvendedor(String numerodelvendedor) {
        this.numerodelvendedor = numerodelvendedor;
    }
}
