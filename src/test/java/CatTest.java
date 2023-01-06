import com.example.Cat;
import com.example.Feline;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        String actual = "Мяу";
        String expected = cat.getSound();
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Collections.singletonList("Кошка хищник"));
        String actual = "[Кошка хищник]";
        String expected = String.valueOf(cat.getFood());
        assertThat(actual, equalTo(expected));
    }
}