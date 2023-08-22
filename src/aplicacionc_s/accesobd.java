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

public class accesobd {
    private final String host;
    private final String user;
    private final String passwd;
    private final String bd;
    private Connection conexion;

    public accesobd(String host, String user, String passwd, String bd) {
        this.host = host;
        this.user = user;
        this.passwd = passwd;
        this.bd = bd;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getBd() {
        return bd;
    }
    public void conectaBD() throws Exception{
        try {
                Driver driver=(Driver)
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String cadena="jdbc:mysql://"+getHost()+"/"+getBd();
                conexion=DriverManager.getConnection(cadena,getUser(),getPasswd());
                System.out.println("conexion exitosa.... COMMIT");                
        } catch (SQLException e) {
            System.out.println("Error grave de acceso a BD ROLL BACK"+e.toString());
        }
    }
    public void actualizaBD(String sql)throws SQLException{
        try {
            Statement stm=conexion.createStatement();
            stm.execute(sql);
            System.out.println("Transaccion realizada correctamente... COMMIT");
            
        } catch (SQLException e) {
             System.out.println("Error en la actualizacion de informacion... ROLLBACK"+e.toString());
        }
  
    }
    public ResultSet consultaBD(String sql)throws SQLException{
        ResultSet cursor;
        Statement stm = conexion.createStatement();
        cursor = stm.executeQuery(sql);
        return cursor;
    }
    public void cerrarBD()throws SQLException{
    conexion.close();
    }

    
    
}
