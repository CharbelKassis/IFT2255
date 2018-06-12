package compte;

import compte.Argent;
import compte.Carte;
import compte.Message;

/**
 * Representations d'un message de type facture du guichet vers la banque.
 * @author Charbel Kassis
 *
 */

public class MessageFacture extends Message {
	
	/** Constructor
	 * 
	 * @param billNumber le numero de la facture
	 * @param card la carte du client
	 * @param pin Le PIN entre par le client
     * @param serialNumber le numero de serie de la transaction
     * @param fromAccount le type du compte source de la transaction - peut etre -1 si 
     *  	   la trasaction ne necessite pas de compte source (ex. depot)
     * @param amount le montant de la transaction - peut etre null 
     *  	   si la transaction n'a pas de montant (ex. une demande de solde)
     */
	public MessageFacture(int billNumber, Carte card, int pin, int serialNumber, int fromAccount,
			Argent amount) {
		
		super(BILL_PAYEMENT, card, pin, serialNumber, fromAccount, -1, amount);
		
		this.billNumber = billNumber;
	}
	
    /** Cree une representation string imprimable du message
    *
    *  @return representation string 
    */
	public String toString() {
		
		String message = super.toString();
		message+= " BILL NUMBER:" + billNumber;
		
		return message;
	}	
	
	/** le numero de la facture
	 * 
	 */
	private int billNumber;
	
	/**
	 * 
	 * @return le numero de la facture
	 */
	public int getBillNumber() {
		
		return this.billNumber;
	}
	
}
