package com.labourhiring.springbootproject.LabourHiring.model;

public class StateRequest {

	private State state;	
	public StateRequest() {
		
	}
	public StateRequest(State state) {
		super();
		this.state = state;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "StateRequest [state=" + state + "]";
	}   
	
}
