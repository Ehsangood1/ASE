from abc import ABC, abstractmethod


class Table(ABC):
    @abstractmethod
    def get_content(self) -> str:
        pass
