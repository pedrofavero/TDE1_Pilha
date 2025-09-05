package TDE1;
public class Merge {

    public static void mergeVetor(int[] vetor1, int[] vetor2, int tamanho1, int tamanho2) {
        int tamanho = tamanho1 + tamanho2;
        int[] vetorMerge = new int[tamanho];

        // for(int i = 0; i < vetor1.length; i++){
        // vetorMerge[i] = vetor1[i];
        // }

        // for (int j = 0; j < tamanho2; j++) {
        // vetorMerge[tamanho1 + j] = vetor2[j];
        // }

        int i = 0;
        int j = 0;
        int k = 0;

        while (j < tamanho2 && i < tamanho1) {
            if (vetor1[i] <= vetor2[j]) {
                vetorMerge[k] = vetor1[i];
                k++;
                i++;
            } else {
                vetorMerge[k] = vetor2[j];
                k++;
                j++;
            }
        }

        while (i < tamanho1) {
            vetorMerge[k] = vetor1[i];
            k++;
            i++;
        }

        while (j < tamanho2) {
            vetorMerge[k] = vetor2[j];
            k++;
            j++;
        }

        for (int v : vetorMerge){
            System.out.println(v);
        }
    }

    private static class No {
        int valor;
        No prox;

        No(int valor) {
            this.valor = valor;
        }
    }

    public static No mergeFila(No fila1, No fila2) {
        // No merge = new No(0);

        No ultimo =  new No(0);

        while (fila1 != null && fila2 != null) {
            if (fila1.valor <= fila2.valor) {
                ultimo.prox = fila1;
                fila1 = fila1.prox;
            } else {
                ultimo.prox = fila2;
                fila2 = fila2.prox;
            }

            ultimo = ultimo.prox;
        }

        while (fila1 != null) {
            ultimo.prox = fila1;
            fila1 = fila1.prox;

        }

        while (fila2 != null) {
            ultimo.prox = fila2;
            fila2 = fila2.prox;
        }

        return ultimo.prox;
    }

    public static void main(String[] args) {
        int[] vetor1 = { 12, 35, 52, 64 };
        int[] vetor2 = { 05, 15, 23, 55, 75 };

        mergeVetor(vetor1, vetor2, 4, 5);

        No fila1 = new No(12);
        fila1.prox = new No(35);
        fila1.prox.prox = new No(52);
        fila1.prox.prox.prox = new No(64);

        No fila2 = new No(5);
        fila2.prox = new No(15);
        fila2.prox.prox = new No(23);
        fila2.prox.prox.prox = new No(55);
        fila2.prox.prox.prox.prox = new No(75);

        No merged = mergeFila(fila1, fila2);
        for (No p = merged; p != null; p = p.prox) {
            System.out.print(p.valor);
            System.out.print(" - ");
        }
        System.out.println();
    }
}
