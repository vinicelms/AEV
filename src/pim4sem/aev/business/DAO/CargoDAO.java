package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoDAO {
	public int retornaCargo(String recebeCargo) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
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
		Connection conn = new ConnectionFactory().getConnection();
		
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
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaCargo = 0;
		
		String sql = "SELECT id_cargo FROM Cargo WHERE nome_cargo = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try{
			stmt.setString(1, recebeCargo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaCargo = rs.getInt("id_cargo");
			}
			rs.close();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
		if(retornaCargo > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void alteraCargo(String recebeCargo, int recebeIdCargo) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		if(recebeCargo == null){
			throw new IllegalArgumentException("O Cargo não pode ser vazio!");
		}
		
		String sql = "UPDATE Cargo SET nome_cargo = ? WHERE id_cargo = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeCargo);
			stmt.setInt(2, recebeIdCargo);
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
}
