package Models.EffectsModels;

public class Effect {
    public int turnosRestantes;
    public EffectsType type;
    public int value;
    public Effect(int turnosRestantes, EffectsType type, int value){
        this.turnosRestantes = turnosRestantes;
        this.type = type;
        this.value = value;
    }

    public void passaTurno(){
        turnosRestantes--;
    }
}
