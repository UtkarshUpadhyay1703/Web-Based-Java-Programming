package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dependency.Transport;
//singleton n eager
@Component("my_atm")
@Scope("prototype")
public class ATMImpl implements ATM {
	@Autowired//(required = false) 
	@Qualifier("httpTransport")//autowire=byName , field level D.I
//	@Resource(name="httpTransport") we can use this instead of (@Autowired and @Qualifier)
	private Transport myTransport;// =new HttpTransport();	
	
	public ATMImpl() {
		System.out.println("in ctor of "+getClass());
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	// init method
	@PostConstruct
	public void myInit() throws Exception {
		System.out.println("in init " + myTransport);
	}

	// destroy method
	@PreDestroy
	public void myDestroy() throws Exception {
		System.out.println("in destroy " + myTransport);
	}
	

}
