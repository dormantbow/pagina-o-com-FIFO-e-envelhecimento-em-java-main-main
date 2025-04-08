import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Pagina> memoriaRam = Pagina.gerarPaginas(10);
		
		System.out.println("\n\n ************************************************************** \n\n");
		for( int index=0; index < memoriaRam.size(); index++) {
			memoriaRam.get(index).imprimirPag();
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("\n \n SEGUINDO O MODO DE PAGINAÇÃO FIFO A PRÓXIMA "
				+ "\n PAGINA A SER SUBSTITUIDA É: \n\n");
		Pagina.substituicaoFifo(memoriaRam).imprimirPag();
		
		System.out.println("\n \n SEGUINDO O MODO DE ENVELHECIMENTO PARA  SUBSTITUIÇÃO "
				+ "\n A PRÓXIMA PÁGINA A SER SUBSTITUIDA É: \n\n");
		Pagina.substituicaoEnvelhecimento(memoriaRam).imprimirPag();
		System.out.println("----------------------------------------------------------------");
		
	}

}
