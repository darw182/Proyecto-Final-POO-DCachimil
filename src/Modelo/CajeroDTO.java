package Modelo;

public class CajeroDTO {
    private String cajeroId;
    private String nombre;
    private String password;

    public CajeroDTO() {
    }

    public CajeroDTO(String cajeroId, String nombre, String password) {
        this.cajeroId = cajeroId;
        this.nombre = nombre;
        this.password = password;
    }

    public String getCajeroId() {
        return cajeroId;
    }

    public void setCajeroId(String cajeroId) {
        this.cajeroId = cajeroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
