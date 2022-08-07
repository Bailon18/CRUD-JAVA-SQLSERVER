
package PKDAO;

import PKDATA.Conexion;
import PKENTIDAD.Docente;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bailon
 */
public class DocenteDAO {
    
    DefaultTableModel dfm=new DefaultTableModel(){
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return Integer.class; //codigo
                case 1:
                    return String.class; //nombres
                case 2:
                    return String.class; //apellidos
                case 3:
                    return String.class; //especialidad
                case 4:
                    return String.class;//pais
                case 5:
                    return Boolean.class;//Estado
                default:
                    return ImageIcon.class; //foto
            }
         }                
     };  
     
    //Metodo para agregar las columnas
    public void CrearColumnas(JTable tabla){

        tabla.setModel(dfm);
        
        dfm.addColumn("Codigo");
        dfm.addColumn("Nombres");
        dfm.addColumn("Apellidos");
        dfm.addColumn("Especialidad");
        dfm.addColumn("Pais");
        dfm.addColumn("Estado");        
        dfm.addColumn("Foto");
        
        //Estableciendo el ancho de cada columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(80);
        tabla.setRowHeight(60);
    }
   
    //Metodos que retornen el listado para el JTable y los combos
    public ResultSet Docentes() throws SQLException{
        PreparedStatement ps= Conexion.getConexion().
                prepareStatement("usp_ListarDocentes");
        return ps.executeQuery();
    }
    
    public ResultSet Especialidades() throws SQLException{
        PreparedStatement ps=Conexion.getConexion().
              prepareStatement("usp_listarespecialidades");
        return ps.executeQuery();
    }
    
    public ResultSet Paies() throws SQLException{
        PreparedStatement ps=Conexion.getConexion().
                prepareStatement("usp_Paises");
        return ps.executeQuery();
    }
    
    public ResultSet BuscarDocente(int codigo)throws SQLException{
        
        PreparedStatement ps=Conexion.getConexion().
          prepareStatement("{Call usp_buscarDocente(?)}");
        
        ps.setInt(1, codigo);
        
        return ps.executeQuery();

    }
    
    public int AgregarFilasenJable()throws SQLException{
        
        dfm.setRowCount(0);
        
        PreparedStatement ps=Conexion.getConexion().
          prepareStatement("usp_ListarDocentes");
        ResultSet rs=ps.executeQuery();
        
        try {
            while(rs.next()){
                //recuperando el campo foto
                
                Blob blob=rs.getBlob(7);
                Image fotodoc=ImageIO.read(blob.getBinaryStream());
                fotodoc=fotodoc.getScaledInstance(50,50,Image.SCALE_DEFAULT);
                ImageIcon icon=new ImageIcon(fotodoc);

                dfm.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6)==1,
                    icon
                });
                System.out.println("inghresoooo");
                
            }
        } catch (Exception e) {
            System.out.println("Agregar: "+e.getMessage());
        }
        
        return dfm.getRowCount();
    }
    
    public void ActualizarDatosdelDocenteDAL(Docente ed){
        
        System.out.println(ed);
        FileInputStream fis;
        
        try {
            CallableStatement proc=Conexion.getConexion().
                 prepareCall("{Call usp_ActualizarDatosDocente(?,?,?,?,?,?)}");
            
            proc.setInt(1, ed.getCodigo());
            proc.setString(2,ed.getNombres());
            proc.setString(3, ed.getApellidos());
            proc.setInt(4, ed.getIdEspecialidad());
            proc.setInt(5, ed.getIdPais());
            proc.setInt(6, ed.getEstado());
            
            proc.execute();  
            System.out.println("sss "+ed.getRutafile());
            
            if(!"".equals(ed.getRutafile())){
                
                CallableStatement proc2=Conexion.getConexion().
                prepareCall("{Call usp_ActualizarFoto(?,?)}");
            
                File file=new File(ed.getRutafile());
                fis=new FileInputStream(file);
         
                proc2.setInt(1, ed.getCodigo());
                proc2.setBinaryStream(2, fis,(int)file.length());
                proc2.execute();  
            
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"dddddd");
        }
      
    }
    
    public String RegistrarDocenteDAL(Docente edoc){
        
        
        
        String codigo=null;
        FileInputStream fis;
        try {
            
            File file=new File(edoc.getRutafile());
            fis=new FileInputStream(file);
            
            CallableStatement proc=Conexion.getConexion().
            prepareCall("{Call usp_RegistraDocente(?,?,?,?,?,?)}");
            
            proc.setString(1,edoc.getNombres());
            proc.setString(2, edoc.getApellidos());
            proc.setInt(3, edoc.getIdEspecialidad());
            proc.setInt(4, edoc.getIdPais());
            proc.setInt(5, edoc.getEstado());
            proc.setBinaryStream(6, fis,(int)file.length());
            
            proc.execute(); //Ejecutando el Procedimiento Almacenado
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return codigo;
    }
    
    public int EliminarDocente(int codigo){
        
        try {
            PreparedStatement ps=Conexion.getConexion().
                    prepareStatement("{Call usp_EliminacionFisica(?)}");
            
            ps.setInt(1, codigo);
            ps.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return dfm.getRowCount();
    
    }
}
