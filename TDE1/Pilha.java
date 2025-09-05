package TDE1;
public class Pilha {
    private class No {
        int valor;
        No prox;

        No(int v) {
            this.valor = v;
        }
    }

    private No topo;

    public Pilha() {
        topo = null;
    }

    public void insere(int elemento) {
        No novo = new No(elemento);
        novo.prox = topo;
        topo = novo;
    }

    public void remove() {
        if (vazia()) {
            System.out.println("vazio");
            return;
        }
        topo = topo.prox;

    }

    public boolean vazia() {
        return topo == null;
    }

    public void listarValores() {
        if (vazia()) {
            System.out.println("ta vazia");
        } else {
            for (No n = topo; n != null; n = n.prox) {
                System.out.println(n.valor);
            }
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.insere(2);
        pilha.insere(4);
        pilha.insere(5);
        pilha.insere(6);
        pilha.listarValores();

        System.out.println("pera");

        pilha.remove();

        pilha.listarValores();

    }
}
