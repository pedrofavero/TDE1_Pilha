package TDE1;
public class Fila {

    private class No {
        int valor;
        No prox;
        No(int valor) { 
            this.valor = valor; 
        }
    }

    private No primeiro;   
    private No ultimo;     
    int contador;          

    Fila(int n){
        this.primeiro = null;
        this.ultimo = null;
        this.contador = 0;
    }

    public void insere(int numero){
        No novo = new No(numero);
        if (vazia()) {                 
            primeiro = novo;
            ultimo = novo;
        } else {                      
            ultimo.prox = novo;
            ultimo = novo;
        }
        contador++;
    }
    

    public void remove(){
        if (vazia()){
            System.out.println("ta vazia");
            return;
        }
        primeiro = primeiro.prox;   
        contador--;
        if (primeiro == null) {    
            ultimo = null;
        }
    }

    public void imprimir(){
        if (vazia()){
            System.out.println("vazia");
            return;
        }
        for (No n = primeiro; n != null; n = n.prox) {
            System.out.println(n.valor);
        }
    }

    public boolean vazia(){
        return contador == 0; 
    }

    public static void main(String[] args) {
        Fila fila = new Fila(5);
        fila.insere(10);
        fila.insere(20);
        fila.insere(30);
        fila.imprimir();  

        fila.remove();   
        fila.imprimir();  


        // fila.remove();
        // fila.remove();
        // System.out.println(fila.vazia());

        // fila.remove();
        // fila.imprimir();
    }
}
