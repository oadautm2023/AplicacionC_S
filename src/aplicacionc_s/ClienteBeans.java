/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionc_s;

/**
 *
 * @author SPEEDMIND
 */
import java.sql.*;
public class ClienteBeans {
    private String id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    accesobd bd;
    public ClienteBeans() throws Exception{
        bd=new accesobd("localhost", "root", "mysql2023", "tienda");
        bd.conectaBD();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public int incremento() throws SQLException {
        ResultSet rs;
        int inc;
        rs = bd.consultaBD("select max(id) as num from cliente");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }
    public void insertar()throws SQLException{
    String cadena="insert into cliente values('"+incremento()+"','"+getCedula()+"','"+getNombres()+"','"+getApellidos()+"','"+getDireccion()+"','"+getTelefono()+"')";
    bd.actualizaBD(cadena);
    }

    
    
    
}
