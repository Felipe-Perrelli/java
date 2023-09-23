package Examepoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppSIstemaExameLista {

	static List<Exame> exames = new ArrayList();

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;
		do {

			System.out.println("1 - Cadastro");
			System.out.println("2 - Consulta");
			System.out.println("3 - Alterar Exame");
			System.out.println("4 - Excluir Exame");
			System.out.println("5 - Listar Exame");
			System.out.println("0 - Finalizar");

			System.out.print("\nOpção: ");
			opcao = input.nextInt();

			switch (opcao) {
				case 1:
					cadastraExame();
					break;
				case 2:
					consultaExame();
					break;
				case 3:
					alteraExame();
					break;
				case 4:
					excluiExame();
					break;
				case 5:
					listaExames();
					break;
				case 0:
					System.out.println("\n--- PROGRAMA FINALIZADO");
					break;
				default:
					System.out.println("\nOpção incorreta");

			}

		} while (opcao != 0);
		input.close();
	}

	public static Exame pesquisaExamePorCodigo(int idExame) {

		for (Exame exame : exames) {
			if (exame.getIdExame() == idExame) {
				return exame;
			}
		}
		return null;
	}

	public static void cadastraExame() {
		System.out.println("\n*** Cadastro de Exame ***\n");

		System.out.printf("\nCódigo do exame: ");
		int idExame = input.nextInt();

		if (pesquisaExamePorCodigo(idExame) != null) {
			System.out.println("\n-- Código já cadastrado --\n");
			return;
		}
		input.nextLine();
		System.out.printf("\nNome do Paciente: ");
		String nomePaciente = input.nextLine();
		System.out.printf("\nNivel de glicose do exame: ");
		int nivelGlicose = input.nextInt();

		exames.add(new Exame(idExame, nomePaciente, nivelGlicose));

		System.out.println("\n-- Cadastro efetuado --\n");
	}

	public static void consultaExame() {
		System.out.println("\n*** Consulta de Exame ***\n");
		if (exames.size() == 0) {
			System.out.println("Lista vazia");
			return;
		}

		System.out.printf("\nCódigo do exame: ");
		int idExame = input.nextInt();

		Exame posicaoEncontrada = pesquisaExamePorCodigo(idExame);

		if (posicaoEncontrada == null) {
			System.out.println("\n-- Código não cadastrado --\n");
			return;
		}

		System.out.printf("\nCódigo...............: %d\n", posicaoEncontrada.getIdExame());
		System.out.printf("nome do paciente....: %s\n", posicaoEncontrada.getNomePaciente());
		System.out.printf("Nivel de glicose: %d\n", posicaoEncontrada.getNivelGlicose());
		System.out.printf("estado do paciente.....: %s\n", posicaoEncontrada.obterDiagnostico());
	}

	public static void alteraExame() {
		System.out.println("\n*** Alteração do Exame ***\n");
		if (exames.size() == 0) {
			System.out.println("Lista vazia");
			return;
		}
		System.out.printf("\nCódigo do exame: ");
		int idExame = input.nextInt();

		Exame posicaoEncontrada = pesquisaExamePorCodigo(idExame);

		if (posicaoEncontrada == null) {
			System.out.println("\n-- Código não cadastrado --\n");
			return;
		}

		System.out.printf("\nCódigo...............: %d\n", posicaoEncontrada.getIdExame());
		System.out.printf("nome do paciente....: %s\n", posicaoEncontrada.getNomePaciente());
		System.out.printf("Nivel de glicose: %d\n", posicaoEncontrada.getNivelGlicose());
		System.out.printf("estado do paciente.....: %s\n", posicaoEncontrada.obterDiagnostico());

		System.out.println("\nNovo nome: ");
		String novoNome = input.next();
		posicaoEncontrada.setNomePaciente(novoNome);
		input.nextLine();

		System.out.println("\nNovo nivel de glicose: ");
		int novoNivelGlicose = input.nextInt();
		posicaoEncontrada.setNivelGlicose(novoNivelGlicose);
		System.out.println("Nome do paciente alterado");
		System.out.println("Nivel de glicose do paciente alterado");
	}

	public static void excluiExame() {
		System.out.println("\n*** Exclusão de Exame ***\n");
		if (exames.size() == 0) {
			System.out.println("Lista vazia");
			return;
		}

		System.out.printf("\nCódigo do exame: ");
		int idExame = input.nextInt();

		Exame posicaoEncontrada = pesquisaExamePorCodigo(idExame);

		if (posicaoEncontrada == null) {
			System.out.println("\n-- Código não cadastrado --\n");
			return;
		}

		System.out.printf("\nCódigo...............: %d\n", posicaoEncontrada.getIdExame());
		System.out.printf("nome do paciente....: %s\n", posicaoEncontrada.getNomePaciente());
		System.out.printf("Nivel de glicose: %d\n", posicaoEncontrada.getNivelGlicose());
		System.out.printf("estado do paciente.....: %s\n", posicaoEncontrada.obterDiagnostico());

		char confirma;
		do {
			System.out.printf("\nConfirma exclusão [S/N]: ");
			input.nextLine();
			confirma = input.nextLine().charAt(0);
			confirma = Character.toUpperCase(confirma);
			if (confirma != 'S' && confirma != 'N') {
				continue;
			}
			break;
		} while (true);
		if (confirma == 'S') {
			exames.remove(posicaoEncontrada);
			System.out.println("-- Exclusão efetuada");
		} else {
			System.out.println("-- Exclusão cancelada");
		}
	}

	public static void listaExames() {
		System.out.println("\n*** Listagem de Exames ***\n");

		if (exames.size() == 0) {
			System.out.println("Lista vazia");
			return;
		}

		System.out.println("----------------------------------------------------");
		;
		System.out.println("Codigo | nome     |     glicose | Diagnostico       ");
		System.out.println("----------------------------------------------------");

		for (Exame exame : exames) {

			System.out.printf("%-6d %7s %12d %17s\n",
					exame.getIdExame(),
					exame.getNomePaciente(),
					exame.getNivelGlicose(),
					exame.obterDiagnostico());
		}
	}
}
