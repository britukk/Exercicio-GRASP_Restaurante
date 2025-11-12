import java.util.List;

/**
 * VIEW - Responsável por toda a interação visual com o usuário
 * GRASP: Separação de Responsabilidades (não mistura lógica de negócio com apresentação)
 */
public class RestauranteView {

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    public void exibirSeparador() {
        System.out.println("----------------------------------------------------------");
    }
    public void exibirTitulo(String titulo) {
        System.out.println("\n--- " + titulo + " ---");
    }
    public void exibirPratoAdicionado(Prato prato) {
        System.out.println("Prato preparado e adicionado ao menu: " + prato);
    }

    public void exibirPedidoAdicionado(Pedido pedido) {
        System.out.println("-> Pedido adicionado: " + pedido.getPrato().getNome() + 
                            " (x" + pedido.getQuantidade() + ")");
    }

    public void exibirContaCriada(int numeroMesa) {
        System.out.println("Conta criada para a Mesa " + numeroMesa);
    }

    public void exibirResumoItens(List<Pedido> itens) {
        System.out.println("\n=== Resumo dos Itens ===");
        for (Pedido pedido : itens) {
            System.out.printf("%dx %s - R$ %.2f%n", 
                pedido.getQuantidade(),
                pedido.getPrato().getNome(),
                pedido.calcularSubTotal());
        }
    }

    public void exibirTotalConta(int numeroMesa, double total) {
        System.out.println("\n=== Total da Conta ===");
        System.out.printf("Mesa %d: R$ %.2f%n", numeroMesa, total);
    }

    public void exibirErro(String mensagem) {
        System.err.println("ERRO: " + mensagem);
    }
}