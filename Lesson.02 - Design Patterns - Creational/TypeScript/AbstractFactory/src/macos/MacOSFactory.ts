import { UIComponent } from '../UIComponent.js';
import { UIComponentFactory } from '../UIComponentFactory.js';
import { MacOSButton } from './MacOSButton.js';
import { MacOSCheckBox } from './MacOSCheckBox.js';

export class MacOSFactory implements UIComponentFactory {
    createButton(): UIComponent {
        return new MacOSButton();
    }

    createCheckBox(): UIComponent {
        return new MacOSCheckBox();
    }
}
