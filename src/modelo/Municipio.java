/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author invitado
 */
public class Municipio {
    
    private int idmunicipio;
    private int departamento; 
    private int codigo; 
    private String nombre;

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public int getDepartamento() {
        return departamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
    
}
