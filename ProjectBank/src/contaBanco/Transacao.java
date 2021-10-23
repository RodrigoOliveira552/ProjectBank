package contaBanco;

public class Transacao {
	
	public Transacao(Conta conta) {
		this.conta = conta;

	}

	private Conta conta;

	public void sacar(double valor) {
		if (valor <= conta.getSaldo()) {
			conta.setSaldo(conta.getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("ERRO..Saldo insuficiente para saque");
		}

	}

	public void depositar(double valor) {
		if (valor > 0) {
			conta.setSaldo(conta.getSaldo() + valor);

			System.out.println("Depósito realizado com Sucesso!");
		} else {
			System.out.println("ERRO..Impossivel depositar");
		}

	}
}