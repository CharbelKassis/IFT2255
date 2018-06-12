package guichet.transaction;

import compte.Carte;
import compte.InformationCompte;
import compte.Message;
import compte.Recu;
import compte.Argent;
import compte.MessageFacture;
import guichet.Guichet;
import guichet.Session;
import guichet.physique.ConsoleClient;
import guichet.physique.ConsoleClient.Cancelled;

/** Representation d'une transation de payement de facture
 * 
 * @author Charbel Kassis
 *
 */
public class PayementFacture extends Transaction {
	
	/** Constructor
    *
    *  @param atm le guichet utilise pour communiquer avec le client
    *  @param session la session dans laquelle la transaction est realisee
    *  @param card la carte client
    *  @param pin le NIP entre par le client
    */
	protected PayementFacture(Guichet atm, Session session, Carte card, int pin) {
		
		super(atm,session,card,pin);

	}
	
    /** Recupere des details de la transaction avec le client
    *
    *  @return message a la banque pour initier cette transaction 
    *  @exception ConsoleClient.Cancelled si le client annule la transaction
    */
	protected Message getSpecificsFromCustomer() throws Cancelled {
		
        from = atm.getCustomerConsole().readMenuChoice(
                "Compte a partir duquel on paye la facture",
                InformationCompte.ACCOUNT_NAMES);
        
        billNumber = atm.getCustomerConsole().readBillNumber("Numero de la facture");
        
        amount = atm.getCustomerConsole().readAmount("Montant a payer"); 
		
		return new MessageFacture(billNumber,card,pin,serialNumber,from,amount);
	}
	
    /** Complete une transaction approuvee
    *
    *  @return recu a etre imprimer pour cette transaction
    */
	protected Recu completeTransaction() throws Cancelled {
		
		return new Recu(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[2];
                detailsPortion[0] = "PAYER FACTURE a partir de: " + 
                                    InformationCompte.ACCOUNT_ABBREVIATIONS[from];
      
                detailsPortion[1] = "Montant paye: " + amount.toString() + " pour la facture #"+ billNumber;
                			        
            }
        
		};
	}
	
	/**
	 * le compte d'utilisateur
	 */
	private int from;
	
	/**
	 * le numero de la facture
	 */
	private int billNumber;
	
	/**
	 * le montant que l'utilisateur veut payer pour la facture
	 */
	private Argent amount;

}
