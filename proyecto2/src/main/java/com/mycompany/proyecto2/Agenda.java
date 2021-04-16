package com.mycompany.proyecto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Agenda {
    
    private Contacto[] contactos;
    
    public Agenda(){
        this.contactos = new Contacto[10];
    }
    
    public Agenda(int tamanio){
        this.contactos = new Contacto[tamanio];
    }
    
    public void aniadirContacto(Contacto c){ 
        
        if(this.existeContacto(c)){
            System.out.println("El contacto con ese nombre ya existe");
        }
        
        else if(agendaLlena()){
           System.out.println("La agenda esta llena, no se pueden meter mas contactos");
        } 
        
             else{
            
             boolean encontrado = false;  
             for(int i=0;i<contactos.length && !encontrado;i++){
                if(contactos[i]==null){
                    contactos[i]=c;
                    encontrado=true;
                }
             }
   
            if(encontrado){
                System.out.println("Se ha añadido");
            }else{
                System.out.println("No se ha podido añadir");
            }
        }
   
   }
   
   public boolean existeContacto(Contacto c){
       
       
        for(int i=0;i<contactos.length;i++){
            if(contactos[i]!=null && c.equals(contactos[i])){
                return true;
            }
        }
        return false;
        
   }
   
   public void listarContactos(){
        
       int contador = 0;
        for(int i=0;i<contactos.length;i++){
            if(contactos[i]!=null){
                System.out.println(contactos[i]);
            }
            if(contactos[i]==null) {
               contador++;
            }
            
        }
        
        if(contador==contactos.length)
        {
            System.out.println("No hay contactos");
        }
   }
   
   public void buscarPorNombre(String nombre){
       boolean encontrado = false;
       for(int i=0;i<contactos.length && !encontrado;i++){
           if(contactos[i]!=null && contactos[i].getNombre().equalsIgnoreCase(nombre.trim())){
              System.out.println("Su teléfono es: " + contactos[i].getTelefono());
              encontrado = true;
           }
       }
        
       if(!encontrado){
           System.out.println("No se ha encontrado el contacto");
       }
       
   }
   
   public boolean agendaLlena(){
       
       for (int i = 0; i < contactos.length; i++){
           if(contactos[i] == null){
               return false;
           }
       }
       
       return true;
       
   }
   
   public void eliminarContacto(Contacto c){
       
       boolean encontrado = false;
       for(int i=0;i<contactos.length&&!encontrado;i++){
           if(contactos[i]!=null && contactos[i].equals(c)){
              contactos[i]=null;
              System.out.println("Contacto eliminado");
              encontrado = true;
           }
       }
       
       if(!encontrado){
           System.out.println("No se ha eliminado el contacto");      
       }
   }
   
   public int huecosLibre(){
       int contador = 0;
       for(int i=0;i<contactos.length;i++){
           if(contactos[i]==null){
              contador++;
           }
       }
       
       return contador;
   }

    
    
   /*ARCHIVOS*/
public void CrearArchivo (String nombre) throws IOException{
       File f;
       FileWriter w;
       BufferedWriter bw;
       PrintWriter wr;

       try{
           f= new File(nombre);
           w= new FileWriter(f);
           bw= new BufferedWriter(w);
           wr= new PrintWriter(bw);
           boolean encontrado = false;
           for(int i=0;i<contactos.length && !encontrado;i++){
           if(contactos[i]!=null && contactos[i].getNombre().equalsIgnoreCase(nombre)){
              wr.write("Nombre: " + contactos[i].getNombre());
              wr.write(" ; ");
              wr.write("Telefono: " + contactos[i].getTelefono());
              wr.write(" ; ");
              encontrado = true;
               System.out.println("Se ha creado el archivo");
           }
       }
           wr.close();
           bw.close();
        }
       catch (Exception e){
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error"+ e);

       }

   }

}

