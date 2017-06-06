package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controlador.Constants;
import controlador.GestorDB;

public class PuntsDAO {
	GestorDB g;
	DestinacionsDAO d=new DestinacionsDAO();
	String consultaSQL;
	public PuntsDAO(){
		g=new GestorDB(Constants.SERVER,Constants.PORT,Constants.BD);
		taulaPunts();
	}
	
	public void taulaPunts(){
		consultaSQL=
				"CREATE TABLE IF NOT EXISTS punts("+
				"ID VARCHAR(255),"+
				"Nom VARCHAR(255),"+
				"Descripcio VARCHAR(255),"+
				"Tipus VARCHAR(255),"+
				"Activitats VARCHAR(255),"+
				"Poblacio VARCHAR(255),"+
				"PRIMARY KEY(ID),"+
				"FOREIGN KEY (ID) REFERENCES destinacions(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		g.modificarRegistre(consultaSQL);
	}

	public void afegirPunts(PuntsInteres p,String pob) {
		String nom=p.getNom();
		String desc=p.getDescripcio();
		String tipus=p.getTipus();
		String acti=p.getActivitats();
		consultaSQL="INSERT INTO punts VALUES('"+d.consultarID(pob)+"','"+nom+"','"+desc+"','"+tipus+"','"+acti+"','"+pob+"');";
		g.modificarRegistre(consultaSQL);
	}

	public void afegirDadesTaula(DefaultTableModel model) {
		consultaSQL="SELECT * FROM punts";
		model.getDataVector().removeAllElements();
		try {
			ResultSet rs=g.consultaRegistres(consultaSQL);
			while(rs.next()){
				String id=rs.getString("ID");
				String nom=rs.getString("Nom");
				String desc=rs.getString("Descripcio");
				String tipus=rs.getString("Tipus");
				String acti=rs.getString("Activitats");
				String poblacio=rs.getString("Poblacio");
				Object dades[]={id,nom,desc,tipus,acti,poblacio};
				model.addRow(dades);
			}
		} catch (SQLException e) {
			System.out.println("Error consulta "+e.toString());
		}		
	}

	public void baixaDestinacio(String id) {
		consultaSQL="DELETE FROM punts WHERE ID='"+id+"';";
		g.modificarRegistre(consultaSQL);
		
	}

	public void baixaPunts(String id) {
		consultaSQL="DELETE FROM punts WHERE ID='"+id+"';";
		g.modificarRegistre(consultaSQL);
		
	}

	public Object[] consultarPoblacions() {
		consultaSQL="SELECT poblacio FROM punts;";
		ResultSet rs=null;
		ArrayList<String> a=new ArrayList<String>();
		try {
			rs=g.consultaRegistres(consultaSQL);
			while(rs.next()){
				a.add(rs.getString("poblacio"));
			}
		} catch (SQLException e) {
			System.out.println("Error consulta registres "+e.toString());
		}
		Object[] poblacions=a.toArray();
		return poblacions;
	}
	
	public Object[] consultarRegistresID(String id){
		consultaSQL="SELECT * FROM punts WHERE id='"+id+"';";
		ResultSet rs=null;
		rs=g.consultaRegistres(consultaSQL);
		ArrayList<Object> dades=new ArrayList<Object>();
		try {
			while(rs.next()){
				dades.add(rs.getString("ID"));
				dades.add(rs.getString("Nom"));
				dades.add(rs.getString("Descripcio"));
				dades.add(rs.getString("Tipus"));
				dades.add(rs.getString("Activitats"));
				dades.add(rs.getString("Poblacio"));
			}
		} catch (SQLException e) {
			System.out.println("Error consulta registres ID");
		}
		Object[] d= dades.toArray();
		return d;
	}
	
	public String consultarID(String poblacio){
		consultaSQL="SELECT ID FROM punts WHERE poblacio='"+poblacio+"';";
		ResultSet rs=g.consultaRegistres(consultaSQL);
		String id="";
		try {
			while(rs.next()){
			id = rs.getString("ID");
			}
		} catch (SQLException e) {
			System.out.println("Error id");
		}
		return id;
	}
	
	public void modificarPunts(PuntsInteres p,String camp){
		String nom=p.getNom();
		String desc=p.getDescripcio();
		String tipus=p.getTipus();
		String acti=p.getActivitats();
		consultaSQL="UPDATE punts "
				+ "SET Nom='"+nom+"'"+
				",Descripcio='"+desc+"'"+
				",Tipus='"+tipus+"'"+
				",Activitats='"+acti+"'"+
				" WHERE ID='"+camp+"';";
		g.modificarRegistre(consultaSQL);
	}
	public boolean esBuit(){
		consultaSQL="SELECT * FROM punts";
		boolean correcte=false;
		ResultSet rs;
		try {
			rs=g.consultaRegistres(consultaSQL);
			if(!rs.isBeforeFirst()){
				correcte=true;
			}else{
				correcte=false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return correcte;
	}
}
