import java.util.ArrayList;
import java.util.List;

public class ContaRestaurante {
    private int numeroMesa;
    private List<Pedido> itensPedidos;

    // Construtor
    public ContaRestaurante(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.itensPedidos = new ArrayList<>();
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public List<Pedido> getItensPedidos() {
        return itensPedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        this.itensPedidos.add(pedido);
        System.out.println("-> Pedido adicionado: " + pedido.getPrato().getNome() + " (x" + pedido.getQuantidade() + ")");
    }

    // GRASP (Information Expert): 'ContaRestaurante' possui a coleção de todos os Pedidos (itensPedidos).
    // Portanto, ela tem a responsabilidade de calcular o total final da conta, pois é o especialista nos dados
    // necessários (lista de pedidos).
    public double calcularTotalConta() {
        double total = 0.0;
        for (Pedido pedido : itensPedidos) {
            total += pedido.calcularSubTotal();
        }
        return total;
    }
}