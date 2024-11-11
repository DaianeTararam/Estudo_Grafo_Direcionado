package controller;

import javax.swing.JOptionPane;

import model.estrutura.grafo.GrafoLista;

public class GrafoListaController {
    public GrafoListaController() {
        super();
    }

    public String teste() throws Exception {
        GrafoLista<Integer> g = new GrafoLista<Integer>();
        g.adicionarCentro("São José do Rio Preto", "Manhuaçu");

        g.adicionarRota("Manhuaçu", "Belo Horizonte", 279);
        g.adicionarRota("Manhuaçu", "Governador Valadares", 198);
        g.adicionarRota("Belo Horizonte", "Juiz de Fora", 260);
        g.adicionarRota("Juiz de Fora", "Rio de Janeiro", 181);

        g.adicionarRota("Governador Valadares", "Colatina", 216);
        g.adicionarRota("Colatina", "Vitória", 131);
        g.adicionarRota("Vitória", "Campo dos Goytacazes", 240);

        g.adicionarRota("São José do Rio Preto", "Uberaba", 245);
        g.adicionarRota("São Carlos", "Ribeirão Preto", 99);
        g.adicionarRota("São Carlos", "Campinas", 142);
        g.adicionarRota("Ribeirão Preto", "Franca", 89);
        g.adicionarRota("Campinas", "São Paulo", 111);
        g.adicionarRota("São Paulo", "São José dos Campos", 99);

        g.adicionarRota("São José do Rio Preto", "São Carlos", 206);
        g.adicionarRota("Uberaba", "Uberlândia", 105);
        g.adicionarRota("Uberlândia", "Patos de Minas", 222);
        
        String escolha = JOptionPane.showInputDialog("Digite o nome da cidade para ser feita a entrega:");
    
        //g.definirRota(escolha);
        System.out.println("Rotas:\n" + g);


        return g.toString();
    }

}


//Este método controla o grafo e executa todas as operações de teste
//Como a adição de aresta entre nós
