package lineales.pruebas;

import lineales.pruebas.App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;

public class AppTest {
        @Test
        public void testSaludar() {
                App app = new App();
                assertEquals("Hello, World!", app.saludar());
        }
}
