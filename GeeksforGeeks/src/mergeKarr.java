import java.util.*;

public class mergeKarr {
    public static void main(String[] args)
    {
    }
}
/*
// C++ program to merge k sorted arrays of size n each.
#include<bits/stdc++.h>
using namespace std;
#define n 4

// Merge arr1[0..n1-1] and arr2[0..n2-1] into
// arr3[0..n1+n2-1]
void mergeArrays(int arr1[],int arr2[],int n1,int n2, int arr3[])
{
	int i = 0, j = 0, k = 0;
	while (i<n1 && j <n2)
	{
		if (arr1[i] < arr2[j])
			arr3[k++] = arr1[i++];
		else
			arr3[k++] = arr2[j++];
	}
	while (i < n1)
		arr3[k++] = arr1[i++];
	while (j < n2)
		arr3[k++] = arr2[j++];
}
void mergeKArrays(int arr[][n],int i,int j, int output[])
{
	//if one array is in range
	if(i==j)
	{
		for(int p=0; p < n; p++)
		output[p]=arr[i][p];
		return;
	}

	//if only two arrays are left them merge them
	if(j-i==1)
	{
		mergeArrays(arr[i],arr[j],n,n,output);
		return;
	}

	//output arrays
	int out1[n*(((i+j)/2)-i+1)],out2[n*(j-((i+j)/2))];

	//divide the array into halves
	mergeKArrays(arr,i,(i+j)/2,out1);
	mergeKArrays(arr,(i+j)/2+1,j,out2);

	//merge the output array
	mergeArrays(out1,out2,n*(((i+j)/2)-i+1),n*(j-((i+j)/2)),output);

}
*/
