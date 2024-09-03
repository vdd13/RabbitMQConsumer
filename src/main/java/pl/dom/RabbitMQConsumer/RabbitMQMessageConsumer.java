package pl.dom.RabbitMQConsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import pl.dom.RabbitMQ.model.Klient;

@Service
public class RabbitMQMessageConsumer {

	
	@RabbitListener(queues = {"${dom.queue}"})
	public void consumeMessage(String message) {
		System.out.println("Message recived: " + message);
	}
	
	
	@RabbitListener(queues = {"${dom.queue.fanout1}"})
	public void consumeMessageFanoutQueue1(String message) {
		System.out.println("Message recived: " + message);
	}
	
	@RabbitListener(queues = {"${dom.queue.json}"})
	public void consumeJSONMessage(Klient client) {
		System.out.println("Message of JSON recived: " + client);
	}
}
