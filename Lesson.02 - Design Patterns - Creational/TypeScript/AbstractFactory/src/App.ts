import { UIComponentFactory } from './UIComponentFactory.js';
import { WindowsFactory } from './windows/WindowsFactory.js';
import { MacOSFactory } from './macos/MacOSFactory.js';

export class App {
    private container: HTMLDivElement;

    constructor() {
        this.container = document.createElement('div');
        this.setupApplication();
    }

    private setupApplication(): void {
        this.container.style.cssText = `
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
        `;

        const title = document.createElement('h1');
        title.textContent = 'Abstract Factory Pattern Demo';
        title.style.cssText = `
            text-align: center;
            color: #333;
            margin-bottom: 40px;
        `;
        this.container.appendChild(title);

        this.createSection('Windows Style', new WindowsFactory());

        this.createSection('MacOS Style', new MacOSFactory());
    }

    private createSection(title: string, factory: UIComponentFactory): void {
        const section = document.createElement('div');
        section.style.cssText = `
            margin-bottom: 40px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        `;

        const sectionTitle = document.createElement('h2');
        sectionTitle.textContent = title;
        sectionTitle.style.cssText = `
            margin-top: 0;
            margin-bottom: 20px;
            color: #555;
        `;
        section.appendChild(sectionTitle);

        const componentsContainer = document.createElement('div');
        componentsContainer.style.cssText = `
            display: flex;
            flex-direction: column;
            gap: 20px;
            align-items: flex-start;
        `;

        const button = factory.createButton();
        componentsContainer.appendChild(button.render());

        const checkbox = factory.createCheckBox();
        componentsContainer.appendChild(checkbox.render());

        section.appendChild(componentsContainer);
        this.container.appendChild(section);
    }

    public render(): HTMLElement {
        return this.container;
    }

    public static main(): void {
        const app = new App();
        document.body.appendChild(app.render());
    }
}

document.addEventListener('DOMContentLoaded', () => {
    App.main();
});
