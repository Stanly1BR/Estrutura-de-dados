/*/*Atividade II - Criar uma Lista em Java ou Python que deverá adicionar
ou remover elementos da LISTA
no Método FIFO (o primeiro a entrar é o primeiro a sair) */
public class Lista {
    private Integer[] elementos;
    private int capacidade;
    private int inicio;
    private int fim;
    private int tamanho;

    public Lista(int capacidade) {
        this.capacidade = capacidade;
        elementos = new Integer[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public void enqueue(Integer elemento) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia");
        }
        fim = (fim + 1) % capacidade;
        elementos[fim] = elemento;
        tamanho++;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        Integer elementoRemovido = elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;

        return elementoRemovido;
    }

    public Integer front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return elementos[inicio];
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public static void main(String[] args) {
        Lista fila = new Lista(10); 

        System.out.println("Adicionando elementos à fila...");
        try {
            fila.enqueue(5);
            System.out.println("Tamanho atual da fila: " + fila.size());
            fila.enqueue(8);
            System.out.println("Tamanho atual da fila: " + fila.size());
            fila.enqueue(10);
            System.out.println("Tamanho atual da fila: " + fila.size());
            fila.enqueue(15);
            System.out.println("Tamanho atual da fila: " + fila.size());
            fila.enqueue(20);
            System.out.println("Tamanho atual da fila: " + fila.size());
            fila.enqueue(25);
            System.out.println("Tamanho atual da fila: " + fila.size());
            fila.enqueue(30);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nElemento da frente da fila: " + fila.front());
        System.out.println("Iniciando remoção de elementos da fila...");
        
        while (!fila.isEmpty()) {
            System.out.println("Elemento desenfileirado: " + fila.dequeue());
            System.out.println("Tamanho atual da fila: " + fila.size());
        }
    }
}

