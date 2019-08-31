/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author invitado
 */
public class MunicipioDAO {
    
        public ArrayList <Municipio> listadoMunicipios(int departamento){ 
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList <Municipio> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            
        String sql;    
            
          sql = "SELECT * FROM municipio ORDER BY id";            
           
           pstm = con.prepareStatement(sql);
                       
           rs = pstm.executeQuery();
                        
            Municipio municipio = null;
            while(rs.next()){
                municipio = new Municipio();
                
                municipio.setCodigo(rs.getInt("codigo"));
                municipio.setCodigo(rs.getInt("nombre"));
                
                listado.add(municipio);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
    
    
    
    
}
