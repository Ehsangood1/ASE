import { UIComponent } from '../UIComponent.js';

export class WindowsButton implements UIComponent {
    private button: HTMLButtonElement;

    constructor() {
        this.button = document.createElement('button');
        this.button.textContent = 'Windows Button';
        this.button.className = 'windows-button';
        this.applyWindowsStyles();
    }

    render(): HTMLElement {
        return this.button;
    }

    private applyWindowsStyles(): void {
        this.button.style.cssText = `
            background-color: #0078d4;
            color: white;
            border: 1px solid #106ebe;
            padding: 8px 16px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-size: 14px;
            border-radius: 2px;
            cursor: pointer;
            transition: background-color 0.2s;
        `;

        this.button.addEventListener('mouseenter', () => {
            this.button.style.backgroundColor = '#106ebe';
        });

        this.button.addEventListener('mouseleave', () => {
            this.button.style.backgroundColor = '#0078d4';
        });
    }
}
