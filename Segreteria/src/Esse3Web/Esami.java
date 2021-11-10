package Esse3Web;

import java.util.ArrayList;

public class Esami {
	
	private String nome_esame;
	private int CFU;
	private boolean svolto;
	private int voto;
	private static ArrayList <Esami> esami = new ArrayList <>();
	studente studente;
	
	
	
	public Esami (String nome_esame, int CFU, boolean svolto)
	{
		this.nome_esame = nome_esame;
		this.CFU = CFU;
	}

	public int setVoto(int voto) {
		if(voto>0 && voto<=30)
			this.voto = voto;
		return voto;
	}
	
	public int getVoto()
	{
		return voto;
	}
	
	public String getNome_esame() {
		return nome_esame;
	}

	public void setNome_esame(String nome_esame) {
		this.nome_esame = nome_esame;
	}

	public int getCFU() {
		return CFU;
	}

	public void setCFU(int cFU) {
		CFU = cFU;
	}

	}
	



