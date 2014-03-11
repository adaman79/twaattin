package com.twaattin;

import com.twaattin.client.DisableOnClickButtonRpc;
import com.twaattin.client.DisableOnClickButtonSharedState;
import com.vaadin.server.AbstractExtension;
import com.vaadin.shared.communication.ServerRpc;
import com.vaadin.ui.Button;

public class DisableOnClickButtonExtension extends AbstractExtension {

	private static final long serialVersionUID = 6351756864203325533L;

	private Button button;

	private ServerRpc rpc = new DisableOnClickButtonRpc() {

		private static final long serialVersionUID = -4476771730679455803L;

		@Override
		public void disableButton(String disabledLabel) {

			button.setCaption(disabledLabel);
			button.setEnabled(false);
		}
	};

	public DisableOnClickButtonExtension(String disabledLabel) {

		registerRpc(rpc);

		getState().setDisabledLabel(disabledLabel);
	}

	protected void extend(Button button) {

		this.button = button;

		super.extend(button);
	}

	@Override
	protected DisableOnClickButtonSharedState getState() {

		return (DisableOnClickButtonSharedState) super.getState();
	}

}
