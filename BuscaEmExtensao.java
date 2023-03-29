import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaEmExtensao {

  // Definir a classe No para representar cada estado no problema a ser resolvido
  private static class No {
    // Propriedades da classe No
    String nome;
    int valor;
    ArrayList<No> vizinhos;

    // Construtor da classe No
    public No(String nome, int valor) {
      this.nome = nome;
      this.valor = valor;
      this.vizinhos = new ArrayList<>();
    }
  }

  // Algoritmo de busca em extensao (BFS)
  public static No buscaEmLargura(No raiz, int valorBuscado) {
    // Inicializar a fila de Nos a serem visitados
    Queue<No> fila = new LinkedList<>();
    // Adicionar a raiz a fila
    fila.add(raiz);
    // Inicializar o conjunto de Nos visitados
    ArrayList<No> visitados = new ArrayList<>();

    while (!fila.isEmpty()) {
      // Remover o primeiro No da fila e marca lo como visitado
      No noAtual = fila.poll();
      visitados.add(noAtual);

      // Verificar se o valor buscado foi encontrado
      if (noAtual.valor == valorBuscado) {
        return noAtual;
      }

      // Adicionar os Nos adjacentes (vizinhos) a fila, se ainda nao foram visitados
      for (No vizinho : noAtual.vizinhos) {
        if (!visitados.contains(vizinho) && !fila.contains(vizinho)) {
          fila.add(vizinho);
        }
      }
    }

    // Se a fila estiver vazia e o valor buscado nao foi encontrado, retorna false
    return new No("falso", 0);
  }

  // Exemplo de uso da classe No e do algoritmo de busca em extensao
  public static void main(String[] args) {
    // Criar os Nos
    No a = new No("A", 4);
    No b = new No("B", 1);
    No c = new No("C", 2);
    No d = new No("D", 5);
    No e = new No("E", 3);

    // Definir os vizinhos de cada No
    a.vizinhos.add(b);
    a.vizinhos.add(c);
    b.vizinhos.add(d);
    c.vizinhos.add(d);
    d.vizinhos.add(e);

    // Realizar a busca em largura a partir do No raiz (a)
    int valorBuscado = 3;
    No resultado = buscaEmLargura(a, valorBuscado);

    // Exibir o resultado da busca
    if (resultado.valor > 0) {
      System.out.println("Valor do no: " + resultado.valor);
      System.out.println("Nome do no: " + resultado.nome);
      System.out.println("Valor " + valorBuscado + " encontrado");
    } else {
      System.out.println("Valor " + valorBuscado + " nao encontrado.");
    }
  }
}
