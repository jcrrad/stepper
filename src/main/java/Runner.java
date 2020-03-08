import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Runner {


	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting app");

		final GpioController gpio = GpioFactory.getInstance();

		final GpioPinDigitalOutput pulse = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "pulse+", PinState.HIGH);

		final GpioPinDigitalOutput step = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "step+", PinState.HIGH);

		for(int i=0;i<200;i++)
		{
			System.out.println("HIGH");
			step.high();
			Thread.sleep(500);
			System.out.println("HIGH");
			step.low();
			Thread.sleep(500);
		}
	}
}
