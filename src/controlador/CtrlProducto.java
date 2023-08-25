
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.formProductos;

public class CtrlProducto implements ActionListener {
    
    private Producto mod;
    private ConsultasProducto modC;
    private formProductos frm;
    
    public CtrlProducto(Producto mod, ConsultasProducto modC, formProductos frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == frm.btnGuardar){
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setExistencias(Integer.parseInt(frm.txtExistencias.getText()));
            
            if(modC.guardar(mod)){
                JOptionPane.showMessageDialog(null, "Producto Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar producto");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnEditar){
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setExistencias(Integer.parseInt(frm.txtExistencias.getText()));
            
            if(modC.editar(mod)){
                JOptionPane.showMessageDialog(null, "Producto Editado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Editar producto");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnEliminar){
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar producto");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnBuscar){
            mod.setCodigo(frm.txtCodigo.getText());
            
            if(modC.buscar(mod)){
                
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtExistencias.setText(String.valueOf(mod.getExistencias()));
           
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnLimpiar){
            limpiar();
        }
        
    }
    
    public void limpiar(){
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtExistencias.setText(null);
    }
    
    
    
}
