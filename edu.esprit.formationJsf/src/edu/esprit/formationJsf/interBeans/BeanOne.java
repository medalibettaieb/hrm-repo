package edu.esprit.formationJsf.interBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="beanOne")
@SessionScoped
public class BeanOne {
	
	private String someStuff="please change me ...";
	
	

	public String getSomeStuff() {
		return someStuff;
	}

	public void setSomeStuff(String someStuff) {
		this.someStuff = someStuff;
	}
	
	

}
