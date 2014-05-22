package com.twaattin.presenter;

import twitter4j.Status;

import com.twaattin.model.StatusDto;
import com.twaattin.view.StatusComponent;
import com.twaattin.view.StatusConverter;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents.ComponentAttachEvent;
import com.vaadin.ui.HasComponents.ComponentAttachListener;
import com.vaadin.ui.Layout;

public class TweetRefresherBehavior implements ComponentAttachListener {

	private static final long serialVersionUID = 8178470139050782838L;

	private Layout layout;

	public void updatedStatus(Status status) {

		if (layout != null) {

			StatusConverter converter = new StatusConverter();

			StatusDto dto = converter.convert(status);

			StatusComponent statusComponent = new StatusComponent(dto);

			layout.addComponent(statusComponent);
		}
	}

	@Override
	public void componentAttachedToContainer(ComponentAttachEvent event) {

		Component component = event.getAttachedComponent();

		if (component instanceof Layout) {

			layout = (Layout) component;
		}
	}
}
