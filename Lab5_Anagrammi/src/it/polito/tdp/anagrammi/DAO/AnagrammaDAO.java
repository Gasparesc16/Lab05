package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AnagrammaDAO {
	
	
	
	public boolean isCorrect(String anagramma){
		
		
		String sql = "SELECT nome FROM parola WHERE nome=? ";

	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, anagramma);
		
		
		int res = st.executeUpdate(sql);

		if (res == 1)
			return true;
		else
			return false;

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}
}

}
