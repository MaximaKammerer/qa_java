import com.example.Feline;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class FelineTest {

    @RunWith(Parameterized.class)
    public static class TheParameterizedPart {

        private int countKittens;
        private int expected;

        public TheParameterizedPart(int countKittens, int expected) {
            this.countKittens = countKittens;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getSumData() {
            return new Object[][] {
                    { 10, 10},
                    { 4, 4},
            };
        }

        @Test
        public void getKittens () {
            Feline feline = new Feline();
            int actual = feline.getKittens(countKittens);
            assertEquals(expected, actual);
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class NotParameterizedPart {

        @Mock
        Feline feline;

        @Test
        public void getFood() throws Exception {
            feline.getFood("Хищник");
            Mockito.verify(feline).getFood("Хищник");
        }

        @Test
        public void eatMeat() throws Exception {
            feline = new Feline();
            String actual = "[Животные, Птицы, Рыба]";
            String expected = String.valueOf(feline.eatMeat());
            assertThat(actual, equalTo(expected));
        }

        @Test
        public void getFamily () {
            feline = new Feline();
            String actual = "Кошачьи";
            String expected = feline.getFamily();
            assertThat(actual, equalTo(expected));
        }

        @Test
        public void getKittens () {
            feline = new Feline();
            int actual = 1;
            int expected = feline.getKittens();
            assertThat(actual, equalTo(expected));
        }
    }
}