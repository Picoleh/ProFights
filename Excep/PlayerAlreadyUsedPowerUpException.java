package Excep;

public class PlayerAlreadyUsedPowerUpException extends Exception{
    public PlayerAlreadyUsedPowerUpException(){
        super("Ja utilizou o poder especial de uma carta nesse turno");
    }
}
