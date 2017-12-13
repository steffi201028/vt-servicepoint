package lulaself;

public class ServicePoint implements Observer { 

	public ServicePoint(){
    	
    }

    public void update(boolean state) { 
        System.out.println("Concrete Observer A is updated with "+state); 
        //ggf. Modifikationen mit setState(). 
    }

	
    
    
} 
