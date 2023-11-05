import org.testng.annotations.Test;
import ru.forma.base.SeleniumBaseTest;

public class SmokeCheckMainPage extends SeleniumBaseTest {

    @Test
    public void test(){
        page.getMainPage()
                .openModalMenu()
                .openAbout();
    }

}
