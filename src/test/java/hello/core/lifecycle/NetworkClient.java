package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    // InitializingBean: 초기화 빈

    private String url;


    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    // url은 외부에서 setter로 넣을 수 있게 설계
    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    // 연결한 서버에 메시지 보내기
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // afterPropertiesSet: 의존관계 주입이 끝나면 호출해주겠다.
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        // destroy: 빈이 종료될 때 호출
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
