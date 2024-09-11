package empresax.services;

import empresax.models.Empleado;

import java.util.Scanner;

public class EmpleadoService {
    private Scanner sc;
    private Empleado empleado;
    private Empleado[] listaEmpleados;

    public EmpleadoService() {
        sc = new Scanner(System.in);
        listaEmpleados = new ArrayList<>();
    }


    public void menu() {
        int opcion;
        do {
            System.out.println("::MENU::");
            System.out.println("1 - CREAR EMPLEADO");
            System.out.println("2 - MODIFICAR EMPLEADO");
            System.out.println("3 - BUSCAR EMPLEADO");
            System.out.println("4 - LISTAR EMPLEADOS");
            System.out.println("5 - ELIMINAR EMPLEADO");
            System.out.println("0 - SALIR");
            System.out.println("Ingrese una opcion del menu");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    modificarEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    listarEmpleado();
                    break;
                case 5:
                    eliminarEmpleado();
                default:
                    opcion = 0;
                    System.out.println("Gracias por usar este menu");
            }
        } while (opcion != 0);
    }

    private void crearEmpleado() {
        System.out.println("****CREAR EMPLEADOS****");

        System.out.println("::CREAR EMPLEADO::");
        System.out.println("Ingrese el documento del empleado");
        String documento = sc.next();
        // Validar documento acá tiene que estar mirar que no este repetido el empleado
        System.out.println("Ingrese el nombre del empleado");
        String nombre = sc.next();
        System.out.println("Ingrese las horas trabajadas");
        int horas = sc.nextInt();
        System.out.println("Ingrese el valor de la hora");
        double valor = sc.nextDouble();
        listaEmpleados.add(new Empleado(documento, nombre, horas, valor, calcularSueldo(horas, valor)))


    }

    private void modificarEmpleado() {
        int posicion = buscarEmpleado();
        if (posicion >= 0) {
            empleado = listaEmpleados.get(posicion);
            System.out.println("::MODIFICAR EMPLEADO::");
            System.out.println("Ingrese el nombre del empleado");
            String nombre = sc.next();
            empleado.setNombreEmpleado(nombre);
            System.out.println("Ingrese las horas trabajadas");
            int horas = sc.nextInt();
            empleado.setHorasTrabajadas(horas);
            System.out.println("Ingrese el valor de la hora");
            double valor = sc.nextDouble();
            empleado.setValorHora(valor);
            empleado.setSueldo(calcularSueldo(horas, valor));
            listaEmpleados.set(posicion, empleado);
        }

    }

    private int buscarEmpleado() {
        System.out.println("####Buscar empleado#####");
        System.out.println("Ingrese el numero de documento del empleado");
        String documento = sc.next();
        empleado = null;
        for (Empleado empleadoEncontrado: listaEmpleados) {
            if (empleadoEncontrado.getDocumento().equals(documento)) {
                empleado = empleadoEncontrado;
                imprimirEmpleado(empleadoEncontrado);
                break;
            }

        }

        System.out.println("Registro no encontrado");
        return listaEmpleados.indexOf(empleado);
    }

    private void listarEmpleado() {
        System.out.println("#####Listado de empleados######");
        for (Empleado empleado: listaEmpleados) {
            imprimirEmpleado(empleado);
        }
    }
    private void eliminarEmpleado(){
        System.out.println("Ingrese el documento del empleado");
        String documento = sc.next();
        for (Empleado deleteEmpleado: listaEmpleados) {
            if (deleteEmpleado.getDocumento().equals(documento)) {
                empleado = deleteEmpleado;
                listaEmpleados.remove(empleado);
                System.out.println("Empleado eliminado");
                break;
            }

        }
        System.out.println("Empleado no encontrado");
        return listaEmpleados.indexOf(empleado);
    }

    private double calcularSueldo(int horas, double valorHora) {
        return horas * valorHora;
    }

    private void imprimirEmpleado(Empleado empleado) {
        System.out.println(empleado.getDocumento() + " | "
                + empleado.getNombreEmpleado() + " | " + empleado.getSueldo());
    }

}










