package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.dto.IncomingMessage;
import com.example.messagingstompwebsocket.dto.OutgoingGreeting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")       // just to map the destination where the message is mapped, in this case "/hello"
    @SendTo("/topic/greetings")     // (i) the returned OutgoingGreeting is broadcast to all Subscribers of "/topic/greetings" (which is the destination), this happens at the end of the method, this is basically how the server can interact with the (individual) clients!
    public OutgoingGreeting greeting(IncomingMessage incomingMessage ) throws Exception {   // the payload of the message is in IncomingMessage

        Thread.sleep(2000); // simulated delay, the server can take as long as it needs to asynchronously process the message

        return new OutgoingGreeting("Hello " + HtmlUtils.htmlEscape(incomingMessage.getName()) + "!");
    }
}
