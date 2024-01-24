import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {

    boolean isRepeated = false;
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        isRepeated = true;
        break;
      }
    }
    if (!isRepeated) {
      PessoaCandidata pessoaCandidata =  new PessoaCandidata(nome, numero);
      System.out.println("Pessoa candidata cadastrada com sucesso!");
      pessoasCandidatas.add(pessoaCandidata);
    }

  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {

    boolean isRepeated = false;
    for (PessoaEleitora eleitor : pessoasEleitoras) {
      if (eleitor.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        isRepeated = true;
        break;
      }
    }
    if (!isRepeated) {
      PessoaEleitora pessoaEleitora =  new PessoaEleitora(nome, cpf);
      System.out.println("Pessoa eleitora cadastrada com sucesso!");
      pessoasEleitoras.add(pessoaEleitora);
    }

  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    boolean isVoter = false;
    for (PessoaEleitora eleitor : pessoasEleitoras) {
      if (cpfPessoaEleitora.equals(eleitor.getCpf())) {
        isVoter = true;
      }
    }
    if (!isVoter) {
      System.out.println("Eleitor não cadastrado");
      return;
    }

    for (String cpfEleitor : cpfsComputados) {
      if (cpfEleitor.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
        System.out.println("Voto OK");
        cpfsComputados.add(cpfPessoaEleitora);
        return;
      }
    }

    System.out.println("Voto Nulo");
    cpfsComputados.add(cpfPessoaEleitora);

  }

  @Override
  public void mostrarResultado() {

  }

}
