package swingy.model.villian;

public class Loki implements Villian {

    private int villian_X_Cor;
    private int villian_Y_Cor;

    @Override
    public void setVillian_X_Cor(int villian_X_Cor) {
        this.villian_X_Cor = villian_X_Cor;
    }

    @Override
    public void setVillian_Y_Cor(int villian_Y_Cor) {
        this.villian_Y_Cor = villian_Y_Cor;
    }

    @Override
    public String villianName() {
        return "Loki";
    }

    @Override
    public String VllianFlag() {
        return "L";
    }

    @Override
    public int villian_X_Cor() {
        return this.villian_X_Cor;
    }

    @Override
    public int villian_Y_Cor() {
        return this.villian_Y_Cor;
    }

    @Override
    public int villian_Attack() {
        return 50;
    }

    @Override
    public int villian_Defence() {
        return 50;
    }

    @Override
    public int villian_HP() {
        return 210;
    }
}
