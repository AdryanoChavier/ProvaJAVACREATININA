package testes;

import java.util.Scanner;

import dao.Creatinina;
import dao.senha;
import dao.usuario;
import dao.valorespadrao;
public class TestePopula {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			
			String login = "Adryano";
			System.out.print("login: " + login);
			String senhaUsuario = "2015";
			System.out.print("\nsenha: " + senhaUsuario );
			usuario dao = new usuario();
			dao.adiciona(login, senhaUsuario);
			System.out.println("\nGravação do usuario e senha feita no banco de dados!");
			
			
			String senhaCriptografia = "fghjy567klo";
			System.out.print("Senha para criptografar a tabela Exame: " + senhaCriptografia);
			senha daoSenha = new senha();
			daoSenha.adiciona(senhaCriptografia, senhaUsuario);
			System.out.println("\nGravação da senha para criptografar feita no banco de dados!");
			Creatinina daoExame = new Creatinina();
			daoExame.adiciona("0,7 mg/dL", 1, 1, senhaCriptografia);
			System.out.println("\nGravação do exame de acido urico feita no banco de dados!");
			daoExame.adiciona("0,7 mg/dL", 2, 1, senhaCriptografia);
			System.out.println("\nGravação do exame de acido urico feita no banco de dados!");
			daoExame.adiciona("1,3 mg/dL", 3, 2, senhaCriptografia);
			System.out.println("\nGravação do exame de acido urico feita no banco de dados!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
