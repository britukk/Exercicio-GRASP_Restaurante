/**
 * Classe principal da aplicação
 * Responsável por inicializar o padrão MVC e executar o sistema
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  SISTEMA DE GERENCIAMENTO - RESTAURANTE");
        System.out.println("  Padrões: MVC + GRASP");
        System.out.println("========================================\n");

        // Instancia os componentes do MVC
        Restaurante restaurante = new Restaurante();           // MODEL
        RestauranteView view = new RestauranteView();          // VIEW
        RestauranteController controller = new RestauranteController(restaurante, view); // CONTROLLER

        // Executa o fluxo da aplicação através do Controller
        controller.executarFluxoPrincipal();

        System.out.println("\n========================================");
        System.out.println("  Sistema finalizado com sucesso!");
        System.out.println("========================================");
    }
}