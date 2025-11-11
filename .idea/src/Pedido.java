public class Pedido {
    private Prato prato;
    private int quantidade;

    // Construtor
    public Pedido(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }

    // Getters
    public Prato getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Método para calcular o subtotal deste item do pedido.
    // GRASP (Information Expert): 'Pedido' é o especialista na sua própria informação (preço do prato e quantidade) e,
    // portanto, tem a responsabilidade de calcular seu próprio subtotal.
    public double calcularSubTotal() {
        return prato.getPreco() * quantidade;
    }
}