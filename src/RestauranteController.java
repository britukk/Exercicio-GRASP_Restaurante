/**
 * CONTROLLER - Coordena as ações entre Model e View
 * GRASP: Controller - centraliza o controle do fluxo da aplicação
 * GRASP: Low Coupling - reduz acoplamento entre View e Model
 */
public class RestauranteController {
    private Restaurante restaurante;  // Model
    private RestauranteView view;     // View

    public RestauranteController(Restaurante restaurante, RestauranteView view) {
        this.restaurante = restaurante;
        this.view = view;
    }

    /**
     * Inicializa o restaurante e o menu
     */
    public void inicializarRestaurante() {
        view.exibirTitulo("Inicializando o Restaurante e Menu (GRASP: Creator)");
        // O menu já foi criado no construtor do Restaurante
        view.exibirMensagem("Menu preparado com " + restaurante.quantidadePratos() + " pratos disponíveis");
        view.exibirSeparador();
    }

    /**
     * Adiciona um prato ao menu do restaurante
     */
    public void adicionarPratoAoMenu(String nome, double preco) {
        restaurante.prepararPrato(nome, preco);
        Prato prato = restaurante.getPrato(nome);
        if (prato != null) {
            view.exibirPratoAdicionado(prato);
        }
    }

    /**
     * Cria uma nova conta para uma mesa
     */
    public ContaRestaurante criarConta(int numeroMesa) {
        view.exibirTitulo("Criando a Conta da Mesa " + numeroMesa + " (GRASP: Creator)");
        ContaRestaurante conta = new ContaRestaurante(numeroMesa);
        view.exibirContaCriada(numeroMesa);
        view.exibirSeparador();
        return conta;
    }

    /**
     * Adiciona um pedido à conta
     */
    public void adicionarPedido(ContaRestaurante conta, String nomePrato, int quantidade) {
        Prato prato = restaurante.getPrato(nomePrato);
        
        if (prato == null) {
            view.exibirErro("Prato '" + nomePrato + "' não encontrado no menu!");
            return;
        }

        if (quantidade <= 0) {
            view.exibirErro("Quantidade deve ser maior que zero!");
            return;
        }

        Pedido pedido = new Pedido(prato, quantidade);
        conta.adicionarPedido(pedido);
        view.exibirPedidoAdicionado(pedido);
    }

    /**
     * Finaliza a conta e exibe o total
     */
    public void finalizarConta(ContaRestaurante conta) {
        view.exibirTitulo("Calculando a Conta Final (GRASP: Information Expert)");
        
        // Exibe resumo dos itens
        view.exibirResumoItens(conta.getItensPedidos());
        
        // Calcula e exibe total
        double total = conta.calcularTotalConta();
        view.exibirTotalConta(conta.getNumeroMesa(), total);
        view.exibirSeparador();
    }

    /**
     * Executa o fluxo completo da aplicação
     */
    public void executarFluxoPrincipal() {
        // 1. Inicializa o restaurante
        inicializarRestaurante();

        // 2. Cria uma conta
        ContaRestaurante contaMesa5 = criarConta(5);

        // 3. Adiciona pedidos
        view.exibirTitulo("Adicionando Pedidos");
        adicionarPedido(contaMesa5, "Asinhas de Frango", 1);
        adicionarPedido(contaMesa5, "Frango à Parmegiana", 2);
        adicionarPedido(contaMesa5, "Suco de Laranja", 3);
        view.exibirSeparador();

        // 4. Finaliza a conta
        finalizarConta(contaMesa5);
    }
}