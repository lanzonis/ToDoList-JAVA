package dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Conexao_teste {
		private String url,usuario,senha;
		private Connection con	;
		
		Conexao_teste(){
			url = "jdbc:postgresql://localhost:5432/Teste_lista";
			usuario = "postgres";
			senha = "dbadmin";
			
			try {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(url,usuario,senha );
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
		}
		public boolean inserir_a1 (String TESTE_a1) {
			String sql = "INSERT INTO tb_teste_A1 (ds_lista) VALUES(?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, TESTE_a1);
				int resposta = ps.executeUpdate();
				ps.close();
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
		public boolean inserir_m1 (String TESTE_m1) {
			String sql = "INSERT INTO tb_teste_m1 (ds_lista) VALUES(?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, TESTE_m1);
				int resposta = ps.executeUpdate();
				ps.close();
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
		public boolean inserir_b1 (String TESTE_b1) {
			String sql = "INSERT INTO tb_teste_b1 (ds_lista) VALUES(?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, TESTE_b1);
				int resposta = ps.executeUpdate();
				ps.close();
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
}
