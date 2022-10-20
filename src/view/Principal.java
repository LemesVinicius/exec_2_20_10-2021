package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.leandrocolevati.filaint.*;

public class Principal
{
	public static void main(String[] args) throws IOException{
		
		int ultimaSenhaComum = 0;
		int ultimaSenhaPrioritaria = 0;
		int prioritariosChamados = 0;
	
		Fila filaPrioritarios = new Fila ();
		Fila filaComum = new Fila ();
		
		
		while(true) {
			
			System.out.println("Digite a opção \n 1 - Inserir uma nova senha na fila comum \n 2 - Inserir uma nova senha na fila prioritaria \n 3 - Chamar senha   ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			
			switch(s) {
			  case  "1":
				filaComum.insert(ultimaSenhaComum + 1);
				ultimaSenhaComum = ultimaSenhaComum + 1;
				System.out.println("Senha inserida: " + ultimaSenhaComum );
			    break;
			  case "2":
				filaPrioritarios.insert(ultimaSenhaPrioritaria + 1);
				ultimaSenhaPrioritaria = ultimaSenhaPrioritaria + 1;
				System.out.println("Senha inserida: PRIORITARIO " + ultimaSenhaPrioritaria );
			    break;
			  case "3":
				if(filaPrioritarios.isEmpty() && filaComum.isEmpty()) {
					System.out.println("Não há senhas a serem chamadas");
					break;
				}else if(filaPrioritarios.isEmpty()){
			    	System.out.println("Proxima senha: " + filaComum.remove());
			    }else {
			    	if(prioritariosChamados > 2) {
			    		System.out.println("Proxima senha: " + filaComum.remove());
			    		prioritariosChamados = 0;
			    	}else {
			    		System.out.println("Proxima senha: PRIORITARIO " + filaPrioritarios.remove());
			    		prioritariosChamados = prioritariosChamados + 1;
			    	}
			    }
			    break;  
			  default:
			    System.out.println("OPC invalida");
			    break;
			}
		
		}
	}
}