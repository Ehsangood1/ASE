import { UIComponent } from '../UIComponent.js';

export class WindowsCheckBox implements UIComponent {
    private container: HTMLDivElement;
    private checkbox: HTMLInputElement;
    private label: HTMLLabelElement;

    constructor() {
        this.container = document.createElement('div');
        this.checkbox = document.createElement('input');
        this.label = document.createElement('label');

        this.checkbox.type = 'checkbox';
        this.checkbox.id = 'windows-checkbox-' + Math.random().toString(36).substr(2, 9);
        this.checkbox.className = 'windows-checkbox';

        this.label.textContent = 'Windows CheckBox';
        this.label.htmlFor = this.checkbox.id;
        this.label.className = 'windows-checkbox-label';

        this.container.appendChild(this.checkbox);
        this.container.appendChild(this.label);

        this.applyWindowsStyles();
    }

    render(): HTMLElement {
        return this.container;
    }

    private applyWindowsStyles(): void {
        this.container.style.cssText = `
            display: flex;
            align-items: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 14px;
            gap: 8px;
        `;

        this.checkbox.style.cssText = `
            width: 16px;
            height: 16px;
            accent-color: #0078d4;
            cursor: pointer;
        `;

        this.label.style.cssText = `
            color: #323130;
            cursor: pointer;
            user-select: none;
        `;
    }
}
