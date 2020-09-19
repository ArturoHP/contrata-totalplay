package com.app.contratatotalplay;

public class Paquetes {

    private String color;
    private String color2;

    private String nombredelpaquete;
    private String descuentoendinero;
    private String recibessincosto;

    private String numeromegas;
    private String textoparawifi;

    private String preciodelistauno;
    private String precioprontopagouno;

    private String preciodelistados;
    private String preciodeprontopagodos;


    //triple play
    private String telesenpaquete;
    private String numerocanales;
    private String parteverdeuno;
    private String parteverdedos;
    private String parteverdetres;


    public Paquetes(String color,String color2, String nombredelpaquete, String descuentoendinero, String recibessincosto, String numeromegas, String textoparawifi, String preciodelistauno, String precioprontopagouno, String preciodelistados, String preciodeprontopagodos,String parteverdeuno, String parteverdedos, String parteverdetres,String telesenpaquete,String numerocanales) {
        this.color = color;
        this.color2 = color2;
        this.nombredelpaquete = nombredelpaquete;
        this.descuentoendinero = descuentoendinero;
        this.recibessincosto = recibessincosto;
        this.numeromegas = numeromegas;
        this.textoparawifi = textoparawifi;
        this.preciodelistauno = preciodelistauno;
        this.precioprontopagouno = precioprontopagouno;
        this.preciodelistados = preciodelistados;
        this.preciodeprontopagodos = preciodeprontopagodos;

        this.telesenpaquete = telesenpaquete;
        this.numerocanales = numerocanales;
        this.parteverdeuno = parteverdeuno;
        this.parteverdedos = parteverdedos;
        this.parteverdetres = parteverdetres;
    }

    public Paquetes(){
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getNombredelpaquete() {
        return nombredelpaquete;
    }

    public void setNombredelpaquete(String nombredelpaquete) {
        this.nombredelpaquete = nombredelpaquete;
    }

    public String getDescuentoendinero() {
        return descuentoendinero;
    }

    public void setDescuentoendinero(String descuentoendinero) {
        this.descuentoendinero = descuentoendinero;
    }

    public String getRecibessincosto() {
        return recibessincosto;
    }

    public void setRecibessincosto(String recibessincosto) {
        this.recibessincosto = recibessincosto;
    }

    public String getNumeromegas() {
        return numeromegas;
    }

    public void setNumeromegas(String numeromegas) {
        this.numeromegas = numeromegas;
    }

    public String getTextoparawifi() {
        return textoparawifi;
    }

    public void setTextoparawifi(String textoparawifi) {
        this.textoparawifi = textoparawifi;
    }

    public String getPreciodelistauno() {
        return preciodelistauno;
    }

    public void setPreciodelistauno(String preciodelistauno) {
        this.preciodelistauno = preciodelistauno;
    }

    public String getPrecioprontopagouno() {
        return precioprontopagouno;
    }

    public void setPrecioprontopagouno(String precioprontopagouno) {
        this.precioprontopagouno = precioprontopagouno;
    }

    public String getPreciodelistados() {
        return preciodelistados;
    }

    public void setPreciodelistados(String preciodelistados) {
        this.preciodelistados = preciodelistados;
    }

    public String getPreciodeprontopagodos() {
        return preciodeprontopagodos;
    }

    public void setPreciodeprontopagodos(String preciodeprontopagodos) {
        this.preciodeprontopagodos = preciodeprontopagodos;
    }
    public String getParteverdeuno() {
        return parteverdeuno;
    }

    public void setParteverdeuno(String parteverdeuno) {
        this.parteverdeuno = parteverdeuno;
    }

    public String getParteverdedos() {
        return parteverdedos;
    }

    public void setPartevertedos(String parteverdedos) {
        this.parteverdedos = parteverdedos;
    }

    public String getParteverdetres() {
        return parteverdetres;
    }

    public void setParteverdetres(String parteverdetres) {
        this.parteverdetres = parteverdetres;
    }

    public String getTelesenpaquete() {
        return telesenpaquete;
    }

    public void setTelesenpaquete(String telesenpaquete) {
        this.telesenpaquete = telesenpaquete;
    }

    public String getNumerocanales() {
        return numerocanales;
    }

    public void setNumerocanales(String numerocanales) {
        this.numerocanales = numerocanales;
    }

}
