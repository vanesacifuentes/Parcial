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
public class DepartamentoDAO {
    
    public ArrayList <Departamento> listadoDepartamentos (){ 
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList <Departamento> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            
            
        String sql;    
            
          sql = "SELECT * FROM departamento ORDER BY id";            
           
           pstm = con.prepareStatement(sql);
                       
           rs = pstm.executeQuery();
                        
            Departamento departamento = null;
            while(rs.next()){
                departamento = new Departamento();
                
                departamento.setNombre(rs.getString("nombre"));
                
                listado.add(departamento);
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
