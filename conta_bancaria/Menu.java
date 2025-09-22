package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.model.Conta;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int op=0;
		
		// Instanciar objetos da classe conta
		
		Conta c1 = new Conta(1,123,1,"Rafaela Lemes", 500000.00f);
		
		Conta c2 = new Conta(2,123,2,"Lemes Rafaela", 500000.00f);
		
		System.out.println("O saldo da conta é: " + c1.getSaldo());
		
		c1.setSaldo(600000.00f); 
		
		c1.visualizar();
		
		c2.visualizar();
		
		
		//while(true) { // verificar onde tenho que fechar essa chave
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
			break;
			
			case 2: System.out.println("Listar todas as contas");
			break;
			
			case 3: System.out.println("Buscar Conta por Numero");
			break;
			
			case 4: System.out.println(" Atualizar Dados da Conta");
			break;
			
			case 5: System.out.println("Apagar Conta");
			break;
			
			case 6: System.out.println("Sacar");
			break;
			
			case 7: System.out.println("Depositar");
			break;
			
			case 8: System.out.println("Transferir valores entre Contas");
			break;
		}
		
		
		sobre();
	
		//}
	
}

	public static void sobre(){
		System.out.println("\n****************************************************************************"
				+ 			"\n\tProjeto deselvoldito por:\n"
				+ 			"\tRafaela Lemes - Dev Full Stack\n "
				+ 			"\tgithub.com/lemesdemorais\n"
				+ 			"\n****************************************************************************");		
	}
}

	
	
		
	

