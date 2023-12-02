package testes;

import java.util.List;
import java.util.Scanner;

import dao.Creatinina;
import dao.senha;
import dao.usuario;
import modelo.Creatininaa;
import modelo.Senha;
import modelo.Usuario;
import seguranca.Criptografia;


public class TesteSelectEDecriptografa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			

			int id = 1;
			String senhaUsuario = "2015";
			
			usuario daoUsuario = new usuario();
			Usuario usuario = daoUsuario.getusuariobyId(id);
			System.out.println("Hash da senha do Usuario (banco de dados): " + usuario.getSenha());
			
			Creatinina daoExame = new Creatinina();
			senha daoSenha = new senha();
			
			Senha senha = daoSenha.getSenhabyId(id);
			System.out.println("Chave criptografada da tabela senha (banco de dados): " + senha.getChaveSecreta());
			String senhaCriptografia = Criptografia.decriptografa(
					senha.getChaveSecreta(), 
					Criptografia.criarChaveSecreta(senhaUsuario));
			System.out.println("Chave decriptografada: " + senhaCriptografia);
			List<Creatininaa> exames = daoExame.getLista();
			
			for (Creatininaa exame : exames) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("Resultado do exame de acido urico do paciente: " + exame.getPaciente() + " solicitado "
						+ "pelo médico: " + exame.getMedico());
				System.out.println("Resultado do exame criptografado (banco de dados): " + exame.getResultado());
				String nomeDoExame = Criptografia.decriptografa(
						exame.getResultado(), 
						Criptografia.criarChaveSecreta(senhaCriptografia));
				System.out.println("Resultado do exame decriptografado: " + nomeDoExame);
			}
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
