import java.util.ArrayList;
import java.util.List;

/**
 * MODEL - Representa uma conta de restaurante
 * GRASP (Information Expert): Calcula o total da conta
 * Agora sem System.out (responsabilidade da View)
 */
public class ContaRestaurante {
    private int numeroMesa;
    private List<Pedido> itensPedidos;

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
        // System.out removido - agora é responsabilidade da View
    }

    /**
     * GRASP (Information Expert): 'ContaRestaurante' possui a coleção de todos os Pedidos.
     * Portanto, ela tem a responsabilidade de calcular o total final da conta.
     */
    public double calcularTotalConta() {
        double total = 0.0;
        for (Pedido pedido : itensPedidos) {
            total += pedido.calcularSubTotal();
        }
        return total;
    }
}