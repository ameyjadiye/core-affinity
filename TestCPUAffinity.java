
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestCPUAffinity {

	public static void main(String[] args) 
{
	
	try{	
		ExecutorService executor = Executors.newFixedThreadPool(8);
		
		
		for(int i=0;i<8;i++){
			
			
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
				
					
					for (int i=0;i<Integer.MAX_VALUE;i++){
					
					Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(14.25))))));
					}
				}
			});
			
			
			
		}
		
		
		
		executor.shutdown();
		executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.HOURS);

		
	}
	catch(Exception e){

	}
	
	}
}
