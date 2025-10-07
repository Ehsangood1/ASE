from abc import ABC, abstractmethod


class Footer(ABC):
    @abstractmethod
    def get_content(self) -> str:
        pass
