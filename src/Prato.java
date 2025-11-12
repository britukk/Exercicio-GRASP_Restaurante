public class Prato {
    private String nome;
    private double preco;

    // Construtor
    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + String.format("%.2f", preco) + ")";
    }
}