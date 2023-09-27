public class Terremoto {

    int identificacion;
    String nombre_terremoto;
    String fecha_ocurrencia;
    float magnitud_terremoto;
    String departamento_ocurrencia;
    int numero_muertos;

    public Terremoto(int identificacion,String nombre_terremoto, String fecha_ocurrencia, float magnitud_terremoto, String departamento_ocurrencia, int numero_muertos) {
        this.identificacion = identificacion;
        this.nombre_terremoto = nombre_terremoto;
        this.fecha_ocurrencia = fecha_ocurrencia;
        this.magnitud_terremoto = magnitud_terremoto;
        this.departamento_ocurrencia = departamento_ocurrencia;
        this.numero_muertos = numero_muertos;
    }

    public Terremoto() {
        this.identificacion = 0;
        this.nombre_terremoto = "";
        this.fecha_ocurrencia = "";
        this.magnitud_terremoto = 0;
        this.departamento_ocurrencia = "";
        this.numero_muertos = 0;
    }

    public String getNombre_terremoto() {
        return nombre_terremoto;
    }

    public void setNombre_terremoto(String nombre_terremoto) {
        this.nombre_terremoto = nombre_terremoto;
    }

    public String getFecha_ocurrencia() {
        return fecha_ocurrencia;
    }

    public void setFecha_ocurrencia(String fecha_ocurrencia) {
        this.fecha_ocurrencia = fecha_ocurrencia;
    }

    public float getMagnitud_terremoto() {
        return magnitud_terremoto;
    }

    public void setMagnitud_terremoto(float magnitud_terremoto) {
        this.magnitud_terremoto = magnitud_terremoto;
    }

    public String getDepartamento_ocurrencia() {
        return departamento_ocurrencia;
    }

    public void setDepartamento_ocurrencia(String departamento_ocurrencia) {
        this.departamento_ocurrencia = departamento_ocurrencia;
    }

    public int getNumero_muertos() {
        return numero_muertos;
    }

    public void setNumero_muertos(int numero_muertos) {
        this.numero_muertos = numero_muertos;
    }


    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Terremoto{" +
                "nombre_terremoto='" + nombre_terremoto + '\'' +
                ", fecha_ocurrencia='" + fecha_ocurrencia + '\'' +
                ", magnitud_terremoto=" + magnitud_terremoto +
                ", departamento_ocurrencia='" + departamento_ocurrencia + '\'' +
                ", numero_muertos=" + numero_muertos +
                '}';
    }
}
