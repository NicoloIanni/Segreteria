package Esse3Web;
import java.util.*;

public class studente {
	Random generatore = new Random();
	private String nome_cognome;
	private String matricola;
	private int credititot = 0;
	private double media= 0;
	private ArrayList <Esami> pstudi = new ArrayList <>();
	private int idMatricola = 109000;
	private static ArrayList <Esami> Esamisvolti = new ArrayList <>();
	CorsoDiLaurea corso;
	

	public studente (String nome_cognome)
	{
		this.nome_cognome = nome_cognome;
		idMatricola += generatore.nextInt(19)+1;
		this.matricola = "s" + idMatricola;		
	}

	public String getNome_cognome() {
		return nome_cognome;
	}

    public void setNome_cognome(String nome_cognome) {
		this.nome_cognome = nome_cognome;
	}
	
	public void addPstudi (Esami es)
	{ 
		pstudi.add(es);		
	}
	
	public int getCredititot() {
		return credititot;
	}

	public void setCredititot(int credititot) {
		this.credititot = credititot;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public boolean removeEs (String esRim)
	{
		for (int i = 0; i < pstudi.size(); i++)
		{
			if(pstudi.get(i).getNome_esame().equals(esRim))
			{
				pstudi.remove(i);
				return true;
			}

		}
		
		return false;
	}

	public boolean cercaEsame (String es)
	{
		for(int i = 0; i<pstudi.size();i++)
		{
		   if(pstudi.get(i).getNome_esame().equals(es))
		   {
			   return true;
		   }
		}
	
	return false;
	}
	
	public void Laureato (String nome)
	{
		if(this.credititot >= corso.getCrediti_min())
			System.out.println("Congratulazione!");
		else
			System.out.println("I CFU miniminon sono stati raggiunti");
			
		
	}
	
	public boolean promosso ( String Esame, int voto)
	{
		for (int i = 0; i < pstudi.size();i++)
		{
			if (pstudi.get(i).getNome_esame().equals(Esame))
			{
				pstudi.get(i).setVoto(voto);
				if(pstudi.get(i).getVoto()>=18)
				{
				    this.credititot += pstudi.get(i).getCFU();
				    Esamisvolti.add(pstudi.get(i));
				    return true;
				}
			
		     }
		}
		return false;
	}
	
	public void addEsami(Esami es)
	{
		pstudi.add(es);
	}
	
	public void stampaEsSv() {
		for(int i = 0; i < Esamisvolti.size();i++)
		{
			System.out.println(Esamisvolti.get(i).getNome_esame()+ " "+ Esamisvolti.get(i).getCFU()+" "+Esamisvolti.get(i).getVoto() );
		}
	}
	
	public void stampaPiano() {
		for (int i =0; i<pstudi.size();i++)
		{
			System.out.println(pstudi.get(i).getNome_esame()+ " " +pstudi.get(i).getCFU());
		}
	}
	
	
	

}
	
	

	



