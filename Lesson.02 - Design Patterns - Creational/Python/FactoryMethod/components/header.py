from abc import ABC, abstractmethod


class Header(ABC):
    @abstractmethod
    def get_content(self) -> str:
        pass
