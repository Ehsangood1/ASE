from document_generator import DocumentGenerator
from components.header import Header
from components.paragraph import Paragraph
from components.table import Table
from components.footer import Footer


class HTMLDocumentGenerator(DocumentGenerator):
    def create_header(self) -> Header:
        return HTMLHeader()

    def create_paragraph(self) -> Paragraph:
        return HTMLParagraph()

    def create_table(self) -> Table:
        return HTMLTable()

    def create_footer(self) -> Footer:
        return HTMLFooter()


class HTMLHeader(Header):
    def get_content(self) -> str:
        return "<h1>Document Title</h1>"


class HTMLParagraph(Paragraph):
    def get_content(self) -> str:
        return "<p>This is an HTML paragraph.</p>"


class HTMLTable(Table):
    def get_content(self) -> str:
        return '<table border="1"><tr><th>Name</th><th>Age</th></tr><tr><td>John</td><td>30</td></tr></table>'


class HTMLFooter(Footer):
    def get_content(self) -> str:
        return "<footer>End of Document</footer>"
