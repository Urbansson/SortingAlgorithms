import java.util.Arrays;
import java.util.concurrent.RecursiveAction;


public class MergeSort extends RecursiveAction {


	private static final long serialVersionUID = 1L;


	private  float[] a;


	public MergeSort(float[] list) {
		this.a = list;
	}

	
	
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if(a.length == 1)
			return;

		float []b = Arrays.copyOfRange(a, 0, a.length/2);
		float []c = Arrays.copyOfRange(a, (a.length/2), a.length);

		invokeAll(new MergeSort(b),new MergeSort(c));
		merge(b,c,a);
	}
	
	private void merge(float []a,float []b,float []c){
		int indexa=0,indexb=0, indexc=0;


		while(indexa<a.length &&indexb<b.length){

			if(a[indexa]<=b[indexb]){
				c[indexc]=a[indexa];
				indexa++;	
			} else {
				c[indexc]=b[indexb];
				indexb++;
			}	
			indexc++;
		}

		while(indexa<a.length){
			c[indexc]=a[indexa]; 
			indexa++;
			indexc++;
		}
		while(indexb<b.length){
			c[indexc]=b[indexb]; 
			indexb++; 
			indexc++;
		}

	}


}
