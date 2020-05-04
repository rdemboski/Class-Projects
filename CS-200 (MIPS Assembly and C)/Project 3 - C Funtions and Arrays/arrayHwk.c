#include <stdio.h>


int max(int name[], int size)
{
    int index, currMax;

    currMax = name[0];

    for (index = 0; index < size; index++)
    {
        if (name[index] > currMax)
        {
            currMax = name[index];
        }
    }
    return currMax;
}


int min(int name[], int size)
{
    int index, currMin;

    currMin = name[0];

    for (index = 0; index < size; index++)
    {
        if (name[index] < currMin)
        {
            currMin = name[index];
        }
    }
    return currMin;
}


float average(int name[], int size)
{
    int index;
    double average, sum;

    for (index = 0; index < size; index++)
    {
        sum += name[index];
    }
    average = (sum / size);
    return average;
}


float median(int name[], int size)
{
    float median = 0;
    
    if (size % 2 == 0)
    {
        median = (name[(size - 1) / 2] + name[size / 2]) / 2.0;
    }
    else
    {
        median = name[size / 2];
    }
    return median;
}


void medianHelper(int name[], int size)
{
    int outIndex = 0, inIndex = 0, hold = 0;

    for (outIndex = 0; outIndex < size; outIndex++)
    {
        for (inIndex = 0; inIndex < size - outIndex - 1; inIndex++)
        {
            if (name[inIndex] > name[inIndex + 1])
            {
                hold = name[inIndex];
                name[inIndex] = name[inIndex + 1];
                name[inIndex + 1] = hold;
            }
        }
    }
}


int main()
{
    int index, size = 8;
    float medianVal;
    int array[] = {1, 4, 7, 3, 2, 9, 12, 5};

    for (index = 0; index < size; index++)
    {
        printf("%d ", array[index]);
    }

    printf("\nMax value is: %d", max(array, size));

    printf("\nMin value is: %d", min(array, size));

    printf("\nAverage value is: %.3f", average(array, size));

    medianHelper(array, size);
    medianVal = median(array, size);

    printf("\nMedian value is: %.1f", medianVal);
    printf("\n");
    return 0;
}
