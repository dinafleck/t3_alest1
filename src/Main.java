//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.adicionar(10);
        arvore.adicionar(20);
        arvore.adicionar(15);
        arvore.adicionar(5);
        arvore.adicionar(25);
        arvore.adicionar(30);
        arvore.adicionar(12);
        arvore.adicionar(9);
        arvore.adicionar(8);
        arvore.adicionar(7);
        arvore.adicionar(31);
        arvore.adicionar(27);
        arvore.adicionar(33);

        arvore.imprimirArvore();

        System.out.println();
        if(arvore.remover(20)) {
            System.out.println("Chave removida com sucesso.");
            System.out.println();
            arvore.imprimirArvore();
        }


        System.out.println();
        System.out.println("Esquerda = " + arvore.obterEsquerda(31) + ".");
        System.out.println("Direita = " + arvore.obterDireita(31) + ".");
        System.out.println("Pai = " + arvore.obterPai(31) + ".");

        if (arvore.existe(29)) System.out.println("A chave solicitada existe na árvore.");
        else System.out.println("A chave solicitada não existe na árvore.");
        System.out.println();

        System.out.println("O maior valor da árvore é " + arvore.obterMaiorValor() + ".");
        System.out.println("O menor valor da árvore é " + arvore.obterMenorValor() + ".");

        System.out.println("O tamanho da arvore é " + arvore.obterTamanho() + ".");

        System.out.println();
        System.out.println("Caminhamento pré-fixado:");
        System.out.println(arvore.elementosPreOrdem());

        System.out.println();
        System.out.println("Caminhamento pós-fixado:");
        System.out.println(arvore.elementosPosOrdem());

        System.out.println();
        System.out.println("Caminhamento central:");
        System.out.println(arvore.elementosCentralOrdem());

        System.out.println();
        System.out.println("Caminhamento em largura:");
        System.out.println(arvore.elementosLargura());

        System.out.println();
        System.out.println("O nível da chave solicitada é " + arvore.obterNivel(7));

        System.out.println();
        System.out.println("A altura da árvore é " + arvore.obterAltura() + ".");

        System.out.println();
        if(arvore.ehInterno(5)) System.out.println("A chave solicitada equivale a um nodo interno.");
        else System.out.println("A chave solicitada não equivale a um nodo interno.");

        System.out.println();
        if(arvore.ehExterno(5)) System.out.println("A chave solicitada equivale a um nodo externo.");
        else System.out.println("A chave solicitada não equivale a um nodo externo.");

        System.out.println();
        System.out.println("A quantidade de nodos folha da árvore é " + arvore.qtdNodosFolha() + " e a quantidade de nodos não folha é " + arvore.qtdNodosNaoFolha() + ".");

        System.out.println();
        System.out.println("A quantidade de pares na árvore é " + arvore.qtdPares() + " e a quantidade de ímpares é " + arvore.qtdImpares() + ".");

        arvore.gerarArvoreAleatoria(10);
        arvore.imprimirArvore();

        System.out.println();
        System.out.println("Adicionando lista string");
        arvore.adicionarString("1,50,20,30");
        arvore.imprimirArvore();

        System.out.println();
        System.out.println("Removendo lista string");
        arvore.removerString("1,50,49");
        arvore.imprimirArvore();

        System.out.println();
        System.out.println("Árvore criada para merge:");
        ArvoreBinaria arvoreMerge = new ArvoreBinaria();
        arvoreMerge.gerarArvoreAleatoria(10);
        System.out.println(arvoreMerge.elementosCentralOrdem());

        System.out.println();
        System.out.println("Árvore mergeada");
        arvore.mergear(arvoreMerge);
        arvore.imprimirArvore();

        arvore.limpar();
        System.out.println();
        System.out.println("Verificação de limpeza:");
        arvore.imprimirArvore();


    }
}