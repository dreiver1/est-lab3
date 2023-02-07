public class ListaLigada implements EstruturaDeDados {
    private No inicio;

    public void removeInicio() {
        if (inicio != null) {
            inicio = inicio.getProximo();
        }
    }

    public void removeFim() {
        if (inicio == null) {
            return;
        }
        if (inicio.getProximo() == null) {
            inicio = null;
        }
        removeFim(inicio);
    }

    public void removeFim(No n) {
        No proximo = n.getProximo();
        if (proximo.getProximo() == null) {
            n.setProximo(null);
            return;
        } else {
            removeFim(proximo);
        }
    }

    public void insereInicio(int valor) {
        if (inicio == null) {
            inicio = new No(valor);
            return;
        }
        No n = new No(valor);
        n.setProximo(inicio);
        inicio = n;

    }

    public void insereFim(int valor) {
        if (inicio == null) {
            inicio = new No(valor);
            return;
        }
        insere(inicio, valor);
    }

    public boolean procura(int valor) {
        if (inicio == null) {
            return false;
        } else {
            return procura(inicio, valor);
        }
    }

    public boolean procura(No n, int valor) {
        if (n.getValor() == valor) {
            return true;
        } else if (n.getProximo() == null) {
            return false;
        } else {
            return procura(n.getProximo(), valor);
        }
    }

    public void insere(No n, int valor) {
        if (n.getProximo() == null) {
            No novo = new No(valor);
            n.setProximo(novo);
        } else {
            insere(n.getProximo(), valor);
        }
    }

    public void remover(int valor) {
        if (inicio == null) {
            return;
        }
        if (inicio.getValor() == valor) {
            inicio = inicio.getProximo();
            return;
        }
        remover(inicio, valor);
    }

    public void remover(No n, int valor) {
        No proximo = n.getProximo();
        if (proximo == null) {
            return;
        }
        if (proximo.getValor() == valor) {
            n.setProximo(proximo.getProximo());
        } else {
            remover(proximo, valor);
        }
    }

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.insert(0);
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);
        lista.insert(6);
        System.out.println(lista.minimum());
        lista.remover(0);
        System.out.println(lista.minimum());
        System.out.println(lista.maximum());
        lista.remover(6);
        System.out.println(lista.prodessor(4));
        System.out.println(lista.sucessor(4));
    }

    @Override
    public boolean insert(int chave) {
        this.insereInicio(chave);
        return false;
    }

    @Override
    public boolean delete(int chave) {
        this.remover(chave);
        return false;
    }

    @Override
    public boolean search(int chave) {
        if (this.procura(chave) == true) {
            return true;
        }
        return false;
    }

    @Override
    public int minimum() {
        if (this.inicio == null) {
            return 0;
        }
        int valor = inicio.getValor();
        if (inicio.getProximo() == null) {
            return inicio.getValor();
        }
        return minimum(inicio.getProximo(), valor);
    }

    public int minimum(No n, int valor) {
        int aux = valor;
        if (aux > n.getValor()) {
            aux = n.getValor();
        }
        if (n.getProximo() != null) {
            return minimum(n.getProximo(), aux);
        }
        return aux;
    }

    @Override
    public int maximum() {
        if (this.inicio == null) {
            return 0;
        }
        int valor = inicio.getValor();
        return maximum(inicio.getProximo(), valor);
    }

    public int maximum(No n, int valor) {
        if (valor < n.getValor()) {
            valor = n.getValor();
        }
        if (n.getProximo() != null) {
            return maximum(n.getProximo(), valor);
        }
        return valor;
    }

    @Override
    public int sucessor(int chave) {
        if (inicio.getValor() == chave) {
            No aux = inicio.getProximo();
            return aux.getValor();
        }
        No aux = inicio.getProximo();
        return sucessor(aux, chave);
    }

    public int sucessor(No n, int chave) {
        if (n.getValor() == chave) {
            No aux = n.getProximo();
            return aux.getValor();
        }
        No aux = n.getProximo();
        return sucessor(aux, chave);
    }

    @Override
    public int prodessor(int chave) {
        if (inicio.getValor() == chave) {
            return inicio.getValor();
        }
        No aux = inicio.getProximo();
        if (aux.getValor() == chave) {
            return inicio.getValor();
        }
        return prodessor(aux.getProximo(), chave);
    }

    public int prodessor(No n, int chave) {
        No aux = n.getProximo();
        if (aux.getValor() == chave) {
            return n.getValor();
        }

        return prodessor(aux.getProximo(), chave);
    }
}
