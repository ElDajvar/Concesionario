import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Calendar;

public class VehiculosClass {
    String marca;
    String matricula;
    long numeroKML;
    LocalDate fechaMatriculacion;
    String Descripcion;
    int  precio;
    String nombrePropietario;
    String dniPropietario;

    public VehiculosClass(String marca, String matricula, long numeroKML, LocalDate fechaMatriculacion, String Descripcion, int precio, String nombrePropietario, String dniPropietario){
        this.marca = marca;
        this.matricula = matricula;
        this.numeroKML = numeroKML;
        this.fechaMatriculacion = fechaMatriculacion;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public long getNumeroKML(){
        return numeroKML;
    }

    public void setNumeroKML(long numeroKML){
        this.numeroKML = numeroKML;
    }

    public LocalDate getFechaMatriculacion(){
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion){
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getDescripcion(){
        return Descripcion;
    }

    public void setDescripcion(String Descripcion){
        this.Descripcion = Descripcion;
    }

    public int getPrecio(){
        return precio;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public String getNombrePropietario(){
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario){
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniPropietario(){
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario){
        this.dniPropietario = dniPropietario;
    }

    @Override
    public String toString(){
        return "VehiculosClass{" +
                "marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", numeroKML=  " + numeroKML +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", Descripcion='" + Descripcion + '\'' +
                ", precio=" + precio +
                ", nombrePropietario='" + nombrePropietario + '\'' +
                ", dniPropietario='" + dniPropietario + '\'' +
                '}';
    }

    public int getAnios(LocalDate fechaMatriculacion) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaMatriculacion, fechaActual);
        return periodo.getYears();
    }
}
