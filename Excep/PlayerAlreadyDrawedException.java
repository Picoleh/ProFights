package Excep;

public class PlayerAlreadyDrawedException extends Exception{
    public PlayerAlreadyDrawedException(){
        super("Jogador já pegou carta no deck");
    }
}
