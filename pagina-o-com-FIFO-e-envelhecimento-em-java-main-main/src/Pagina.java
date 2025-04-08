import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Pagina {
	private int id;
	private int carga;
	private int ultimaReferencia;
	private int bitReferencia;
	private int bitModificacao;
	private int contador[];
	private Integer contadorEmDecimal;

	/*
	 * RETORNA UMA LISTA DE PAGINAS REPRESENTA A MEMORIA RAM
	 */
	public Pagina() {
		super();
		contador = new int[8];
	}

	public static List<Pagina> gerarPaginas(int quantidade) {

		Random gerador = new Random();
		List<Pagina> memoriaRam = new ArrayList<Pagina>();
		Pagina pagina;

		for (int index = 0; index < quantidade; index++) {
			pagina = new Pagina();
			pagina.setId(index);
			// de 100 a 200
			pagina.setCarga(gerador.nextInt(101) + 100);
			// de 200 a 300
			pagina.setUltimaReferencia(gerador.nextInt(101) + 200);
			// 0 a 1
			pagina.setBitReferencia(sorteiaBinario());
			pagina.setBitModificacao(sorteiaBinario());
			memoriaRam.add(pagina);

			// Sorteando os valores do contador
			for (int i = 0; i < pagina.getContador().length; i++) {
				pagina.getContador()[i] = sorteiaBinario();
			}

			pagina.setContadorEmDecimal(Integer.parseInt(arrayEmString(pagina.getContador()), 2));
		}
		return memoriaRam;
	}

	public static int sorteiaBinario() {
		Random gerador = new Random();
		return gerador.nextInt(2);
	}

	public static Pagina substituicaoFifo(List<Pagina> lista) {

		Pagina maisAntiga = lista.get(0);
		for (int index = 1; index < lista.size(); index++) {
			if (lista.get(index).getCarga() < maisAntiga.getCarga()) {
				maisAntiga = lista.get(index);
			}
		}
		return maisAntiga;
	}

	public static Pagina substituicaoEnvelhecimento(List<Pagina> lista) {

		Pagina maisVelho = lista.get(0);

		for (int index = 1; index < lista.size(); index++) {

			if (maisVelho.getContadorEmDecimal() > lista.get(index).getContadorEmDecimal()) {
				maisVelho = lista.get(index);
			}
		}
		return maisVelho;

	}

	public void imprimirPag() {
		String binario = "";
		for (int i = 0; i < this.getContador().length; i++) {
			binario += this.getContador()[i];
		}

		System.out.println("----------------------------------------------------------------");
		System.out.println("Id: " + this.getId() + " | Carga: " + this.getCarga() + " | Ult. Ref: "
				+ this.getUltimaReferencia() + " | Bit Ref: " + this.getBitReferencia() + " | Bit Mod: "
				+ this.getBitModificacao() + " | Cont.: " + binario + " | Cont. Dec: " + this.getContadorEmDecimal());

	}

	public static String arrayEmString(int array[]) {
		String string = "";
		for (int i = 0; i < array.length; i++) {
			string += array[i];
		}
		return string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public int getUltimaReferencia() {
		return ultimaReferencia;
	}

	public void setUltimaReferencia(int ultimaReferencia) {
		this.ultimaReferencia = ultimaReferencia;
	}

	public int getBitReferencia() {
		return bitReferencia;
	}

	public void setBitReferencia(int bitReferencia) {
		this.bitReferencia = bitReferencia;
	}

	public int getBitModificacao() {
		return bitModificacao;
	}

	public void setBitModificacao(int bitModificacao) {
		this.bitModificacao = bitModificacao;
	}

	public int[] getContador() {
		return contador;
	}

	public void setContador(int[] contador) {
		this.contador = contador;
	}

	public Integer getContadorEmDecimal() {
		return contadorEmDecimal;
	}

	public void setContadorEmDecimal(Integer contadorEmDecimal) {
		this.contadorEmDecimal = contadorEmDecimal;
	}

}
