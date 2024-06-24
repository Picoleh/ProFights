package Excep;

public class OutOfCardsException extends Exception{
    public OutOfCardsException(){
        super("Não há cartas restantes no deck");
    }
}
