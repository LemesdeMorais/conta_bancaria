package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;




public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
					// aqui é a classe, a proxima é o objeto		
	
	public static void main(String[] args) {
		
		
		int op=0;
		
		//criarContasTeste();
		
		while(true) { // verificar onde tenho que fechar essa chave
		//System.out.println("****************************************************************************");
		System.out.println("");
		System.out.println("\t\t\t Gringotes o Banco das Bruxas");
		System.out.println("");
		System.out.println("****************************************************************************");
		System.out.println("");
		System.out.println("\t\t\t 1 - Criar Conta");
		System.out.println("\t\t\t 2 - Listar todas as Contas");
		System.out.println("\t\t\t 3 - Buscar Conta por Numero");
		System.out.println("\t\t\t 4 - Atualizar Dados da Conta");
		System.out.println("\t\t\t 5 - Apagar Conta");
		System.out.println("\t\t\t 6 - Sacar");
		System.out.println("\t\t\t 7 - Depositar");
		System.out.println("\t\t\t 8 - Transferir valores entre Contas");
		System.out.println("\t\t\t 0 - Sair");
		System.out.println("");
		System.out.println("****************************************************************************");
		System.out.println("Entre com a opção desejada:");
		
		try {
		op = leia.nextInt();
		leia.nextLine();

		if (op == 0) {
			System.out.println("\n Gringotes o Banco das Bruxas - O lugar mais seguro!");
			leia.close();
			System.exit(0);
			}else if(op >= 9 ) {
				System.out.println("\n Opção inválida! Tente novamente.");
				}
		}catch (InputMismatchException e) {
			System.out.println("ERRO! Entrada inválida. Tente novamente.");
			leia.next();
		}

		
		
		switch (op) {
			case 1: System.out.println("Criar Conta");
			cadastrarConta();
			keyPress();
			break;
			
			case 2: System.out.println("Listar todas as contas");
			listarContas();
			
			keyPress();
			break;
			
			case 3: System.out.println("Buscar Conta por Numero");
			procurarContaPorNumero();
			keyPress();
			break;
			
			case 4: System.out.println(" Atualizar Dados da Conta");
			atualizarConta();
			keyPress();
			break;
			
			case 5: System.out.println("Apagar Conta");
			deletarConta();
			keyPress();
			break;
			
			case 6: System.out.println("Sacar");
			keyPress();
			break;
			
			case 7: System.out.println("Depositar");
			keyPress();
			break;
			
			case 8: System.out.println("Transferir valores entre Contas");
			keyPress();
			break;
		}
		
		
		sobre();
	
		}
	
}

	public static void sobre(){
		System.out.println("\n****************************************************************************"
				+ 			"\n\tProjeto deselvoldito por:\n"
				+ 			"\tRafaela Lemes - Dev Full Stack\n "
				+ 			"\tgithub.com/lemesdemorais\n"
				+ 			"\n****************************************************************************");		
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressiona Enter para continuar...");
		leia.nextLine();
		}
	
	/*private static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456,1,"Thuany Silva", 1000000.00f,10000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(),456,2,"Marcia Condarco", 1000000.00f, 10));
	}*/
	private static void listarContas() {
		contaController.listarTodas();
		
	}
	
	private static void cadastrarConta() {
		
		System.out.print("Digite o numero da Agência: ");
		int agencia = leia.nextInt();
		
		System.out.print("Digite o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();
		
		System.out.print("Digite o tipo da conta (1 - CC || 2 - CP): ");
		int tipo = leia.nextInt();
		
		System.out.print("Digite o saldo inicial: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1 ->{
			System.out.print("Digite o limite inicial da conta: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia,tipo, titular, saldo, limite));
		}
		case 2 ->{
			System.out.print("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia,tipo, titular, saldo, aniversario));
			
		}
		default-> System.out.println(Cores.TEXT_RED + "Opção Inválida!");
		}
		
		}
	
	private static void procurarContaPorNumero() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		contaController.procurarPorNumero(numero);
	}
	
	private static void deletarConta() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		Conta conta = contaController.buscarNaCollection(numero);
		
		if(conta != null) {
		
			System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();
			
			
			if(confirmacao.equalsIgnoreCase("S")) {
				contaController.deletar(numero);
			}else {
				System.out.println("\nOperação cancelada!");
			}
			
		}else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}
	
	private static void atualizarConta() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		Conta conta = contaController.buscarNaCollection(numero);
		
		if(conta != null) {
			
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			System.out.printf("A Agência atual: %d\nNova Agência (Pressione ENTER para manter o valor atual): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
			
			System.out.printf("O nome do Titular atual: %s\n Novo Titular (Pressione ENTER para manter o valor atual): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
			
			
			System.out.printf("Digite o saldo atual: %.2f\nNovo Saldo (Pressione ENTER para manter o valor atual): ", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);
			
			switch(tipo) {
			case 1 ->{
				float limite = ((ContaCorrente) conta).getLimite();
				
				System.out.printf("O Limite atual é: %.2f\nNovo Limite (Pressione ENTER para manter o valor atual):", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
				contaController.atualizar(new ContaCorrente(numero, agencia,tipo, titular, saldo, limite));
			}
			case 2 ->{
				int aniversario = ((ContaPoupanca) conta).getAniversario();
				System.out.printf("O aniversário atual é: %d\nNovo aniversário (Pressione ENTER para manter o valor atual): ", aniversario);
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				leia.nextLine();
				contaController.atualizar(new ContaPoupanca(numero, agencia,tipo, titular, saldo, aniversario));
				
			}
			default-> System.out.println(Cores.TEXT_RED + "Opção Inválida!");
			}
			
			
			
		}else {
				System.out.printf("\nA conta número %d não foi encontrada!", numero);
			}
			
		
		
		
	}
	
}
