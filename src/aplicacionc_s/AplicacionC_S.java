/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionc_s;

import java.util.Scanner;

/**
 *
 * @author SPEEDMIND
 */
public class AplicacionC_S {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String _cedula,_nombres,_apellidos,_direccion,_telefono;
        Scanner sc=new Scanner(System.in);
        ClienteBeans cliente=new ClienteBeans();
        System.out.println("Ingrese cedula");
        _cedula=sc.next();
        cliente.setCedula(_cedula);
        System.out.println("Ingrese Nombres");
         _nombres=sc.next();
         cliente.setNombres(_nombres);
        System.out.println("Ingrese apellidos");
         _apellidos=sc.next();
         cliente.setApellidos(_apellidos);
        System.out.println("Ingrese direccion");
        _direccion=sc.next();
        cliente.setDireccion(_direccion);
        System.out.println("Ingrese el telefono");
        _telefono=sc.next();
        cliente.setTelefono(_telefono);
        cliente.insertar();
        
        
    }
    
}
