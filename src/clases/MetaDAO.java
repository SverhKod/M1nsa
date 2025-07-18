package clases;

import java.util.ArrayList;
import java.sql.*;
import clases.Conexion;

public class MetaDAO{
    public static ArrayList<MetaObstetra> obtenerAvances() {
    ArrayList<MetaObstetra> lista = new ArrayList<>();
    try {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(
            "SELECT mo.id, mo.id_meta, mo.id_obstetra, mo.cantidad_avance, m.objetivo, o.nombre_obstetra, m.nombre " +
            "FROM meta_obstetra mo " +
            "JOIN metas m ON mo.id_meta = m.id " +
            "JOIN obstetras o ON mo.id_obstetra = o.id"
        );

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            lista.add(new MetaObstetra(
                rs.getInt("id"),
                rs.getInt("id_meta"),
                rs.getInt("id_obstetra"),
                rs.getInt("cantidad_avance"),
                rs.getInt("objetivo"),
                rs.getString("nombre_obstetra"),
                rs.getString("nombre")
            ));
        }

        cn.close();

    } catch (Exception e) {
        System.err.println("Error al obtener avances: " + e);
    }
    return lista;
}
}