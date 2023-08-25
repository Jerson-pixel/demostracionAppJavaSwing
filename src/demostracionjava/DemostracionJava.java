/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demostracionjava;

import controlador.CtrlProducto;
import modelo.Producto;
import modelo.ConsultasProducto;
import vista.formProductos;

/**
 *
 * @author Eliecer Gaete <your.name at your.org>
 */
public class DemostracionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        formProductos frm = new formProductos();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
