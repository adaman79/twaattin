package com.twaattin.presenter;

import twitter4j.Status;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents.ComponentAttachEvent;
import com.vaadin.ui.HasComponents.ComponentAttachListener;
import com.vaadin.ui.Table;

public class TweetRefresherBehavior implements ComponentAttachListener {

	private static final long serialVersionUID = 8178470139050782838L;

	private BeanContainer<Long, Status> container;

	public void updateStatus(Status status) {
		if (container != null) {
			container.addBean(status);
		}
	}

	@Override
	public void componentAttachedToContainer(ComponentAttachEvent event) {
		Component component = event.getAttachedComponent();

		if (component instanceof Table) {
			Table table = (Table) component;

			container = (BeanContainer<Long, Status>) table
					.getContainerDataSource();

		}

	}

}
