package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null || battleResult.getWinner() == null) {
            return "No reward";
        }

        if (battleResult.getWinner().equals("Knight")) {
            return "100 gold + Epic Sword";
        }

        return "Better luck next time";
    }
}
