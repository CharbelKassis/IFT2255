 package compte;/** Representation des montants d'argent */public class Argent{    /** Constructeur     *     *  @param dollars montant total en dollar     */    public Argent(int dollars)    {        this(dollars, 0);    }        /** Constructeurr     *     *  @param dollars partie dollar du montant      *  @param cents partie cents du montant     */    public Argent(int dollars, int cents)    {        this.cents = 100L * dollars + cents;    }        /** Copy constructeur     *     *  @param toCopy objet Argent a copier     */    public Argent(Argent toCopy)    {        this.cents = toCopy.cents;    }        /** Cree une representation String du montant      *     *  @return string representation de ce montant     */    public String toString()    {        return "$" + cents/100 +             (cents %100 >= 10  ? "." + cents % 100 : ".0" + cents % 100);    }        /** Ajoute un montant d'argent a celui-ci     *     *  @param amountToAdd le montant a rajouter     */    public void add(Argent amountToAdd)    {        this.cents += amountToAdd.cents;    }        /** Soutrait un montant d'argent a celui-ci     *     *  @param amountToSubtract le montant a soustraire     *     *  Precondition: montant soustrait <= ce montant     */    public void subtract(Argent amountToSubtract)    {        this.cents -= amountToSubtract.cents;    }        /** Comparer a un autre montant     *     *  @param compareTo le montant a comparer     *  @return true si ce montant <= compareTo      */    public boolean lessEqual(Argent compareTo)    {        return this.cents <= compareTo.cents;    }        /** Variable d'instance: ce montant represente par le nombre de cents      */    private long cents; }