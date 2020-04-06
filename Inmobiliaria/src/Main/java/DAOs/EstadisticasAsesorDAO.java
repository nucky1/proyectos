/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Asesor;
import Modelo.EstadisticasAsesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fran_
 */
public class EstadisticasAsesorDAO implements EstadisticasAseDAO{
    
    public String fechaSQL(Date fecha){
        DateFormat fmtSQL = new SimpleDateFormat("yyyy-MM-dd");  
        return fmtSQL.format(fecha);
    }
    
    @Override
    public ArrayList<EstadisticasAsesor> getEstadisticas(int mesDesde, int mesHasta, int anioDesde, int anioHasta) {
        Date desde = new Date(anioDesde-1900,mesDesde,1);
        Date hasta = new Date(anioHasta-1900,mesHasta,1);
        String fechaDesde = fechaSQL(desde);
        
        String fechaHasta = fechaSQL(hasta);
        String SQL = "SELECT aux.ase_nombre,sum(aux.opAlqui),sum(aux.opVenta),sum(aux.ganaCaptar),sum(aux.ganaOperacion),sum(aux.ganaOficina) FROM "
                + "(SELECT CASE"
                + "	WHEN (infoC_tipo=1 AND infoC_asesorID=ase_id) THEN 1 "
                + "         ELSE 0 "
                + "	END AS opAlqui, "
                + " CASE "
                + "	WHEN (infoC_tipo=2 AND infoC_asesorID=ase_id) THEN 1 "
                + "		ELSE 0"
                + "	END AS opVenta, "
                + " CASE "
                + "	WHEN(cte_id=infoC_clienteID AND cte_asesorID=ase_id) THEN (infoC_alq_aumento/4) "
                + "		ELSE 0"
                + "	END AS ganaCaptar,"
                + " CASE "
                + "	WHEN(infoC_asesorID=ase_id) THEN (infoC_alq_aumento/4) "
                + "		ELSE 0"
                + "	END AS ganaOperacion,"
                + " CASE "
                + "	WHEN(1=ase_id) THEN (infoC_alq_aumento/2) "
                + "		ELSE 0"
                + "	END AS ganaOficina,ase_nombre,cte_id,ase_id"
                + " FROM infocontrato,asesor,cliente WHERE cte_id=infoC_clienteID AND infoC_fecha BETWEEN '"+fechaDesde+"' AND '"+fechaHasta+"'"
                + ")AS aux GROUP BY aux.ase_id";
        System.out.println("SQL = " + SQL);
        String sql2 = "SELECT COUNT(cte_id) AS capto,ase_id from cliente,asesor WHERE cte_asesorID = ase_id AND cte_fechaAlta BETWEEN '"+fechaDesde+"' AND '"+fechaHasta+"' GROUP BY ase_id";
        System.out.println("SQL = " + sql2);
        ArrayList<EstadisticasAsesor> ea = new ArrayList();
        try {
            ResultSet rs = Main.Conexion.getInstance().EjecutarConsultaSQL(SQL);
            ResultSet rs2 = Main.Conexion.getInstance().EjecutarConsultaSQL(sql2);
            while (rs.next()) {
                EstadisticasAsesor contAux = new EstadisticasAsesor(rs.getString("ase_nombre"), rs.getFloat("sum(aux.ganaCaptar)") + rs.getFloat("sum(aux.ganaOperacion)")+rs.getFloat("sum(aux.ganaOficina)"), rs.getInt("sum(aux.opVenta)"), rs.getInt("sum(aux.opAlqui)"),0);
                ea.add(contAux);
            }
            int i=0;
            while(rs2.next()){
                ea.get(i).setCantCapto(rs2.getInt("capto"));
                i++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ea;
    }
    
}
