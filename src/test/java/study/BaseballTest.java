package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
        /* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

    같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,
    그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
            e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
    위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
    게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
    게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다. */
    // 스트라이크 : 인덱스 비교
    // 볼, 포볼 : 검색
    // 게임 종료 : 값이 완전 똑같으면
    // 순서를 따져야하고, 전체 검색 시 cost가 적은 자료구조
    // 일단 3자리로 고정되어 있으니까 배열로 하고, 전체 순회하자
    // + 랜덤 3자리 숫자 생성

    baseball bb;
    List<Integer> randomNumber;

    @BeforeEach
    void SetUp() {
        bb = new baseball();
        randomNumber = bb.generateRandomNumber();
    }

    @Test
    void 랜덤3자리숫자생성() {
        // 1부터 9까지 서로 다른 수로 이루어진 3자리 수 인지 검증
        assertThat(isValidNumber(randomNumber)).isTrue();
    }

    private boolean isValidNumber(List<Integer> randomNumber) {
        Set<Integer> numberSet = new HashSet<>(randomNumber);
        // 길이가 3인지 확인
        if(numberSet.size() != 3) return false;
        // 1~9까지의 숫자만 있는지 확인
        if(numberSet.contains(0)) return false;

        return true;
    }

    @Test
    void 스트라이크3() {
        List<Integer> copy = new ArrayList<>(randomNumber);
        assertThat(bb.compare(copy)).isEqualTo("3스트라이크");
    }

    @Test
    void 볼() {
        List<Integer> copy = new ArrayList<>(randomNumber);
        assertThat(bb.compare(copy)).isEqualTo("1볼");
    }

    @Test
    void 낫싱() {
        List<Integer> copy = new ArrayList<>(randomNumber);
        assertThat(bb.compare(copy)).isEqualTo("낫싱");
    }

    @Test
    void 게임종료() {

    }
}
