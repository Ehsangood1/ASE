import { UIComponent } from '../UIComponent.js';
import { UIComponentFactory } from '../UIComponentFactory.js';
import { WindowsButton } from './WindowsButton.js';
import { WindowsCheckBox } from './WindowsCheckBox.js';

export class WindowsFactory implements UIComponentFactory {
    createButton(): UIComponent {
        return new WindowsButton();
    }

    createCheckBox(): UIComponent {
        return new WindowsCheckBox();
    }
}
