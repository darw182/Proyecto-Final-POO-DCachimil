package Modelo;

public class CajeroDTO {
    private String nombre;
    private String apellido;
    private String cajeroId;
    private String usuario;
    private String password;

    public CajeroDTO() {
    }

    public CajeroDTO(String nombre,String apellido,String cajeroId, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cajeroId = cajeroId;
        this.usuario = usuario;
        this.password = password;
    }

    public String getCajeroId() {
        return cajeroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCajeroId(String cajeroId) {
        this.cajeroId = cajeroId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
