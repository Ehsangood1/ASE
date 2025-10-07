import { UIComponent } from './UIComponent.js';

export interface UIComponentFactory {
    createButton(): UIComponent;
    createCheckBox(): UIComponent;
}
