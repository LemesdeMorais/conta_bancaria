package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
					// aqui é a classe, a proxima é o objeto		
	
	public static void main(String[] args) {
		
		
		int op=0;
		
		criarContasTeste();
		
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
			keyPress();
			break;
			
			case 2: System.out.println("Listar todas as contas");
			listarContas();
			
			keyPress();
			break;
			
			case 3: System.out.println("Buscar Conta por Numero");
			keyPress();
			break;
			
			case 4: System.out.println(" Atualizar Dados da Conta");
			keyPress();
			break;
			
			case 5: System.out.println("Apagar Conta");
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
		System.out.println(Cores.TEXT_RESET + "\n\nPressiona Ender para continuar...");
		leia.nextLine();
		}
	
	private static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(1, 456,1,"Thuany Silva", 1000000.00f,10000.00f));
		contaController.cadastrar(new ContaPoupanca(2,456,2,"Marcia Condarco", 1000000.00f, 10));
	}
	private static void listarContas() {
		contaController.listarTodas();
		
	}
}

	
	
		
	

