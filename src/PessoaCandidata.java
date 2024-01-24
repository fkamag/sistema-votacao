public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return this.votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
