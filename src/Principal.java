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

  }

}
