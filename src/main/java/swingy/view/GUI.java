package swingy.view;
import swingy.model.GameData;
import swingy.utils_swingy.SwingyUtils;

import javax.swing.*;

public class GUI implements IDisplay {
    GameData gameData = new GameData();
    SwingyUtils utils = new SwingyUtils();

    @Override
    public void initGame() {

        JOptionPane.showMessageDialog(null,gameData.getGameBeginHeader());
//        JFrame header =  new JFrame();
//
//        header.add(gameData.gameBeginHeader());
//
//        header.setSize(800,800);
//        header.setLayout(null);
//        header.setVisible(true);
    }
}
