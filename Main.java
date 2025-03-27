public class Main {
    public static void main(String[] args) {
        // Check if the user has entered exactly 5 arguments
        if (args.length != 5) {
            System.out.println("Error: You must provide exactly 5 numbers.");
            System.exit(1);
        }

        // Convert command-line arguments to integers
        int[] numbers = new int[5];
        try {
            for (int i = 0; i < 5; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: All arguments must be integers.");
            System.exit(1);
        }

        // Determine which sorting method to use (Bubble or Quick)
        String sortMethod = "bubble"; // default to bubble sort
        if (args.length > 5) {
            sortMethod = args[5].toLowerCase();
        }

        // Thread to print unsorted numbers
        Thread unsortedThread = new Thread(() -> {
            System.out.print("Unsorted Numbers: ");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        });

        // Thread to print sorted numbers
        Thread sortedThread = new Thread(() -> {
            int[] sortedNumbers = numbers.clone();
            if (sortMethod.equals("quick")) {
                quickSort(sortedNumbers, 0, sortedNumbers.length - 1);
            } else {
                bubbleSort(sortedNumbers);
            }
            System.out.print("Sorted Numbers: ");
            for (int num : sortedNumbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        });

        // Start both threads
        unsortedThread.start();
        sortedThread.start();

        try {
            // Wait for both threads to finish
            unsortedThread.join();
            sortedThread.join();
        } catch (InterruptedException e) {
            System.out.println("Error: Thread interrupted.");
        }

        // Calculate and display the sum of the numbers
        int totalSum = sum(numbers);
        System.out.println("Sum of Numbers: " + totalSum);
    }

    // Method to calculate the sum of an array
    public static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Method to implement Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Method for partitioning
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Method to implement Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}