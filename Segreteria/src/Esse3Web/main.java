package Esse3Web;
import java.util.*;

public class main {

	public static void main(String[] args) {
	    /*ArrayList <CorsoDiLaurea> Corso= new ArrayList<>();*/
		ArrayList <studente> Studente = new ArrayList<>();
	    Scanner in = new Scanner(System.in);
		System.out.println("Scegli corso di laurea che vuoi frequentare:");
		CorsoDiLaurea Corso = new CorsoDiLaurea(in.next());
		Byte scelta;
		studente alunno;
		Esami esame;
		
		do
		{
			
			System.out.println("Seleziona: \n0) Per uscire;");
			System.out.println("1)Iscrivere uno studente;");
			System.out.println("2)Cercare uno studente;");
			System.out.println("3)Ritirare uno studente;");
			System.out.println("4)Visualizzare gli studenti iscritti ad un corso di laurea;");
			System.out.println("5)Visualizzare gli studenti laureati ad un corso di laurea;");
			System.out.println("6)Login;");
			scelta=in.nextByte();
			switch(scelta)
			{
			case 0:
				System.out.println("Arrivederci!");
				break;
			case 1:
				System.out.println("Inserisci nome studente:");
				String nome = in.next();
				System.out.println("Inserisci cognome studente:");
				String cognome = in.next();
				alunno = new studente(nome+ " " +cognome);
				System.out.println("L'alunno è associato a questa matricola:" +alunno.getMatricola());
				Corso.addStudente(alunno);
				break;
			case 2:
				System.out.println("Matricola dello studente da cercare");
				if(Corso.cercaStudente(in.next()))
					System.out.println("Lo studente è presente in lista");
				else
					System.out.println("Lo studente non è in lista");
				break;
			case 3:
				System.out.println("Indicare la matricola dello studente da rimuovere:");
				if(Corso.removeStudente(in.next()))
					System.out.println("Lo studente è stato rimosso con successo");
				else
					System.out.println("Studente non rimosso");
				break;
			case 4:
				Corso.stampaLista();
				break;
			case 5:
				Corso.stampaListaLaureati();
				break;
			case 6:
				System.out.println("Inserisci nome dello studente");
				String nome2 = in.next();
				System.out.println("Cognome dello studente");
				String cognome2=in.next();
				String nome_cognome =nome2+" "+ cognome2;
				System.out.println("Inserire numero di matricola:");
				String matricola = in.next();
				
				if(Corso.login(nome_cognome,matricola))
				{
					System.out.println("Login eseguito con successo!");
					Byte Scelta;
					studente s = Corso.indice(matricola);
					do
					{
					
						System.out.println("Menù:");
					    System.out.println("0)Per uscire;");
					    System.out.println("1)Stampa piano di studio;");
					    System.out.println("2)Aggiungere un esame al piano di studio;");
					    System.out.println("3)Rimuovere un esame dal piano di studio;");
					    System.out.println("4)Cercare un esame;");
					    System.out.println("5)Promuovere uno studente;");
					    System.out.println("6)Visualizzare gli esami svolti ;");
					    System.out.println("7)Laureare studente");
					    Scelta = in.nextByte();
					    
					    switch(Scelta)
					    {
					    case 0:
					    	break;
					    case 1:
					    	s.stampaPiano();
					    	break;
					    case 2:
					    	System.out.println("Che esame vuoi aggiungere?");
					    	String nome1 = in.next();
					    	System.out.println("Quanti CFU?");
					    	int CFU = in.nextInt();
					    	esame = new Esami (nome1,CFU, false);
					    	s.addEsami(esame);
					    	break;
					    case 3:
					    	System.out.println("Che esame vuoi rimuovere?");
					    	if(s.removeEs(in.next()))
					    	{
					    		System.out.println("Esame rimosso con successo.");
					    	}
					    	else
					    		System.out.println("Non è stato possibile rimuovere l'esame");
					    	break;
					    case 4:
					    	System.out.println("Che esame vuoi cercare?");
					    	if (s.cercaEsame(in.next()))
					    	{
					    		System.out.println("L'esame è presente nella lista,");
					    	}
					    	else
					    		System.out.println("Esame non trovato!");
					    	break;
					    case 5:
					    	System.out.println("Quale esame è stato superato? ");
					    	String nomesame = in.next();
					    	System.out.println("Qual è il voto?");
					    	int Voto= in.nextInt();
					    	if(s.promosso(nomesame,Voto))
					    	{
					    		System.out.println("Studente promosso!");
					    	}
					    	else
					    		System.out.println("Studente bocciato!");
					    	break;
					    case 6:
					    	s.stampaEsSv();
					    	break;
					    case 7:
					    	s.Laureato(s.getNome_cognome());
					    	Corso.laureato(s);
					    	break;
					    	

					    	
					    	
					    	
					    	
					    }
					}while(Scelta != 0);
				}
					
				
			}
	
		}while(scelta != 0);
		
		

	}

}
