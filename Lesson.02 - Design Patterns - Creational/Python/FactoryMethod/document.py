from abc import ABC, abstractmethod


class Document(ABC):
    @abstractmethod
    def render(self) -> str:
        pass
