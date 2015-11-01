package pim4sem.aev.business.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class CargoDAO {

	private static Connection conn;
	
	public CargoDAO(){
		Connection conn = new ConnectionFactory().getConnection();
	}
	
	static int retornaIdCargo(String recebeCargo) throws SQLException{
		int idCargo = 0;
		
		String sql = "SELECT id_cargo FROM Cargo WHERE nome_cargo = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try{			
			stmt.setString(1, recebeCargo);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				idCargo = rs.getInt("id_cargo");
			}
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
		return idCargo;
	}
	
	public void registraCargo(String recebeCargo) throws SQLException{
		String sql = "INSERT INTO cargo (nome_cargo) VALUES (?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try{
			stmt.setString(1, recebeCargo);
			
			stmt.execute();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public boolean verificaCargo(String recebeCargo) throws SQLException{
		int id_cargo = 0;
		
		String sql = "SELECT id_cargo FROM Cargo WHERE nome_cargo = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try{
			stmt.setString(1, recebeCargo);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				id_cargo = rs.getInt("id_cargo");
			}
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
		if(id_cargo > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
