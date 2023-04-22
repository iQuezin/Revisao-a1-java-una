import java.util.Scanner;

public class Entrevista {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nome, cartaoVacina, sintomas, contatoPessoas, retornandoViagem, idade;
        int contadorErro = 0;
        int porcentagemRisco = 0;

        System.out.println("Informe:");
        // nome/idade
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("Idade: ");
        idade = scanner.nextLine();

        // Cartão Vacina
        while (true) {
            System.out.println("Seu cartão de vacina está em dia? (SIM/NAO)");
            cartaoVacina = scanner.nextLine();
            if (cartaoVacina.equalsIgnoreCase("sim")) {
                break;
            } else if (cartaoVacina.equalsIgnoreCase("nao")) {
                porcentagemRisco += 10;
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                contadorErro++;
                if (contadorErro >= 3) {
                    System.out.println(
                            "Não foi possível realizar o diagnóstico.Gentileza procurar ajuda médica caso apareça algum sintoma.");
                    return;
                }
            }
        }

        contadorErro = 0;

        // Sintomas
        while (true) {
            System.out.println(
                    "Teve algum dos sintomas recentemente? (dor de cabeça, febre, náusea, dor articular, gripe) (SIM/NAO)");
            sintomas = scanner.nextLine();
            if (sintomas.equalsIgnoreCase("sim")) {
                porcentagemRisco += 30;
                break;
            } else if (sintomas.equalsIgnoreCase("nao")) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                contadorErro++;
                if (contadorErro >= 3) {
                    System.out.println(
                            "Não foi possível realizar o diagnóstico.Gentileza procurar ajuda médica caso apareça algum sintoma.");
                    return;
                }
            }
        }

        contadorErro = 0;

        // Contato com Pessoas
        while (true) {
            System.out.println("Teve contato com pessoas com sintomas gripais nos últimos dias? (SIM/NAO)");
            contatoPessoas = scanner.nextLine();
            if (contatoPessoas.equalsIgnoreCase("sim")) {
                porcentagemRisco += 30;
                break;
            } else if (contatoPessoas.equalsIgnoreCase("nao")) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                contadorErro++;
                if (contadorErro >= 3) {
                    System.out.println(
                            "Não foi possível realizar o diagnóstico.Gentileza procurar ajuda médica caso apareça algum sintoma.");
                    return;
                }
            }
        }

        contadorErro = 0;

        // Retornando de Viagem
        while (true) {
            System.out.println("Está retornando de viagem realizada no exterior? (SIM/NAO)");
            retornandoViagem = scanner.nextLine();
            if (retornandoViagem.equalsIgnoreCase("sim")) {
                porcentagemRisco += 30;
                break;
            } else if (retornandoViagem.equalsIgnoreCase("nao")) {
                break;
            } else {
                System.out.println("Opção inválida. Tente Novamente.");
                contadorErro++;
                if (contadorErro >= 3) {
                    System.out.println(
                            "Não foi possível realizar o diagnóstico. Gentileza procurar ajuda médica caso apareça algum sintoma.");
                    return;
                }
            }
        }

        System.out.println("\nInformações coletadas");
        System.out.println(nome + ";");
        System.out.println(idade + " anos;");
        System.out.println("Carão de vacinas está em dia? " + cartaoVacina + ";");
        System.out.println("Teve algum dos sintomas recentemente? " + sintomas + ";");
        System.out.println("Teve contato com pessoas com sintomas gripais nos últimos dias? " + contatoPessoas + ";");
        System.out.println("Está retornando de viagem realizada no exterior? " + retornandoViagem + ";");
        System.out.println("Chance de infecção = " + porcentagemRisco + "%.");

        switch (retornandoViagem) {
            case "sim":
                System.out.println("Você ficará sob observação por 05 dias devido ao retorno da viagem.");
        }

        if (porcentagemRisco <= 30) {
            System.out.println(
                    "Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.");
        } else if (porcentagemRisco <= 60) {
            System.out.println(
                    "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.");
        } else if (porcentagemRisco <= 90) {
            System.out.println("Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado");
        }

        scanner.close();
    }
}
