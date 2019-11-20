package swingy.model.villain;

public class Thanos implements Villain {

    private int villain_X_Cor;
    private int villain_Y_Cor;

    @Override
    public void setVillain_X_Cor(int villain_X_Cor) {
        this.villain_X_Cor = villain_X_Cor;
    }

    @Override
    public void setVillain_Y_Cor(int villain_Y_Cor) {
        this.villain_Y_Cor = villain_Y_Cor;
    }

    @Override
    public String villainName() {
        return "Thanos";
    }

    @Override
    public String villainFlag() {
        return "T";
    }

    @Override
    public int villain_X_Cor() {
        return this.villain_X_Cor;
    }

    @Override
    public int villain_Y_Cor() {
        return this.villain_Y_Cor;
    }

    @Override
    public int villain_Attack() {
        return 400;
    }

    @Override
    public int villain_Defence() {
        return 390;
    }

    @Override
    public int villain_HP() {
        return 600;
    }
}
