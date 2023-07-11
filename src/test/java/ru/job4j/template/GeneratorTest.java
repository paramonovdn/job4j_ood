package ru.job4j.template;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GeneratorTest {

    @Test
    public void simpleTest() {
        Generator generator = new PatternGenerator();
        String pattern = "I am a ${name}, Who are ${subject}? ";
        String expected = "I am a human, Who are you? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "human");
        map.put("subject", "you");
        String result = generator.produce(pattern, map);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testWithWrongArgument() {
        Generator generator = new PatternGenerator();
        String pattern = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "human");
        assertThatThrownBy(() -> generator.produce(pattern, map)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWithWrongArgument2() {
        Generator generator = new PatternGenerator();
        String pattern = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "human");
        map.put("object", "you");
        assertThatThrownBy(() -> generator.produce(pattern, map)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWithExtraArgument() {
        Generator generator = new PatternGenerator();
        String pattern = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "human");
        map.put("subject", "you");
        map.put("subject", "me");
        assertThatThrownBy(() -> generator.produce(pattern, map)).
                isInstanceOf(IllegalArgumentException.class);
    }


}
