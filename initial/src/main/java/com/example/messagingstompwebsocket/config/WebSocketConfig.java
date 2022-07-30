package com.example.messagingstompwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * This is the configuration class to enable spring for STOMP messaging
 *  ... enables WebSocket message handling, backed by a message broker
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry mbRegistry) {
        // to enable a simple memory-based message broker to carry the outgoing greeting back to the client on destinations prefixed with /topic
        mbRegistry.enableSimpleBroker("/topic");

        //  It also designates the /app prefix for messages that are bound for methods annotated with @MessageMapping.
        // so the greeting controller will be mapped to "/app/hello"
        mbRegistry.setApplicationDestinationPrefixes("/app");
    }

    /**
     * method registers the /gs-guide-websocket endpoint, enabling SockJS fallback options so that alternate transports
     * can be used if WebSocket is not available. The SockJS client will attempt to connect to /gs-guide-websocket and
     * use the best available transport (websocket, xhr-streaming, xhr-polling, and so on).
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry epRegistry) {
        epRegistry.addEndpoint("gs-guide-websocket").withSockJS();
    }
}
