package com.github.ASE.FactoryMethod.MarkDown;

import com.github.ASE.FactoryMethod.Footer;
import com.github.ASE.FactoryMethod.Header;
import com.github.ASE.FactoryMethod.Paragraph;
import com.github.ASE.FactoryMethod.Table;

public class DocumentGenerator extends com.github.ASE.FactoryMethod.DocumentGenerator {

    @Override
    public Header createHeader() {
        return new Header() {
            @Override
            public String getContent() {
                return "# Document Title";
            }
        };
    }

    @Override
    public Paragraph createParagraph() {
        return new Paragraph() {
            @Override
            public String getContent() {
                return "This is a Markdown paragraph.";
            }
        };
    }

    @Override
    public Table createTable() {
        return new Table() {
            @Override
            public String getContent() {
                return "| Name | Age |\n|------|-----|\n| John | 30  |";
            }
        };
    }

    @Override
    public Footer createFooter() {
        return new Footer() {
            @Override
            public String getContent() {
                return "---\n*End of Document*";
            }
        };
    }

}
