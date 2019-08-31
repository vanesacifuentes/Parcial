/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import modelo.Municipio;
import modelo.MunicipioDAO;
import modelo.Departamento;
import modelo.DepartamentoDAO;
import vista.Interfaz;
import java.awt.event.ItemListener;

/**
 *
 * @author invitado
 */
public class ControladorPrincipal {
    
    
    Interfaz vista;
    DepartamentoDAO modeloDepartamento;
    MunicipioDAO modeloMunicipio; 

    public ControladorPrincipal(Interfaz vista, DepartamentoDAO modeloDepartamento) {
        this.vista = this.vista;
        this.modeloDepartamento = modeloDepartamento;
        
        ArrayList <Departamento> listadoDepartamentos;
        listadoDepartamentos = this.modeloDepartamento.listadoDepartamentos();
        this.vista.cargarDepartamentosCombo(listadoDepartamentos);
        
    }
    
    public ControladorPrincipal(Interfaz vista, MunicipioDAO modeloMunicipio) {
        this.vista = vista;
        this.modeloMunicipio = modeloMunicipio;
        
        this.vista.addItemListenerjComboDepartamento(new MunicipioListener());
                          
    }
    
    
    class MunicipioListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent ie) {
            
        ArrayList<Municipio> listadoMunicipio;
        ArrayList <Departamento> listadoDepartamento = null;
        
 
        listadoMunicipio = modeloMunicipio.listadoMunicipios(listadoDepartamento.get(0).getCodigoDepartamento());
        
        vista.cargarMunicipiosTabla(listadoMunicipio);
            
        }
        
        
        
    }
    
            
}
   
    

