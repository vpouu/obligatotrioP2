/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import dominio.*;

/**
 *
 * @author Usuario
 */
public class Interfaz {
    private Sistema sistema;

    public Interfaz(Sistema sistema) {
        this.sistema = sistema;
    }
    public void iniciar(){
        
    }
    public static void mostrarMatrizLogica (String [][] matLogica){
        String separador= "+--+--+--+--+--+--+";
        System.out.println(separador);
        for (int i = 0; i < matLogica.length; i++) {
            for(int k=1; k<=3;k++){
                String cadena="|";
                for (int j = 0; j < matLogica[i].length; j++) {
                    cadena +=darCiruclito(i,k,j,matLogica)+"|";
                }
                System.out.println(cadena);
            }
            System.out.println(separador);                  
        }
    }
    public static String darCiruclito (int i, int k, int j, String [][] matLogica){
        String circulito="";
        String ret="  ";
        if(null!=matLogica[i][j]){
            if(matLogica[i][j].charAt(1)=='1'){
                circulito="o";
            }else{
                circulito="●";
            }
            char COD=matLogica[i][j].toUpperCase().charAt(0);
            if((COD=='C' && k%2!=0) || (COD=='D'&&k%2==0)){
                ret=" "+ circulito;
            }else{
                ret=circulito + " ";
            }
            
        }
        return ret;
        
    }
            

}
