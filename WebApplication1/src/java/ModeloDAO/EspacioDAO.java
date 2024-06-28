/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

/**
 *
 * @author LENOVO
 */
import Config.clsConecion;
import Interfaces.InterfaceEspacio;
import Modelo.clsEEspacio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EspacioDAO implements InterfaceEspacio{
    clsConecion cn = new clsConecion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<clsEEspacio> listar() {
        ArrayList<clsEEspacio> list = new ArrayList<>();
        String sql = "SELECT posicion, estado  FROM espacios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clsEEspacio espacio = new clsEEspacio();
                espacio.setPosicion(rs.getInt("posicion"));
                espacio.setEstado(rs.getString("estado"));
                list.add(espacio);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return list;
    }
    
   
}
