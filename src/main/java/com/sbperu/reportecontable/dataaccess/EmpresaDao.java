package com.sbperu.reportecontable.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sbperu.reportecontable.businessentities.EmpresaBe;
import com.sbperu.reportecontable.businessentities.LibroSunat1213BE;



/*import com.sbperu.reportecontable.DataAccess.Conexion;
import com.sbperu.reportecontable.DataAccess.Empresa_BE;
import com.sbperu.reportecontable.DataAccess.Empresa_DAO;*/

public class EmpresaDao {
	public static LinkedList<EmpresaBe> ListarEmpresa(int idEmpresa)
    {
        LinkedList<EmpresaBe> listaEmpresa = new LinkedList<>();        
        ResultSet rs= null;
        
        try
        {
        	Statement st = Conexionn.Cadena().createStatement();
            /*Statement st = Conexion.Cadena().createStatement();*/
            String sql = "SELECT idempresa,empresa,abreviado,ruc,direccion,telefono,cabecera_reporte ";
            sql +=",codigo_postal,codigo_estado,idauditoria,flag_default,flag_agente_retencion ";
            sql +="FROM empresas with (nolock) ";
            
            if (idEmpresa != 0)
            {
                sql+="WHERE idempresa =" + idEmpresa;
            }
            
            rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                listaEmpresa.add(new EmpresaBe(
                        rs.getInt(1)
                        ,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
                        ,rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)
                        ,rs.getInt(10)
                        ,rs.getString(11),rs.getString(12)
                ));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return listaEmpresa;
    }

}
