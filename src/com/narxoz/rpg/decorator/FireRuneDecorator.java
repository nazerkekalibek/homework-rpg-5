package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName()+ "+ fire rune";
    }

    @Override
    public int getDamage() {
        return super.getDamage()+10;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary()+ ", burning damage";
    }
}
