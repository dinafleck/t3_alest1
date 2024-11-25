//Dinara Regina Fleck

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ArvoreBinaria {
        public int tamanho;

        private class ResultadoBuscaProfundidade{
            public String preordem;
            public String posordem;
            public String central;
            public String centralMerge;
            public String largura;
            public int altura;
            public int folha;
            public int naoFolha;
            public int pares;
            public int impares;
            public ResultadoBuscaProfundidade(){
                preordem = "";
                posordem = "";
                central = "";
                centralMerge = "";
                largura = "";
                altura = 0;
                folha = 0;
                naoFolha = 1;
                pares = 0;
                impares = 0;
            }
        }

    private class Nodo{
        private int chave;
        private int nivel;
        private Nodo esquerda;
        private Nodo direita;
        private Nodo pai;
        public Nodo(int chave){
            this.chave = chave;
            this.nivel = 0;
        }
    }
    private Nodo raiz;
    public ArvoreBinaria(){};

    public void adicionar(int chave){
        Nodo n = new Nodo(chave);
        if(estaVazia()){
            raiz = n;
            tamanho++;
        }
        else{
            adicionaRecursivo(n, raiz);
        }

    }

    private void adicionaRecursivo(Nodo n, Nodo pai){
        n.nivel = n.nivel + 1;
        if(n.chave>pai.chave){
            if(pai.direita==null){
                pai.direita = n;
                n.pai = pai;
                tamanho++;
            }
            else{
                adicionaRecursivo(n, pai.direita);
            }
        }
        else{
            if(pai.esquerda==null){
                pai.esquerda = n;
                n.pai = pai;
                tamanho++;
            }
            else{
                adicionaRecursivo(n, pai.esquerda);
            }
        }
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public int obterTamanho(){
        return tamanho;
    }

    public int obterNivel(int chave){
        Nodo aux = obterNodoRecursivo(chave, raiz);
        return aux.nivel;
    }

    private void percorrerRecursivamente(Nodo aux, ResultadoBuscaProfundidade resultado){
        if(aux==null) return;
        if(resultado.altura<aux.nivel) resultado.altura = aux.nivel;
        if(numeroFilhos(aux)==0) resultado.folha++;
        else resultado.naoFolha++;
        if(aux.chave%2==0) resultado.pares++;
        else resultado.impares++;

        resultado.preordem = resultado.preordem + " " + aux.chave;
        if(aux.esquerda!=null) percorrerRecursivamente(aux.esquerda, resultado);
        resultado.central = resultado.central + " " + aux.chave;
        resultado.centralMerge = resultado.centralMerge + aux.chave + ",";
        if(aux.direita!=null) percorrerRecursivamente(aux.direita, resultado);
        resultado.posordem = resultado.posordem + " " + aux.chave;

    }

    private void percorrerEmLargura(ResultadoBuscaProfundidade resultado){
        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);
        while(!fila.isEmpty()){
            Nodo aux = fila.poll();
            if(aux.esquerda!=null) fila.add(aux.esquerda);
            if(aux.direita!=null) fila.add(aux.direita);
            resultado.largura = resultado.largura + " " + aux.chave;
        }
    }

    public String elementosPreOrdem(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.preordem;
    }

    public String elementosPosOrdem(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.posordem;
    }

    public String elementosCentralOrdem(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.central;
    }

    public String elementosLargura(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerEmLargura(r);
        return r.largura;
    }

    public void imprimirArvore(){
        imprimirArvoreRecursivamente(raiz,0);
    }

    private void imprimirArvoreRecursivamente(Nodo raiz, int nivel){
        if (raiz==null) return;
        nivel += 5;
        imprimirArvoreRecursivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.chave + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecursivamente(raiz.esquerda, nivel);
        }

    public void limpar(){
        raiz = null;
    }

    private Nodo obterNodoRecursivo(int chave, Nodo n){
        if(n==null) return null;
        if(n.chave==chave) return n;
        if(chave>n.chave) return obterNodoRecursivo(chave,n.direita);
        if(chave<n.chave) return obterNodoRecursivo(chave,n.esquerda);
        return null;
    }

    public int obterEsquerda(int chave){
        Nodo auxEsquerda = obterNodoRecursivo(chave,raiz);
        if(auxEsquerda.esquerda==null) return -1;
        return auxEsquerda.esquerda.chave;
    }

    public int obterDireita(int chave){
        Nodo aux = obterNodoRecursivo(chave,raiz);
        if(aux.direita==null) return -1;
        return aux.direita.chave;
    }

    public int obterPai(int chave){
        Nodo aux = obterNodoRecursivo(chave,raiz);
        if(aux.pai==null) return -1;
        return aux.pai.chave;
    }

    public boolean existe(int chave){
        Nodo aux = obterNodoRecursivo(chave,raiz);
        if(aux==null) return false;
        return true;
    }

    public int obterAltura(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.altura;
    }

    public boolean ehInterno(int chave){
        Nodo n = obterNodoRecursivo(chave,raiz);
        if (n==null) return false;
        if(numeroFilhos(n)==0) return true;
        else return false;
    }

    public boolean ehExterno(int chave){
        Nodo n = obterNodoRecursivo(chave,raiz);
        if (n==null) return false;
        if(numeroFilhos(n)==0) return false;
        else return true;
    }

    public int qtdNodosNaoFolha(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.naoFolha;
    }

    public int qtdNodosFolha(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.folha;
    }

    private int numeroFilhos(Nodo n){
        if(n==null) return -1;
        if(n.esquerda==null && n.direita==null) return 0;
        if(n.direita!=null && n.esquerda!=null) return 2;
        return 1;
    }

    public boolean remover(int chave){
        Nodo n = obterNodoRecursivo(chave, raiz);
        if(n==null) return false;
        if(numeroFilhos(n)==0){
            if(n.pai.esquerda==n) n.pai.esquerda = null;
            else n.pai.direita = null;
        }
        if(numeroFilhos(n)==1){
            if(n.direita==null){
                if(n.pai.esquerda==n) n.pai.esquerda = n.esquerda;
                else n.pai.direita = n.esquerda;
            }
            else {
                if(n.pai.esquerda==n) n.pai.esquerda = n.direita;
                else n.pai.direita = n.direita;
            }
        }
        if(numeroFilhos(n)==2){
            Nodo auxRemocao = obterNodoRecursivo(menorValorDireita(n),n);
            n.chave = auxRemocao.chave;
            if(auxRemocao.pai.direita==auxRemocao) auxRemocao.pai.direita = null;
            else auxRemocao.pai.esquerda = null;

        }
        return true;
    }

    public int menorValorDireita(Nodo n){
        int[] menor = new int[1];
        menor[0] = Integer.MAX_VALUE;
        menorValorRecursivo(n,menor);
        return menor[0];
    }

    public int obterMaiorValor(){
        int[] maior = new int[1];
        maior[0] = Integer.MIN_VALUE;
        maiorValorRecursivo(raiz,maior);
        return maior[0];
    }

    private void maiorValorRecursivo(Nodo n, int[] maior){
        if(n==null) return;
        if(n.chave>maior[0]) maior[0] = n.chave;
        maiorValorRecursivo(n.esquerda,maior);
        maiorValorRecursivo(n.direita,maior);
    }

    public int obterMenorValor(){
        int[] menor = new int[1];
        menor[0] = Integer.MAX_VALUE;
        menorValorRecursivo(raiz,menor);
        return menor[0];
    }

    private void menorValorRecursivo(Nodo n, int[] menor){
        if(n==null) return;
        if(n.chave<menor[0]) menor[0] = n.chave;
        menorValorRecursivo(n.esquerda,menor);
        menorValorRecursivo(n.direita,menor);
    }

    public int qtdPares(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.pares;
    }

    public int qtdImpares(){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.impares;
    }

    public void mergear(ArvoreBinaria arvore){
        ResultadoBuscaProfundidade r = new ResultadoBuscaProfundidade();
        percorrerRecursivamente(arvore.raiz, r);
        String merge = r.centralMerge;
        adicionarString(merge);
    }

    public void adicionarString(String lista){
        String[] auxAdicionarString = lista.split(",");

        for (int i = 0; i < auxAdicionarString.length; i++) {
            adicionar(Integer.parseInt(auxAdicionarString[i]));
        }

    }

    public void removerString(String lista){
        String[] auxRemoverString = lista.split(",");
        for (int i = 0; i < auxRemoverString.length; i++) {
            remover(Integer.parseInt(auxRemoverString[i]));
        }
    }

    public void gerarArvoreAleatoria(int n){
        raiz = null;
        gerarArvoreAleatoriaRecursivo(n, 1);
    }

    private void gerarArvoreAleatoriaRecursivo(int n, int cont){
        Random random = new Random();
        int aux = random.nextInt(1, 51);
        if(obterNodoRecursivo(aux, raiz)==null) adicionar(aux);
        if(cont<n) gerarArvoreAleatoriaRecursivo(n, cont+1);
    }



}
