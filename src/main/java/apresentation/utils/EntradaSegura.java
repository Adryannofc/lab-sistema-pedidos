package apresentation.utils;

import java.util.Scanner;

public class EntradaSegura {
    public static int lerOpcao(Scanner scanner, int min, int max) {

        while (true) {
            String entrada = scanner.nextLine().trim();
            try {
                int opcao = Integer.parseInt(entrada);
                if(opcao >= min && opcao <= max) {
                    return opcao;
                } else {
                    System.out.println("⚠ Opção fora do intervalo permitido!");
                }
            } catch (NumberFormatException error) {
                System.out.println("⚠ Digite apenas numeros validos");
            }
        }
    }

    public static String lerStringOuVoltar(Scanner scanner) {
        String entrada;
        do {
            entrada = scanner.nextLine().trim();
            if (entrada.equals("0")) return null;
            if (entrada.isBlank()) {
                System.out.println("⚠ Campo obrigatorio! Digite Algo ou 0 para voltar.");
            }
        } while (entrada.isBlank());
        return entrada;
    }

    public static String lerString(Scanner scanner) {
        String entrada;
        do {
            entrada = scanner.nextLine().trim();

            if(entrada.isBlank()) {
                System.out.println("⚠ Campo obrigatorio! Digite Algo.");
            }
        } while (entrada.isBlank());
        return entrada;
    }
}
