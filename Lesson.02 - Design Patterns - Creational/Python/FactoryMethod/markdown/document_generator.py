from document_generator import DocumentGenerator
from components.header import Header
from components.paragraph import Paragraph
from components.table import Table
from components.footer import Footer


class MarkdownDocumentGenerator(DocumentGenerator):
    def create_header(self) -> Header:
        return MarkdownHeader()

    def create_paragraph(self) -> Paragraph:
        return MarkdownParagraph()

    def create_table(self) -> Table:
        return MarkdownTable()

    def create_footer(self) -> Footer:
        return MarkdownFooter()


class MarkdownHeader(Header):
    def get_content(self) -> str:
        return "# Document Title"


class MarkdownParagraph(Paragraph):
    def get_content(self) -> str:
        return "This is a Markdown paragraph."


class MarkdownTable(Table):
    def get_content(self) -> str:
        return "| Name | Age |\n|------|-----|\n| John | 30  |"


class MarkdownFooter(Footer):
    def get_content(self) -> str:
        return "---\n*End of Document*"
