/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.clsECargo;
import java.util.List;

public interface InterfaceCargo {
    public List<clsECargo> listar();
    public boolean agregar(clsECargo cargo);
    public boolean editar(clsECargo cargo);
    public boolean eliminar(int id_cargo);
    public clsECargo obtenerPorId(int id_cargo);
}
