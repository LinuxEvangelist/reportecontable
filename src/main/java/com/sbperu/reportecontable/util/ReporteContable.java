package com.sbperu.reportecontable.util;


import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.sbperu.reportecontable.businessentities.EmpresaBe;
import com.sbperu.reportecontable.businessentities.LibroSunat1213BE;
import com.sbperu.reportecontable.dataaccess.EmpresaDao;
import com.sbperu.reportecontable.dataaccess.ReporteContableDao;

import net.sf.jasperreports.engine.JRException;
/*import net.sf.jasperreports.engine.JRException;*/
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReporteContable extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JasperReport reportx;

	public void Report_Libro_Sunat_12_13() 
    {
        try
        {
            //int idEmpresa = Integer.parseInt(((cboItem)cbEmpresa.getSelectedItem()).getCodigo());
            //String dsEmpresa = ((cboItem)cbEmpresa.getSelectedItem()).getDescripcion();
            //int anio = (int) spnAnio.getValue();
            //int idMes = Integer.parseInt(((cboItem)cbMes.getSelectedItem()).getCodigo());
            //Date fecha = (Date) dchFechaImpresion.getDate();
            String Ruc = "";
            LinkedList<EmpresaBe> listEmpresaBE = EmpresaDao.ListarEmpresa(1);
            Date fecInicio = new Date(System.currentTimeMillis());
            

            for(EmpresaBe oEmpresa : listEmpresaBE)
            {
                Ruc = oEmpresa.getRUC();
            }

            ReporteContableDao libroDAO = new ReporteContableDao();
            LinkedList<LibroSunat1213BE> libroContable = new LinkedList<>();
            JasperPrint jasperPrint;
            String ruta = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            
            //getClass() directorioActual = (this.getClass()) System.getProperty("user.dir");
            

//          ruta = ruta.split("build")[0]+"src/Reportes/reportPrueba";
            ruta = ruta.split("build")[0]+"\\src\\main\\java\\com\\sbperu\\reportecontable\\Reports\\RptLibroSunat12_13";
            String x = ruta.substring(1);
            String strJrxml = x + ".jrxml";
            String strJasper = x + ".jasper";
            Map parameter = new HashMap();
            parameter.put("fecha_inicio", fecInicio);
            
         
            //String documents=newJFileChooser().getFileSystemView().getDefaultDirectory().toString();


            //reportx = (JasperReport) JRLoader.loadObject(this.getClass().getResource("com/sbperu/reportecontable/reports/RptLibroSunat12_13.jasper"));

//                JasperReport report1 = JasperCompileManager.compileReport(strJrxml);
                JasperReport report1;
            report1 = (JasperReport) JRLoader.loadObject(this.getClass().getResource("reports/RptLibroSunat12_13.jasper"));
            //report1 = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/src/main/java/com/sbperu/reportecontable/Reports/RptLibroSunat12_13.jasper"));
                
                
//                libroContable = libroDAO.Libro_Sunat_12_13_1(idEmpresa, anio, idMes, "S", "BTTJNC0005MELES", 4, Ruc, dsEmpresa, fecha);


//                libroContable = libroDAO.Libro_Sunat_12_13_1(idEmpresa, anio, idMes, "S", "*", 0, Ruc, dsEmpresa, fecha);
    //            libroContable = Libro_Sunat_12_13_1(3, 2016, 12, "S", "*", 0);
                libroContable = libroDAO.Libro_Sunat_12_13_1(1, 2018, 1, "S", "BTTJNC0005MELES", 4, "20563207095", "SMART BRANDS SAC", fecInicio);

//                JasperCompileManager.compileReportToFile(ruta+".jrxml");
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(libroContable);
                Date fecFin = new Date(System.currentTimeMillis());
                parameter.put("fecha_fin", fecFin);
                jasperPrint = JasperFillManager.fillReport(report1, parameter, beanColDataSource);
                
//                File pdf = File.createTempFile("output.", ".pdf");
                JasperExportManager.exportReportToPdfFile(jasperPrint, "/opt/application.pdf");
//                JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Backup\\application.pdf");
//                JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));

//                JasperViewer jasperViewer = new JasperViewer(jasperPrint);
//                jasperViewer.setVisible(true);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
//            logg.e(ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
