import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Stepper {

	private final GpioController gpio = GpioFactory.getInstance();

	private final GpioPinDigitalOutput pulse = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "pulse+",
			PinState.HIGH);

	private final GpioPinDigitalOutput step = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "step+", PinState.HIGH);

	public Stepper()
	{
		System.out.println("new Stepper made");
	}

	public void spin(int num)
	{
		try {
			for (int i = 0; i < num; i++) {
				System.out.println("HIGH");
				step.high();
				Thread.sleep(500);
				System.out.println("Low");
				step.low();
				Thread.sleep(500);
			}
		}catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
	}
}
