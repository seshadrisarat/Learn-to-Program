#include<iostream>

using namespace std;

int main()
{
	int a[3][3];
	
	for(int i=0;i<3;i++)
	for(int j=0;j<3;j++)
	cin>>a[i][j];
	int temp;
	for(int i=0;i<3;i++)
	{
	for(int j=0;j!=i;j++)
	{
	temp=a[i][j];
	a[i][j]=a[j][i];
	a[j][i]=temp;
	}
	}
	
	for(int i=0;i<3;i++)
	{
	for(int j=0;j<3;j++)
	cout<<a[i][j]<<" ";

	cout<<endl;
	}
}
