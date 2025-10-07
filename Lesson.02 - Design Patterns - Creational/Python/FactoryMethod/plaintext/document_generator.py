from document_generator import DocumentGenerator
from components.header import Header
from components.paragraph import Paragraph
from components.table import Table
from components.footer import Footer


class PlainTextDocumentGenerator(DocumentGenerator):
    def create_header(self) -> Header:
        return PlainTextHeader()

    def create_paragraph(self) -> Paragraph:
        return PlainTextParagraph()

    def create_table(self) -> Table:
        return PlainTextTable()

    def create_footer(self) -> Footer:
        return PlainTextFooter()


class PlainTextHeader(Header):
    def get_content(self) -> str:
        return "=== Document Title ==="


class PlainTextParagraph(Paragraph):
    def get_content(self) -> str:
        return "This is a plain text paragraph."


class PlainTextTable(Table):
    def get_content(self) -> str:
        return "Name | Age\n-----|-----\nJohn | 30"


class PlainTextFooter(Footer):
    def get_content(self) -> str:
        return "--- End of Document ---"
