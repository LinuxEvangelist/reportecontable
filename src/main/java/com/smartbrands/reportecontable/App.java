package com.smartbrands.reportecontable;

import com.sbperu.reportecontable.util.ReporteContable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReporteContable rpt = new ReporteContable(args[0]);
		
		rpt.Report_Libro_Sunat_12_13();
    }
}
