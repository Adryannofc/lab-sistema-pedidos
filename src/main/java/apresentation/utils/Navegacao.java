package apresentation.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Navegacao {
    private final Deque<Runnable> historico = new ArrayDeque<>();

    public void navegarPara(Runnable tela) {
        historico.push(tela);
        limparTela();
        tela.run();
    }

    public void voltar() {
        historico.pop();
        if (!historico.isEmpty()) {
            limparTela();
            historico.peek().run();
        }
    }

    public void limparTela() {
        for(int i = 0; i < 25; i++){
            System.out.println("");
        }
    }
}
