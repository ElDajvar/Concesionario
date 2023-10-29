import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Calendar;

public class Principal {

    private static final int Max_Clientes = 2;
    private static final ClientesClass[] Cliente = new ClientesClass[Max_Clientes];
    private static VehiculosClass[] Vehiculo;
    private static int numClientes = 0;

    public static boolean esDNIValido(String dni) {
        // Verificar la longitud
        if (dni.length() != 9) {
            // Error: la cadena debe tener 9 caracteres
            return false;
        }

        // Extraer los primeros 8 dígitos y el carácter de control
        String digitos = dni.substring(0, 8);
        char letraControl = dni.charAt(8);

        try {
            int numDNI = Integer.parseInt(digitos);
            char letrasValidas[] = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray();
            int resto = numDNI % 23;
            char letraCalculada = letrasValidas[resto];

            // Verificar si la letra de control coincide
            return letraCalculada == letraControl;
        } catch (NumberFormatException e) {
            // Error al convertir los dígitos a número
            return false;
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarmenu();
            int opcion = obtenerEntero(sc);

            try {
                switch (opcion) {
                    case 1:
                        nuevocliente(sc);
                        break;
                    case 2:
                        nuevovehiculo(sc);
                        break;
                    case 3:
                        vervehiculos(sc);
                        break;
                    case 4:
                        listartodo();
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Adios <3");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error, seleccione una opcion correcta");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada: Por favor, ingrese un número válido.");
                sc.nextLine(); // Limpiar el búfer del scanner
            } catch (NoSuchElementException e) {
                System.out.println("Error de entrada: No se encontró el elemento.");
                sc.nextLine(); // Limpiar el búfer del scanner
            }
        }
    }
//cambios en el sf


    public static void mostrarmenu() {
        System.out.println("INGRESE UNA OPCION VALIDA");
        System.out.println("1. Nuevo Cliente");
        System.out.println("2. Nuevo Vehiculo");
        System.out.println("3. Ver Vehiculos de un Cliente");
        System.out.println("4. Listado de todos los Clientes y sus Vehiculos");
        System.out.println("5. Salir");
    }

    public static void nuevocliente(Scanner sc)
    {if (numClientes >= Max_Clientes) {
        System.out.println("Solo se pueden tener como máximo 2 clientes");
        return;
    }

        System.out.println("Ingrese los datos del nuevo cliente:");
        System.out.print("DNI: ");
        String DNI = sc.next();  //asdad Captura la línea completa y elimina espacios en blanco al principio y al final
        for (int i = 0; i < numClientes; i++) {
            if (Cliente[i] != null && Cliente[i].getDNI().equals(DNI)) {
                System.out.println("Este DNI ya existe. No se puede cç´ñd.sadrear un nuevo cliente con el mismo DNI.");
                return;
            }
        }

        if (esDNIValido(DNI)) {

            System.out.print("Nombre: ");
            String Nombre = sc.next();

            System.out.print("Apellido primero: ");
            String Apellido1 = sc.next();

            System.out.print("Apellido segundo: ");
            String Apellido2 = sc.next();

            System.out.print("Direccion: ");
            String Direccion = sc.next();

            System.out.print("Poblacion: ");
            String poblacion = sc.next();

            System.out.print("Codigo Postal: ");
            String codPostal = sc.next();


            ClientesClass nuevoCliente = new ClientesClass(DNI, Nombre, Apellido1, Apellido2, Direccion, poblacion, codPostal, 0);
            Cliente[numClientes] = nuevoCliente;
            numClientes++;

            System.out.println("\nNuevo cliente creado exitosamente.\n");


        } else {
            System.out.println("\nEl DNI no es válido.\n");
            return;
        }
        if (DNI.isEmpty()) {
            System.out.println("El DNI no puede estar vacío.");
            return;
        }

    }

    public static void nuevovehiculo(Scanner sc) {
        if (numClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Ingrese los datos del nuevo vehiculo:");
        System.out.print("DNI del propietario: ");
        String dniPropietario = sc.next();

        ClientesClass propietario = null;

        for (int i = 0; i < numClientes; i++) {
            if (Cliente[i] != null && Cliente[i].getDNI().equals(dniPropietario)) {
                propietario = Cliente[i];
                break;
            }
        }
        if (propietario == null) {
            System.out.println("El DNI del propietario no corresponde a ningun cliente registrado.\n");
            return;
        }

        System.out.print("Marca: ");
        String marca = sc.next();
        System.out.print("Matricula: ");
        String matricula = sc.next();
        System.out.print("Numero de kilometros: (Sin decimales ej : 12 ");
        int numKilometros = sc.nextInt();
        if (numKilometros <= 0) {
            System.out.println("El número de kilómetros debe ser mayor que 0.");
            return;
        }
        System.out.print("Fecha de matriculación (en formato dd/mm/aaaa): ");
        String fechaMatriculacionInput = sc.next();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        // Limpiar el búfer del scanner
        sc.nextLine();

        System.out.print("Precio: NO UTILIZE DECIMALES (ej : 12.5) ");
        int precio = sc.nextInt();

        String[] fechaParts = fechaMatriculacionInput.split("/");
        if (fechaParts.length != 3) {
            System.out.println("El formato de fecha es incorrecto. Debe ser dd/mm/aaaa.");
            return;
        }

        int dia = Integer.parseInt(fechaParts[0]);
        int mes = Integer.parseInt(fechaParts[1]);
        int anio = Integer.parseInt(fechaParts[2]);

        LocalDate fechaMatriculacion = null;
        try {
            fechaMatriculacion = LocalDate.of(anio, mes, dia);

            if (fechaMatriculacion.isAfter(LocalDate.now())) {
                System.out.println("La fecha de matriculación debe ser anterior a la fecha actual.");
            } else {
                // La fecha es válida y es anterior o igual a la fecha actual
                System.out.println("La fecha de matriculación es válida.");
            }
        } catch (DateTimeException e) {
            System.out.println("La fecha ingresada no es válida.");
        }


        VehiculosClass nuevoVehiculo = new VehiculosClass(marca, matricula, numKilometros, fechaMatriculacion, descripcion, precio, propietario.getNombre(), propietario.getDNI());
        propietario.agregarVehiculo(nuevoVehiculo);

        System.out.println("\nNuevo vehículo creado exitosamente.\n");
    }

    public static void vervehiculos(Scanner sc) {
        if (numClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.print("Ingrese el DNI del cliente: ");
        String dni = sc.next();

        ClientesClass cliente = null;

        for (int i = 0; i < numClientes; i++) {
            if (Cliente[i].getDNI().equals(dni)) {
                cliente = Cliente[i];
                break;
            }
        }

        if (cliente == null) {
            System.out.println("El DNI ingresado no corresponde a ningun cliente registrado.");
            return;
        }

        System.out.println("Vehiculos del cliente/n " + cliente.getNombre() + cliente.getApellido1() +":\n" + cliente.getVehiculos());
    }

    private static void listartodo() {
        if (numClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Listado de todos los Clientes y sus Vehiculos:\n");
        for (int i = 0; i < numClientes; i++) {
            ClientesClass cliente = Cliente[i];
            System.out.println("Cliente: " +  cliente.getNombre());

            for (VehiculosClass Vehiculo : cliente.getVehiculos()) {
                if (Vehiculo != null) {
                    System.out.println("Marca Vehiculo: " + Vehiculo.getMarca());
                    System.out.println("Matricula: " + Vehiculo.getMatricula());
                    System.out.println("Fecha Matriculacion: " + Vehiculo.getFechaMatriculacion());
                } else if (Vehiculo == null) {
                    System.out.println("No tiene vehiculos");
                }
            }
        }
    }
    private static int obtenerEntero(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada: Por favor, ingrese un número válido.");
                return 0;
            }
        }
    }
}