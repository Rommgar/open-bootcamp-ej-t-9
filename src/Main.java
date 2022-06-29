/*
Crea una clase Persona con las siguientes variables:
    La edad
    El nombre
    El teléfono

Una vez creada la clase, crea una nueva clase Cliente que herede de Persona, esta nueva clase tendrá la variable
credito solo para esa clase.

Crea ahora un objeto de la clase Cliente que debe tener como propiedades la edad, el telefono,
el nombre y el credito, tienes que darles valor y mostrarlas por pantalla.

Una vez hecho esto, haz lo mismo con la clase Trabajador que herede de Persona,
y con una variable salario que solo tenga la clase Trabajador.

*/

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.setNombre("Antonio");
        client.setEdad(28);
        client.setTelefono("666 66 66 66");
        client.setCredito(100.50);
        System.out.println("Client" +
                "\n\tNombre: " + client.getNombre() +
                "\n\tEdad: " + client.getEdad() +
                "\n\tTelefono: " + client.getTelefono() +
                "\n\tCredito: " + client.getCredito());

        Trabajador trabajador = new Trabajador();
        trabajador.setNombre("Juan");
        trabajador.setEdad(45);
        trabajador.setTelefono("677777777");
        trabajador.setSalario(1000.67);
        System.out.println("Trabajador" +
                "\n\tNombre: " + trabajador.getNombre() +
                "\n\tEdad: " + trabajador.getEdad() +
                "\n\tTelefono: " + trabajador.getTelefono() +
                "\n\tSalario: " + trabajador.getSalario());
    }

    public static class Client extends Persona {
        private double credito;

        public void setCredito(double credito) {
            this.credito = credito;
        }

        public double getCredito() {
            return this.credito;
        }
    }

    public static class Trabajador extends Persona {
        private double salario;

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public double getSalario() {
            return this.salario;
        }
    }

    public static class Persona {
        private String nombre;
        private int edad;
        private String telefono;

        public Persona() {}
        public Persona(String nombre, int edad, String telefono) {
            this.nombre = nombre;
            this.setEdad(edad);
            this.setTelefono(telefono);
        }

        public String getTelefono() {
            return this.telefono;
        }

        public void setTelefono(String telefono) {
            Pattern telRegex = Pattern.compile("\\d{9}" +
                    "|^(\\d{2})[\\s-/](\\d{3})([\\s-/]\\d{2}){2}" +
                    "|^(\\d{3})([\\s-/]\\d{2}){3}");
            if (!telRegex.matcher(telefono).matches()) {
                throw new IllegalArgumentException("Telefono no es valido");
            }
            this.telefono = telefono;
        }

        public int getEdad() {
            return this.edad;
        }

        public void setEdad(int edad){
            if (edad < 0) {
                throw new IllegalArgumentException("Edad no es valido");
            }
            this.edad = edad;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", telefono='" + telefono + '\'' +
                    '}';
        }
    }
}