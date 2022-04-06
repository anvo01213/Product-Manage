import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int choice;
		int[] b = null;
		Algorithm t = new Algorithm();

		while (true) {
			System.out.println("\n Choose your option:");
			System.out.println("  1. Input");
			System.out.println("  2. Output");
			System.out.println("  3. Bubble Sort");
			System.out.println("  4. Selection Sort");
			System.out.println("  5. Insertion Sort");
			System.out.println("  6. Search > value");
			System.out.println("  7. Search = value");
			System.out.println("  0. Exit\n");
			System.out.print("  Your selection (0 -> 7): ");
			choice = s.nextInt();
			if (choice == 0) {
				System.out.println("Thanks!!!");
				break;
			}

			switch (choice) {
			case 1:
				//Chức năng 1: nhập và lưu vào file INPUT.TXT
				System.out.print("Input number of elements: ");
				int n = s.nextInt();
				b = new int[n];

				System.out.print("Input elements: ");
				for (int i = 0; i < n; i++) {

					b[i] = s.nextInt();
					t.writeFile("INPUT.TXT", b);
				}
				break;
			case 2:
				//Chức năng 2: đọc từ file INPUT.TXT và xuất ra ngoài màng hình
				System.out.println("Read from file");
				t.readFile("INPUT.TXT", b);
				break;
			case 3:
				//Chức năng 3: Sắp xếp bằng bubble sort và lưu vào file INPUT1
				t.bubbleSort(b);
				break;

			case 4:
				//Chức năng 4: Sắp xếp bằng selection sort và lưu vào file INPUT2
				t.selectionSort(b);
				break;
			case 5:
				//Chức năng 5: Sắp xếp bằng insertion sort và lưu vào file INPUT3
				t.insertionSort(b);
				break;
			case 6:
				//Chức năng 6: Tìm kiếm nhị phân và lưu vào file INPUT4
				System.out.println("Linear Search");
				System.out.println("Input value");
				int searchNum = s.nextInt();
				t.search(b, searchNum);
				break;
			case 7:
				//Chức năng 7: Tìm kiếm theo thuật toán nhị phân và lưu vào file INPUT5
				System.out.println("Binary Search");
				System.out.println("Input value");
				int searchBinary = s.nextInt();
				t.binarySearch(b, searchBinary);
				break;
			default:
				System.out.println("**Invalid choice. Try again.**");
			}
		}
	}

}
