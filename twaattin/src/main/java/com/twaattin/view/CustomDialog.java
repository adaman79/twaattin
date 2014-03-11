package com.twaattin.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class CustomDialog extends Window {

	private static final long serialVersionUID = -3639043580654276589L;
	private String clickValue;
	
	public CustomDialog() {
		setContent(this.new CustomDialogContent());
	}

	public String getClickValue() {
		return clickValue;
	}
	
	public class CustomDialogContent extends CustomComponent {

		private static final long serialVersionUID = 3677464638805137982L;
		private Label message = new Label("This is a confirm dialog");
		private Button yesButton = new Button("Yes");
		private Button cancelButton = new Button("Cancel");
		private Button noButton = new Button("No");
		
		public CustomDialogContent() {
			VerticalLayout mainLayout = new VerticalLayout();
			
			mainLayout.setMargin(true);
			mainLayout.setSpacing(true);
			
			setCompositionRoot(mainLayout);
			
			mainLayout.addComponent(message);
			
			HorizontalLayout buttonBar = new HorizontalLayout();
			buttonBar.setSpacing(true);
			
			mainLayout.addComponent(buttonBar);
			
			Button[] buttons = new Button[] {
					yesButton, noButton, cancelButton
			};
			
			for(final Button button : buttons) {
				buttonBar.addComponent(button);
				button.addClickListener(new ClickListener() {

					private static final long serialVersionUID = -3771224163095907732L;

					@Override
					public void buttonClick(ClickEvent event) {
						clickValue = button.getCaption();
						
						UI.getCurrent().removeWindow(CustomDialog.this);
					}
				});
			}
			
			
			
		}

	}

}
