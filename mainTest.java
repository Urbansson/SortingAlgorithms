import java.util.Random;
import java.util.concurrent.ForkJoinPool;


public class mainTest {

	  public static void main(String[] args) {
		    // create a random data set
		    final float[] data = new float[100000000];
		    final Random random = new Random();
		    for (int i = 0; i < data.length; i++) {
		      data[i] = random.nextFloat();
		    }

		    // submit the task to the pool
		    final ForkJoinPool pool = new ForkJoinPool(8);
		    final QuickSort finder = new QuickSort(data);
		    //final MergeSort finder = new MergeSort(data);

		    
		    System.out.println("Starting sort");



			System.out.println("Min quicksort Start");


			long time = System.nanoTime();
			
		    pool.invoke(finder);
			
			float elapsedTime = (System.nanoTime() - time);
			elapsedTime/=1000000000;
			System.out.println("Min quicksort tid : " + elapsedTime + " seconds");
		    
		    
		    System.out.println("Data is sorted: " + data.length);
		    
			for(int i = 0; i < data.length-1;i++){
				if(data[i]>data[i+1])
					System.out.println("MIN ERROR : " + data[i] +">"+data[i+1]);
			}
			

		  }

}
