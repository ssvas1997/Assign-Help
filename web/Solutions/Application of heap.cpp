#include<iostream>
using namespace std;
class Heap
{
	int *heapArray, size, last;
	
	void reHeapUp(int);
	void reHeapDown(int,int);
	
	public:
		Heap(int);
		void buildHeap();
		void insertHeap(int);
		void deleteHeap();
		void getHeap();
		void displayHeap();
		void heapSort();
		void selectK(int);
};
Heap::Heap(int s)
{
	last=-1;
	size=s;
	heapArray=new int[size];
	if(heapArray==NULL)
	{
		cout<<"\nMemory allocation failed\n";
		exit(0);
	}
}
void Heap::reHeapUp(int index)
{
	if(index!=0)
	{
		int parent=(index-1)/2;
		if(heapArray[index]>heapArray[parent])
		{
			int t=heapArray[index];
			heapArray[index]=heapArray[parent];
			heapArray[parent]=t;
			
			reHeapUp(parent);
		}
	}
	return;
}
void Heap::reHeapDown(int root, int l)
{
	int left, right, largeChildKey, largeChildIndex, temp;
	
	if( ((root*2)+1) <= l) //tree has atleast one left child
	{
		left=heapArray[(root*2)+1];
		
		if(((root*2)+2)<=l)
			right=heapArray[(root*2)+2];
		else
			right=-1;
		
		if(left > right)
		{
			largeChildKey=left;
			largeChildIndex=(root*2)+1;
		}
		else
		{
			largeChildKey=right;
			largeChildIndex=(root*2)+2;
		}
		
		if(heapArray[root] < heapArray[largeChildIndex])
		{
			temp=heapArray[root];
			heapArray[root]=heapArray[largeChildIndex];
			heapArray[largeChildIndex]=temp;
			
			reHeapDown(largeChildIndex, l);
		}
	}
	return;
}
void Heap::buildHeap()
{
	for(int i=1; i<=last; i++)
		reHeapUp(i);
	return;
}
void Heap::insertHeap(int value)
{
	if(last==size)
	{
		cout<<"\nHeap is full\n";
		return;
	}
	else
	{
		last++;
		heapArray[last]=value;
		reHeapUp(last);
		return;
	}
}
void Heap::deleteHeap()
{
	if(last==-1)
	{
		cout<<"\nHeap is empty\n";
		exit(0);
	}
	
	int dataOut=heapArray[0];
	heapArray[0]=heapArray[last];
	last--;
	
	reHeapDown(0,last);
	cout<<endl<<dataOut<<" deleted \n";
	
}
void Heap::getHeap()
{
	for(int i=0; i<7; i++)
	{
		cout<<"\nEnter element "<<i+1<<" /7 : ";
		cin>>heapArray[i];
		last++;
	}
}
void Heap::displayHeap()
{
	for(int i=0; i<=last; i++)
	{
		cout<<heapArray[i]<<"  ";
	}
}
void Heap::heapSort()
{
	int sorted, temp, i;

	for(i=1; i<=last; i++)
		reHeapUp(i);
	
	sorted=last;
	while(sorted>0)
	{
		temp=heapArray[0];
		heapArray[0]=heapArray[sorted];
		heapArray[sorted]=temp;
		
		sorted--;
		reHeapDown(0,sorted);
	}
}
void Heap::selectK(int k)
{
	if(k>last)
	{
		cout<<"\nK is higher than last\n";
		return;
	}
	int i=1;
	int heapsize=last;
	while(i<=k)
	{
		int temp=heapArray[0];
		deleteHeap();
		heapArray[last+1]=temp;
		i++;
	}
	int temp=heapArray[0];
	while(last<heapsize)
	{
		last++;
		reHeapUp(last);
	}
	
	cout<<endl<<"highest k = "<<temp<<"\n";
}
main()
{
	Heap h(10);
	h.getHeap();
	
	cout<<endl<<"Heap is: ";
	h.buildHeap();
	h.displayHeap();
	
	h.deleteHeap();
	
	cout<<endl<<"After deletion heap is: "<<endl;
	h.displayHeap();
	
	h.insertHeap(94);
	cout<<endl<<endl<<"After inserting 94 heap is: "<<endl;
	h.displayHeap();
	
	h.heapSort();
	cout<<endl<<"After sorting heap is: "<<endl;
	h.displayHeap();
	
	h.selectK(6); //i +1 
	cout<<endl<<endl;
	h.displayHeap();
}
