package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controlador.Constants;
import controlador.GestorDB;

public class DestinacionsDAO {
	GestorDB g;
	String consultaSQL;
	public DestinacionsDAO(){
		g=new GestorDB(Constants.SERVER,Constants.PORT,Constants.BD);
		taulaDestinacions();
	}
	
	public void taulaDestinacions(){
		consultaSQL=
				"CREATE TABLE IF NOT EXISTS destinacions("+
				"ID VARCHAR(255),"+
				"Continent VARCHAR(255),"+
				"Pais VARCHAR(255),"+
				"Capital VARCHAR(255),"+
				"Ciutat VARCHAR(255),"+
				"Poblacio VARCHAR(255) NOT NULL,"+
				"CP VARCHAR(255),"+
				"Platja VARCHAR(255),"
				+ "PRIMARY KEY(ID),"
				+"UNIQUE(Poblacio));";
		g.modificarRegistre(consultaSQL);
		
	}
	
	public boolean esBuit(){
		consultaSQL="SELECT * FROM destinacions";
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
	
	public String consultarPoblacio(String id){
		consultaSQL="SELECT poblacio FROM destinacions WHERE ID='"+id+"';";
		String dades = "";
		ResultSet rs=g.consultaRegistres(consultaSQL);
		try {
			dades=rs.getString("Poblacio");
		} catch (SQLException e) {
			System.out.println("Error consulta poblacio");
		}
		return dades;
	}

	public Object[] consultarPoblacions(){
		consultaSQL="SELECT poblacio FROM destinacions;";
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
	
	public String consultarID(String poblacio){
		consultaSQL="SELECT ID FROM destinacions WHERE poblacio='"+poblacio+"';";
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
	
	public Object[] consultarRegistresID(String id){
		consultaSQL="SELECT * FROM destinacions WHERE id='"+id+"';";
		ResultSet rs=null;
		rs=g.consultaRegistres(consultaSQL);
		ArrayList<Object> dades=new ArrayList<Object>();
		try {
			while(rs.next()){
				dades.add(rs.getString("ID"));
				dades.add(rs.getString("Continent"));
				dades.add(rs.getString("Pais"));
				dades.add(rs.getString("Capital"));
				dades.add(rs.getString("Ciutat"));
				dades.add(rs.getString("Poblacio"));
				dades.add(rs.getString("CP"));
				dades.add(rs.getString("Platja"));
			}
		} catch (SQLException e) {
			System.out.println("Error consulta registres ID");
		}
		Object[] d= dades.toArray();
		return d;
	}
	
	public void modificarDestinacio(Destinacions d,String camp){
		String id=d.getId();
		String continent=d.getContinent();
		String pais=d.getPais();
		String capital=d.getCapital();
		String ciutat=d.getCiutat();
		String poblacio=d.getPoblacio();
		String cp=d.getCP();
		String platja=d.getPlatja();
		consultaSQL="UPDATE destinacions "
				+ "SET Continent='"+continent+
				"',Pais='"+pais+
				"',Capital='"+capital+
				"',Ciutat='"+ciutat+
				"',Poblacio='"+poblacio+
				"',CP='"+cp+
				"',Platja='"+platja+"' WHERE ID='"+camp+"';";
		g.modificarRegistre(consultaSQL);
	}
	public void baixaDestinacio(String id){
		consultaSQL="DELETE FROM destinacions WHERE ID='"+id+"';";
		g.modificarRegistre(consultaSQL);

	}
	public boolean comprobarDestinacions(){
		consultaSQL="SELECT * FROM destinacions";
		boolean correcte=false;
		try {
			ResultSet rs=g.consultaRegistres(consultaSQL);
			if(!rs.first()){
				correcte=true;
			}else{
				correcte=false;
			}
		} catch (SQLException e) {
			System.out.println("Error comprobar "+e.toString());
		}
		System.out.println("Comprobacio realitzada");
		return correcte;
	}
	
	public void afegirDadesTaula(DefaultTableModel model){
		consultaSQL="SELECT * FROM destinacions";
		model.getDataVector().removeAllElements();
		try {
			ResultSet rs=g.consultaRegistres(consultaSQL);
			while(rs.next()){
				String id=rs.getString("ID");
				String continent=rs.getString("Continent");
				String pais=rs.getString("Pais");
				String capital=rs.getString("Capital");
				String ciutat=rs.getString("Ciutat");
				String poblacio=rs.getString("Poblacio");
				String cp=rs.getString("CP");
				String platja=rs.getString("Platja");
				Object dades[]={id,continent,pais,capital,ciutat,poblacio,cp,platja};
				model.addRow(dades);
			}
		} catch (SQLException e) {
			System.out.println("Error consulta "+e.toString());
		}
	}
	
	public void altaDestinacio(Destinacions d){
		String[] dades=new String[8];
		dades[0]=d.getId();
		dades[1]=d.getContinent();
		dades[2]=d.getPais();
		dades[3]=d.getCapital();
		dades[4]=d.getCiutat();
		dades[5]=d.getPoblacio();
		dades[6]=d.getCP();
		dades[7]=d.getPlatja();
		consultaSQL="INSERT INTO destinacions VALUES("+"'"+dades[0]+"',"+"'"+dades[1]+"',"+"'"+dades[2]+"',"+"'"+dades[3]+"',"+"'"+dades[4]+"',"+"'"+dades[5]+"',"+"'"+dades[6]+"',"+"'"+dades[7]+"'"+");";
		g.modificarRegistre(consultaSQL);
		System.out.println("Alta correcte");
	}
	
	public boolean comprobarPoblacions(String poblacio){
		consultaSQL="SELECT Poblacio FROM destinacions WHERE Poblacio='"+poblacio+"';";
		ResultSet rs=null;
		boolean existeix=false;
		rs=g.consultaRegistres(consultaSQL);
		try{
			if(rs.first()){
				existeix=true;
			}
		}catch(SQLException e){
			System.out.println("Error comprobar Poblacions");
		}
		return existeix;
	}
	
	public boolean comprobarID(String id){
		consultaSQL="SELECT id FROM destinacions WHERE id='"+id+"';";
		boolean existeix=false;
		ResultSet rs=g.consultaRegistres(consultaSQL);
		try{
			if(rs.first()){
				existeix=true;
			}
		}catch(SQLException e){
			System.out.println("Error comprobar ID desti");
		}
		return existeix;
	}
	
	public void tancarConnexio(){
		g.tancarConnexio();
	}
}
