public class SortareSiCautareBinara {
    
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) { 
            // mijlocul 
            int m = (l + r) / 2; 
  
            // sorteaza prima si a doua jumatate
            sort(arr, l, m); 
            sort(arr, m + 1, r); 
  
            // "uneste" cele 2 jumatati
            merge(arr, l, m, r); 
        } 
    } 

    void merge(int arr[], int s, int m, int d) 
    { 
        // dimensiunile a 2 vectori pt a fi "uniti"
        int d1 = m - s + 1; 
        int d2 = d - m; 
  
        // vectori temporari 
        int stanga[] = new int[d1]; 
        int dreapta[] = new int[d2]; 
  
        // copierea vectorilor initiali in vectorii temp
        for (int i = 0; i < d1; i++){
            stanga[i] = arr[s + i]; 
        } 
            
        for (int j = 0; j < d2; j++){
            dreapta[j] = arr[m + 1 + j];
        } 
             
  
        
        int i = 0, j = 0; 
  
        // "unirea" celor 2 vectori
        int k = s; 
        while (i < d1 && j < d2) { 
            if (stanga[i] <= dreapta[j]) { 
                arr[k] = stanga[i]; 
                i++; 
            } 
            else { 
                arr[k] = dreapta[j]; 
                j++; 
            } 
            k++; 
        } 
  
        // copierea elemntelor ramase daca mai sunt
        while (i < d1) { 
            arr[k] = stanga[i]; 
            i++; 
            k++; 
        } 
  
        // copierea elementelor ramase daca mai sunt
        while (j < d2) { 
            arr[k] = dreapta[j]; 
            j++; 
            k++; 
        } 
    } 

    public int binarySearch(int[] array, int key, int min, int max){
        int middle = min + ((max - min) / 2);
        if(max < min) return -2;
        if(key == array[middle]) return -1;
        else if (key < array[middle]) return binarySearch(array, key, min, middle - 1);
        else return binarySearch(array, key, middle + 1, max);
    }
}
