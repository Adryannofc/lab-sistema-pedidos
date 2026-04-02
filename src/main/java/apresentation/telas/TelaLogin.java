package apresentation.telas;

import apresentation.utils.EntradaSegura;
import apresentation.utils.Navegacao;
import java.util.Scanner;

public class TelaLogin {
    Scanner scan = new Scanner(System.in);
    Navegacao nav = new Navegacao();

    public void iniciar() {
        nav.navegarPara(this::exibirInicio);
    }

    public void exibirInicio() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║               LOGIN/CADASTRO             ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ [1] ▸ Login                              ║");
        System.out.println("║ [2] ▸ Cadastro                           ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("⮞ ");
        int opcao = EntradaSegura.lerOpcao(scan, 1, 2);

        switch (opcao) {
            case 1: nav.navegarPara(this::exibirLogin); break;
            case 2: nav.navegarPara(this::exibirCadastroUsuario); break;
        }
    }

    public void exibirLogin() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║ ↵                LOGIN                   ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ [0] ▸ Voltar                             ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print  ("⮞ [EMAIL]: ");
        String email = EntradaSegura.lerStringOuVoltar(scan);
        if (email == null) { nav.voltar(); return; }
        System.out.print  (" [SENHA]: ");
        String senha = EntradaSegura.lerStringOuVoltar(scan);
        if (senha == null) { nav.voltar(); return; }
        System.out.println("╚══════════════════════════════════════════╝");
    }

    public void exibirCadastroUsuario() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║ ↵              CADASTRO                  ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ [1] ▸ Cliente                            ║");
        System.out.println("║ [2] ▸ Restaurante                        ║");
        System.out.println("║ [0] ▸ Voltar                             ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("⮞ ");
        int opcao = EntradaSegura.lerOpcao(scan, 1, 2);

        switch (opcao) {
            case 1: nav.navegarPara(this::exibirCadastroCliente); break;
        }
    }

    public void exibirCadastroCliente() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║ ↵               CADASTRO                 ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ [0] ▸ Voltar                             ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("⮞ [NOME]: ");
        String nome = EntradaSegura.lerStringOuVoltar(scan);
        if(nome == null) { nav.voltar(); return;}

        System.out.print("⮞ [CPF]: ");
        String cpf = EntradaSegura.lerStringOuVoltar(scan);
        if(cpf == null) {nav.voltar(); return;}

        System.out.print("⮞ [EMAIL]: ");
        String email = EntradaSegura.lerStringOuVoltar(scan);
        if(email == null) { nav.voltar(); return;}

        System.out.print("⮞ [SENHA]: ");
        String senha = EntradaSegura.lerStringOuVoltar(scan);
    }
}
