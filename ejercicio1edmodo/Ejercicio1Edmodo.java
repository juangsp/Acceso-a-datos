/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio1edmodo;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Ejercicio1Edmodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in,"ISO_8859-1");
        String fichero2="fichero_lectura.txt";
        String ruta = "F:\\desarrollo de aplicaciones multiplataforma\\";
        String ruta2="F:\\desarrollo de aplicaciones multiplataforma\\2º\\Acceso a datos\\Ejercicios\\Ejercicio1Edmodo\\fichero_lectura.txt";
        String fichero= "F:\\desarrollo de aplicaciones multiplataforma\\fichero1.txt";
        String directorio="C:\\NUEVODIR";
        String extension = ".txt";
        String separacion=",";
        boolean f=existeArchivo(fichero);
        System.out.println(f);
        
        System.out.println(datosFicheros(fichero));
        
        System.out.println(devolverRuta(ruta));
        
        imprimirContenidoDirectorio(ruta);
        
        listarDirectorio2(ruta,extension);
        
        boolean f2=crearDirectorio(directorio);
        System.out.println(f2);
        
        String s2=renombrarArchivo(ruta);
        System.out.println(s2);
        
        System.out.println(touch());
        
        System.out.println(touch2( ruta));
        System.out.println(leerArchivo());
       
        System.out.println("-----------------------------------------------------------------------");
        leerFichero(fichero2,separacion);
        System.out.println(leerLineaBuffer());
    
     
        

    }

    
    public static boolean existeArchivo(String s) {
        File f = new File(s);

        return f.exists();
    }
    
    
    public static String [] datosFicheros(String fichero){
        
         File f2 = new File(fichero);
        
        String array[] = new String[6];
        array[0] = f2.getName();
        array[1] = f2.getAbsolutePath();
        if(f2.canRead()){
           array[2] = "True";
        }else array[2] = "False";
        
         if(f2.canWrite()){
           array[3] = "True";
        }else array[3] = "False";
        
        int tamano = (int) f2.length();
        String tamano2 = Integer.toString(tamano);
         
        array[4] = tamano2;
        array[5] = f2.getParent();
        
        return array;
        
        
    }
    public static String devolverRuta(String ruta){
        
        File f=new File(ruta);
        if(f.isAbsolute()==true){
            return f.getAbsolutePath();
        }else
            
       return f.getPath();
    }

    public static void imprimirContenidoDirectorio(String s) {
        File f = new File(s);
        String[] archivos = f.list();
        for (String archivo : archivos) {
            System.out.println(archivo);
        }
    }

    public static void listarDirectorio2(String s,String ext) {
        File f = new File(s);
        
        String[] archivos = f.list();

        for (String archivo : archivos) {
            if (archivo.contains(ext)) {
                System.out.println(archivo);
            }

        }
    }
        public static boolean crearDirectorio(String s) {
        File f = new File(s);

        f.mkdir();
        return f.exists();
    }

    public static String renombrarArchivo(String s) {
        File f = new File(s + "\\" + "fichero.txt");
        File f2;

        f.renameTo(f2 = new File(s + "\\" + "fichero1.txt"));

       return f2.getName();

    }
    public static boolean touch() throws IOException{
        File f = new File("fichero2.txt");
        f.createNewFile();
        
        return f.exists();
    }
    
    public static boolean touch2(String ruta) throws IOException{
        File f = new File(ruta + "\\fichero3.txt");
        f.createNewFile();
        
        return f.exists();
        
        
    }

    public static String leerArchivo() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();

        return s;

    }

    public static void leerFichero(String fichero,String separacion){
        try {
            String s;
            String [] s1=null;
            Scanner sc=new Scanner(new File(fichero));
            
            while(sc.hasNext()){
                
                s=sc.nextLine();
                s1=s.split(separacion);
                
            }
            for (int i=0;i<s1.length;i++){
                
                System.out.println(s1[i]);
            }
                
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio1Edmodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public static String leerLineaBuffer() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Introduce texto");
            String texto = br.readLine();
            return texto;
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1Edmodo.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        return "..";
    }
    

}
