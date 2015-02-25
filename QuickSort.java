import java.util.concurrent.RecursiveAction;


public class QuickSort extends RecursiveAction {


	private static final long serialVersionUID = 1L;

	private static final int TINY_SIZE = 17;

	private  float[] list;
	private  int first;
	private  int last;

	public QuickSort(float[] list, int first, int last) {
		this.list = list;
		this.first = first;
		this.last = last;
	}

	public QuickSort(float[] list) {
		this(list, 0, list.length-1);
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub

		int len = last - first;
		if (len < TINY_SIZE) { // insertion sort on tiny array
			insertSort(list, first,last);
			return;
		}
		
		if(first<last){
			int pivit = partion(list, first,last);
			invokeAll(new QuickSort(list, first, pivit-1),new QuickSort(list, pivit+1, last));
		}
	}


	public static int partion(float []list,int first ,int last){
		float pivit = list[first];
		int up = first;
		int down = last;

		do {

			while((up < last) && list[up] <= pivit){
				up++;
			}

			while(list[down] > pivit){
				down--;
			}
				
			if(up<down){
				swap(list,up,down);
			}

		}while (up < down);
		
		swap(list,first,down);

		return down;
	}

	private static void swap(float []list,int up ,int down){
		float temp = list[up];
		list[up] = list[down];
		list[down] = temp;
	}
	
	
	
	private void insertSort(float []list,int first ,int last){
		float x;
		for (int i = first + 1; i <= last; i++) {
			for (int j = i; j > first && list[j] < list[j - 1]; j--) {
				x = list[j - 1];
				list[j - 1] = list[j];
				list[j] = x;
			}
		}
	}


}
