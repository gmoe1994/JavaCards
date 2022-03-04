package no.hiof.thomasjg.Model.TypeOfGames;

public class War implements IGameType {

    private static War warInstance = null;

    private War(){}


    @Override
    public void result() {
        // logic to determine the winner of the round based on the players cards
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
