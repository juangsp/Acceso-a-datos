/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Ejercicio4 {

    static String ruta = "fichero.txt";
    static String ruta2 = "alineacion.txt";
    static String ruta3 = "alineacion.csv";
    static int CANTIDAD_POR_DEFECTO = 5;
    static String[] alineacion = {"Casillas", "Ramos", "Pepe", "Marcelo", "Carvajal", "Kroos", "Modric", "James", "Bale", "Ronaldo", "Benzema"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String serie = serieFibbonacci(CANTIDAD_POR_DEFECTO);
        escribirArchivo(ruta, serie);

        menuFibbonacci();

        guardarAlineacionEquipo(ruta2, alineacion);
        guardarAlineacionEquipo2(ruta3, alineacion);
    }

    public static void menuFibbonacci() {//Menu para poder seleccionar 
        Scanner sc = new Scanner(System.in);//cuantos numeros de la serie Fibbonacci quieres conocer
        int numero;

        System.out.println("Introduce cuantos numeros de la serie fibbonacci quieres conocer");
        numero = sc.nextInt();
        sc.nextLine();

        if (numero > 0) {
            String serie = serieFibbonacciNumero(numero);

            escribirArchivo(ruta, serie);
        } else {
            System.out.println("Error, el numero no puede ser menor que 0");
        }
    }

  //Realiza la serie fibbonacci hasta un numero determinado
    public static String serieFibbonacci(int CANTIDAD_POR_DEFECTO) {
        int variable1 = 0;
        int variable2 = 1;
        int numeroF = 1;
        String serieF = "";
        for (int i = 0; i < CANTIDAD_POR_DEFECTO; i++) {

            serieF = serieF + " " + Integer.toString(numeroF);
            numeroF = variable1 + variable2;
            variable1 = variable2;
            variable2 = numeroF;

        }
        return serieF;
    }
//realiza la serie hasta un numero seleccionado por el usuario

    public static String serieFibbonacciNumero(int numero) {
        int variable1 = 0;
        int variable2 = 1;
        int numeroF = 1;
        String serieF = "";
        for (int i = 0; i < numero; i++) {

            serieF = serieF + " " + Integer.toString(numeroF);
            numeroF = variable1 + variable2;
            variable1 = variable2;
            variable2 = numeroF;

        }
        return serieF;
    }

    //Guarda la serie de fibonacci en un archivo del tipo txt
    public static void escribirArchivo(String ruta, String serie) {

        File f = new File(ruta);
        FileWriter fw=null;
        try {
           fw = new FileWriter(f, true);
            fw.write(serie);

            fw.close(); 

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //Guarda la alineacion de un equipo en un archivo del tipo txt
    public static void guardarAlineacionEquipo(String ruta, String[] alineacion) {

        File f = new File(ruta);
        BufferedWriter bw=null;
        try {
            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.write("RealMadrid");
            bw.newLine();
            for (int i = 0; i < alineacion.length; i++) {
                bw.write(alineacion[i].toString());
                bw.newLine();

            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //Guarda la alineacion de un equipo en un archivo del tipo csv
    public static void guardarAlineacionEquipo2(String ruta, String[] alineacion) {

        File f = new File(ruta);
        BufferedWriter bw=null;
        try {
            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.write("RealMadrid");
            bw.newLine();
            for (int i = 0; i < alineacion.length; i++) {
                bw.write(alineacion[i].toString() + ";");
                bw.newLine();

            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
