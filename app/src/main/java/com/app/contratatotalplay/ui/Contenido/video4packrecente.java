package com.app.contratatotalplay.ui.Contenido;

public class video4packrecente {

    private String videoparapaquetereciente;
    private String imagenparapaquetereciente;

    public video4packrecente(){
    }

    public video4packrecente(String imagenparapaquetereciente,String videoparapaquetereciente) {
        this.imagenparapaquetereciente = imagenparapaquetereciente;
        this.videoparapaquetereciente = videoparapaquetereciente;
    }

    public String getVideoparapaquetereciente() {
        return videoparapaquetereciente;
    }

    public void setVideoparapaquetereciente(String videoparapaquetereciente) {
        this.videoparapaquetereciente = videoparapaquetereciente;
    }

    public String getImagenparapaquetereciente() {
        return imagenparapaquetereciente;
    }

    public void setImagenparapaquetereciente(String imagenparapaquetereciente) {
        this.imagenparapaquetereciente = imagenparapaquetereciente;
    }

}
