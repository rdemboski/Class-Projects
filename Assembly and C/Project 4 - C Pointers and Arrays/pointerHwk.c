#include <stdio.h>


int max(int * arr_ptr, int size)
{
    int index, currMax;

    currMax = arr_ptr[0];

    for (index = 0; index < size; index++)
    {
        if (arr_ptr[index] > currMax)
        {
            currMax = arr_ptr[index];
        }
    }
    return currMax;
}


int min(int * arr_ptr, int size)
{
    int index, currMin;

    currMin = arr_ptr[0];

    for (index = 0; index < size; index++)
    {
        if (arr_ptr[index] < currMin)
        {
            currMin = arr_ptr[index];
        }
    }
    return currMin;
}


float average(int * arr_ptr, int size)
{
    int index;
    double average, sum;

    for (index = 0; index < size; index++)
    {
        sum += arr_ptr[index];
    }
    average = (sum / size);
    return average;
}


float median(int * arr_ptr, int size)
{
    float median = 0;
    
    if (size % 2 == 0)
    {
        median = (arr_ptr[(size - 1) / 2] + arr_ptr[size / 2]) / 2.0;
    }
    else
    {
        median = arr_ptr[size / 2];
    }
    return median;
}


void medianHelper(int * arr_ptr, int size)
{
    int outIndex = 0, inIndex = 0, hold = 0;

    for (outIndex = 0; outIndex < size; outIndex++)
    {
        for (inIndex = 0; inIndex < size - outIndex - 1; inIndex++)
        {
            if (arr_ptr[inIndex] > arr_ptr[inIndex + 1])
            {
                hold = arr_ptr[inIndex];
                arr_ptr[inIndex] = arr_ptr[inIndex + 1];
                arr_ptr[inIndex + 1] = hold;
            }
        }
    }
}


int main()
{
    int index, size = 8;
    float medianVal;
    int array[] = {1, 4, 7, 3, 2, 9, 12, 5};
    int * array_ptr = array;

    for (index = 0; index < size; index++)
    {
        printf("%d ", *(array_ptr + index));
    }

    printf("\nMax value is: %d", max(array_ptr, size));

    printf("\nMin value is: %d", min(array_ptr, size));

    printf("\nAverage value is: %.3f", average(array_ptr, size));

    medianHelper(array_ptr, size);
    medianVal = median(array_ptr, size);

    printf("\nMedian value is: %.1f", medianVal);
    printf("\n");
    return 0;
}