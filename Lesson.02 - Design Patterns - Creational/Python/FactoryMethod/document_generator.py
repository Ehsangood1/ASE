from abc import ABC, abstractmethod
from document import Document
from components.header import Header
from components.paragraph import Paragraph
from components.table import Table
from components.footer import Footer


class DocumentGenerator(ABC):
    @abstractmethod
    def create_header(self) -> Header:
        pass

    @abstractmethod
    def create_paragraph(self) -> Paragraph:
        pass

    @abstractmethod
    def create_table(self) -> Table:
        pass

    @abstractmethod
    def create_footer(self) -> Footer:
        pass

    def generate_document(self) -> Document:
        header = self.create_header()
        paragraph = self.create_paragraph()
        table = self.create_table()
        footer = self.create_footer()

        content: list[str] = []
        content.append(header.get_content())
        content.append("")
        content.append(paragraph.get_content())
        content.append("")
        content.append(table.get_content())
        content.append("")
        content.append(footer.get_content())

        return ConcreteDocument("\n".join(content))


class ConcreteDocument(Document):
    def __init__(self, content: str):
        self._content = content

    def render(self) -> str:
        return self._content
