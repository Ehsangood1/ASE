import { UIComponent } from '../UIComponent.js';

export class MacOSButton implements UIComponent {
    private button: HTMLButtonElement;

    constructor() {
        this.button = document.createElement('button');
        this.button.textContent = 'MacOS Button';
        this.button.className = 'macos-button';
        this.applyMacOSStyles();
    }

    render(): HTMLElement {
        return this.button;
    }

    private applyMacOSStyles(): void {
        this.button.style.cssText = `
            background: linear-gradient(180deg, #007AFF 0%, #0051D5 100%);
            color: white;
            border: none;
            padding: 8px 16px;
            font-family: -apple-system, BlinkMacSystemFont, 'SF Pro Display', sans-serif;
            font-size: 13px;
            font-weight: 500;
            border-radius: 6px;
            cursor: pointer;
            transition: all 0.2s ease;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
        `;

        this.button.addEventListener('mouseenter', () => {
            this.button.style.transform = 'translateY(-1px)';
            this.button.style.boxShadow = '0 2px 6px rgba(0, 0, 0, 0.25)';
        });

        this.button.addEventListener('mouseleave', () => {
            this.button.style.transform = 'translateY(0)';
            this.button.style.boxShadow = '0 1px 3px rgba(0, 0, 0, 0.2)';
        });

        this.button.addEventListener('mousedown', () => {
            this.button.style.transform = 'translateY(0)';
            this.button.style.boxShadow = '0 1px 2px rgba(0, 0, 0, 0.3)';
        });
    }
}
