public class Principal {

  public static void main(String[] args) {
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    votacao.cadastrarPessoaCandidata("Maria", 12345);
    votacao.cadastrarPessoaCandidata("José", 12345);
    votacao.cadastrarPessoaCandidata("José", 12346);

    System.out.println("Candidatos");
    for (PessoaCandidata candidato : votacao.pessoasCandidatas) {
      System.out.printf("Nome: %s\t número: %d\n", candidato.getNome(), candidato.getNumero());
    }

    votacao.cadastrarPessoaEleitora("Maria", "123.456.789-10");
    votacao.cadastrarPessoaEleitora("José", "123.456.789-10");
    votacao.cadastrarPessoaEleitora("José", "123.456.789-00");

    System.out.println("Eleitores");
    for (PessoaEleitora eleitor : votacao.pessoasEleitoras) {
      System.out.printf("Nome: %s\t cpf: %s\n", eleitor.getNome(), eleitor.getCpf());
    }

    votacao.votar("123", 123);
    votacao.votar("123.456.789-10", 12345);
    votacao.votar("123.456.789-10", 12345);
    votacao.votar("123.456.789-00", 0);


  }

}
