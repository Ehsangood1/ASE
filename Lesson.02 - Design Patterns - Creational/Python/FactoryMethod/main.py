from document_generator import DocumentGenerator
from html.document_generator import HTMLDocumentGenerator
from plaintext.document_generator import PlainTextDocumentGenerator
from markdown.document_generator import MarkdownDocumentGenerator


def main():
    print("=" * 60)
    print("Factory Method Pattern Demo")
    print("=" * 60)
    print()

    # Create generators for different document formats
    generators: list[tuple[str, DocumentGenerator]] = [
        ("HTML", HTMLDocumentGenerator()),
        ("Plain Text", PlainTextDocumentGenerator()),
        ("Markdown", MarkdownDocumentGenerator())
    ]

    # Generate and display documents in all formats
    for format_name, generator in generators:
        print(f"--- {format_name} Document ---")
        print()

        # Use the factory method pattern to generate a document
        document = generator.generate_document()

        # Render and display the document
        print(document.render())
        print()
        print("-" * 40)
        print()


if __name__ == "__main__":
    main()
