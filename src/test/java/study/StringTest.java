package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항1() {
        // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인
        String[] result = "1,2".split(",");
        assertThat(result).contains("1","2");
        // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지
        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void 요구사항2() {
        // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 메서드 테스트") // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다
    void 요구사항3() {
        // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현
        String testStr = "abc";
        assertThat(testStr.charAt(0)).isEqualTo('a');
        assertThat(testStr.charAt(1)).isEqualTo('b');
        assertThat(testStr.charAt(2)).isEqualTo('c');
        // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char wrongResult = testStr.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
