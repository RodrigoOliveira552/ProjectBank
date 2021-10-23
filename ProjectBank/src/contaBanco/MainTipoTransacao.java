package contaBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class MainTipoTransacao {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectBank", "rodrigo", "ASDqwe123");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver do BancodeDados não localizado");
		}catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco" + e.getMessage());
		
		}
		
		Scanner sc = new Scanner(System.in);

		Conta conta = new Conta();

		Transacao tr = new Transacao(conta);

		Cliente cliente = new Cliente();

		int oper;

		do {
			System.out.println("0.Informações");
			System.out.println("1.Sacar");
			System.out.println("2.Depositar");
			System.out.println("3.Saldo");
			System.out.println("4. Sair");
			oper = sc.nextInt();

			if (oper == 0) {
				System.out.print("Digite seu NOME:");
				cliente.setNome(new Scanner(System.in).nextLine());

				System.out.print("Digite seu CPF: ");
				cliente.setCpf(sc.next());
				System.out.println("Olá! Escolha o que deseja fazer nas opções a seguir:");

			} else if (oper == 1) {
				System.out.println("Qual valor gostaria de sacar?");
				tr.sacar(sc.nextDouble());

			} else if (oper == 2) {
				System.out.println("Qual valor gostaria de Depositar?");
				tr.depositar(sc.nextDouble());
				System.out.println(conta.getSaldo());

			} else if (oper == 3) {
				System.out.println("O saldo total da sua conta é: " + conta.getSaldo() + "R$");

			} else if (oper == 4) {
				System.out.println("Você saiu!");

			}

		} while (oper != 4);

	}

}
