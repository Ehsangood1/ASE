from abc import ABC, abstractmethod


class Paragraph(ABC):
    @abstractmethod
    def get_content(self) -> str:
        pass
