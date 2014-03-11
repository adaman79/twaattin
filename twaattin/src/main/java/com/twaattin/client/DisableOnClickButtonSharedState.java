package com.twaattin.client;

import com.vaadin.shared.communication.SharedState;

public class DisableOnClickButtonSharedState extends SharedState {

	private static final long serialVersionUID = -7643493773624394738L;
	private String disabledLabel;

	public String getDisabledLabel() {
		return disabledLabel;
	}

	public void setDisabledLabel(String disabledLabel) {
		this.disabledLabel = disabledLabel;
	}
}
