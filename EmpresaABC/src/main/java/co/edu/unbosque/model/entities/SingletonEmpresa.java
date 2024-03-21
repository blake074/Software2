package co.edu.unbosque.model.entities;

import jakarta.persistence.Entity;

public class SingletonEmpresa {
    private static SingletonEmpresa instace;

    private int idEmpresa;
    private int idEmpleado;
    private Empresa empresa;
    private SingletonEmpresa(){
        empresa = new Empresa();
        this.idEmpresa = empresa.getId_empresa();
        this.idEmpleado = empresa.getEmpleado().getId_empleado();
    }
    public static SingletonEmpresa getInstance(){
        if(instace == null){
            instace = new SingletonEmpresa();
        }
        return  instace;
    }
}
