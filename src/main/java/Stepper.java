import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Stepper {

	private final GpioController gpio = GpioFactory.getInstance();

	private final GpioPinDigitalOutput dir = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "direction+",
			PinState.HIGH);

	private final GpioPinDigitalOutput ena = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "enable",
			PinState.HIGH);

	private final GpioPinDigitalOutput pul = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "step+", PinState.HIGH);

	public Stepper()
	{
		System.out.println("new Stepper made");
	}

	public void spin(int num) {
		try {
			for (int i = 0; i < 64000; i++) {
				System.out.println("i: " + i);
				dir.low();
				ena.high();
				pul.high();
				Thread.sleep(50);
				pul.low();
				Thread.sleep(50);
			}
		}catch(Exception e)
		{
			System.out.println("ERROR : " + e);
		}
	}
}
