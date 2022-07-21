//package com.smart.car.gateway.config;
//
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author chenf
// * @version 1.0
// * @date 2022-07-21
// */
//@Configuration
//public class GatewayConfiguration {
//
//    //自定义限流异常页面
//    @PostConstruct
//    public void initBlockHandlers(){
//        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
//            @Override
//            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
//                Map map = new HashMap();
//                map.put("code",0);
//                map.put("msg","被限流了");
//                return ServerResponse.status(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(BodyInserters.fromObject(map));
//            }
//        };
//        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
//    }
//}
