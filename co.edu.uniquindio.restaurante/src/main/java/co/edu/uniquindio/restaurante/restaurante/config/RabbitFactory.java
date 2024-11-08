package co.edu.uniquindio.restaurante.restaurante.config;

import com.rabbitmq.client.ConnectionFactory;

public class RabbitFactory {

    private ConnectionFactory connectionFactory;
    public RabbitFactory() {
        this.connectionFactory = new ConnectionFactory();
        this.connectionFactory.setHost("localhost");
        this.connectionFactory.setPort(5672);
        this.connectionFactory.setUsername("arquesoft_manager");
        this.connectionFactory.setPassword("Felipe0904");
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }
}
