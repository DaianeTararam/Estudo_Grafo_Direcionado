package model.estrutura.grafo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GrafoLista<T> {
    // Este Map armazena cada nó como uma chave e suas conexões (vizinhos) como uma lista
    private Map<String, List<T>> mapa = new HashMap<>();

    public void adicionarCentro(String centro1, String centro2){
        mapa.put(centro1, new LinkedList<T>());
        mapa.put(centro2, new LinkedList<T>());

    }
    public void adicionarOrigem(String centro){
        mapa.put(centro, new LinkedList<T>());
    }

    public void adicionarRota(String cidadeOrigem, String cidadeDestino, int distancia) {
        if(!mapa.containsKey(cidadeOrigem)){
            adicionarOrigem(cidadeOrigem);
        }
        if(!mapa.containsKey(cidadeDestino)){
            adicionarOrigem(cidadeDestino);
        }

        mapa.get(cidadeOrigem).add(cidadeDestino);
        mapa.get(cidadeDestino).add(cidadeOrigem);

    }

    public String definirRota(String cidade){
        //Neste método eu vou ter que criar a melhor rota e obviamente chamar um outro método para incluir fazer os cálculos das km
        //chamar ao método toString
        //modificar o toString, para imprimir apenas o caminho do texto até o caminho do da cidade 
        //

    }

    
    public void adicionarAresta(T origem, T destino) {
        if (!mapa.containsKey(origem)) adicionarNo(origem);
        if (!mapa.containsKey(destino)) adicionarNo(destino);

        // Adiciona a conexão de origem para destino e vice-versa (grafo não-direcionado)
        // Mas o meu grafo será direcionado;

        mapa.get(origem).add(destino);
        mapa.get(destino).add(origem);
    }

    // Método para verificar se um nó existe no grafo
    public boolean temNo(T no) {
        return mapa.containsKey(no);
    }

    // Método para verificar se existe uma aresta entre dois nós
    public boolean temAresta(T origem, T destino) {
        return mapa.containsKey(origem) && mapa.get(origem).contains(destino);
    }

    // Método que retorna o número total de nós no grafo
    public int tamanho() {
        return mapa.keySet().size();
    }

    // Método para remover um nó e todas as arestas conectadas a ele
    public void removerNo(T no) {
        if (!mapa.containsKey(no)) return; // Verifica se o nó existe no grafo
        
        // Remove o nó das listas de adjacência de outros nós
        for (T vizinho : mapa.get(no)) {
            mapa.get(vizinho).remove(no);
        }

        // Remove o próprio nó do mapa
        mapa.remove(no);
    }

    // Método para remover uma aresta (conexão) entre dois nós
    public void removerAresta(T origem, T destino) {
        if (mapa.containsKey(origem) && mapa.containsKey(destino)) {
            mapa.get(origem).remove(destino);  // Remove destino da lista de origem
            mapa.get(destino).remove(origem);  // Remove origem da lista de destino
        }
    }

    // Método que retorna uma String representando o grafo, com cada nó e suas conexões
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Percorre todos os nós no grafo
        for (String v : mapa.keySet()) {
            builder.append(v.toString() + ": ");
            // Para cada nó, adiciona as conexões (arestas)
            for (T w : mapa.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}


//Essa classe implementa a estrutura do grafo, utilizando um map
//O map é uma interface que representa uma coleção de pares chave-valor
// O código ainda encontra-se incompleto