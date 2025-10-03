package com.github.ASE.FactoryMethod.HTML;

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
                return "<h1>Document Title</h1>";
            }
        };
    }

    @Override
    public Paragraph createParagraph() {
        return new Paragraph() {
            @Override
            public String getContent() {
                return "<p>This is an HTML paragraph.</p>";
            }
        };
    }

    @Override
    public Table createTable() {
        return new Table() {
            @Override
            public String getContent() {
                return "<table border=\"1\"><tr><th>Name</th><th>Age</th></tr><tr><td>John</td><td>30</td></tr></table>";
            }
        };
    }

    @Override
    public Footer createFooter() {
        return new Footer() {
            @Override
            public String getContent() {
                return "<footer>End of Document</footer>";
            }
        };
    }

}
