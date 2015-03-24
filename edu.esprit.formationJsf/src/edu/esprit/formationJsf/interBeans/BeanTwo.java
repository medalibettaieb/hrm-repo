package edu.esprit.formationJsf.interBeans;

import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class BeanTwo {
	private String theOtherStuff;
	private FacesContext facesContext = FacesContext.getCurrentInstance();

	@ManagedProperty(value="#{beanOne}")
	 BeanOne beanOne1;
	
	
	public String doSomeStuff() {
//		ValueExpression valueExpression = facesContext
//				.getApplication()
//				.getExpressionFactory()
//				.createValueExpression(facesContext.getELContext(),
//						"#{beanOne}", BeanOne.class);
//
//		BeanOne beanOne = (BeanOne) valueExpression.getValue(facesContext
//				.getELContext());
		System.out.println(beanOne1.getSomeStuff());

		theOtherStuff = beanOne1.getSomeStuff();
		return "call";
	}

	public String getTheOtherStuff() {
		return theOtherStuff;
	}

	public void setTheOtherStuff(String theOtherStuff) {
		this.theOtherStuff = theOtherStuff;
	}
	public BeanOne getBeanOne1() {
		return beanOne1;
	}
	public void setBeanOne1(BeanOne beanOne1) {
		this.beanOne1 = beanOne1;
	}

}
