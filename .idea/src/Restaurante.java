import java.util.HashMap;
import java.util.Map;

public class Restaurante {
    // Armazena os pratos disponíveis no menu
    private Map<String, Prato> menu;

    // Construtor
    public Restaurante() {
        this.menu = new HashMap<>();
        // Inicializa o menu com alguns pratos de exemplo
        prepararPrato("Asinhas de Frango", 25.00);
        prepararPrato("Frango à Parmegiana", 35.50);
        prepararPrato("Suco de Laranja", 8.00);
    }

    // ** GRASP (Creator): 'Restaurante' tem os dados para inicializar um objeto 'Prato' e o utiliza diretamente
    // (por exemplo, adicionando ao seu menu). Portanto, o 'Restaurante' é o Creator de objetos 'Prato'.
    public void prepararPrato(String nome, double preco) {
        // 'Restaurante' cria (instancia) o 'Prato'
        Prato novoPrato = new Prato(nome, preco);
        menu.put(nome, novoPrato);
        System.out.println("Prato preparado e adicionado ao menu: " + novoPrato);
    }

    // Método que demonstra o uso dos objetos criados
    public Prato getPrato(String nome) {
        return menu.get(nome);
    }

    // Fluxo principal
    public static void main(String[] args) {
        System.out.println("--- Inicializando o Restaurante e Menu (GRASP: Creator) ---");
        Restaurante meuRestaurante = new Restaurante();
        System.out.println("----------------------------------------------------------\n");

        System.out.println("--- Criando a Conta da Mesa 5 (GRASP: Creator) ---");
        // O Restaurante (ou um sistema que o gerencia) pode ser o Creator da Conta
        // O sistema cria a Conta
        ContaRestaurante contaMesa5 = new ContaRestaurante(5);
        System.out.println("----------------------------------------------------------\n");

        System.out.println("--- Adicionando Pedidos ---");
        // Pega os pratos do menu
        Prato asinhas = meuRestaurante.getPrato("Asinhas de Frango");
        Prato frango = meuRestaurante.getPrato("Frango à Parmegiana");
        Prato suco = meuRestaurante.getPrato("Suco de Laranja");

        // Adiciona pedidos à conta
        contaMesa5.adicionarPedido(new Pedido(asinhas, 1));
        contaMesa5.adicionarPedido(new Pedido(frango, 2));
        contaMesa5.adicionarPedido(new Pedido(suco, 3));
        System.out.println("----------------------------------------------------------\n");


        System.out.println("--- Calculando a Conta Final (GRASP: Information Expert) ---");
        double total = contaMesa5.calcularTotalConta();
        System.out.println("Total da Conta para a Mesa: " + contaMesa5.getNumeroMesa() + "R$ " + String.format("%.2f", total));
        System.out.println("----------------------------------------------------------");
    }
}