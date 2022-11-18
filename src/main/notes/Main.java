public class Main {
	public static void main(String[] args) {
		Heap heap = new Heap(10000);
		Scanner sc = new Scanner(System.in);
		int Q = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < Q; i++) {
			String[] str = sc.nextLine().split(" ");
			int op = Integer.parseInt(str[0]);
			int val = 0;
			switch (op) {
				case 1:
					val = Integer.parseInt(str[1]);
					heap.offer(val);
					break;
				case 2:
					val = Integer.parseInt(str[1]);
					heap.remove(val);
					break;
				case 3:
					System.out.println(heap.peek());
					break;
				default:
					break;
			}
		}
	}

	// 12
	// 1 10
	// 1 9
	// 3
	// 1 3
	// 3
	// 2 9
	// 3
	// 2 3
	// 3
	// 1 5
	// 1 2
	// 3
}
