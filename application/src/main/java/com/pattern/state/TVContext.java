package com.pattern.state;

public class TVContext implements State {

    private State tvState;

    public State getState() {
        return tvState;
    }

    public void setState(State state) {
        this.tvState = state;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }

}