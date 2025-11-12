import java.util.HashMap;
import java.util.Map;

/**
 * MODEL - Representa o restaurante e seu menu
 * GRASP (Creator): Cria objetos Prato
 * Agora sem lógica de apresentação (apenas Model)
 */
public class Restaurante {
    private Map<String, Prato> menu;

    public Restaurante() {
        this.menu = new HashMap<>();
        // Inicializa o menu com alguns pratos de exemplo
        prepararPrato("Asinhas de Frango", 25.00);
        prepararPrato("Frango à Parmegiana", 35.50);
        prepararPrato("Suco de Laranja", 8.00);
    }

    /**
     * GRASP (Creator): 'Restaurante' tem os dados para inicializar um objeto 'Prato' 
     * e o utiliza diretamente. Portanto, o 'Restaurante' é o Creator de objetos 'Prato'.
     */
    public void prepararPrato(String nome, double preco) {
        Prato novoPrato = new Prato(nome, preco);
        menu.put(nome, novoPrato);
    }

    public Prato getPrato(String nome) {
        return menu.get(nome);
    }

    public int quantidadePratos() {
        return menu.size();
    }

    public Map<String, Prato> getMenu() {
        return new HashMap<>(menu); // Retorna cópia para proteger encapsulamento
    }


}