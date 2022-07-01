package jms;

import java.util.Hashtable;
import java.util.Scanner;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TesteConsume {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws NamingException, JMSException {
        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("financeiro");
        MessageConsumer consumer = session.createConsumer(fila);

        //Message message = consumer.receive();

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;

                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        });

       // System.out.println("recebendo a mensagem " + message);

        new Scanner(System.in).nextLine();

        session.close();
        connection.close();
        context.close();
    }
}
