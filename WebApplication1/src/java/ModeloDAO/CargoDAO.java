/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.clsConecion;
import Interfaces.InterfaceCargo;
import Modelo.clsECargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO implements InterfaceCargo {
    clsConecion cn = new clsConecion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<clsECargo> listar() {
        ArrayList<clsECargo> list = new ArrayList<>();
        String sql = "SELECT * FROM tbcargo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clsECargo cargo = new clsECargo();
                cargo.setId_cargo(rs.getInt("id_cargo"));
                cargo.setDescripcion(rs.getString("descripcion"));
                list.add(cargo);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return list;
    }

    @Override
    public boolean agregar(clsECargo cargo) {
        String sql = "INSERT INTO tbcargo (descripcion) VALUES (?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getDescripcion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar cargo: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean editar(clsECargo cargo) {
        String sql = "UPDATE tbcargo SET descripcion = ? WHERE id_cargo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getDescripcion());
            ps.setInt(2, cargo.getId_cargo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cargo: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(int id_cargo) {
        String sql = "DELETE FROM tbcargo WHERE id_cargo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cargo);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cargo: " + e.getMessage());
        }
        return false;
    }

    @Override
    public clsECargo obtenerPorId(int id_cargo) {
        clsECargo cargo = new clsECargo();
        String sql = "SELECT * FROM tbcargo WHERE id_cargo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cargo);
            rs = ps.executeQuery();
            while (rs.next()) {
                cargo.setId_cargo(rs.getInt("id_cargo"));
                cargo.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cargo: " + e.getMessage());
        }
        return cargo;
    }
}

