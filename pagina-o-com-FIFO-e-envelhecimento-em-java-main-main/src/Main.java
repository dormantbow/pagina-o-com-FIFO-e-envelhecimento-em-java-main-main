import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Pagina> memoriaRam = Pagina.gerarPaginas(10);
		
		System.out.println("\n\n ************************************************************** \n\n");
		for( int index=0; index < memoriaRam.size(); index++) {
			memoriaRam.get(index).imprimirPag();
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("\n \n SEGUINDO O MODO DE PAGINA��O FIFO A PR�XIMA "
				+ "\n PAGINA A SER SUBSTITUIDA �: \n\n");
		Pagina.substituicaoFifo(memoriaRam).imprimirPag();
		
		System.out.println("\n \n SEGUINDO O MODO DE ENVELHECIMENTO PARA  SUBSTITUI��O "
				+ "\n A PR�XIMA P�GINA A SER SUBSTITUIDA �: \n\n");
		Pagina.substituicaoEnvelhecimento(memoriaRam).imprimirPag();
		System.out.println("----------------------------------------------------------------");
		
	}

}
