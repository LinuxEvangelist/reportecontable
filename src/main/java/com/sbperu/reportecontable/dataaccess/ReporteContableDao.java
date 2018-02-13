package com.sbperu.reportecontable.dataaccess;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.table.DefaultTableModel;

import com.sbperu.reportecontable.businessentities.LibroSunat1213BE;



public class ReporteContableDao {
	public static LinkedList<LibroSunat1213BE> Libro_Sunat_12_13_1(int p_idempresa, int p_anio, int p_mes
            , String p_valorizado, String p_codigo_producto, int p_idalmacen
            , String RucEmpresa, String Empresa, Date FechaImpresion) throws Exception
        {
            DefaultTableModel tableModel =  new DefaultTableModel();
            LinkedList<LibroSunat1213BE> listaLibro = new LinkedList<>();
            Connection con = null;
            CallableStatement proc_stmt = null;
            ResultSet rs= null;
            ResultSetMetaData rsm;
            
            try
            {
                proc_stmt = Conexionn.Cadena().prepareCall(" exec USP_CONTABILIDAD_LIBROSUNAT_FORMATO_12_13 ?,?,?,?,?,? ");

                proc_stmt.setInt(1, p_idempresa);
                proc_stmt.setInt(2, p_anio);
                proc_stmt.setInt(3, p_mes);
                proc_stmt.setString(4, p_valorizado);
                proc_stmt.setString(5, p_codigo_producto);
                proc_stmt.setInt(6, p_idalmacen);
                
                proc_stmt.execute();
                rs = proc_stmt.executeQuery();
                rsm=rs.getMetaData();
                
                int col=rsm.getColumnCount();
                //int col=rs.getRow();
                // Agrega Nombre Cabecera
                for(int i=1; i<=col;i++)
                {
                    tableModel.addColumn(rsm.getColumnLabel(i));
                }
                
                Date intr[] = new Date[col];
                Object fila[]=new Object[col];
                String strFila[] = new String[col];
                boolean  flag = false;
                
                while (rs.next()) 
                {
//                    for (int j=0;j<col;j++)
//                    {
//                        strFila[j]=rs.getString(j+1);
                        listaLibro.add(new LibroSunat1213BE(
                                rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                                rs.getDate(6),
                                rs.getString(7),
                                rs.getString(8),rs.getString(9),rs.getString(10),
                                rs.getString(11),rs.getDouble(12),rs.getDouble(13),rs.getDouble(14),rs.getDouble(15),
                                rs.getDouble(16),rs.getDouble(17),rs.getDouble(18),rs.getDouble(19),rs.getDouble(20),
                                rs.getString(21),
                                RucEmpresa, Empresa, FechaImpresion
                        ));     
//                    }
//                    tableModel.addRow(strFila);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            return listaLibro;
        }

}
