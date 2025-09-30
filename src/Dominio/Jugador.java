/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author victo
 */
public class Jugador {
    private String nombre;
    private int edad;
    public void setNombre( String elNombre){
        this.nombre = elNombre;
    
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setEdad(int laEdad){
        this.edad = laEdad;
    }
    public int getEdad(){
        return this.edad;
    }
    
}
