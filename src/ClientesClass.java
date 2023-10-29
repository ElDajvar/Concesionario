public class ClientesClass {

    String DNI;
    String Nombre;
    String Apellido1;
    String Apellido2;
    String Direccion;
    String poblacion;
    String codPostal;
    int numero_Vehiculos;

    private int numVehiculos;
    public final int Max_Vehiculos = 2;
    private final VehiculosClass[] vehiculos;

    public ClientesClass(String DNI, String Nombre, String Apellido1, String Apellido2, String Direccion, String poblacion, String codPostal, int numero_Vehiculos) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Direccion = Direccion;
        this.poblacion = poblacion;
        this.codPostal = codPostal;
        this.numero_Vehiculos = numero_Vehiculos;
        this.vehiculos = new VehiculosClass[Max_Vehiculos];

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public  String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public int getNumero_Vehiculos() {
        return numero_Vehiculos;
    }

    public void setNumero_Vehiculos(int numero_Vehiculos) {
        this.numero_Vehiculos = numero_Vehiculos;
    }


    public VehiculosClass[] getVehiculos() {
        return vehiculos;
    }

    @Override

    public String toString() {
        return "ClientesClass{" +
                "DNI=" + DNI +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido1='" + Apellido1 + '\'' +
                ", Apellido2='" + Apellido2 + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", codPostal=" + codPostal +
                ", numero_Vehiculos=" + numero_Vehiculos +
                '}';

    }

    public void agregarVehiculo(VehiculosClass vehiculo) {
        if (numVehiculos >= Max_Vehiculos) {
            System.out.println("No se pueden agregar más vehículos al cliente.");
            return;
        }
        vehiculos[numVehiculos] = vehiculo;
        numVehiculos++;
    }
}
