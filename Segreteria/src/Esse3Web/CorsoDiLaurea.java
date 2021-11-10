package Esse3Web;

import java.util.ArrayList;

public class CorsoDiLaurea {
	
	private String nome;
	private static int crediti_min=51;
	private static ArrayList <studente> listaStudenti = new ArrayList <>();
	private static ArrayList <studente> listaStudentiLaureati = new ArrayList <>();
	studente s;
	

	public studente indice(String matricola)
	{
		int index =0;
		for(int i = 0; i < listaStudenti.size();i++)
		{
			if(listaStudenti.get(i).getMatricola().equals(matricola))
			index = i;
		}
		return listaStudenti.get(index);
	}
	
	public CorsoDiLaurea(String nome)
	{
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

	public static int getCrediti_min() {
		return crediti_min;
	}
	
	public void addStudente(studente studente)
	{
		listaStudenti.add(studente);
	}
	
	public boolean removeStudente(String matricola)
	{
		for(int i = 0; i < listaStudenti.size();i++)
		{
			if(listaStudenti.get(i).getMatricola().equals(matricola))
			{
				listaStudenti.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean cercaStudente(String matricola)
	{
		for(int i = 0; i<listaStudenti.size();i++)
			{
			   if(listaStudenti.get(i).getMatricola().equals(matricola))
			   {
				   return true;
			   }
			}
		
		return false;
	}
	
	
	public void stampaLista()
	{
		for(int i = 0; i < listaStudenti.size();i++)
		{
			System.out.println("Lo studente si chiama:" + listaStudenti.get(i).getNome_cognome() +" ha la matricola:"+listaStudenti.get(i).getMatricola());

		}
	}
	
	
	public void stampaListaLaureati()
	{
		for(int i = 0; i < listaStudentiLaureati.size();i++)
		{
			System.out.println("Lo studente si chiama:" + listaStudentiLaureati.get(i).getNome_cognome()+" ha la matricola:"+listaStudentiLaureati.get(i).getMatricola());
		}
	}
	
	
    public boolean login(String nome_cognome,String matricola)
	{
		for(int i = 0; i < listaStudenti.size();i++)
		{
			if (listaStudenti.get(i).getNome_cognome().equals(nome_cognome) && listaStudenti.get(i).getMatricola().equals(matricola))
				return true;
		}
		return false;
	}
	
	
	public void laureato(studente studente)
	{
		for (int i=0;i<listaStudenti.size();i++)
			if(listaStudenti.get(i).equals(studente)) 
			{
				listaStudentiLaureati.add(studente);
				listaStudenti.remove(i);
			}
	}
	

}

	
	
	


