import java.util.Scanner;

public class Principal {

  static Scanner scanner = new Scanner(System.in);
  static GerenciamentoVotacao votacao = new GerenciamentoVotacao();

  public static void main(String[] args) {
    menu1();
    menu2();
    menu3();
  }

  public static void menu1() {

    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String option1 = scanner.next();
      if (option1.equals("1")) {
        cadatrarCandidato();
      } else if (option1.equals("2")) {
        break;
      } else {
        System.out.println("Opção inválida");
      }
    }
  }

  public static void cadatrarCandidato() {
    System.out.println("Entre com o nome da pessoa candidata: ");
    String nome = scanner.next();
    System.out.println("Entre com o número da pessoa candidata:");
    int numero = scanner.nextInt();
    votacao.cadastrarPessoaCandidata(nome, numero);
  }

  public static void menu2() {

    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String option2 = scanner.next();
      if (option2.equals("1")) {
        cadastrarEleitor();
      } else if (option2.equals("2")) {
        break;
      } else {
        System.out.println("Opção inválida");
      }
    }
  }

  public static void cadastrarEleitor() {
    System.out.println("Entre com o nome da pessoa eleitora: ");
    String nome = scanner.next();
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.next();
    votacao.cadastrarPessoaEleitora(nome, cpf);
  }

  public static void menu3() {

    label:
    while (true) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      String option3 = scanner.next();
      switch (option3) {
        case "1":
          votar();
          break;
        case "2":
          votacao.mostrarResultado();
          break;
        case "3":
          System.out.println("RESULTADO FINAL");
          votacao.mostrarResultado();
          break label;
        default:
          System.out.println("Opção inválida");
          break;
      }
    }
  }

  public static void votar() {
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.next();
    System.out.println("Entre com o número da pessoa candidata:");
    int numero = scanner.nextInt();
    votacao.votar(cpf, numero);
  }

}
