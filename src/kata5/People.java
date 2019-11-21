package kata5;

class People {
    String nombre;
    String apellido;
    String departamento;
    
    People(String n, String a, String d) {
        nombre = n;
        apellido = a;
        departamento = d;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    
    
}
