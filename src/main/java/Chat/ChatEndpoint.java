/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author lberr
 */
@ServerEndpoint(
        value="/chat/{username}",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class
)
public class ChatEndpoint {
    private final Logger log = Logger.getLogger(getClass().getName());

    private Session session;
    private String username;
    private static final Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String,String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {
        log.info(session.getId() + " conectado!");

        this.session = session;
        this.username = username;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("conectado!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        log.info(message.toString());

        message.setFrom(users.get(session.getId()));
        sendMessageToOneUser(message);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        log.info(session.getId() + " desconectado!");

        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("desconectado!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.warning(throwable.toString());
    }

    private static void broadcast(Message message) throws IOException, EncodeException {
        for (ChatEndpoint endpoint : chatEndpoints) {
            synchronized(endpoint) {
                endpoint.session.getBasicRemote().sendObject(message);
            }
        }
    }

    private static void sendMessageToOneUser(Message message) throws IOException, EncodeException {
        for (ChatEndpoint endpoint : chatEndpoints) {
            synchronized(endpoint) {
                if (endpoint.session.getId().equals(getSessionId(message.getTo()))) {
                    endpoint.session.getBasicRemote().sendObject(message);
                }
            }
        }
    }

    private static String getSessionId(String to) {
        if (users.containsValue(to)) {
            for (String sessionId: users.keySet()) {
                if (users.get(sessionId).equals(to)) {
                    return sessionId;
                }
            }
        }
        return null;
    }
}
