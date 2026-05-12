package com.ferbo.gestion.core.tools;

import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateUtils 
{
    private static Logger log = LogManager.getLogger(DateUtils.class);
    
    public static final int ENERO = Calendar.JANUARY;
    public static final int FEBRERO = Calendar.FEBRUARY;
    public static final int MARZO = Calendar.MARCH;
    public static final int ABRIL = Calendar.APRIL;
    public static final int MAYO = Calendar.MAY;
    public static final int JUNIO = Calendar.JUNE;
    public static final int JULIO = Calendar.JULY;
    public static final int AGOSTO = Calendar.AUGUST;
    public static final int SEPTIEMBRE = Calendar.SEPTEMBER;
    public static final int OCTUBRE = Calendar.OCTOBER;
    public static final int NOVIEMBRE = Calendar.NOVEMBER;
    public static final int DICIEMBRE = Calendar.DECEMBER;

    public static LocalDate fechaVencimiento(LocalDate fecha, int diasVencimiento, boolean esVigenciaNatural) 
    {
        LocalDate vencimiento = fecha;

        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonthValue();
        int anio = fecha.getYear();

        if (diasVencimiento == 30 && (!esVigenciaNatural)) 
        {
            vencimiento = vencimiento.plusMonths(1);

            if (Year.isLeap(anio)) {
                if (!(mes == DateUtils.ENERO && dia > 29)) {
                    vencimiento = vencimiento.minusDays(1);
                }
            } else {
                if (!(mes == DateUtils.ENERO && dia > 28)) {
                    vencimiento = vencimiento.minusDays(1);
                }
            }
        } else {
            vencimiento = vencimiento.plusDays(diasVencimiento);
        }

        return vencimiento;
    }

}
