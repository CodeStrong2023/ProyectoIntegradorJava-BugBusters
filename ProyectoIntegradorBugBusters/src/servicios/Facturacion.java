
package servicios;
import java.util.Random;
import java.time.LocalDate;

public class Facturacion {
    private double importeCable;
    private double importeTotalFactura;
    private double importeInternet;
    //para establecer fecha de vencimiento 30 dias a partir de la consulta
    private LocalDate fechaVencimiento;

    public Facturacion() {
        //para generar importes aleatorios en el rango de 5000 a 10000 redondeados
        Random random = new Random();
        double cableValue = 5000 + random.nextDouble() * (10000 - 5000);
        double internetValue = 5000 + random.nextDouble() * (10000 - 5000);
        importeCable = Math.round(cableValue * 100.0) / 100.0;
        importeInternet = Math.round(internetValue * 100.0) / 100.0;
        importeTotalFactura = importeCable + importeInternet;
        //seteo fecha de vencimiento 30 dias a partir de hoy
        LocalDate fechaActual = LocalDate.now();
        fechaVencimiento = fechaActual.plusDays(30);
    }
    public double getImporteCable() {
        return importeCable;
    }
    public double getImporteInternet() {
        return importeInternet;
    }
    
    public double getImporteTotal() {
        return importeCable + importeInternet;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setImporteCable(double importeCable) {
        this.importeCable = importeCable;
    }

    public void setImporteInternet(double importeInternet) {
        this.importeInternet = importeInternet;
    }

    public void setImporteTotalFactura(double importeTotalFactura) {
        this.importeTotalFactura = importeTotalFactura;
    }

    
}
