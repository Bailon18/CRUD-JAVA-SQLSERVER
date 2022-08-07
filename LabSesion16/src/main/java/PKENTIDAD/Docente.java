
package PKENTIDAD;

/**
 *
 * @author Bailon
 */
public class Docente {
    
    private int codigo;
    private String nombres;
    private String apellidos;
    private int idEspecialidad;
    private int idPais;
    private int estado;
    private String rutafile;

    public Docente() {
    }

    public Docente(int codigo, String nombres, String apellidos,
            int idEspecialidad, int idPais, int estado, String rutafile) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idEspecialidad = idEspecialidad;
        this.idPais = idPais;
        this.estado = estado;
        this.rutafile = rutafile;
    }
    
    public Docente(String nombres, String apellidos,
            int idEspecialidad, int idPais, int estado, String rutafile) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idEspecialidad = idEspecialidad;
        this.idPais = idPais;
        this.estado = estado;
        this.rutafile = rutafile;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRutafile() {
        return rutafile;
    }

    public void setRutafile(String rutafile) {
        this.rutafile = rutafile;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Docente{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", idEspecialidad=").append(idEspecialidad);
        sb.append(", idPais=").append(idPais);
        sb.append(", estado=").append(estado);
        sb.append(", rutafile=").append(rutafile);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
