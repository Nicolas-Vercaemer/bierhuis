package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.vdab.entities.Bier;

@Embeddable
public class BestelbonLijn implements Serializable {
	private static final long serialVersionUID = 1L;
	private int aantal;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bierNr")
	private Bier bier;
	
	protected BestelbonLijn(){
		
	}
	
	public int getAantal() {
		return aantal;
	}

	public Bier getBier() {
		return bier;
	}

	public BestelbonLijn(int aantal, Bier bier){
		this.aantal=aantal;
		this.bier=bier;
	}
	
	public BigDecimal getTotaal() {
		return bier.getPrijs().multiply(BigDecimal.valueOf(aantal));
	}
	@Override
	public boolean equals(Object object){
		if(!(object instanceof BestelbonLijn)){
			return false;
		}
		else{
			BestelbonLijn andereBestelbonLijn = (BestelbonLijn) object;
			return(bier.getNaam().equals(andereBestelbonLijn.getBier().getNaam()) && 
					bier.getBrouwer().getNaam().equals(andereBestelbonLijn.getBier().getBrouwer().getNaam()));
		}
	}
	@Override
	public int hashCode() {
		String hashCode = bier.getNaam()+bier.getBrouwer().getNaam();
		return hashCode.hashCode();
	}

}
