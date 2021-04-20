
package com.mycompany.proyecto2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class agendatelefonica {
    
    public static void main(String[] args) throws IOException
    {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; 
        
        Agenda agendaTelefonica = new Agenda(3);
        String nombre;
        int telefono;
        Contacto c;
        
        while (!salir)
        {
            System.out.println("1. AÃ±adir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contactos");
            System.out.println("6. Contactos disponibles");
            System.out.println("7. Agenda llena");
            System.out.println("8. Archivar contacto");
            System.out.println("9. Salir");
            try
            {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
            
                switch(opcion)
                {
                    case 1:
                        if(agendaTelefonica.agendaLlena())
                        {
                         System.out.println("La agenda estÃ¡ llena");
                         break;
                        }
                        else{
                        System.out.println("Escribe un nombre: ");
                        nombre = sn.next();
                        
                        System.out.println("Escribe un telefono");
                        telefono = sn.nextInt();
                        
                        c = new Contacto(nombre, telefono);
                        
                        agendaTelefonica.aniadirContacto(c);
                        }
                        break;
                    case 2:   
                        agendaTelefonica.listarContactos();
                        break;
                    case 3:
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
                        
                        agendaTelefonica.buscarPorNombre(nombre);
                        break;
                    case 4:
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
                        
                        c = new Contacto(nombre, 0);
                         
                        if(agendaTelefonica.existeContacto(c)){
                            System.out.println("Existe contacto");
                        }else{
                            System.out.println("No existe contacto");
                        }
                        
                        break;
                    case 5: 
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
                        
                        c = new Contacto(nombre, 0);
                         
                        agendaTelefonica.eliminarContacto(c);
                        
                        break;
                    case 6:
                        System.out.println("Hay "+agendaTelefonica.huecosLibre()+" contactos libres");
                        break;
                    case 7:  
                        if(agendaTelefonica.agendaLlena())
                        {
                         System.out.println("La agenda estÃ¡ llena");
                        }else{
                            System.out.println("Aun puedes meter contactos");
                        }
                        break;
                    case 8: 
                        System.out.println("Escribe el nombre del contacto que deseas archivar");
                        nombre = sn.next();
                        agendaTelefonica.CrearArchivo(nombre);
                    case 9:
                        salir = true;
                        break;
                    default: 
                        System.out.println("Solo numeros entre 1 y 7");  
                }
                
                
            } catch (InputMismatchException e)
            {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
    
        }
    
    }
}

