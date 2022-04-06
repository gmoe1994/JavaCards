package no.hiof.thomasjg.Model.TypeOfGames;

import no.hiof.thomasjg.Model.IGameType;

public class War implements IGameType {

    private static War warInstance = null;

    private War(){}


    @Override
    public void result() {

    }

    @Override
    public void gameLoop() {
        // logic for how the game is played
    }

    public static War getInstance(){
        if (warInstance == null){
            warInstance = new War();
        }
        return warInstance;
    }


}
