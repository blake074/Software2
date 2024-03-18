package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Date;

public interface ICrearEmpleado {



    void crearEmpleado(int id,

                       String nombreCompleto,

                       String direccion,

                       int salario,

                       Date fechaIngreso,


                       int telefono,

                       int num_doc_empl,

                       IDTipoDocumento idTipoDocumento,

                       Rol rol);
    void eliminarEmpleado(int id,

                          String nombreCompleto,

                          String direccion,

                          int salario,

                          Date fechaIngreso,


                          int telefono,

                          int num_doc_empl,

                          IDTipoDocumento idTipoDocumento,

                          Rol rol);
    void leerEmpleado(int id,

                      String nombreCompleto,

                      String direccion,

                      int salario,

                      Date fechaIngreso,


                      int telefono,

                      int num_doc_empl,

                      IDTipoDocumento idTipoDocumento,

                      Rol rol);
    void actualizarEmpleado(int id,

                            String nombreCompleto,

                            String direccion,

                            int salario,

                            Date fechaIngreso,


                            int telefono,

                            int num_doc_empl,

                            IDTipoDocumento idTipoDocumento,

                            Rol rol);
}
