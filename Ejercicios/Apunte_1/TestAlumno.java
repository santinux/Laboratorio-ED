import misClases.Alumno;
import java.util.Scanner;
public class TestAlumno
{
        static Scanner sc = new Scanner(System.in);
        public static short menu()
        {
                System.out.println("- MENÚ -");
                System.out.println("------------------------------------------");
                System.out.println("1) Registrar alumno.");
                System.out.println("2) Ver el listado de alumnos.");
                System.out.println("3) Modificar nombre.");
                System.out.println("0) Salir.");
                return (opcion);
        }
        public static Alumno registrarAlumno()
        {
                int legajo;
                int nroDocumento;
                int nroTelefono;
                String tipoDocumento;
                String nombre;
                String apellido;
                String domicilio; // (calle, número, ciudad)
                String usuarioSIU;
                String claveSIU;
                do {
                        System.out.println("- Ingrese datos del alumno -");
                        System.out.println("- Los 3 primeros campos son OBLIGATORIOS -");
                        System.out.println("------------------------------------------");
                        System.out.println("Legajo: ");
                        legajo = "" + sc.next();
                        System.out.println("Tipo de documento: ");
                        tipoDocumento = "" + sc.next();
                        System.out.println("Número de documento: ");
                        nroDocumento = "" + sc.next();
                        System.out.println("Nombre: ");
                        nombre = "" + sc.next();
                        System.out.println("Apellido: ");
                        apellido = "" + sc.next();
                        System.out.println("Domicililo (calle, número, ciudad): ");
                        domicilio = "" + sc.next();
                        System.out.println("Teléfono: ");
                        nroTelefono = "" + sc.next();
                        System.out.println("Usuario SIU: ");
                        usuarioSIU = "" + sc.next();
                        System.out.println("Clave SIU: ");
                        claveSIU = "" + sc.next();
                } while (legajo != null && tipoDocumento != null
                                && nroDocumento != null);
                Alumno alumnito = new Alumno(legajo, tipoDocumento, nroDocumento,
                                nroTelefono, nombre, apellido, domicilio,
                                usuarioSIU, claveSIU);
                return (alumnito);
        }
        public static void main(String[] args)
        {
                boolean salir = false;
                do {
                        short opcion = menu();
                        switch (opcion) {
                        case 0:
                                break;
                        case 1:
                                registrarAlumno();
                                break;
                        case 2:
                                verListadoAlumnos();
                                break;
                        case 3:
                                modificarNombre();
                                break;
                        case 4:
                                validarContrasegna();
                                break;
                        default:
                                System.out.println("Opción inválida, "
                                                + "elija una opción del menú.");
                                break;
                        }
                } while (!salir);
                System.out.println("¡Fin del programa!");
        }
}
