package rest.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RedisHash("point")
public class Point implements Serializable {
    // Serializable 참고
    // http://hyeonstorage.tistory.com/254

    @Id
    private String id;
    private LocalDateTime refreshTime;

    @Builder
    public Point(String id, LocalDateTime refreshTime) {
        this.id = id;
        this.refreshTime = refreshTime;
    }

    public void refresh(LocalDateTime refreshTime) {
        if(refreshTime.isAfter(this.refreshTime)) {
            // 저장된 데이터보다 최신 데이터일 경우
            this.refreshTime = refreshTime;
        }
    }

}
