package com.smart.car.gateway.filter;

import com.smart.car.gateway.util.IpUtil;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 *   自定义ip限流拦截器
 *   GlobalGilter（全局过滤器接口）与 GatewayFilter（网关过滤器接口）具有相同的方法定义。区别在于：
 *   1.全局过滤器是一系列特殊的过滤器，会根据条件应用到所有路由中。
 *   2.网关过滤器是更细粒度的过滤器，作用于指定的路由中。
 * @author chenf
 * @version 1.0
 * @date 2022-07-24
 */
@Slf4j
@Component
public class IpLimitFilter implements GlobalFilter, Ordered {

    public static final String WARNING_MSG = "您当前ip请求过于频繁，请5秒后再试试";
    public static final Map<String, Bucket> LOCAL_CACHE = new ConcurrentHashMap<>();
    // 令牌桶初始容量
    public static final long capacity = 2;
    // 补充桶的时间间隔，即5秒补充一次
    public static final long seconds = 5;
    // 每次补充token的个数
    public static final long refillTokens = 1;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String ip = IpUtil.getIpAddr(request);
        log.info("访问IP为:{}", ip);

        Bucket bucket = LOCAL_CACHE.computeIfAbsent(ip, k -> createNewBucket(ip));
        log.info("IP:{} ,令牌通可用的Token数量:{} ", ip, bucket.getAvailableTokens());
        if (bucket.tryConsume(1)) {
            // 有桶直接放行
            return chain.filter(exchange);
        } else {
            // 限制提示
            byte[] bits = WARNING_MSG.getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            // 指定编码，防止浏览器中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
    }

    //创建新的令牌桶
    private Bucket createNewBucket(String ip) {
        Duration refillDuration = Duration.ofSeconds(seconds);
        Refill refill = Refill.greedy(refillTokens, refillDuration);
        Bandwidth limit = Bandwidth.classic(capacity, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }
    @Override
    public int getOrder() {
        return 1;
    }
}
