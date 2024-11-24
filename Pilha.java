/*Atividade I - Criar uma PILHA em Java ou Python que deverá adicionar ou remover 
elementos da PILHA no Método LIFO (onde o último elemento a ser inserido,
 será o primeiro a ser retirado) */
public class Pilha {
    private Object[] pilha;     
    private int posicaoPilha;  

    public Pilha() {
        this.pilha = new Object[10];
        this.posicaoPilha = -1;     
    }

    public boolean pilhaVazia() {
        return this.posicaoPilha == -1;
    }

    public int tamanho() {
        return this.pilhaVazia() ? 0 : this.posicaoPilha + 1;
    }

    public Object exibeUltimoValor() {
        if (this.pilhaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }

    public Object desempilhar() {
        if (this.pilhaVazia()) {
            System.out.println("Erro: Pilha vazia!");
            return null;
        }
        return this.pilha[this.posicaoPilha--];
    }

    public void empilhar(Object valor) {
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        } else {
            System.out.println("Erro: Pilha cheia!");
        }
    }


   public static void main(String[] args) {
    Pilha p = new Pilha();

    p.empilhar(6);
    System.out.println("Tamanho atual da pilha: " + p.tamanho());
    p.empilhar(7);
    System.out.println("Tamanho atual da pilha: " + p.tamanho());
    p.empilhar(10);
    System.out.println("Tamanho atual da pilha: " + p.tamanho());

    while (!p.pilhaVazia()) {
        System.out.println("Elemento desempilhado: " + p.desempilhar());
        System.out.println("Tamanho atual da pilha: " + p.tamanho());
    }
}

}
