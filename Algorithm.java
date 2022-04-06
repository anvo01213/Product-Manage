import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Algorithm {
	int[] a;
	int[] arr;
	int n;

	Algorithm() {

	}

	Algorithm(int[] b) {
		int i;
		n = b.length;
		a = new int[n];
		for (i = 0; i < n; i++)
			a[i] = b[i];
	}

	void swap(int i, int k) {
		int x;
		x = a[i];
		a[i] = a[k];
		a[k] = x;
	}

	void display() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void writeFile(String fileName, int[] arr) throws Exception {

		FileWriter writer = new FileWriter(fileName);
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			writer.write(arr[i] + "\t" + "");
		}
		writer.close();

	}

	public void readFile(String readFile, int arr[]) throws Exception {

		FileReader reader = new FileReader(readFile);
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}

	public int[] bubbleSort(int arr[]) {
		System.out.println("Bubble Sort \n");
		// Lưu dữ liệu của mảng a sang một mảng b

		a = new int[arr.length];

		for (int o = 0; o < arr.length; o++) {
			a[o] = arr[o];
		}
		// Thực hiện thuật toán Bubble Sort trên mảng b
		boolean swap = true;

		try {
			// Lưu vào file OUTPUT1
			FileWriter fw = new FileWriter("OUTPUT1.TXT");
			while (swap) {
				swap = false;
				for (int i = 0; i < a.length - 1; i++) {
					if (a[i] > a[i + 1]) {
						swap = true;
						int temp = a[i];
						a[i] = a[i + 1];
						a[i + 1] = temp;
					}

				}

				for (int i = 0; i < a.length; i++) {
					System.out.print(a[i] + " ");
				}

				System.out.println();
			}
			for (int j = 0; j < a.length; j++) {
				fw.write(a[j] + " ");
			}
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

	}

	public int[] selectionSort(int arr[]) {
		System.out.println("Selection Sort \n");
		// Lưu dữ liệu của mảng a sang một mảng b
		a = new int[arr.length];

		for (int o = 0; o < arr.length; o++) {
			a[o] = arr[o];
		}

		try {
			// Lưu vào file OUTPUT2
			FileWriter fw = new FileWriter("OUTPUT2.TXT");
			// Thực hiện thuật toán Selection Sort trên mảng b
			for (int i = 0; i < a.length - 1; i++) {

				int min = a[i];
				int k = i;
				// System.out.print(a[p] + " ");
				for (int j = i + 1; j < a.length; j++)
					if (a[j] < min) {
						k = j;
						min = a[j];
					}
				if (k != i) {
					swap(i, k);
				}
				display();

				System.out.println();

			}
			for (int j = 0; j < a.length; j++) {
				fw.write(a[j] + " ");
			}
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

	}

	public int[] insertionSort(int arr[]) {
		// Lưu dữ liệu của mảng a sang một mảng b
		a = new int[arr.length];

		for (int o = 0; o < arr.length; o++) {
			a[o] = arr[o];
		}
		int i, j;
		int currentValue;
		try {
			try (FileWriter fw = new FileWriter("OUTPUT3.TXT")) { //// Lưu vào file OUTPUT3
				// Thực hiện thuật toán Insertion Sort trên mảng b
				for (i = 0; i < a.length; i++) {

					currentValue = a[i];
					j = i;
					// System.out.print(a[p] + " ");

					while (j > 0 && a[j - 1] > currentValue) {
						a[j] = a[j - 1];
						j = j - 1;

					}
					a[j] = currentValue;

					display();
					System.out.println();

				}
				for (int h = 0; h < a.length; h++) {
					fw.write(a[h] + " ");
				}
				fw.write("\n");
				fw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

	public int search(int arr[], int value) {
		// Lưu dữ liệu của mảng a sang một mảng b
		a = new int[arr.length];
		for (int o = 0; o < arr.length; o++) {
			a[o] = arr[o];
		}

		try {
			// Lưu vào file OUTPUT4
			FileWriter fw = new FileWriter("OUTPUT4.TXT");

			// Tìm kiếm vị trí (chỉ số) của các phần tử có giá trị lớn hơn biến value được
			// nhập vào.
			System.out.print("Chi so la: ");
			fw.write("Chi so la: ");
			for (int i = 0; i < a.length; i++) {
				if (a[i] > value) {
					System.out.print(i + " ");
					fw.write(i + " ");
				}
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	public int binarySearch(int arr[], int value) {
		// Lưu dữ liệu của mảng a sang một mảng b
		a = new int[arr.length];
		for (int o = 0; o < arr.length; o++) {
			a[o] = arr[o];
		}
		// Sắp xếp mảng b bằng thuật toán Selection Sort
		for (int i = 0; i < a.length - 1; i++) {
			int min = a[i];
			int k = i;
			for (int j = i + 1; j < a.length; j++)
				if (a[j] < min) {
					k = j;
					min = a[j];
				}
			if (k != i) {
				swap(i, k);
			}
		}

		int left = 0;
		int right = a.length - 1;

		try {
			// Lưu vào file OUTPUT5
			try (FileWriter fw = new FileWriter("OUTPUT5.TXT")) {
				// Tìm kiếm theo thuật toán nhị phân
				int middle = (left + right) / 2;
				while (left <= right) {
					if (value < a[middle]) {
						right = middle - 1;
					} else if (value == a[middle] && a[left] != value) {
						System.out.println("Index of first elements " + middle);
						fw.write("Index of first elements: " + middle);
						break;
					} else if(a[middle] == value && a[left] == value){
						System.out.println("Index of first elements " + left);
						fw.write("Index of first elements: " + left);
						break;

					} else {
						left = middle + 1;
					}
					middle = (left + right) /2;
				}
				fw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
