import { UIComponent } from '../UIComponent.js';

export class MacOSCheckBox implements UIComponent {
    private container: HTMLDivElement;
    private checkbox: HTMLInputElement;
    private label: HTMLLabelElement;

    constructor() {
        this.container = document.createElement('div');
        this.checkbox = document.createElement('input');
        this.label = document.createElement('label');

        this.checkbox.type = 'checkbox';
        this.checkbox.id = 'macos-checkbox-' + Math.random().toString(36).substr(2, 9);
        this.checkbox.className = 'macos-checkbox';

        this.label.textContent = 'MacOS CheckBox';
        this.label.htmlFor = this.checkbox.id;
        this.label.className = 'macos-checkbox-label';

        this.container.appendChild(this.checkbox);
        this.container.appendChild(this.label);

        this.applyMacOSStyles();
    }

    render(): HTMLElement {
        return this.container;
    }

    private applyMacOSStyles(): void {
        this.container.style.cssText = `
            display: flex;
            align-items: center;
            font-family: -apple-system, BlinkMacSystemFont, 'SF Pro Display', sans-serif;
            font-size: 13px;
            gap: 8px;
        `;

        this.checkbox.style.cssText = `
            width: 18px;
            height: 18px;
            accent-color: #007AFF;
            cursor: pointer;
            border-radius: 3px;
        `;

        this.label.style.cssText = `
            color: #1d1d1f;
            cursor: pointer;
            user-select: none;
            font-weight: 400;
        `;
    }
}
