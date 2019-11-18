package swingy.model.villian;

public class Loki implements Villian {

    private int villian_X_Cor;
    private int villian_Y_Cor;

    @Override
    public String villianName() {
        return null;
    }

    @Override
    public String VllianFlag() {
        return null;
    }

    @Override
    public int villian_X_Cor() {
        return 0;
    }

    @Override
    public int villian_Y_Cor() {
        return 0;
    }

    @Override
    public int villian_Attack() {
        return 0;
    }

    @Override
    public int villian_Defence() {
        return 0;
    }

    @Override
    public int villian_HP() {
        return 0;
    }

    @Override
    public void setVillian_X_Cor(int villian_X_Cor) {
        this.villian_X_Cor = villian_X_Cor;
    }

    @Override
    public void setVillian_Y_Cor(int villian_Y_Cor) {
        this.villian_Y_Cor = villian_Y_Cor;
    }
}
